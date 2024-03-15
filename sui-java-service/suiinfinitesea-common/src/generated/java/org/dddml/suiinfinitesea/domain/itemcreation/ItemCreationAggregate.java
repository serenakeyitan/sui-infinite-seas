// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.itemcreation;

import java.util.List;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.Event;
import org.dddml.suiinfinitesea.domain.Command;

public interface ItemCreationAggregate {
    ItemCreationState getState();

    List<Event> getChanges();

    void create(Integer requirementsLevel, Long baseQuantity, Long baseExperience, BigInteger baseCreationTime, BigInteger energyCost, Integer successRate, Long offChainVersion, String commandId, String requesterId, ItemCreationCommands.Create c);

    void update(Integer requirementsLevel, Long baseQuantity, Long baseExperience, BigInteger baseCreationTime, BigInteger energyCost, Integer successRate, Long offChainVersion, String commandId, String requesterId, ItemCreationCommands.Update c);

    void throwOnInvalidStateTransition(Command c);
}

