// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess;

import java.util.*;
import java.math.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;


public class SkillProcessStateDto {

    private SkillProcessId skillProcessId;

    public SkillProcessId getSkillProcessId()
    {
        return this.skillProcessId;
    }

    public void setSkillProcessId(SkillProcessId skillProcessId)
    {
        this.skillProcessId = skillProcessId;
    }

    private String id_;

    public String getId_()
    {
        return this.id_;
    }

    public void setId_(String id)
    {
        this.id_ = id;
    }

    private Long itemId;

    public Long getItemId()
    {
        return this.itemId;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    private BigInteger startedAt;

    public BigInteger getStartedAt()
    {
        return this.startedAt;
    }

    public void setStartedAt(BigInteger startedAt)
    {
        this.startedAt = startedAt;
    }

    private BigInteger creationTime;

    public BigInteger getCreationTime()
    {
        return this.creationTime;
    }

    public void setCreationTime(BigInteger creationTime)
    {
        this.creationTime = creationTime;
    }

    private Boolean completed;

    public Boolean getCompleted()
    {
        return this.completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    private BigInteger endedAt;

    public BigInteger getEndedAt()
    {
        return this.endedAt;
    }

    public void setEndedAt(BigInteger endedAt)
    {
        this.endedAt = endedAt;
    }

    private java.math.BigInteger energyVault;

    public java.math.BigInteger getEnergyVault()
    {
        return this.energyVault;
    }

    public void setEnergyVault(java.math.BigInteger energyVault)
    {
        this.energyVault = energyVault;
    }

    private BigInteger version;

    public BigInteger getVersion()
    {
        return this.version;
    }

    public void setVersion(BigInteger version)
    {
        this.version = version;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    private Long offChainVersion;

    public Long getOffChainVersion()
    {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion)
    {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public SkillProcessStateDto[] toSkillProcessStateDtoArray(Iterable<SkillProcessState> states) {
            return toSkillProcessStateDtoList(states).toArray(new SkillProcessStateDto[0]);
        }

        public List<SkillProcessStateDto> toSkillProcessStateDtoList(Iterable<SkillProcessState> states) {
            ArrayList<SkillProcessStateDto> stateDtos = new ArrayList();
            for (SkillProcessState s : states) {
                SkillProcessStateDto dto = toSkillProcessStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public SkillProcessStateDto toSkillProcessStateDto(SkillProcessState state)
        {
            if(state == null) {
                return null;
            }
            SkillProcessStateDto dto = new SkillProcessStateDto();
            if (returnedFieldsContains("SkillProcessId")) {
                dto.setSkillProcessId(state.getSkillProcessId());
            }
            if (returnedFieldsContains("Id_")) {
                dto.setId_(state.getId_());
            }
            if (returnedFieldsContains("ItemId")) {
                dto.setItemId(state.getItemId());
            }
            if (returnedFieldsContains("StartedAt")) {
                dto.setStartedAt(state.getStartedAt());
            }
            if (returnedFieldsContains("CreationTime")) {
                dto.setCreationTime(state.getCreationTime());
            }
            if (returnedFieldsContains("Completed")) {
                dto.setCompleted(state.getCompleted());
            }
            if (returnedFieldsContains("EndedAt")) {
                dto.setEndedAt(state.getEndedAt());
            }
            if (returnedFieldsContains("EnergyVault")) {
                dto.setEnergyVault(state.getEnergyVault());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("OffChainVersion")) {
                dto.setOffChainVersion(state.getOffChainVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

