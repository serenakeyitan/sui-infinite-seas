// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.ship;

import java.util.List;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.Event;
import org.dddml.suiinfinitesea.domain.Command;

public interface ShipAggregate {
    ShipState getState();

    List<Event> getChanges();

    void create(String owner, Long healthPoints, Long attack, Long protection, Long speed, ItemIdQuantityPairs buildingExpenses, Long offChainVersion, String commandId, String requesterId, ShipCommands.Create c);

    void throwOnInvalidStateTransition(Command c);
}

