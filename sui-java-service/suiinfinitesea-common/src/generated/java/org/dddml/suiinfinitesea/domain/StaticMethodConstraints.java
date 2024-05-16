// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain;

import org.dddml.suiinfinitesea.specialization.ReflectUtils;
import org.dddml.suiinfinitesea.specialization.MutationContext;
import org.dddml.suiinfinitesea.specialization.VerificationContext;
import org.dddml.suiinfinitesea.domain.item.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.itemcreation.*;
import org.dddml.suiinfinitesea.domain.itemproduction.*;
import org.dddml.suiinfinitesea.domain.player.*;
import org.dddml.suiinfinitesea.domain.skillprocess.*;
import org.dddml.suiinfinitesea.domain.ship.*;
import org.dddml.suiinfinitesea.domain.roster.*;
import org.dddml.suiinfinitesea.domain.shipbattle.*;
import org.dddml.suiinfinitesea.domain.experiencetable.*;
import org.dddml.suiinfinitesea.domain.map.*;

public class StaticMethodConstraints {

    public static void assertStaticVerificationAndMutationMethods() {

        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.item.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemState.class, String.class, Boolean.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "name", "requiredForCompletion", "sellsFor"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.item.UpdateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemState.class, String.class, Boolean.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "name", "requiredForCompletion", "sellsFor"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemcreation.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemCreationState.class, Long.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "resourceCost", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemcreation.UpdateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemCreationState.class, Long.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "resourceCost", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemproduction.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemProductionState.class, ItemIdQuantityPairs.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "productionMaterials", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemproduction.UpdateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ItemProductionState.class, ItemIdQuantityPairs.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "productionMaterials", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, VerificationContext.class},
                    new String[]{"_", "_"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.ClaimIslandLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, Coordinates.class, VerificationContext.class},
                    new String[]{"_", "_", "map", "coordinates"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.AirdropLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, PlayerState.class, Long.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "itemId", "quantity"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "player"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.StartProductionLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "itemProduction"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteProductionLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "itemProduction", "experienceTable"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.StartShipProductionLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "productionMaterials", "player", "itemProduction"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteShipProductionLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "unassignedShips", "player", "itemProduction", "experienceTable"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.StartCreationLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "itemCreation"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteCreationLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, SkillProcessState.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "itemCreation", "experienceTable"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.ship.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ShipState.class, String.class, Long.class, Long.class, Long.class, Long.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "owner", "healthPoints", "attack", "protection", "speed", "buildingExpenses"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, Integer.class, Long.class, Coordinates.class, BigInteger.class, Coordinates.class, String.class, VerificationContext.class},
                    new String[]{"_", "_", "status", "speed", "updatedCoordinates", "coordinatesUpdatedAt", "targetCoordinates", "shipBattleId"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.CreateEnvironmentRosterLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, Coordinates.class, Long.class, Long.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "coordinates", "shipResourceQuantity", "shipBaseResourceQuantity", "baseExperience"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.AddShipLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, BigInteger.class, VerificationContext.class},
                    new String[]{"_", "_", "ship", "position"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.SetSailLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, Coordinates.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "targetCoordinates"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.UpdateLocationLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, VerificationContext.class},
                    new String[]{"_", "_"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.AdjustShipsPositionLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, BigInteger[].class, String[].class, VerificationContext.class},
                    new String[]{"_", "_", "player", "positions", "shipIds"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TransferShipLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, RosterId.class, BigInteger.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "shipId", "toRoster", "toPosition"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TransferShipInventoryLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, String.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "fromShipId", "toShipId", "itemIdQuantityPairs"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TakeOutShipInventoryLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "shipId", "itemIdQuantityPairs"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.PutInShipInventoryLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "shipId", "itemIdQuantityPairs"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.InitiateBattleLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ShipBattleState.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "initiator", "responder"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.MakeMoveLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ShipBattleState.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "initiator", "responder", "attackerCommand"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.TakeLootLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ShipBattleState.class, Integer.class, VerificationContext.class},
                    new String[]{"_", "_", "player", "loserPlayer", "initiator", "responder", "experienceTable", "choice"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.__Init__Logic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ExperienceTableState.class, VerificationContext.class},
                    new String[]{"_", "_"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.AddLevelLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ExperienceTableState.class, Integer.class, Long.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "level", "experience", "difference"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.UpdateLevelLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ExperienceTableState.class, Integer.class, Long.class, Long.class, VerificationContext.class},
                    new String[]{"_", "_", "level", "experience", "difference"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.__Init__Logic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, MapState.class, VerificationContext.class},
                    new String[]{"_", "_"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.AddIslandLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, MapState.class, Coordinates.class, ItemIdQuantityPairs.class, VerificationContext.class},
                    new String[]{"_", "_", "coordinates", "resources"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.ClaimIslandLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, MapState.class, Coordinates.class, String.class, BigInteger.class, VerificationContext.class},
                    new String[]{"_", "_", "coordinates", "claimedBy", "claimedAt"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.GatherIslandResourcesLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, MapState.class, VerificationContext.class},
                    new String[]{"_", "_", "player"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.item.CreateLogic",
                    "mutate",
                    new Class[]{ItemState.class, String.class, Boolean.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "name", "requiredForCompletion", "sellsFor", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.item.UpdateLogic",
                    "mutate",
                    new Class[]{ItemState.class, String.class, Boolean.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "name", "requiredForCompletion", "sellsFor", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemcreation.CreateLogic",
                    "mutate",
                    new Class[]{ItemCreationState.class, Long.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "resourceCost", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemcreation.UpdateLogic",
                    "mutate",
                    new Class[]{ItemCreationState.class, Long.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "resourceCost", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemproduction.CreateLogic",
                    "mutate",
                    new Class[]{ItemProductionState.class, ItemIdQuantityPairs.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "productionMaterials", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.itemproduction.UpdateLogic",
                    "mutate",
                    new Class[]{ItemProductionState.class, ItemIdQuantityPairs.class, Integer.class, Long.class, Long.class, BigInteger.class, BigInteger.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "productionMaterials", "requirementsLevel", "baseQuantity", "baseExperience", "baseCreationTime", "energyCost", "successRate", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.CreateLogic",
                    "mutate",
                    new Class[]{PlayerState.class, String.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "owner", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.ClaimIslandLogic",
                    "mutate",
                    new Class[]{PlayerState.class, Coordinates.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "coordinates", "claimedAt", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.player.AirdropLogic",
                    "mutate",
                    new Class[]{PlayerState.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "itemId", "quantity", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CreateLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteProductionLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, Boolean.class, Long.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "itemId", "startedAt", "creationTime", "endedAt", "successful", "quantity", "experience", "newLevel", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteShipProductionLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, Boolean.class, Long.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "itemId", "startedAt", "creationTime", "endedAt", "successful", "quantity", "experience", "newLevel", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteCreationLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, Boolean.class, Long.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "itemId", "startedAt", "creationTime", "endedAt", "successful", "quantity", "experience", "newLevel", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.ship.CreateLogic",
                    "mutate",
                    new Class[]{ShipState.class, String.class, Long.class, Long.class, Long.class, Long.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "owner", "healthPoints", "attack", "protection", "speed", "buildingExpenses", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.CreateLogic",
                    "mutate",
                    new Class[]{RosterState.class, Integer.class, Long.class, Coordinates.class, BigInteger.class, Coordinates.class, String.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "status", "speed", "updatedCoordinates", "coordinatesUpdatedAt", "targetCoordinates", "shipBattleId", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.CreateEnvironmentRosterLogic",
                    "mutate",
                    new Class[]{RosterState.class, Coordinates.class, Long.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "coordinates", "shipResourceQuantity", "shipBaseResourceQuantity", "baseExperience", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.AddShipLogic",
                    "mutate",
                    new Class[]{RosterState.class, String.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "ship", "position", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.UpdateLocationLogic",
                    "mutate",
                    new Class[]{RosterState.class, Coordinates.class, BigInteger.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "updatedCoordinates", "coordinatesUpdatedAt", "newStatus", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.AdjustShipsPositionLogic",
                    "mutate",
                    new Class[]{RosterState.class, BigInteger[].class, String[].class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "positions", "shipIds", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TransferShipLogic",
                    "mutate",
                    new Class[]{RosterState.class, String.class, RosterId.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "shipId", "toRosterId", "toPosition", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TransferShipInventoryLogic",
                    "mutate",
                    new Class[]{RosterState.class, String.class, String.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "fromShipId", "toShipId", "itemIdQuantityPairs", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.TakeOutShipInventoryLogic",
                    "mutate",
                    new Class[]{RosterState.class, String.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "shipId", "itemIdQuantityPairs", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.roster.PutInShipInventoryLogic",
                    "mutate",
                    new Class[]{RosterState.class, String.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "shipId", "itemIdQuantityPairs", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.InitiateBattleLogic",
                    "mutate",
                    new Class[]{ShipBattleState.class, String.class, String.class, BigInteger.class, Integer.class, String.class, String.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "initiatorId", "responderId", "startedAt", "firstRoundMover", "firstRoundAttackerShip", "firstRoundDefenderShip", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.MakeMoveLogic",
                    "mutate",
                    new Class[]{ShipBattleState.class, Integer.class, Integer.class, Long.class, Long.class, Long.class, Boolean.class, Integer.class, BigInteger.class, Integer.class, String.class, String.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "attackerCommand", "defenderCommand", "roundNumber", "defenderDamageTaken", "attackerDamageTaken", "isBattleEnded", "winner", "nextRoundStartedAt", "nextRoundMover", "nextRoundAttackerShip", "nextRoundDefenderShip", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.shipbattle.TakeLootLogic",
                    "mutate",
                    new Class[]{ShipBattleState.class, Integer.class, ItemIdQuantityPair[].class, BigInteger.class, Long.class, Integer.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "choice", "loot", "lootedAt", "increasedExperience", "newLevel", "loserIncreasedExperience", "loserNewLevel", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.__Init__Logic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.AddLevelLogic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Integer.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "level", "experience", "difference", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.experiencetable.UpdateLevelLogic",
                    "mutate",
                    new Class[]{ExperienceTableState.class, Integer.class, Long.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "level", "experience", "difference", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.__Init__Logic",
                    "mutate",
                    new Class[]{MapState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.AddIslandLogic",
                    "mutate",
                    new Class[]{MapState.class, Coordinates.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "coordinates", "resources", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.ClaimIslandLogic",
                    "mutate",
                    new Class[]{MapState.class, Coordinates.class, String.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "coordinates", "claimedBy", "claimedAt", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );


        ReflectUtils.assertStaticMethodIfClassExists(
                    "org.dddml.suiinfinitesea.domain.map.GatherIslandResourcesLogic",
                    "mutate",
                    new Class[]{MapState.class, Coordinates.class, ItemIdQuantityPair[].class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new String[]{"_", "coordinates", "resources", "gatheredAt", "suiTimestamp", "suiTxDigest", "suiEventSeq", "suiPackageId", "suiTransactionModule", "suiSender", "suiType", "eventStatus"}
            );



    }

}


