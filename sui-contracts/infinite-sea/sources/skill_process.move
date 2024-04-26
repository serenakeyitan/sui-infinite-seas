// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea::skill_process {
    use infinite_sea_coin::energy::ENERGY;
    use infinite_sea_common::item_id_quantity_pairs::ItemIdQuantityPairs;
    use infinite_sea_common::skill_process_id::SkillProcessId;
    use std::option::{Self, Option};
    use sui::balance::Balance;
    use sui::event;
    use sui::object::{Self, UID};
    use sui::table;
    use sui::transfer;
    use sui::tx_context::TxContext;

    struct SKILL_PROCESS has drop {}

    friend infinite_sea::skill_process_create_logic;
    friend infinite_sea::skill_process_start_production_logic;
    friend infinite_sea::skill_process_complete_production_logic;
    friend infinite_sea::skill_process_start_ship_production_logic;
    friend infinite_sea::skill_process_complete_ship_production_logic;
    friend infinite_sea::skill_process_start_creation_logic;
    friend infinite_sea::skill_process_complete_creation_logic;
    friend infinite_sea::skill_process_aggregate;

    const EIdAlreadyExists: u64 = 101;
    #[allow(unused_const)]
    const EDataTooLong: u64 = 102;
    #[allow(unused_const)]
    const EInappropriateVersion: u64 = 103;
    const EEmptyObjectID: u64 = 107;

    struct SkillProcessTable has key {
        id: UID,
        table: table::Table<SkillProcessId, object::ID>,
    }

    struct SkillProcessTableCreated has copy, drop {
        id: object::ID,
    }

    fun init(otw: SKILL_PROCESS, ctx: &mut TxContext) {
        sui::package::claim_and_keep(otw, ctx);
        let id_generator_table = SkillProcessTable {
            id: object::new(ctx),
            table: table::new(ctx),
        };
        let id_generator_table_id = object::uid_to_inner(&id_generator_table.id);
        transfer::share_object(id_generator_table);
        event::emit(SkillProcessTableCreated {
            id: id_generator_table_id,
        });
    }

    struct SkillProcess has key {
        id: UID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        completed: bool,
        ended_at: u64,
        energy_vault: Balance<ENERGY>,
        production_materials: Option<ItemIdQuantityPairs>,
    }

    public fun id(skill_process: &SkillProcess): object::ID {
        object::uid_to_inner(&skill_process.id)
    }

    public fun skill_process_id(skill_process: &SkillProcess): SkillProcessId {
        skill_process.skill_process_id
    }

    public fun version(skill_process: &SkillProcess): u64 {
        skill_process.version
    }

    public fun item_id(skill_process: &SkillProcess): u32 {
        skill_process.item_id
    }

    public(friend) fun set_item_id(skill_process: &mut SkillProcess, item_id: u32) {
        skill_process.item_id = item_id;
    }

    public fun started_at(skill_process: &SkillProcess): u64 {
        skill_process.started_at
    }

    public(friend) fun set_started_at(skill_process: &mut SkillProcess, started_at: u64) {
        skill_process.started_at = started_at;
    }

    public fun creation_time(skill_process: &SkillProcess): u64 {
        skill_process.creation_time
    }

    public(friend) fun set_creation_time(skill_process: &mut SkillProcess, creation_time: u64) {
        skill_process.creation_time = creation_time;
    }

    public fun completed(skill_process: &SkillProcess): bool {
        skill_process.completed
    }

    public(friend) fun set_completed(skill_process: &mut SkillProcess, completed: bool) {
        skill_process.completed = completed;
    }

    public fun ended_at(skill_process: &SkillProcess): u64 {
        skill_process.ended_at
    }

    public(friend) fun set_ended_at(skill_process: &mut SkillProcess, ended_at: u64) {
        skill_process.ended_at = ended_at;
    }

    public fun borrow_energy_vault(skill_process: &SkillProcess): &Balance<ENERGY> {
        &skill_process.energy_vault
    }

    public(friend) fun borrow_mut_energy_vault(skill_process: &mut SkillProcess): &mut Balance<ENERGY> {
        &mut skill_process.energy_vault
    }

    public fun production_materials(skill_process: &SkillProcess): Option<ItemIdQuantityPairs> {
        skill_process.production_materials
    }

    public(friend) fun set_production_materials(skill_process: &mut SkillProcess, production_materials: Option<ItemIdQuantityPairs>) {
        skill_process.production_materials = production_materials;
    }

    fun new_skill_process(
        skill_process_id: SkillProcessId,
        ctx: &mut TxContext,
    ): SkillProcess {
        SkillProcess {
            id: object::new(ctx),
            skill_process_id,
            version: 0,
            item_id: infinite_sea_common::item_id::unused_item(),
            started_at: 0,
            creation_time: 0,
            completed: true,
            ended_at: 0,
            energy_vault: sui::balance::zero(),
            production_materials: std::option::none(),
        }
    }

    struct SkillProcessCreated has copy, drop {
        id: option::Option<object::ID>,
        skill_process_id: SkillProcessId,
    }

    public fun skill_process_created_id(skill_process_created: &SkillProcessCreated): option::Option<object::ID> {
        skill_process_created.id
    }

    public(friend) fun set_skill_process_created_id(skill_process_created: &mut SkillProcessCreated, id: object::ID) {
        skill_process_created.id = option::some(id);
    }

    public fun skill_process_created_skill_process_id(skill_process_created: &SkillProcessCreated): SkillProcessId {
        skill_process_created.skill_process_id
    }

    public(friend) fun new_skill_process_created(
        skill_process_id: SkillProcessId,
    ): SkillProcessCreated {
        SkillProcessCreated {
            id: option::none(),
            skill_process_id,
        }
    }

    struct ProductionProcessStarted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        energy_cost: u64,
        started_at: u64,
        creation_time: u64,
        production_materials: ItemIdQuantityPairs,
    }

    public fun production_process_started_id(production_process_started: &ProductionProcessStarted): object::ID {
        production_process_started.id
    }

    public fun production_process_started_skill_process_id(production_process_started: &ProductionProcessStarted): SkillProcessId {
        production_process_started.skill_process_id
    }

    public fun production_process_started_item_id(production_process_started: &ProductionProcessStarted): u32 {
        production_process_started.item_id
    }

    public fun production_process_started_energy_cost(production_process_started: &ProductionProcessStarted): u64 {
        production_process_started.energy_cost
    }

    public fun production_process_started_started_at(production_process_started: &ProductionProcessStarted): u64 {
        production_process_started.started_at
    }

    public fun production_process_started_creation_time(production_process_started: &ProductionProcessStarted): u64 {
        production_process_started.creation_time
    }

    public fun production_process_started_production_materials(production_process_started: &ProductionProcessStarted): ItemIdQuantityPairs {
        production_process_started.production_materials
    }

    public(friend) fun new_production_process_started(
        skill_process: &SkillProcess,
        item_id: u32,
        energy_cost: u64,
        started_at: u64,
        creation_time: u64,
        production_materials: ItemIdQuantityPairs,
    ): ProductionProcessStarted {
        ProductionProcessStarted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            energy_cost,
            started_at,
            creation_time,
            production_materials,
        }
    }

    struct ProductionProcessCompleted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    }

    public fun production_process_completed_id(production_process_completed: &ProductionProcessCompleted): object::ID {
        production_process_completed.id
    }

    public fun production_process_completed_skill_process_id(production_process_completed: &ProductionProcessCompleted): SkillProcessId {
        production_process_completed.skill_process_id
    }

    public fun production_process_completed_item_id(production_process_completed: &ProductionProcessCompleted): u32 {
        production_process_completed.item_id
    }

    public fun production_process_completed_started_at(production_process_completed: &ProductionProcessCompleted): u64 {
        production_process_completed.started_at
    }

    public fun production_process_completed_creation_time(production_process_completed: &ProductionProcessCompleted): u64 {
        production_process_completed.creation_time
    }

    public fun production_process_completed_ended_at(production_process_completed: &ProductionProcessCompleted): u64 {
        production_process_completed.ended_at
    }

    public fun production_process_completed_successful(production_process_completed: &ProductionProcessCompleted): bool {
        production_process_completed.successful
    }

    public fun production_process_completed_quantity(production_process_completed: &ProductionProcessCompleted): u32 {
        production_process_completed.quantity
    }

    public fun production_process_completed_experience(production_process_completed: &ProductionProcessCompleted): u32 {
        production_process_completed.experience
    }

    public fun production_process_completed_new_level(production_process_completed: &ProductionProcessCompleted): u16 {
        production_process_completed.new_level
    }

    public(friend) fun new_production_process_completed(
        skill_process: &SkillProcess,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    ): ProductionProcessCompleted {
        ProductionProcessCompleted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            started_at,
            creation_time,
            ended_at,
            successful,
            quantity,
            experience,
            new_level,
        }
    }

    struct ShipProductionProcessStarted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        energy_cost: u64,
        started_at: u64,
        creation_time: u64,
        production_materials: ItemIdQuantityPairs,
    }

    public fun ship_production_process_started_id(ship_production_process_started: &ShipProductionProcessStarted): object::ID {
        ship_production_process_started.id
    }

    public fun ship_production_process_started_skill_process_id(ship_production_process_started: &ShipProductionProcessStarted): SkillProcessId {
        ship_production_process_started.skill_process_id
    }

    public fun ship_production_process_started_item_id(ship_production_process_started: &ShipProductionProcessStarted): u32 {
        ship_production_process_started.item_id
    }

    public fun ship_production_process_started_energy_cost(ship_production_process_started: &ShipProductionProcessStarted): u64 {
        ship_production_process_started.energy_cost
    }

    public fun ship_production_process_started_started_at(ship_production_process_started: &ShipProductionProcessStarted): u64 {
        ship_production_process_started.started_at
    }

    public fun ship_production_process_started_creation_time(ship_production_process_started: &ShipProductionProcessStarted): u64 {
        ship_production_process_started.creation_time
    }

    public fun ship_production_process_started_production_materials(ship_production_process_started: &ShipProductionProcessStarted): ItemIdQuantityPairs {
        ship_production_process_started.production_materials
    }

    public(friend) fun new_ship_production_process_started(
        skill_process: &SkillProcess,
        item_id: u32,
        energy_cost: u64,
        started_at: u64,
        creation_time: u64,
        production_materials: ItemIdQuantityPairs,
    ): ShipProductionProcessStarted {
        ShipProductionProcessStarted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            energy_cost,
            started_at,
            creation_time,
            production_materials,
        }
    }

    struct ShipProductionProcessCompleted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    }

    public fun ship_production_process_completed_id(ship_production_process_completed: &ShipProductionProcessCompleted): object::ID {
        ship_production_process_completed.id
    }

    public fun ship_production_process_completed_skill_process_id(ship_production_process_completed: &ShipProductionProcessCompleted): SkillProcessId {
        ship_production_process_completed.skill_process_id
    }

    public fun ship_production_process_completed_item_id(ship_production_process_completed: &ShipProductionProcessCompleted): u32 {
        ship_production_process_completed.item_id
    }

    public fun ship_production_process_completed_started_at(ship_production_process_completed: &ShipProductionProcessCompleted): u64 {
        ship_production_process_completed.started_at
    }

    public fun ship_production_process_completed_creation_time(ship_production_process_completed: &ShipProductionProcessCompleted): u64 {
        ship_production_process_completed.creation_time
    }

    public fun ship_production_process_completed_ended_at(ship_production_process_completed: &ShipProductionProcessCompleted): u64 {
        ship_production_process_completed.ended_at
    }

    public fun ship_production_process_completed_successful(ship_production_process_completed: &ShipProductionProcessCompleted): bool {
        ship_production_process_completed.successful
    }

    public fun ship_production_process_completed_quantity(ship_production_process_completed: &ShipProductionProcessCompleted): u32 {
        ship_production_process_completed.quantity
    }

    public fun ship_production_process_completed_experience(ship_production_process_completed: &ShipProductionProcessCompleted): u32 {
        ship_production_process_completed.experience
    }

    public fun ship_production_process_completed_new_level(ship_production_process_completed: &ShipProductionProcessCompleted): u16 {
        ship_production_process_completed.new_level
    }

    public(friend) fun new_ship_production_process_completed(
        skill_process: &SkillProcess,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    ): ShipProductionProcessCompleted {
        ShipProductionProcessCompleted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            started_at,
            creation_time,
            ended_at,
            successful,
            quantity,
            experience,
            new_level,
        }
    }

    struct CreationProcessStarted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        energy_cost: u64,
        resource_cost: u32,
        started_at: u64,
        creation_time: u64,
    }

    public fun creation_process_started_id(creation_process_started: &CreationProcessStarted): object::ID {
        creation_process_started.id
    }

    public fun creation_process_started_skill_process_id(creation_process_started: &CreationProcessStarted): SkillProcessId {
        creation_process_started.skill_process_id
    }

    public fun creation_process_started_item_id(creation_process_started: &CreationProcessStarted): u32 {
        creation_process_started.item_id
    }

    public fun creation_process_started_energy_cost(creation_process_started: &CreationProcessStarted): u64 {
        creation_process_started.energy_cost
    }

    public fun creation_process_started_resource_cost(creation_process_started: &CreationProcessStarted): u32 {
        creation_process_started.resource_cost
    }

    public fun creation_process_started_started_at(creation_process_started: &CreationProcessStarted): u64 {
        creation_process_started.started_at
    }

    public fun creation_process_started_creation_time(creation_process_started: &CreationProcessStarted): u64 {
        creation_process_started.creation_time
    }

    public(friend) fun new_creation_process_started(
        skill_process: &SkillProcess,
        item_id: u32,
        energy_cost: u64,
        resource_cost: u32,
        started_at: u64,
        creation_time: u64,
    ): CreationProcessStarted {
        CreationProcessStarted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            energy_cost,
            resource_cost,
            started_at,
            creation_time,
        }
    }

    struct CreationProcessCompleted has copy, drop {
        id: object::ID,
        skill_process_id: SkillProcessId,
        version: u64,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    }

    public fun creation_process_completed_id(creation_process_completed: &CreationProcessCompleted): object::ID {
        creation_process_completed.id
    }

    public fun creation_process_completed_skill_process_id(creation_process_completed: &CreationProcessCompleted): SkillProcessId {
        creation_process_completed.skill_process_id
    }

    public fun creation_process_completed_item_id(creation_process_completed: &CreationProcessCompleted): u32 {
        creation_process_completed.item_id
    }

    public fun creation_process_completed_started_at(creation_process_completed: &CreationProcessCompleted): u64 {
        creation_process_completed.started_at
    }

    public fun creation_process_completed_creation_time(creation_process_completed: &CreationProcessCompleted): u64 {
        creation_process_completed.creation_time
    }

    public fun creation_process_completed_ended_at(creation_process_completed: &CreationProcessCompleted): u64 {
        creation_process_completed.ended_at
    }

    public fun creation_process_completed_successful(creation_process_completed: &CreationProcessCompleted): bool {
        creation_process_completed.successful
    }

    public fun creation_process_completed_quantity(creation_process_completed: &CreationProcessCompleted): u32 {
        creation_process_completed.quantity
    }

    public fun creation_process_completed_experience(creation_process_completed: &CreationProcessCompleted): u32 {
        creation_process_completed.experience
    }

    public fun creation_process_completed_new_level(creation_process_completed: &CreationProcessCompleted): u16 {
        creation_process_completed.new_level
    }

    public(friend) fun new_creation_process_completed(
        skill_process: &SkillProcess,
        item_id: u32,
        started_at: u64,
        creation_time: u64,
        ended_at: u64,
        successful: bool,
        quantity: u32,
        experience: u32,
        new_level: u16,
    ): CreationProcessCompleted {
        CreationProcessCompleted {
            id: id(skill_process),
            skill_process_id: skill_process_id(skill_process),
            version: version(skill_process),
            item_id,
            started_at,
            creation_time,
            ended_at,
            successful,
            quantity,
            experience,
            new_level,
        }
    }


    public(friend) fun create_skill_process(
        skill_process_id: SkillProcessId,
        skill_process_table: &mut SkillProcessTable,
        ctx: &mut TxContext,
    ): SkillProcess {
        let skill_process = new_skill_process(
            skill_process_id,
            ctx,
        );
        asset_skill_process_id_not_exists_then_add(skill_process_id, skill_process_table, object::uid_to_inner(&skill_process.id));
        skill_process
    }

    public(friend) fun asset_skill_process_id_not_exists(
        skill_process_id: SkillProcessId,
        skill_process_table: &SkillProcessTable,
    ) {
        assert!(!table::contains(&skill_process_table.table, skill_process_id), EIdAlreadyExists);
    }

    fun asset_skill_process_id_not_exists_then_add(
        skill_process_id: SkillProcessId,
        skill_process_table: &mut SkillProcessTable,
        id: object::ID,
    ) {
        asset_skill_process_id_not_exists(skill_process_id, skill_process_table);
        table::add(&mut skill_process_table.table, skill_process_id, id);
    }

    #[lint_allow(share_owned)]
    public(friend) fun share_object(skill_process: SkillProcess) {
        assert!(skill_process.version == 0, EInappropriateVersion);
        transfer::share_object(skill_process);
    }

    public(friend) fun update_object_version(skill_process: &mut SkillProcess) {
        skill_process.version = skill_process.version + 1;
        //assert!(skill_process.version != 0, EInappropriateVersion);
    }

    public(friend) fun drop_skill_process(skill_process: SkillProcess) {
        let SkillProcess {
            id,
            skill_process_id: _skill_process_id,
            version: _version,
            item_id: _item_id,
            started_at: _started_at,
            creation_time: _creation_time,
            completed: _completed,
            ended_at: _ended_at,
            energy_vault,
            production_materials: _production_materials,
        } = skill_process;
        object::delete(id);
        sui::balance::destroy_zero(energy_vault);
    }

    public(friend) fun emit_skill_process_created(skill_process_created: SkillProcessCreated) {
        assert!(std::option::is_some(&skill_process_created.id), EEmptyObjectID);
        event::emit(skill_process_created);
    }

    public(friend) fun emit_production_process_started(production_process_started: ProductionProcessStarted) {
        event::emit(production_process_started);
    }

    public(friend) fun emit_production_process_completed(production_process_completed: ProductionProcessCompleted) {
        event::emit(production_process_completed);
    }

    public(friend) fun emit_ship_production_process_started(ship_production_process_started: ShipProductionProcessStarted) {
        event::emit(ship_production_process_started);
    }

    public(friend) fun emit_ship_production_process_completed(ship_production_process_completed: ShipProductionProcessCompleted) {
        event::emit(ship_production_process_completed);
    }

    public(friend) fun emit_creation_process_started(creation_process_started: CreationProcessStarted) {
        event::emit(creation_process_started);
    }

    public(friend) fun emit_creation_process_completed(creation_process_completed: CreationProcessCompleted) {
        event::emit(creation_process_completed);
    }

}
