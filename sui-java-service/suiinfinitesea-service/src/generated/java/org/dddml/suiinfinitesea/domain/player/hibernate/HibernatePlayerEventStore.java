// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.player.hibernate;

import java.io.Serializable;
import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.specialization.hibernate.AbstractHibernateEventStore;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.transaction.annotation.Transactional;
import org.dddml.suiinfinitesea.domain.player.*;

public class HibernatePlayerEventStore extends AbstractHibernateEventStore {
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new PlayerEventId((String) eventStoreAggregateId.getId(), BigInteger.valueOf(version));
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractPlayerEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractPlayerEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        String idObj = (String) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractPlayerEvent.class);
        criteria.add(Restrictions.eq("playerEventId.id", idObj));
        criteria.add(Restrictions.le("playerEventId.offChainVersion", version));
        criteria.addOrder(Order.asc("playerEventId.offChainVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractPlayerEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractPlayerEvent) es.get(es.size() - 1)).getPlayerEventId().getVersion().longValue());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

