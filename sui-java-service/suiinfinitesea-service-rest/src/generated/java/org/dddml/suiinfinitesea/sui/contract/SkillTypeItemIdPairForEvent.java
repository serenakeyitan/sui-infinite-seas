// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract;

import java.util.*;
import java.math.*;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.sui.bean.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SkillTypeItemIdPairForEvent {
    private Integer skillType;

    private Long itemId;

    public Integer getSkillType() {
        return skillType;
    }

    public void setSkillType(Integer skillType) {
        this.skillType = skillType;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "SkillTypeItemIdPairFields{" +
                "skillType=" + skillType +
                ", itemId=" + itemId +
            '}';
    }

}

