// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocessmutex.hibernate;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.SessionFactory;
import org.dddml.suiinfinitesea.domain.skillprocessmutex.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.specialization.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

public class HibernateSkillProcessMutexStateQueryRepository implements SkillProcessMutexStateQueryRepository {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() { return this.sessionFactory; }

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
    private static final Set<String> readOnlyPropertyPascalCaseNames = new HashSet<String>(Arrays.asList("PlayerId", "ActiveSkillType", "Version", "OffChainVersion", "CreatedBy", "CreatedAt", "UpdatedBy", "UpdatedAt", "Active", "Deleted"));
    
    private ReadOnlyProxyGenerator readOnlyProxyGenerator;
    
    public ReadOnlyProxyGenerator getReadOnlyProxyGenerator() {
        return readOnlyProxyGenerator;
    }

    public void setReadOnlyProxyGenerator(ReadOnlyProxyGenerator readOnlyProxyGenerator) {
        this.readOnlyProxyGenerator = readOnlyProxyGenerator;
    }

    @Transactional(readOnly = true)
    public SkillProcessMutexState get(String id) {

        SkillProcessMutexState state = (SkillProcessMutexState)getCurrentSession().get(AbstractSkillProcessMutexState.SimpleSkillProcessMutexState.class, id);
        if (getReadOnlyProxyGenerator() != null && state != null) {
            return (SkillProcessMutexState) getReadOnlyProxyGenerator().createProxy(state, new Class[]{SkillProcessMutexState.SqlSkillProcessMutexState.class}, "getStateReadOnly", readOnlyPropertyPascalCaseNames);
        }
        return state;
    }

    @Transactional(readOnly = true)
    public Iterable<SkillProcessMutexState> getAll(Integer firstResult, Integer maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(SkillProcessMutexState.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        if (firstResult != null) { criteria.setFirstResult(firstResult); }
        if (maxResults != null) { criteria.setMaxResults(maxResults); }
         addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<SkillProcessMutexState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(SkillProcessMutexState.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public Iterable<SkillProcessMutexState> get(org.dddml.support.criterion.Criterion filter, List<String> orders, Integer firstResult, Integer maxResults) {
        Criteria criteria = getCurrentSession().createCriteria(SkillProcessMutexState.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        HibernateUtils.criteriaAddFilterAndOrdersAndSetFirstResultAndMaxResults(criteria, filter, orders, firstResult, maxResults);
        addNotDeletedRestriction(criteria);
        return criteria.list();
    }

    @Transactional(readOnly = true)
    public SkillProcessMutexState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders) {
        List<SkillProcessMutexState> list = (List<SkillProcessMutexState>)get(filter, orders, 0, 1);
        if (list == null || list.size() <= 0)
        {
            return null;
        }
        return list.get(0);
    }

    @Transactional(readOnly = true)
    public SkillProcessMutexState getFirst(Map.Entry<String, Object> keyValue, List<String> orders) {
        List<Map.Entry<String, Object>> filter = new ArrayList<>();
        filter.add(keyValue);
        return getFirst(filter, orders);
    }

    @Transactional(readOnly = true)
    public Iterable<SkillProcessMutexState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults) {
        Map.Entry<String, Object> keyValue = new java.util.AbstractMap.SimpleEntry<String, Object> (propertyName, propertyValue);
        List<Map.Entry<String, Object>> filter = new ArrayList<Map.Entry<String, Object>>();
        filter.add(keyValue);
        return get(filter, orders, firstResult, maxResults);
    }

    @Transactional(readOnly = true)
    public long getCount(Iterable<Map.Entry<String, Object>> filter) {
        Criteria criteria = getCurrentSession().createCriteria(SkillProcessMutexState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null) {
            HibernateUtils.criteriaAddFilter(criteria, filter);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }

    @Transactional(readOnly = true)
    public long getCount(org.dddml.support.criterion.Criterion filter) {
        Criteria criteria = getCurrentSession().createCriteria(SkillProcessMutexState.class);
        criteria.setProjection(Projections.rowCount());
        if (filter != null)
        {
            org.hibernate.criterion.Criterion hc = CriterionUtils.toHibernateCriterion(filter);
            criteria.add(hc);
        }
        addNotDeletedRestriction(criteria);
        return (long)criteria.uniqueResult();
    }


    protected static void addNotDeletedRestriction(Criteria criteria) {
        criteria.add(org.hibernate.criterion.Restrictions.or(
                org.hibernate.criterion.Restrictions.isNull("deleted"),
                org.hibernate.criterion.Restrictions.eq("deleted", false)
        ));
    }

}

