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
import org.dddml.suiinfinitesea.domain.shipbattle.AbstractShipBattleEvent;
import org.dddml.suiinfinitesea.sui.contract.ContractConstants;
import org.dddml.suiinfinitesea.sui.contract.DomainBeanUtils;
import org.dddml.suiinfinitesea.sui.contract.SuiPackage;
import org.dddml.suiinfinitesea.sui.contract.shipbattle.ShipBattleInitiated;
import org.dddml.suiinfinitesea.sui.contract.repository.ShipBattleEventRepository;
import org.dddml.suiinfinitesea.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipBattleEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private ShipBattleEventRepository shipBattleEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractShipBattleEvent event) {
        event.setEventStatus("D");
        shipBattleEventRepository.save(event);
    }

    @Transactional
    public void pullShipBattleInitiatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getShipBattleInitiatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<ShipBattleInitiated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.SHIP_BATTLE_MODULE_SHIP_BATTLE_INITIATED,
                    cursor, limit, false, ShipBattleInitiated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<ShipBattleInitiated> eventEnvelope : eventPage.getData()) {
                    saveShipBattleInitiated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getShipBattleInitiatedEventNextCursor() {
        AbstractShipBattleEvent lastEvent = shipBattleEventRepository.findFirstShipBattleInitiatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveShipBattleInitiated(SuiMoveEventEnvelope<ShipBattleInitiated> eventEnvelope) {
        AbstractShipBattleEvent.ShipBattleInitiated shipBattleInitiated = DomainBeanUtils.toShipBattleInitiated(eventEnvelope);
        if (shipBattleEventRepository.findById(shipBattleInitiated.getShipBattleEventId()).isPresent()) {
            return;
        }
        shipBattleEventRepository.save(shipBattleInitiated);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}
