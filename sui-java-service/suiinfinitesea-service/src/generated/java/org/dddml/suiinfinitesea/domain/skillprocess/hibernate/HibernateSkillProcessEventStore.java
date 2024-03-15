// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess.hibernate;

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
import org.dddml.suiinfinitesea.domain.skillprocess.*;

public class HibernateSkillProcessEventStore extends AbstractHibernateEventStore {
    @Override
    protected Serializable getEventId(EventStoreAggregateId eventStoreAggregateId, long version)
    {
        return new SkillProcessEventId((SkillTypePlayerIdPair) eventStoreAggregateId.getId(), BigInteger.valueOf(version));
    }

    @Override
    protected Class getSupportedEventType()
    {
        return AbstractSkillProcessEvent.class;
    }

    @Transactional(readOnly = true)
    @Override
    public EventStream loadEventStream(Class eventType, EventStoreAggregateId eventStoreAggregateId, long version) {
        Class supportedEventType = AbstractSkillProcessEvent.class;
        if (!eventType.isAssignableFrom(supportedEventType)) {
            throw new UnsupportedOperationException();
        }
        SkillTypePlayerIdPair idObj = (SkillTypePlayerIdPair) eventStoreAggregateId.getId();
        Criteria criteria = getCurrentSession().createCriteria(AbstractSkillProcessEvent.class);
        criteria.add(Restrictions.eq("skillProcessEventId.skillProcessIdSkillType", idObj.getSkillType()));
        criteria.add(Restrictions.eq("skillProcessEventId.skillProcessIdPlayerId", idObj.getPlayerId()));
        criteria.add(Restrictions.le("skillProcessEventId.offChainVersion", version));
        criteria.addOrder(Order.asc("skillProcessEventId.offChainVersion"));
        List es = criteria.list();
        for (Object e : es) {
            ((AbstractSkillProcessEvent) e).setEventReadOnly(true);
        }
        EventStream eventStream = new EventStream();
        if (es.size() > 0) {
            eventStream.setSteamVersion(((AbstractSkillProcessEvent) es.get(es.size() - 1)).getSkillProcessEventId().getVersion().longValue());
        } else {
            //todo?
        }
        eventStream.setEvents(es);
        return eventStream;
    }

}

