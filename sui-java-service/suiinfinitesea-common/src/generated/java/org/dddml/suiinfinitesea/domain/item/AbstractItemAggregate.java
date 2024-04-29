// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.item;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;

public abstract class AbstractItemAggregate extends AbstractAggregate implements ItemAggregate {
    private ItemState.MutableItemState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractItemAggregate(ItemState state) {
        this.state = (ItemState.MutableItemState)state;
    }

    public ItemState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        ItemCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimpleItemAggregate extends AbstractItemAggregate {
        public SimpleItemAggregate(ItemState state) {
            super(state);
        }

        @Override
        public void create(String name, Boolean requiredForCompletion, Long sellsFor, Long offChainVersion, String commandId, String requesterId, ItemCommands.Create c) {
            java.util.function.Supplier<ItemEvent.ItemCreated> eventFactory = () -> newItemCreated(name, requiredForCompletion, sellsFor, offChainVersion, commandId, requesterId);
            ItemEvent.ItemCreated e;
            try {
                e = verifyCreate(eventFactory, name, requiredForCompletion, sellsFor, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void update(String name, Boolean requiredForCompletion, Long sellsFor, Long offChainVersion, String commandId, String requesterId, ItemCommands.Update c) {
            java.util.function.Supplier<ItemEvent.ItemUpdated> eventFactory = () -> newItemUpdated(name, requiredForCompletion, sellsFor, offChainVersion, commandId, requesterId);
            ItemEvent.ItemUpdated e;
            try {
                e = verifyUpdate(eventFactory, name, requiredForCompletion, sellsFor, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        protected ItemEvent.ItemCreated verifyCreate(java.util.function.Supplier<ItemEvent.ItemCreated> eventFactory, String name, Boolean requiredForCompletion, Long sellsFor, ItemCommands.Create c) {
            String Name = name;
            Boolean RequiredForCompletion = requiredForCompletion;
            Long SellsFor = sellsFor;

            ItemEvent.ItemCreated e = (ItemEvent.ItemCreated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.item.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemState.class, String.class, Boolean.class, Long.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), name, requiredForCompletion, sellsFor, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.item;
//
//public class CreateLogic {
//    public static ItemEvent.ItemCreated verify(java.util.function.Supplier<ItemEvent.ItemCreated> eventFactory, ItemState itemState, String name, Boolean requiredForCompletion, Long sellsFor, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected ItemEvent.ItemUpdated verifyUpdate(java.util.function.Supplier<ItemEvent.ItemUpdated> eventFactory, String name, Boolean requiredForCompletion, Long sellsFor, ItemCommands.Update c) {
            String Name = name;
            Boolean RequiredForCompletion = requiredForCompletion;
            Long SellsFor = sellsFor;

            ItemEvent.ItemUpdated e = (ItemEvent.ItemUpdated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.item.UpdateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemState.class, String.class, Boolean.class, Long.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), name, requiredForCompletion, sellsFor, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.item;
//
//public class UpdateLogic {
//    public static ItemEvent.ItemUpdated verify(java.util.function.Supplier<ItemEvent.ItemUpdated> eventFactory, ItemState itemState, String name, Boolean requiredForCompletion, Long sellsFor, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected AbstractItemEvent.ItemCreated newItemCreated(String name, Boolean requiredForCompletion, Long sellsFor, Long offChainVersion, String commandId, String requesterId) {
            ItemEventId eventId = new ItemEventId(getState().getItemId(), null);
            AbstractItemEvent.ItemCreated e = new AbstractItemEvent.ItemCreated();

            e.setName(name);
            e.setRequiredForCompletion(requiredForCompletion);
            e.setSellsFor(sellsFor);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setItemEventId(eventId);
            return e;
        }

        protected AbstractItemEvent.ItemUpdated newItemUpdated(String name, Boolean requiredForCompletion, Long sellsFor, Long offChainVersion, String commandId, String requesterId) {
            ItemEventId eventId = new ItemEventId(getState().getItemId(), null);
            AbstractItemEvent.ItemUpdated e = new AbstractItemEvent.ItemUpdated();

            e.setName(name);
            e.setRequiredForCompletion(requiredForCompletion);
            e.setSellsFor(sellsFor);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setItemEventId(eventId);
            return e;
        }

    }

}

