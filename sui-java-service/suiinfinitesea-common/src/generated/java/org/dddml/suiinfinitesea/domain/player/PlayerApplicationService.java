// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.player;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.Event;
import org.dddml.suiinfinitesea.domain.Command;

public interface PlayerApplicationService {
    void when(PlayerCommands.Create c);

    void when(PlayerCommands.Airdrop c);

    void when(PlayerCommands.DeductItems c);

    void when(PlayerCommands.IncreaseExperienceAndItems c);

    PlayerState get(String id);

    Iterable<PlayerState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PlayerState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PlayerState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PlayerState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PlayerEvent getEvent(String id, long version);

    PlayerState getHistoryState(String id, long version);

    PlayerItemState getPlayerItem(String playerId, Long itemId);

    Iterable<PlayerItemState> getPlayerItems(String playerId, Criterion filter, List<String> orders);

}

