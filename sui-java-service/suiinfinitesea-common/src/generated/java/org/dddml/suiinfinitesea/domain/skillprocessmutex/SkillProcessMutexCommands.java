// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocessmutex;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;

public class SkillProcessMutexCommands {
    private SkillProcessMutexCommands() {
    }

    public static class Create extends AbstractSkillProcessMutexCommand implements SkillProcessMutexCommand {

        public String getCommandType() {
            return "Create";
        }

        public void setCommandType(String commandType) {
            //do nothing
        }

        /**
         * Player Id
         */
        private String playerId;

        public String getPlayerId() {
            return this.playerId;
        }

        public void setPlayerId(String playerId) {
            this.playerId = playerId;
        }

        /**
         * Off Chain Version
         */
        private Long offChainVersion;

        public Long getOffChainVersion() {
            return this.offChainVersion;
        }

        public void setOffChainVersion(Long offChainVersion) {
            this.offChainVersion = offChainVersion;
        }

    }

}

