// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.player;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;

public interface PlayerStateRepository {
    PlayerState get(String id, boolean nullAllowed);

    void save(PlayerState state);

    void merge(PlayerState detached);
}

