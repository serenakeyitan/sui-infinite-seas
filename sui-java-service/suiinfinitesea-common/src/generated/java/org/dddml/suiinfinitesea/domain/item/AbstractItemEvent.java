// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.item;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.AbstractEvent;

public abstract class AbstractItemEvent extends AbstractEvent implements ItemEvent.SqlItemEvent, SuiEventEnvelope.MutableSuiEventEnvelope, SuiMoveEvent.MutableSuiMoveEvent, HasStatus.MutableHasStatus {
    private ItemEventId itemEventId = new ItemEventId();

    public ItemEventId getItemEventId() {
        return this.itemEventId;
    }

    public void setItemEventId(ItemEventId eventId) {
        this.itemEventId = eventId;
    }
    
    public Long getItemId() {
        return getItemEventId().getItemId();
    }

    public void setItemId(Long itemId) {
        getItemEventId().setItemId(itemId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public BigInteger getVersion() {
        return getItemEventId().getVersion();
    }
    
    public void setVersion(BigInteger version) {
        getItemEventId().setVersion(version);
    }

    private String id_;

    public String getId_() {
        return this.id_;
    }
    
    public void setId_(String id) {
        this.id_ = id;
    }

    private Long suiTimestamp;

    public Long getSuiTimestamp() {
        return this.suiTimestamp;
    }
    
    public void setSuiTimestamp(Long suiTimestamp) {
        this.suiTimestamp = suiTimestamp;
    }

    private String suiTxDigest;

    public String getSuiTxDigest() {
        return this.suiTxDigest;
    }
    
    public void setSuiTxDigest(String suiTxDigest) {
        this.suiTxDigest = suiTxDigest;
    }

    private BigInteger suiEventSeq;

    public BigInteger getSuiEventSeq() {
        return this.suiEventSeq;
    }
    
    public void setSuiEventSeq(BigInteger suiEventSeq) {
        this.suiEventSeq = suiEventSeq;
    }

    private String suiPackageId;

    public String getSuiPackageId() {
        return this.suiPackageId;
    }
    
    public void setSuiPackageId(String suiPackageId) {
        this.suiPackageId = suiPackageId;
    }

    private String suiTransactionModule;

    public String getSuiTransactionModule() {
        return this.suiTransactionModule;
    }
    
    public void setSuiTransactionModule(String suiTransactionModule) {
        this.suiTransactionModule = suiTransactionModule;
    }

    private String suiSender;

    public String getSuiSender() {
        return this.suiSender;
    }
    
    public void setSuiSender(String suiSender) {
        this.suiSender = suiSender;
    }

    private String suiType;

    public String getSuiType() {
        return this.suiType;
    }
    
    public void setSuiType(String suiType) {
        this.suiType = suiType;
    }

    private String status;

    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
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


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private String commandType;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    protected AbstractItemEvent() {
    }

    protected AbstractItemEvent(ItemEventId eventId) {
        this.itemEventId = eventId;
    }


    public abstract String getEventType();

    public static class ItemClobEvent extends AbstractItemEvent {

        protected Map<String, Object> getDynamicProperties() {
            return dynamicProperties;
        }

        protected void setDynamicProperties(Map<String, Object> dynamicProperties) {
            if (dynamicProperties == null) {
                throw new IllegalArgumentException("dynamicProperties is null.");
            }
            this.dynamicProperties = dynamicProperties;
        }

        private Map<String, Object> dynamicProperties = new HashMap<>();

        protected String getDynamicPropertiesLob() {
            return ApplicationContext.current.getClobConverter().toString(getDynamicProperties());
        }

        protected void setDynamicPropertiesLob(String text) {
            getDynamicProperties().clear();
            Map<String, Object> ps = ApplicationContext.current.getClobConverter().parseLobProperties(text);
            if (ps != null) {
                for (Map.Entry<String, Object> kv : ps.entrySet()) {
                    getDynamicProperties().put(kv.getKey(), kv.getValue());
                }
            }
        }

        @Override
        public String getEventType() {
            return "ItemClobEvent";
        }

    }

    public static class ItemCreated extends ItemClobEvent implements ItemEvent.ItemCreated {

        @Override
        public String getEventType() {
            return "ItemCreated";
        }

        public String getName() {
            Object val = getDynamicProperties().get("name");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setName(String value) {
            getDynamicProperties().put("name", value);
        }

        public Boolean getRequiredForCompletion() {
            Object val = getDynamicProperties().get("requiredForCompletion");
            if (val instanceof Boolean) {
                return (Boolean) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Boolean.class);
        }

        public void setRequiredForCompletion(Boolean value) {
            getDynamicProperties().put("requiredForCompletion", value);
        }

        public Long getSellsFor() {
            Object val = getDynamicProperties().get("sellsFor");
            if (val instanceof Long) {
                return (Long) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Long.class);
        }

        public void setSellsFor(Long value) {
            getDynamicProperties().put("sellsFor", value);
        }

    }

    public static class ItemUpdated extends ItemClobEvent implements ItemEvent.ItemUpdated {

        @Override
        public String getEventType() {
            return "ItemUpdated";
        }

        public String getName() {
            Object val = getDynamicProperties().get("name");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setName(String value) {
            getDynamicProperties().put("name", value);
        }

        public Boolean getRequiredForCompletion() {
            Object val = getDynamicProperties().get("requiredForCompletion");
            if (val instanceof Boolean) {
                return (Boolean) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Boolean.class);
        }

        public void setRequiredForCompletion(Boolean value) {
            getDynamicProperties().put("requiredForCompletion", value);
        }

        public Long getSellsFor() {
            Object val = getDynamicProperties().get("sellsFor");
            if (val instanceof Long) {
                return (Long) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Long.class);
        }

        public void setSellsFor(Long value) {
            getDynamicProperties().put("sellsFor", value);
        }

    }


}
