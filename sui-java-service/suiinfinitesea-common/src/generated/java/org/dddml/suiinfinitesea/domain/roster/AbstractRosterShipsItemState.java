// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.roster;

import java.util.*;
import java.math.*;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.roster.RosterShipsItemEvent.*;

public abstract class AbstractRosterShipsItemState implements RosterShipsItemState.SqlRosterShipsItemState {

    private RosterShipsItemId rosterShipsItemId = new RosterShipsItemId();

    public RosterShipsItemId getRosterShipsItemId() {
        return this.rosterShipsItemId;
    }

    public void setRosterShipsItemId(RosterShipsItemId rosterShipsItemId) {
        this.rosterShipsItemId = rosterShipsItemId;
    }

    private transient RosterState rosterState;

    public RosterState getRosterState() {
        return rosterState;
    }

    public void setRosterState(RosterState s) {
        rosterState = s;
    }
    
    private RosterState protectedRosterState;

    protected RosterState getProtectedRosterState() {
        return protectedRosterState;
    }

    protected void setProtectedRosterState(RosterState protectedRosterState) {
        this.protectedRosterState = protectedRosterState;
    }

    public RosterId getRosterId() {
        return this.getRosterShipsItemId().getRosterId();
    }
        
    public void setRosterId(RosterId rosterId) {
        this.getRosterShipsItemId().setRosterId(rosterId);
    }

    public String getKey() {
        return this.getRosterShipsItemId().getKey();
    }
        
    public void setKey(String key) {
        this.getRosterShipsItemId().setKey(key);
    }

    private java.util.Map<String, Object> value;

    public java.util.Map<String, Object> getValue() {
        return this.value;
    }

    public void setValue(java.util.Map<String, Object> value) {
        this.value = value;
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

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
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


    public AbstractRosterShipsItemState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getKey().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof RosterShipsItemState) {
            return Objects.equals(this.getKey(), ((RosterShipsItemState)obj).getKey());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(RosterShipsItemState s) {
        if (s == this) {
            return;
        }
        this.setValue(s.getValue());
        this.setActive(s.getActive());
    }

    public void save() {
    }

    protected void throwOnWrongEvent(RosterShipsItemEvent event) {
        RosterId stateEntityIdRosterId = this.getRosterShipsItemId().getRosterId();
        RosterId eventEntityIdRosterId = ((RosterShipsItemEvent.SqlRosterShipsItemEvent)event).getRosterShipsItemEventId().getRosterId();
        if (!stateEntityIdRosterId.equals(eventEntityIdRosterId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id RosterId %1$s in state but entity id RosterId %2$s in event", stateEntityIdRosterId, eventEntityIdRosterId);
        }

        String stateEntityIdKey = this.getRosterShipsItemId().getKey();
        String eventEntityIdKey = ((RosterShipsItemEvent.SqlRosterShipsItemEvent)event).getRosterShipsItemEventId().getKey();
        if (!stateEntityIdKey.equals(eventEntityIdKey)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id Key %1$s in state but entity id Key %2$s in event", stateEntityIdKey, eventEntityIdKey);
        }


        if (getForReapplying()) { return; }

    }


    public static class SimpleRosterShipsItemState extends AbstractRosterShipsItemState {

        public SimpleRosterShipsItemState() {
        }

        public static SimpleRosterShipsItemState newForReapplying() {
            SimpleRosterShipsItemState s = new SimpleRosterShipsItemState();
            s.initializeForReapplying();
            return s;
        }

    }



}

