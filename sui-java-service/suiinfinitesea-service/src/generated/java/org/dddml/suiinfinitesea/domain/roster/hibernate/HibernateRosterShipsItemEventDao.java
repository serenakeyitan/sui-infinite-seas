// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.roster.hibernate;

import org.dddml.suiinfinitesea.domain.ship.*;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.dddml.suiinfinitesea.domain.roster.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateRosterShipsItemEventDao implements RosterShipsItemEventDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(RosterShipsItemEvent e)
    {
        getCurrentSession().save(e);
        if (e instanceof Saveable)
        {
            Saveable saveable = (Saveable) e;
            saveable.save();
        }
    }


    @Transactional(readOnly = true)
    @Override
    public Iterable<RosterShipsItemEvent> findByRosterEventId(RosterEventId rosterEventId)
    {
        Criteria criteria = getCurrentSession().createCriteria(AbstractRosterShipsItemEvent.class);
        Junction partIdCondition = Restrictions.conjunction()
            .add(Restrictions.eq("rosterShipsItemEventId.rosterIdPlayerId", rosterEventId.getRosterId().getPlayerId()))
            .add(Restrictions.eq("rosterShipsItemEventId.rosterIdSequenceNumber", rosterEventId.getRosterId().getSequenceNumber()))
            .add(Restrictions.eq("rosterShipsItemEventId.version", rosterEventId.getVersion()))
            ;
        return criteria.add(partIdCondition).list();
    }

}

