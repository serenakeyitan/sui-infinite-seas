// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.restful.config;

import org.dddml.suiinfinitesea.sui.contract.ContractConstants;

import java.util.*;

public class SuiCliCheatsheetConstants {
    public static final String PACKAGE_ID_ARGUMENT_HINT = "_PACKAGE_ID_";

    public static Map<String, String> ID_GENERATOR_OBJECT_NAME_TO_ARGUMENT_HINT_MAP;

    static {
        Map<String, String> map = new HashMap<>();
        map.put(ContractConstants.ITEM_MODULE_ITEM_TABLE, "_ITEM_ITEM_TABLE_OBJECT_ID_");
        map.put(ContractConstants.ITEM_CREATION_MODULE_ITEM_CREATION_TABLE, "_ITEM_CREATION_ITEM_CREATION_TABLE_OBJECT_ID_");
        map.put(ContractConstants.ITEM_PRODUCTION_MODULE_ITEM_PRODUCTION_TABLE, "_ITEM_PRODUCTION_ITEM_PRODUCTION_TABLE_OBJECT_ID_");
        map.put(ContractConstants.SKILL_PROCESS_MODULE_SKILL_PROCESS_TABLE, "_SKILL_PROCESS_SKILL_PROCESS_TABLE_OBJECT_ID_");
        map.put(ContractConstants.ROSTER_MODULE_ROSTER_TABLE, "_ROSTER_ROSTER_TABLE_OBJECT_ID_");
        ID_GENERATOR_OBJECT_NAME_TO_ARGUMENT_HINT_MAP = map;
    }

    private SuiCliCheatsheetConstants() {
    }
}
