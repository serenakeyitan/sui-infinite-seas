// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.roster;

import java.io.Serializable;
import org.dddml.suiinfinitesea.domain.RosterId;
import org.dddml.suiinfinitesea.domain.*;

public class RosterShipsItemId implements Serializable {
    private RosterId rosterId = new RosterId();

    public RosterId getRosterId()
    {
        return this.rosterId;
    }

    public void setRosterId(RosterId rosterId)
    {
        this.rosterId = rosterId;
    }

    private String key;

    public String getKey()
    {
        return this.key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    protected String getRosterIdPlayerId()
    {
        return getRosterId().getPlayerId();
    }

    protected void setRosterIdPlayerId(String rosterIdPlayerId)
    {
        getRosterId().setPlayerId(rosterIdPlayerId);
    }

    protected Integer getRosterIdSequenceNumber()
    {
        return getRosterId().getSequenceNumber();
    }

    protected void setRosterIdSequenceNumber(Integer rosterIdSequenceNumber)
    {
        getRosterId().setSequenceNumber(rosterIdSequenceNumber);
    }

    public RosterShipsItemId()
    {
    }

    public RosterShipsItemId(RosterId rosterId, String key)
    {
        this.rosterId = rosterId;
        this.key = key;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        RosterShipsItemId other = (RosterShipsItemId)obj;
        return true 
            && (rosterId == other.rosterId || (rosterId != null && rosterId.equals(other.rosterId)))
            && (key == other.key || (key != null && key.equals(other.key)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.rosterId != null) {
            hash += 13 * this.rosterId.hashCode();
        }
        if (this.key != null) {
            hash += 13 * this.key.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "RosterShipsItemId{" +
                "rosterId=" + rosterId +
                ", key=" + '\'' + key + '\'' +
                '}';
    }

    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "rosterIdPlayerId",
            "rosterIdSequenceNumber",
            "key",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "Integer",
            "String",
    };

    protected static final java.util.Map<String, String> FLATTENED_PROPERTY_TYPE_MAP;

    static {
        java.util.Map<String, String> m = new java.util.HashMap<String, String>();
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            m.put(FLATTENED_PROPERTY_NAMES[i], FLATTENED_PROPERTY_TYPES[i]);
        }
        FLATTENED_PROPERTY_TYPE_MAP = m;
    }

    protected void forEachFlattenedProperty(java.util.function.BiConsumer<String, Object> consumer) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            java.lang.reflect.Method m = null;
            try {
                m = this.getClass().getDeclaredMethod("get" + pn, new Class[0]);
            } catch (NoSuchMethodException e) {
                try {
                    m = this.getClass().getMethod("get" + pn, new Class[0]);
                } catch (NoSuchMethodException e1) {
                    throw new RuntimeException(e);
                }
            }
            Object pv = null;
            try {
                pv = m.invoke(this);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            consumer.accept(pn, pv);
        }
    }

    protected void setFlattenedPropertyValues(Object... values) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            Object v = values[i];
            Class propCls = v == null ? Object.class : v.getClass();
            java.lang.reflect.Method setterMethod = null;
            if (v == null) {
                setterMethod = getNullValueSetterMethod(pn);
            }
            if (setterMethod == null) {
                try {
                    setterMethod = this.getClass().getDeclaredMethod("set" + pn, new Class[]{propCls});
                } catch (NoSuchMethodException e) {
                    try {
                        setterMethod = this.getClass().getMethod("set" + pn, new Class[]{propCls});
                    } catch (NoSuchMethodException e1) {
                        throw new RuntimeException(e1);
                    }
                }
            }
            try {
                setterMethod.invoke(this, v);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private java.lang.reflect.Method getNullValueSetterMethod(String pascalPropName) {
        java.lang.reflect.Method m;
        final String methodName = "set" + pascalPropName;
        m = java.util.Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                .findFirst().orElse(null);
        if (m == null) {
            m = java.util.Arrays.stream(this.getClass().getMethods())
                    .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                    .findFirst().orElse(null);
        }
        return m;
    }

}

