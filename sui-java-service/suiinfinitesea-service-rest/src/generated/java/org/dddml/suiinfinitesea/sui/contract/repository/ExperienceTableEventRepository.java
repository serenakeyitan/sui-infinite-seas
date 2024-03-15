// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.repository;

import org.dddml.suiinfinitesea.domain.experiencetable.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ExperienceTableEventRepository extends JpaRepository<AbstractExperienceTableEvent, ExperienceTableEventId> {

    List<AbstractExperienceTableEvent> findByStatusIsNull();

    AbstractExperienceTableEvent.InitExperienceTableEvent findFirstInitExperienceTableEventByOrderBySuiTimestampDesc();

    AbstractExperienceTableEvent.ExperienceLevelAdded findFirstExperienceLevelAddedByOrderBySuiTimestampDesc();

    AbstractExperienceTableEvent.ExperienceLevelUpdated findFirstExperienceLevelUpdatedByOrderBySuiTimestampDesc();

}
