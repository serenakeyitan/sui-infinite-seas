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
import org.dddml.suiinfinitesea.domain.experiencetable.AbstractExperienceTableEvent;
import org.dddml.suiinfinitesea.sui.contract.ContractConstants;
import org.dddml.suiinfinitesea.sui.contract.DomainBeanUtils;
import org.dddml.suiinfinitesea.sui.contract.SuiPackage;
import org.dddml.suiinfinitesea.sui.contract.experiencetable.InitExperienceTableEvent;
import org.dddml.suiinfinitesea.sui.contract.experiencetable.ExperienceLevelAdded;
import org.dddml.suiinfinitesea.sui.contract.experiencetable.ExperienceLevelUpdated;
import org.dddml.suiinfinitesea.sui.contract.repository.ExperienceTableEventRepository;
import org.dddml.suiinfinitesea.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExperienceTableEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private ExperienceTableEventRepository experienceTableEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractExperienceTableEvent event) {
        event.setStatus("D");
        experienceTableEventRepository.save(event);
    }

    @Transactional
    public void pullInitExperienceTableEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getInitExperienceTableEventNextCursor();
        while (true) {
            PaginatedMoveEvents<InitExperienceTableEvent> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.EXPERIENCE_TABLE_MODULE_INIT_EXPERIENCE_TABLE_EVENT,
                    cursor, limit, false, InitExperienceTableEvent.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<InitExperienceTableEvent> eventEnvelope : eventPage.getData()) {
                    saveInitExperienceTableEvent(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getInitExperienceTableEventNextCursor() {
        AbstractExperienceTableEvent lastEvent = experienceTableEventRepository.findFirstInitExperienceTableEventByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveInitExperienceTableEvent(SuiMoveEventEnvelope<InitExperienceTableEvent> eventEnvelope) {
        AbstractExperienceTableEvent.InitExperienceTableEvent initExperienceTableEvent = DomainBeanUtils.toInitExperienceTableEvent(eventEnvelope);
        if (experienceTableEventRepository.findById(initExperienceTableEvent.getExperienceTableEventId()).isPresent()) {
            return;
        }
        experienceTableEventRepository.save(initExperienceTableEvent);
    }

    @Transactional
    public void pullExperienceLevelAddedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getExperienceLevelAddedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<ExperienceLevelAdded> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.EXPERIENCE_TABLE_MODULE_EXPERIENCE_LEVEL_ADDED,
                    cursor, limit, false, ExperienceLevelAdded.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<ExperienceLevelAdded> eventEnvelope : eventPage.getData()) {
                    saveExperienceLevelAdded(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getExperienceLevelAddedEventNextCursor() {
        AbstractExperienceTableEvent lastEvent = experienceTableEventRepository.findFirstExperienceLevelAddedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveExperienceLevelAdded(SuiMoveEventEnvelope<ExperienceLevelAdded> eventEnvelope) {
        AbstractExperienceTableEvent.ExperienceLevelAdded experienceLevelAdded = DomainBeanUtils.toExperienceLevelAdded(eventEnvelope);
        if (experienceTableEventRepository.findById(experienceLevelAdded.getExperienceTableEventId()).isPresent()) {
            return;
        }
        experienceTableEventRepository.save(experienceLevelAdded);
    }

    @Transactional
    public void pullExperienceLevelUpdatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getExperienceLevelUpdatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<ExperienceLevelUpdated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.EXPERIENCE_TABLE_MODULE_EXPERIENCE_LEVEL_UPDATED,
                    cursor, limit, false, ExperienceLevelUpdated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<ExperienceLevelUpdated> eventEnvelope : eventPage.getData()) {
                    saveExperienceLevelUpdated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getExperienceLevelUpdatedEventNextCursor() {
        AbstractExperienceTableEvent lastEvent = experienceTableEventRepository.findFirstExperienceLevelUpdatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveExperienceLevelUpdated(SuiMoveEventEnvelope<ExperienceLevelUpdated> eventEnvelope) {
        AbstractExperienceTableEvent.ExperienceLevelUpdated experienceLevelUpdated = DomainBeanUtils.toExperienceLevelUpdated(eventEnvelope);
        if (experienceTableEventRepository.findById(experienceLevelUpdated.getExperienceTableEventId()).isPresent()) {
            return;
        }
        experienceTableEventRepository.save(experienceLevelUpdated);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}
