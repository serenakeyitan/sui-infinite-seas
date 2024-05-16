// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.shipbattle;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.dddml.suiinfinitesea.sui.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShipBattleLootTaken {
    private String id;

    private BigInteger version;

    private Integer choice;

    private ItemIdQuantityPairForEvent[] loot;

    private BigInteger lootedAt;

    private Long increasedExperience;

    private Integer newLevel;

    private Long loserIncreasedExperience;

    private Integer loserNewLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Integer getChoice() {
        return choice;
    }

    public void setChoice(Integer choice) {
        this.choice = choice;
    }

    public ItemIdQuantityPairForEvent[] getLoot() {
        return loot;
    }

    public void setLoot(ItemIdQuantityPairForEvent[] loot) {
        this.loot = loot;
    }

    public BigInteger getLootedAt() {
        return lootedAt;
    }

    public void setLootedAt(BigInteger lootedAt) {
        this.lootedAt = lootedAt;
    }

    public Long getIncreasedExperience() {
        return increasedExperience;
    }

    public void setIncreasedExperience(Long increasedExperience) {
        this.increasedExperience = increasedExperience;
    }

    public Integer getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(Integer newLevel) {
        this.newLevel = newLevel;
    }

    public Long getLoserIncreasedExperience() {
        return loserIncreasedExperience;
    }

    public void setLoserIncreasedExperience(Long loserIncreasedExperience) {
        this.loserIncreasedExperience = loserIncreasedExperience;
    }

    public Integer getLoserNewLevel() {
        return loserNewLevel;
    }

    public void setLoserNewLevel(Integer loserNewLevel) {
        this.loserNewLevel = loserNewLevel;
    }

    @Override
    public String toString() {
        return "ShipBattleLootTaken{" +
                "id=" + '\'' + id + '\'' +
                ", version=" + version +
                ", choice=" + choice +
                ", loot=" + Arrays.toString(loot) +
                ", lootedAt=" + lootedAt +
                ", increasedExperience=" + increasedExperience +
                ", newLevel=" + newLevel +
                ", loserIncreasedExperience=" + loserIncreasedExperience +
                ", loserNewLevel=" + loserNewLevel +
                '}';
    }

}