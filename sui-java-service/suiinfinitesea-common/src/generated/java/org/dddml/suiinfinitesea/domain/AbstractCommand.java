// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain;

import org.dddml.suiinfinitesea.specialization.CommandType;

public abstract class AbstractCommand implements Command {

    protected String commandType;

    public String getCommandType() {
        return this.commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    private String commandId;

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private String requesterId;

    public String getRequesterId() {
        return this.requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    private java.util.Map<String, Object> commandContext = new java.util.HashMap<>();

    public java.util.Map<String, Object> getCommandContext() {
        return commandContext;
    }

    public void setCommandContext(java.util.Map<String, Object> commandContext) {
        this.commandContext = commandContext;
    }

}


