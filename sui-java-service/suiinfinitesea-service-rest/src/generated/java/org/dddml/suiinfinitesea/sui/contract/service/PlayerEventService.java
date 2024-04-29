// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.service;

import com.github.wubuku.sui.bean.EventId;
import com.github.wubuku.sui.bean.Page;
import com.github.wubuku.sui.bean.PaginatedMoveEvents;
import com.github.wubuku.sui.bean.SuiMoveEventEnvelope;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.dddml.suiinfinitesea.domain.player.AbstractPlayerEvent;
import org.dddml.suiinfinitesea.sui.contract.ContractConstants;
import org.dddml.suiinfinitesea.sui.contract.DomainBeanUtils;
import org.dddml.suiinfinitesea.sui.contract.SuiPackage;
import org.dddml.suiinfinitesea.sui.contract.player.PlayerCreated;
import org.dddml.suiinfinitesea.sui.contract.player.IslandClaimed;
import org.dddml.suiinfinitesea.sui.contract.player.PlayerAirdropped;
import org.dddml.suiinfinitesea.sui.contract.player.PlayerItemsDeducted;
import org.dddml.suiinfinitesea.sui.contract.player.PlayerExperienceAndItemsIncreased;
import org.dddml.suiinfinitesea.sui.contract.repository.PlayerEventRepository;
import org.dddml.suiinfinitesea.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private PlayerEventRepository playerEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractPlayerEvent event) {
        event.setEventStatus("D");
        playerEventRepository.save(event);
    }

    @Transactional
    public void pullPlayerCreatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getPlayerCreatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<PlayerCreated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.PLAYER_MODULE_PLAYER_CREATED,
                    cursor, limit, false, PlayerCreated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<PlayerCreated> eventEnvelope : eventPage.getData()) {
                    savePlayerCreated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getPlayerCreatedEventNextCursor() {
        AbstractPlayerEvent lastEvent = playerEventRepository.findFirstPlayerCreatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void savePlayerCreated(SuiMoveEventEnvelope<PlayerCreated> eventEnvelope) {
        AbstractPlayerEvent.PlayerCreated playerCreated = DomainBeanUtils.toPlayerCreated(eventEnvelope);
        if (playerEventRepository.findById(playerCreated.getPlayerEventId()).isPresent()) {
            return;
        }
        playerEventRepository.save(playerCreated);
    }

    @Transactional
    public void pullIslandClaimedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getIslandClaimedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<IslandClaimed> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.PLAYER_MODULE_ISLAND_CLAIMED,
                    cursor, limit, false, IslandClaimed.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<IslandClaimed> eventEnvelope : eventPage.getData()) {
                    saveIslandClaimed(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getIslandClaimedEventNextCursor() {
        AbstractPlayerEvent lastEvent = playerEventRepository.findFirstIslandClaimedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveIslandClaimed(SuiMoveEventEnvelope<IslandClaimed> eventEnvelope) {
        AbstractPlayerEvent.IslandClaimed islandClaimed = DomainBeanUtils.toIslandClaimed(eventEnvelope);
        if (playerEventRepository.findById(islandClaimed.getPlayerEventId()).isPresent()) {
            return;
        }
        playerEventRepository.save(islandClaimed);
    }

    @Transactional
    public void pullPlayerAirdroppedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getPlayerAirdroppedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<PlayerAirdropped> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.PLAYER_MODULE_PLAYER_AIRDROPPED,
                    cursor, limit, false, PlayerAirdropped.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<PlayerAirdropped> eventEnvelope : eventPage.getData()) {
                    savePlayerAirdropped(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getPlayerAirdroppedEventNextCursor() {
        AbstractPlayerEvent lastEvent = playerEventRepository.findFirstPlayerAirdroppedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void savePlayerAirdropped(SuiMoveEventEnvelope<PlayerAirdropped> eventEnvelope) {
        AbstractPlayerEvent.PlayerAirdropped playerAirdropped = DomainBeanUtils.toPlayerAirdropped(eventEnvelope);
        if (playerEventRepository.findById(playerAirdropped.getPlayerEventId()).isPresent()) {
            return;
        }
        playerEventRepository.save(playerAirdropped);
    }

    @Transactional
    public void pullPlayerItemsDeductedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getPlayerItemsDeductedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<PlayerItemsDeducted> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.PLAYER_MODULE_PLAYER_ITEMS_DEDUCTED,
                    cursor, limit, false, PlayerItemsDeducted.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<PlayerItemsDeducted> eventEnvelope : eventPage.getData()) {
                    savePlayerItemsDeducted(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getPlayerItemsDeductedEventNextCursor() {
        AbstractPlayerEvent lastEvent = playerEventRepository.findFirstPlayerItemsDeductedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void savePlayerItemsDeducted(SuiMoveEventEnvelope<PlayerItemsDeducted> eventEnvelope) {
        AbstractPlayerEvent.PlayerItemsDeducted playerItemsDeducted = DomainBeanUtils.toPlayerItemsDeducted(eventEnvelope);
        if (playerEventRepository.findById(playerItemsDeducted.getPlayerEventId()).isPresent()) {
            return;
        }
        playerEventRepository.save(playerItemsDeducted);
    }

    @Transactional
    public void pullPlayerExperienceAndItemsIncreasedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getPlayerExperienceAndItemsIncreasedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<PlayerExperienceAndItemsIncreased> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.PLAYER_MODULE_PLAYER_EXPERIENCE_AND_ITEMS_INCREASED,
                    cursor, limit, false, PlayerExperienceAndItemsIncreased.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<PlayerExperienceAndItemsIncreased> eventEnvelope : eventPage.getData()) {
                    savePlayerExperienceAndItemsIncreased(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getPlayerExperienceAndItemsIncreasedEventNextCursor() {
        AbstractPlayerEvent lastEvent = playerEventRepository.findFirstPlayerExperienceAndItemsIncreasedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void savePlayerExperienceAndItemsIncreased(SuiMoveEventEnvelope<PlayerExperienceAndItemsIncreased> eventEnvelope) {
        AbstractPlayerEvent.PlayerExperienceAndItemsIncreased playerExperienceAndItemsIncreased = DomainBeanUtils.toPlayerExperienceAndItemsIncreased(eventEnvelope);
        if (playerEventRepository.findById(playerExperienceAndItemsIncreased.getPlayerEventId()).isPresent()) {
            return;
        }
        playerEventRepository.save(playerExperienceAndItemsIncreased);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}
