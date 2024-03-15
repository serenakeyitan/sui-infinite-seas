// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.player;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;

public abstract class AbstractPlayerAggregate extends AbstractAggregate implements PlayerAggregate {
    private PlayerState.MutablePlayerState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractPlayerAggregate(PlayerState state) {
        this.state = (PlayerState.MutablePlayerState)state;
    }

    public PlayerState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        PlayerCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimplePlayerAggregate extends AbstractPlayerAggregate {
        public SimplePlayerAggregate(PlayerState state) {
            super(state);
        }

        @Override
        public void create(Long offChainVersion, String commandId, String requesterId, PlayerCommands.Create c) {
            java.util.function.Supplier<PlayerEvent.PlayerCreated> eventFactory = () -> newPlayerCreated(offChainVersion, commandId, requesterId);
            PlayerEvent.PlayerCreated e;
            try {
                e = verifyCreate(eventFactory, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void airdrop(Long itemId, Long quantity, Long offChainVersion, String commandId, String requesterId, PlayerCommands.Airdrop c) {
            java.util.function.Supplier<PlayerEvent.PlayerAirdropped> eventFactory = () -> newPlayerAirdropped(itemId, quantity, offChainVersion, commandId, requesterId);
            PlayerEvent.PlayerAirdropped e;
            try {
                e = verifyAirdrop(eventFactory, itemId, quantity, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void deductItems(ProductionMaterial[] items, Long offChainVersion, String commandId, String requesterId, PlayerCommands.DeductItems c) {
            java.util.function.Supplier<PlayerEvent.PlayerItemsDeducted> eventFactory = () -> newPlayerItemsDeducted(items, offChainVersion, commandId, requesterId);
            PlayerEvent.PlayerItemsDeducted e;
            try {
                e = verifyDeductItems(eventFactory, items, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void increaseExperienceAndItems(Long experience, ProductionMaterial[] items, Integer newLevel, Long offChainVersion, String commandId, String requesterId, PlayerCommands.IncreaseExperienceAndItems c) {
            java.util.function.Supplier<PlayerEvent.PlayerExperienceAndItemsIncreased> eventFactory = () -> newPlayerExperienceAndItemsIncreased(experience, items, newLevel, offChainVersion, commandId, requesterId);
            PlayerEvent.PlayerExperienceAndItemsIncreased e;
            try {
                e = verifyIncreaseExperienceAndItems(eventFactory, experience, items, newLevel, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        protected PlayerEvent.PlayerCreated verifyCreate(java.util.function.Supplier<PlayerEvent.PlayerCreated> eventFactory, PlayerCommands.Create c) {

            PlayerEvent.PlayerCreated e = (PlayerEvent.PlayerCreated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.player.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.player;
//
//public class CreateLogic {
//    public static PlayerEvent.PlayerCreated verify(java.util.function.Supplier<PlayerEvent.PlayerCreated> eventFactory, PlayerState playerState, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected PlayerEvent.PlayerAirdropped verifyAirdrop(java.util.function.Supplier<PlayerEvent.PlayerAirdropped> eventFactory, Long itemId, Long quantity, PlayerCommands.Airdrop c) {
            Long ItemId = itemId;
            Long Quantity = quantity;

            PlayerEvent.PlayerAirdropped e = (PlayerEvent.PlayerAirdropped) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.player.AirdropLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, Long.class, Long.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), itemId, quantity, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.player;
//
//public class AirdropLogic {
//    public static PlayerEvent.PlayerAirdropped verify(java.util.function.Supplier<PlayerEvent.PlayerAirdropped> eventFactory, PlayerState playerState, Long itemId, Long quantity, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected PlayerEvent.PlayerItemsDeducted verifyDeductItems(java.util.function.Supplier<PlayerEvent.PlayerItemsDeducted> eventFactory, ProductionMaterial[] items, PlayerCommands.DeductItems c) {
            ProductionMaterial[] Items = items;

            PlayerEvent.PlayerItemsDeducted e = (PlayerEvent.PlayerItemsDeducted) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.player.DeductItemsLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, ProductionMaterial[].class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), items, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.player;
//
//public class DeductItemsLogic {
//    public static PlayerEvent.PlayerItemsDeducted verify(java.util.function.Supplier<PlayerEvent.PlayerItemsDeducted> eventFactory, PlayerState playerState, ProductionMaterial[] items, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected PlayerEvent.PlayerExperienceAndItemsIncreased verifyIncreaseExperienceAndItems(java.util.function.Supplier<PlayerEvent.PlayerExperienceAndItemsIncreased> eventFactory, Long experience, ProductionMaterial[] items, Integer newLevel, PlayerCommands.IncreaseExperienceAndItems c) {
            Long Experience = experience;
            ProductionMaterial[] Items = items;
            Integer NewLevel = newLevel;

            PlayerEvent.PlayerExperienceAndItemsIncreased e = (PlayerEvent.PlayerExperienceAndItemsIncreased) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.player.IncreaseExperienceAndItemsLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, Long.class, ProductionMaterial[].class, Integer.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), experience, items, newLevel, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.player;
//
//public class IncreaseExperienceAndItemsLogic {
//    public static PlayerEvent.PlayerExperienceAndItemsIncreased verify(java.util.function.Supplier<PlayerEvent.PlayerExperienceAndItemsIncreased> eventFactory, PlayerState playerState, Long experience, ProductionMaterial[] items, Integer newLevel, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected AbstractPlayerEvent.PlayerCreated newPlayerCreated(Long offChainVersion, String commandId, String requesterId) {
            PlayerEventId eventId = new PlayerEventId(getState().getId(), null);
            AbstractPlayerEvent.PlayerCreated e = new AbstractPlayerEvent.PlayerCreated();

            e.setOwner(null);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setPlayerEventId(eventId);
            return e;
        }

        protected AbstractPlayerEvent.PlayerAirdropped newPlayerAirdropped(Long itemId, Long quantity, Long offChainVersion, String commandId, String requesterId) {
            PlayerEventId eventId = new PlayerEventId(getState().getId(), null);
            AbstractPlayerEvent.PlayerAirdropped e = new AbstractPlayerEvent.PlayerAirdropped();

            e.setItemId(itemId);
            e.setQuantity(quantity);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setPlayerEventId(eventId);
            return e;
        }

        protected AbstractPlayerEvent.PlayerItemsDeducted newPlayerItemsDeducted(ProductionMaterial[] items, Long offChainVersion, String commandId, String requesterId) {
            PlayerEventId eventId = new PlayerEventId(getState().getId(), null);
            AbstractPlayerEvent.PlayerItemsDeducted e = new AbstractPlayerEvent.PlayerItemsDeducted();

            e.setItems(items);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setPlayerEventId(eventId);
            return e;
        }

        protected AbstractPlayerEvent.PlayerExperienceAndItemsIncreased newPlayerExperienceAndItemsIncreased(Long experience, ProductionMaterial[] items, Integer newLevel, Long offChainVersion, String commandId, String requesterId) {
            PlayerEventId eventId = new PlayerEventId(getState().getId(), null);
            AbstractPlayerEvent.PlayerExperienceAndItemsIncreased e = new AbstractPlayerEvent.PlayerExperienceAndItemsIncreased();

            e.setExperience(experience);
            e.setItems(items);
            e.setNewLevel(newLevel);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setPlayerEventId(eventId);
            return e;
        }

    }

}

