// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.ship;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;

public abstract class AbstractShipApplicationService implements ShipApplicationService {

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private ShipStateRepository stateRepository;

    protected ShipStateRepository getStateRepository() {
        return stateRepository;
    }

    private ShipStateQueryRepository stateQueryRepository;

    protected ShipStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<ShipAggregate, ShipState> aggregateEventListener;

    public AggregateEventListener<ShipAggregate, ShipState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<ShipAggregate, ShipState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractShipApplicationService(EventStore eventStore, ShipStateRepository stateRepository, ShipStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(ShipCommands.Create c) {
        update(c, ar -> ar.create(c.getOwner(), c.getHealthPoints(), c.getAttack(), c.getProtection(), c.getSpeed(), c.getBuildingExpenses(), c.getOffChainVersion(), c.getCommandId(), c.getRequesterId(), c));
    }

    public ShipState get(String id) {
        ShipState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<ShipState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<ShipState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<ShipState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public ShipEvent getEvent(String id, long version) {
        ShipEvent e = (ShipEvent)getEventStore().getEvent(toEventStoreAggregateId(id), version);
        if (e != null) {
            ((ShipEvent.SqlShipEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(id, 0);
        }
        return e;
    }

    public ShipState getHistoryState(String id, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractShipEvent.class, toEventStoreAggregateId(id), version - 1);
        return new AbstractShipState.SimpleShipState(eventStream.getEvents());
    }


    public ShipAggregate getShipAggregate(ShipState state) {
        return new AbstractShipAggregate.SimpleShipAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(String aggregateId) {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(ShipCommand c, Consumer<ShipAggregate> action) {
        String aggregateId = c.getId();
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        ShipState state = getStateRepository().get(aggregateId, false);
        boolean duplicate = isDuplicateCommand(c, eventStoreAggregateId, state);
        if (duplicate) { return; }

        ShipAggregate aggregate = getShipAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOffChainVersion() == null ? ShipState.VERSION_NULL : c.getOffChainVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, ShipAggregate aggregate, ShipState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { 
                getStateRepository().save(state); 
            });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    protected boolean isDuplicateCommand(ShipCommand command, EventStoreAggregateId eventStoreAggregateId, ShipState state) {
        boolean duplicate = false;
        if (command.getOffChainVersion() == null) { command.setOffChainVersion(ShipState.VERSION_NULL); }
        if (state.getOffChainVersion() != null && state.getOffChainVersion() > command.getOffChainVersion()) {
            Event lastEvent = getEventStore().getEvent(AbstractShipEvent.class, eventStoreAggregateId, command.getOffChainVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId())) {
                duplicate = true;
            }
        }
        return duplicate;
    }

    public static class SimpleShipApplicationService extends AbstractShipApplicationService {
        public SimpleShipApplicationService(EventStore eventStore, ShipStateRepository stateRepository, ShipStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

