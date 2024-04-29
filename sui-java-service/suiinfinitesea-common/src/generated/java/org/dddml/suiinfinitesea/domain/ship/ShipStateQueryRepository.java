// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.ship;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;

public interface ShipStateQueryRepository {
    ShipState get(String id);

    Iterable<ShipState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<ShipState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<ShipState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    ShipState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    ShipState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<ShipState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

