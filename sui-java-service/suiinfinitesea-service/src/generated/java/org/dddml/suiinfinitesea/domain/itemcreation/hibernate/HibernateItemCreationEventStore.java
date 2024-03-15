// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.itemcreation.hibernate;

import java.io.Serializable;
import java.util.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.suiinfinitesea.domain.itemcreation.*;

public class HibernateItemCreationEventStore extends AbstractHibernateEventStore {
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new ItemCreationEventId((SkillTypeItemIdPair) eventStoreAggregateId.getId(), BigInteger.valueOf(version));
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractItemCreationEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractItemCreationEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        SkillTypeItemIdPair idObj = (SkillTypeItemIdPair) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractItemCreationEvent.class);
        criteria.add(Restrictions.eq("itemCreationEventId.itemCreationIdSkillType", idObj.getSkillType()));
        criteria.add(Restrictions.eq("itemCreationEventId.itemCreationIdItemId", idObj.getItemId()));
        criteria.add(Restrictions.le("itemCreationEventId.offChainVersion", version));
        criteria.addOrder(Order.asc("itemCreationEventId.offChainVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractItemCreationEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractItemCreationEvent) es.get(es.size() - 1)).getItemCreationEventId().getVersion().longValue());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

