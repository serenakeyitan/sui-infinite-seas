// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.sui.bean.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Roster {

    private UID id;

    private RosterId rosterId;

    private Long offChainVersion;

    private Integer status;

    private Long speed;

    private String[] shipIds;

    private ObjectTable ships;

    private Coordinates updatedCoordinates;

    private BigInteger coordinatesUpdatedAt;

    private Coordinates targetCoordinates;

    private String shipBattleId;

    private BigInteger version;

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public RosterId getRosterId() {
        return rosterId;
    }

    public void setRosterId(RosterId rosterId) {
        this.rosterId = rosterId;
    }

    public Long getOffChainVersion() {
        return offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public String[] getShipIds() {
        return shipIds;
    }

    public void setShipIds(String[] shipIds) {
        this.shipIds = shipIds;
    }

    public ObjectTable getShips() {
        return ships;
    }

    public void setShips(ObjectTable ships) {
        this.ships = ships;
    }

    public Coordinates getUpdatedCoordinates() {
        return updatedCoordinates;
    }

    public void setUpdatedCoordinates(Coordinates updatedCoordinates) {
        this.updatedCoordinates = updatedCoordinates;
    }

    public BigInteger getCoordinatesUpdatedAt() {
        return coordinatesUpdatedAt;
    }

    public void setCoordinatesUpdatedAt(BigInteger coordinatesUpdatedAt) {
        this.coordinatesUpdatedAt = coordinatesUpdatedAt;
    }

    public Coordinates getTargetCoordinates() {
        return targetCoordinates;
    }

    public void setTargetCoordinates(Coordinates targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public String getShipBattleId() {
        return shipBattleId;
    }

    public void setShipBattleId(String shipBattleId) {
        this.shipBattleId = shipBattleId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "id=" + id +
                ", rosterId=" + rosterId +
                ", offChainVersion=" + offChainVersion +
                ", status=" + status +
                ", speed=" + speed +
                ", shipIds=" + Arrays.toString(shipIds) +
                ", ships=" + ships +
                ", updatedCoordinates=" + updatedCoordinates +
                ", coordinatesUpdatedAt=" + coordinatesUpdatedAt +
                ", targetCoordinates=" + targetCoordinates +
                ", shipBattleId=" + '\'' + shipBattleId + '\'' +
                ", version=" + version +
                '}';
    }
}
