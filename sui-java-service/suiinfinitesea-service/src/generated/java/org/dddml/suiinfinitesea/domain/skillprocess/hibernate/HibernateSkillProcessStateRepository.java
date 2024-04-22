// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess.hibernate;

import java.util.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Criteria;
//import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.suiinfinitesea.domain.skillprocess.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSkillProcessStateRepository implements SkillProcessStateRepository {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("SkillProcessId", "ItemId", "StartedAt", "CreationTime", "Completed", "EndedAt", "EnergyVault", "Version", "OffChainVersion", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public SkillProcessState get(SkillProcessId id, boolean nullAllowed) {
        SkillProcessState.SqlSkillProcessState state = (SkillProcessState.SqlSkillProcessState)getCurrentSession().get(AbstractSkillProcessState.SimpleSkillProcessState.class, id);
        if (!nullAllowed && state == null) {
            state = new AbstractSkillProcessState.SimpleSkillProcessState();
            state.setSkillProcessId(id);
        }
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (SkillProcessState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{SkillProcessState.SqlSkillProcessState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    public void save(SkillProcessState state) {
        SkillProcessState s = state;
        if (getReadOnlyProxyGenerator() != null) {
            s = (SkillProcessState) getReadOnlyProxyGenerator().getTarget(state);
        }
        if(s.getOffChainVersion() == null) {
            getCurrentSession().save(s);
        } else {
            getCurrentSession().update(s);
        }

        if (s instanceof Saveable)
        {
            Saveable saveable = (Saveable) s;
            saveable.save();
        }
        getCurrentSession().flush();
    }

    public void merge(SkillProcessState detached) {
        SkillProcessState persistent = getCurrentSession().get(AbstractSkillProcessState.SimpleSkillProcessState.class, detached.getSkillProcessId());
        if (persistent != null) {
            merge(persistent, detached);
            getCurrentSession().save(persistent);
        } else {
            getCurrentSession().save(detached);
        }
        getCurrentSession().flush();
    }

    private void merge(SkillProcessState persistent, SkillProcessState detached) {
        ((AbstractSkillProcessState) persistent).merge(detached);
    }

}

