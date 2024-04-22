// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess;

import java.util.*;
import java.util.function.Consumer;
import org.dddml.support.criterion.Criterion;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;

public abstract class AbstractSkillProcessApplicationService implements SkillProcessApplicationService {

    private EventStore eventStore;

    protected EventStore getEventStore()
    {
        return eventStore;
    }

    private SkillProcessStateRepository stateRepository;

    protected SkillProcessStateRepository getStateRepository() {
        return stateRepository;
    }

    private SkillProcessStateQueryRepository stateQueryRepository;

    protected SkillProcessStateQueryRepository getStateQueryRepository() {
        return stateQueryRepository;
    }

    private AggregateEventListener<SkillProcessAggregate, SkillProcessState> aggregateEventListener;

    public AggregateEventListener<SkillProcessAggregate, SkillProcessState> getAggregateEventListener() {
        return aggregateEventListener;
    }

    public void setAggregateEventListener(AggregateEventListener<SkillProcessAggregate, SkillProcessState> eventListener) {
        this.aggregateEventListener = eventListener;
    }

    public AbstractSkillProcessApplicationService(EventStore eventStore, SkillProcessStateRepository stateRepository, SkillProcessStateQueryRepository stateQueryRepository) {
        this.eventStore = eventStore;
        this.stateRepository = stateRepository;
        this.stateQueryRepository = stateQueryRepository;
    }

    public void when(SkillProcessCommands.Create c) {
        update(c, ar -> ar.create(c.getPlayer(), c.getOffChainVersion(), c.getCommandId(), c.getRequesterId(), c));
    }

    public void when(SkillProcessCommands.CompleteProduction c) {
        update(c, ar -> ar.completeProduction(c.getPlayer(), c.getItemProduction(), c.getExperienceTable(), c.getClock(), c.getOffChainVersion(), c.getCommandId(), c.getRequesterId(), c));
    }

    public SkillProcessState get(SkillProcessId id) {
        SkillProcessState state = getStateRepository().get(id, true);
        return state;
    }

    public Iterable<SkillProcessState> getAll(Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getAll(firstResult, maxResults);
    }

    public Iterable<SkillProcessState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SkillProcessState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().get(filter, orders, firstResult, maxResults);
    }

    public Iterable<SkillProcessState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        return getStateQueryRepository().getByProperty(propertyName, propertyValue, orders, firstResult, maxResults);
    }

    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public long getCount(Criterion filter) {
        return getStateQueryRepository().getCount(filter);
    }

    public SkillProcessEvent getEvent(SkillProcessId skillProcessId, long version) {
        SkillProcessEvent e = (SkillProcessEvent)getEventStore().getEvent(toEventStoreAggregateId(skillProcessId), version);
        if (e != null) {
            ((SkillProcessEvent.SqlSkillProcessEvent)e).setEventReadOnly(true); 
        } else if (version == -1) {
            return getEvent(skillProcessId, 0);
        }
        return e;
    }

    public SkillProcessState getHistoryState(SkillProcessId skillProcessId, long version) {
        EventStream eventStream = getEventStore().loadEventStream(AbstractSkillProcessEvent.class, toEventStoreAggregateId(skillProcessId), version - 1);
        return new AbstractSkillProcessState.SimpleSkillProcessState(eventStream.getEvents());
    }


    public SkillProcessAggregate getSkillProcessAggregate(SkillProcessState state) {
        return new AbstractSkillProcessAggregate.SimpleSkillProcessAggregate(state);
    }

    public EventStoreAggregateId toEventStoreAggregateId(SkillProcessId aggregateId) {
        return new EventStoreAggregateId.SimpleEventStoreAggregateId(aggregateId);
    }

    protected void update(SkillProcessCommand c, Consumer<SkillProcessAggregate> action) {
        SkillProcessId aggregateId = c.getSkillProcessId();
        EventStoreAggregateId eventStoreAggregateId = toEventStoreAggregateId(aggregateId);
        SkillProcessState state = getStateRepository().get(aggregateId, false);
        boolean duplicate = isDuplicateCommand(c, eventStoreAggregateId, state);
        if (duplicate) { return; }

        SkillProcessAggregate aggregate = getSkillProcessAggregate(state);
        aggregate.throwOnInvalidStateTransition(c);
        action.accept(aggregate);
        persist(eventStoreAggregateId, c.getOffChainVersion() == null ? SkillProcessState.VERSION_NULL : c.getOffChainVersion(), aggregate, state); // State version may be null!

    }

    private void persist(EventStoreAggregateId eventStoreAggregateId, long version, SkillProcessAggregate aggregate, SkillProcessState state) {
        getEventStore().appendEvents(eventStoreAggregateId, version, 
            aggregate.getChanges(), (events) -> { 
                getStateRepository().save(state); 
            });
        if (aggregateEventListener != null) {
            aggregateEventListener.eventAppended(new AggregateEvent<>(aggregate, state, aggregate.getChanges()));
        }
    }

    protected boolean isDuplicateCommand(SkillProcessCommand command, EventStoreAggregateId eventStoreAggregateId, SkillProcessState state) {
        boolean duplicate = false;
        if (command.getOffChainVersion() == null) { command.setOffChainVersion(SkillProcessState.VERSION_NULL); }
        if (state.getOffChainVersion() != null && state.getOffChainVersion() > command.getOffChainVersion()) {
            Event lastEvent = getEventStore().getEvent(AbstractSkillProcessEvent.class, eventStoreAggregateId, command.getOffChainVersion());
            if (lastEvent != null && lastEvent instanceof AbstractEvent
               && command.getCommandId() != null && command.getCommandId().equals(((AbstractEvent) lastEvent).getCommandId())) {
                duplicate = true;
            }
        }
        return duplicate;
    }

    public static class SimpleSkillProcessApplicationService extends AbstractSkillProcessApplicationService {
        public SimpleSkillProcessApplicationService(EventStore eventStore, SkillProcessStateRepository stateRepository, SkillProcessStateQueryRepository stateQueryRepository)
        {
            super(eventStore, stateRepository, stateQueryRepository);
        }
    }

}

