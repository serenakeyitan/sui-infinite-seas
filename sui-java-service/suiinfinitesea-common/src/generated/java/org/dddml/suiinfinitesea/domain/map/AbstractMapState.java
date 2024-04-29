// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.map;

import java.util.*;
import java.math.*;
import java.util.Date;
import java.math.BigInteger;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.map.MapEvent.*;

public abstract class AbstractMapState implements MapState.SqlMapState, Saveable {

    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Long offChainVersion;

    public Long getOffChainVersion() {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    private BigInteger version;

    public BigInteger getVersion() {
        return this.version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
    }

    private Set<MapLocationState> protectedLocations = new HashSet<>();

    protected Set<MapLocationState> getProtectedLocations() {
        return this.protectedLocations;
    }

    protected void setProtectedLocations(Set<MapLocationState> protectedLocations) {
        this.protectedLocations = protectedLocations;
    }

    private EntityStateCollection<Coordinates, MapLocationState> locations;

    public EntityStateCollection<Coordinates, MapLocationState> getLocations() {
        return this.locations;
    }

    public void setLocations(EntityStateCollection<Coordinates, MapLocationState> locations) {
        this.locations = locations;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractMapState(List<Event> events) {
        initializeForReapplying();
        if (events != null && events.size() > 0) {
            this.setId(((MapEvent.SqlMapEvent) events.get(0)).getMapEventId().getId());
            for (Event e : events) {
                mutate(e);
                this.setOffChainVersion((this.getOffChainVersion() == null ? MapState.VERSION_NULL : this.getOffChainVersion()) + 1);
            }
        }
    }


    public AbstractMapState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
        locations = new SimpleMapLocationStateCollection();
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof MapState) {
            return Objects.equals(this.getId(), ((MapState)obj).getId());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else if (e instanceof AbstractMapEvent.InitMapEvent) {
            when((AbstractMapEvent.InitMapEvent)e);
        } else if (e instanceof AbstractMapEvent.IslandAdded) {
            when((AbstractMapEvent.IslandAdded)e);
        } else if (e instanceof AbstractMapEvent.MapIslandClaimed) {
            when((AbstractMapEvent.MapIslandClaimed)e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(MapState s) {
        if (s == this) {
            return;
        }
        this.setActive(s.getActive());
        this.setVersion(s.getVersion());

        if (s.getLocations() != null) {
            Iterable<MapLocationState> iterable;
            if (s.getLocations().isLazy()) {
                iterable = s.getLocations().getLoadedStates();
            } else {
                iterable = s.getLocations();
            }
            if (iterable != null) {
                for (MapLocationState ss : iterable) {
                    MapLocationState thisInnerState = ((EntityStateCollection.ModifiableEntityStateCollection<Coordinates, MapLocationState>)this.getLocations()).getOrAddDefault(ss.getCoordinates());
                    ((AbstractMapLocationState) thisInnerState).merge(ss);
                }
            }
        }
        if (s.getLocations() != null) {
            if (s.getLocations() instanceof EntityStateCollection.RemovalLoggedEntityStateCollection) {
                if (((EntityStateCollection.RemovalLoggedEntityStateCollection)s.getLocations()).getRemovedStates() != null) {
                    for (MapLocationState ss : ((EntityStateCollection.RemovalLoggedEntityStateCollection<Coordinates, MapLocationState>)s.getLocations()).getRemovedStates()) {
                        MapLocationState thisInnerState = ((EntityStateCollection.ModifiableEntityStateCollection<Coordinates, MapLocationState>)this.getLocations()).getOrAddDefault(ss.getCoordinates());
                        ((EntityStateCollection.ModifiableEntityStateCollection)this.getLocations()).removeState(thisInnerState);
                    }
                }
            } else {
                if (s.getLocations().isAllLoaded()) {
                    Set<Coordinates> removedStateIds = new HashSet<>(this.getLocations().stream().map(i -> i.getCoordinates()).collect(java.util.stream.Collectors.toList()));
                    s.getLocations().forEach(i -> removedStateIds.remove(i.getCoordinates()));
                    for (Coordinates i : removedStateIds) {
                        MapLocationState thisInnerState = ((EntityStateCollection.ModifiableEntityStateCollection<Coordinates, MapLocationState>)this.getLocations()).getOrAddDefault(i);
                        ((EntityStateCollection.ModifiableEntityStateCollection)this.getLocations()).removeState(thisInnerState);
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        }
    }

    public void when(AbstractMapEvent.InitMapEvent e) {
        throwOnWrongEvent(e);

        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        MapState updatedMapState = (MapState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.map.__Init__Logic",
                    "mutate",
                    new Class[]{MapState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.map;
//
//public class __Init__Logic {
//    public static MapState mutate(MapState mapState, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<MapState, MapState.MutableMapState> mutationContext) {
//    }
//}

        if (this != updatedMapState) { merge(updatedMapState); } //else do nothing

    }

    public void when(AbstractMapEvent.IslandAdded e) {
        throwOnWrongEvent(e);

        Coordinates coordinates = e.getCoordinates();
        Coordinates Coordinates = coordinates;
        ItemIdQuantityPairs resources = e.getResources();
        ItemIdQuantityPairs Resources = resources;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        MapState updatedMapState = (MapState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.map.AddIslandLogic",
                    "mutate",
                    new Class[]{MapState.class, Coordinates.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, coordinates, resources, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.map;
//
//public class AddIslandLogic {
//    public static MapState mutate(MapState mapState, Coordinates coordinates, ItemIdQuantityPairs resources, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<MapState, MapState.MutableMapState> mutationContext) {
//    }
//}

        if (this != updatedMapState) { merge(updatedMapState); } //else do nothing

    }

    public void when(AbstractMapEvent.MapIslandClaimed e) {
        throwOnWrongEvent(e);

        Coordinates coordinates = e.getCoordinates();
        Coordinates Coordinates = coordinates;
        String claimedBy = e.getClaimedBy();
        String ClaimedBy = claimedBy;
        BigInteger claimedAt = e.getClaimedAt();
        BigInteger ClaimedAt = claimedAt;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        MapState updatedMapState = (MapState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.map.ClaimIslandLogic",
                    "mutate",
                    new Class[]{MapState.class, Coordinates.class, String.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, coordinates, claimedBy, claimedAt, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.map;
//
//public class ClaimIslandLogic {
//    public static MapState mutate(MapState mapState, Coordinates coordinates, String claimedBy, BigInteger claimedAt, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<MapState, MapState.MutableMapState> mutationContext) {
//    }
//}

        if (this != updatedMapState) { merge(updatedMapState); } //else do nothing

    }

    public void save() {
        if (locations instanceof Saveable) {
            ((Saveable)locations).save();
        }
    }

    protected void throwOnWrongEvent(MapEvent event) {
        String stateEntityId = this.getId(); // Aggregate Id
        String eventEntityId = ((MapEvent.SqlMapEvent)event).getMapEventId().getId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }


        Long stateVersion = this.getOffChainVersion();

    }


    public static class SimpleMapState extends AbstractMapState {

        public SimpleMapState() {
        }

        public SimpleMapState(List<Event> events) {
            super(events);
        }

        public static SimpleMapState newForReapplying() {
            SimpleMapState s = new SimpleMapState();
            s.initializeForReapplying();
            return s;
        }

    }


    class SimpleMapLocationStateCollection implements EntityStateCollection.ModifiableEntityStateCollection<Coordinates, MapLocationState>, Collection<MapLocationState> {

        @Override
        public MapLocationState get(Coordinates coordinates) {
            return protectedLocations.stream().filter(
                            e -> e.getCoordinates().equals(coordinates))
                    .findFirst().orElse(null);
        }

        @Override
        public boolean isLazy() {
            return false;
        }

        @Override
        public boolean isAllLoaded() {
            return true;
        }

        @Override
        public Collection<MapLocationState> getLoadedStates() {
            return protectedLocations;
        }

        @Override
        public MapLocationState getOrAddDefault(Coordinates coordinates) {
            MapLocationState s = get(coordinates);
            if (s == null) {
                MapLocationId globalId = new MapLocationId(getId(), coordinates);
                AbstractMapLocationState state = new AbstractMapLocationState.SimpleMapLocationState();
                state.setMapLocationId(globalId);
                add(state);
                s = state;
            }
            return s;
        }

        @Override
        public int size() {
            return protectedLocations.size();
        }

        @Override
        public boolean isEmpty() {
            return protectedLocations.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return protectedLocations.contains(o);
        }

        @Override
        public Iterator<MapLocationState> iterator() {
            return protectedLocations.iterator();
        }

        @Override
        public java.util.stream.Stream<MapLocationState> stream() {
            return protectedLocations.stream();
        }

        @Override
        public Object[] toArray() {
            return protectedLocations.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return protectedLocations.toArray(a);
        }

        @Override
        public boolean add(MapLocationState s) {
            if (s instanceof AbstractMapLocationState) {
                AbstractMapLocationState state = (AbstractMapLocationState) s;
                state.setProtectedMapState(AbstractMapState.this);
            }
            return protectedLocations.add(s);
        }

        @Override
        public boolean remove(Object o) {
            if (o instanceof AbstractMapLocationState) {
                AbstractMapLocationState s = (AbstractMapLocationState) o;
                s.setProtectedMapState(null);
            }
            return protectedLocations.remove(o);
        }

        @Override
        public boolean removeState(MapLocationState s) {
            return remove(s);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return protectedLocations.contains(c);
        }

        @Override
        public boolean addAll(Collection<? extends MapLocationState> c) {
            return protectedLocations.addAll(c);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return protectedLocations.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return protectedLocations.retainAll(c);
        }

        @Override
        public void clear() {
            protectedLocations.clear();
        }
    }


}

