// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea::item_production_aggregate {
    use infinite_sea::item_production;
    use infinite_sea::item_production_create_logic;
    use infinite_sea::item_production_update_logic;
    use infinite_sea_common::production_materials::{Self, ProductionMaterials};
    use infinite_sea_common::skill_type_item_id_pair::{Self, SkillTypeItemIdPair};
    use std::option::Option;
    use sui::tx_context;

    friend infinite_sea::skill_process_service;

    const EInvalidPublisher: u64 = 50;

    public entry fun create(
        item_production_id_skill_type: u8,
        item_production_id_item_id: u32,
        publisher: &sui::package::Publisher,
        production_materials_material_item_id_1: u32,
        production_materials_material_quantity_1: u32,
        production_materials_material_item_id_2: Option<u32>,
        production_materials_material_quantity_2: Option<u32>,
        production_materials_material_item_id_3: Option<u32>,
        production_materials_material_quantity_3: Option<u32>,
        production_materials_material_item_id_4: Option<u32>,
        production_materials_material_quantity_4: Option<u32>,
        production_materials_material_item_id_5: Option<u32>,
        production_materials_material_quantity_5: Option<u32>,
        requirements_level: u16,
        base_quantity: u32,
        base_experience: u32,
        base_creation_time: u64,
        energy_cost: u64,
        success_rate: u16,
        item_production_table: &mut item_production::ItemProductionTable,
        ctx: &mut tx_context::TxContext,
    ) {
        assert!(sui::package::from_package<item_production::ItemProduction>(publisher), EInvalidPublisher);
        let item_production_id: SkillTypeItemIdPair = skill_type_item_id_pair::new(
            item_production_id_skill_type,
            item_production_id_item_id,
        );

        let production_materials: ProductionMaterials = production_materials::new(
            production_materials_material_item_id_1,
            production_materials_material_quantity_1,
            production_materials_material_item_id_2,
            production_materials_material_quantity_2,
            production_materials_material_item_id_3,
            production_materials_material_quantity_3,
            production_materials_material_item_id_4,
            production_materials_material_quantity_4,
            production_materials_material_item_id_5,
            production_materials_material_quantity_5,
        );
        let item_production_created = item_production_create_logic::verify(
            item_production_id,
            production_materials,
            requirements_level,
            base_quantity,
            base_experience,
            base_creation_time,
            energy_cost,
            success_rate,
            item_production_table,
            ctx,
        );
        let item_production = item_production_create_logic::mutate(
            &item_production_created,
            item_production_table,
            ctx,
        );
        item_production::set_item_production_created_id(&mut item_production_created, item_production::id(&item_production));
        item_production::share_object(item_production);
        item_production::emit_item_production_created(item_production_created);
    }

    public entry fun update(
        item_production: &mut item_production::ItemProduction,
        publisher: &sui::package::Publisher,
        production_materials_material_item_id_1: u32,
        production_materials_material_quantity_1: u32,
        production_materials_material_item_id_2: Option<u32>,
        production_materials_material_quantity_2: Option<u32>,
        production_materials_material_item_id_3: Option<u32>,
        production_materials_material_quantity_3: Option<u32>,
        production_materials_material_item_id_4: Option<u32>,
        production_materials_material_quantity_4: Option<u32>,
        production_materials_material_item_id_5: Option<u32>,
        production_materials_material_quantity_5: Option<u32>,
        requirements_level: u16,
        base_quantity: u32,
        base_experience: u32,
        base_creation_time: u64,
        energy_cost: u64,
        success_rate: u16,
        ctx: &mut tx_context::TxContext,
    ) {
        assert!(sui::package::from_package<item_production::ItemProduction>(publisher), EInvalidPublisher);
        let production_materials: ProductionMaterials = production_materials::new(
            production_materials_material_item_id_1,
            production_materials_material_quantity_1,
            production_materials_material_item_id_2,
            production_materials_material_quantity_2,
            production_materials_material_item_id_3,
            production_materials_material_quantity_3,
            production_materials_material_item_id_4,
            production_materials_material_quantity_4,
            production_materials_material_item_id_5,
            production_materials_material_quantity_5,
        );
        let item_production_updated = item_production_update_logic::verify(
            production_materials,
            requirements_level,
            base_quantity,
            base_experience,
            base_creation_time,
            energy_cost,
            success_rate,
            item_production,
            ctx,
        );
        item_production_update_logic::mutate(
            &item_production_updated,
            item_production,
            ctx,
        );
        item_production::update_object_version(item_production);
        item_production::emit_item_production_updated(item_production_updated);
    }

}
