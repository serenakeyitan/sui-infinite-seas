// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.roster;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.dddml.suiinfinitesea.sui.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RosterSetSail {
    private String id;

    private RosterIdForEvent rosterId;

    private BigInteger version;

    private CoordinatesForEvent targetCoordinates;

    private BigInteger setSailAt;

    private CoordinatesForEvent updatedCoordinates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RosterIdForEvent getRosterId() {
        return rosterId;
    }

    public void setRosterId(RosterIdForEvent rosterId) {
        this.rosterId = rosterId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public CoordinatesForEvent getTargetCoordinates() {
        return targetCoordinates;
    }

    public void setTargetCoordinates(CoordinatesForEvent targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public BigInteger getSetSailAt() {
        return setSailAt;
    }

    public void setSetSailAt(BigInteger setSailAt) {
        this.setSailAt = setSailAt;
    }

    public CoordinatesForEvent getUpdatedCoordinates() {
        return updatedCoordinates;
    }

    public void setUpdatedCoordinates(CoordinatesForEvent updatedCoordinates) {
        this.updatedCoordinates = updatedCoordinates;
    }

    @Override
    public String toString() {
        return "RosterSetSail{" +
                "id=" + '\'' + id + '\'' +
                ", rosterId=" + rosterId +
                ", version=" + version +
                ", targetCoordinates=" + targetCoordinates +
                ", setSailAt=" + setSailAt +
                ", updatedCoordinates=" + updatedCoordinates +
                '}';
    }

}
