// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea_player::player {
    use std::option;
    use sui::event;
    use sui::object::{Self, UID};
    use sui::table;
    use sui::transfer;
    use sui::tx_context::TxContext;
    friend infinite_sea_player::player_aggregate;

    const EIdAlreadyExists: u64 = 101;
    #[allow(unused_const)]
    const EDataTooLong: u64 = 102;
    const EInappropriateVersion: u64 = 103;
    const EEmptyObjectID: u64 = 107;

    struct PlayerTable has key {
        id: UID,
        table: table::Table<address, object::ID>,
    }

    struct PlayerTableCreated has copy, drop {
        id: object::ID,
    }

    fun init(ctx: &mut TxContext) {
        let id_generator_table = PlayerTable {
            id: object::new(ctx),
            table: table::new(ctx),
        };
        let id_generator_table_id = object::uid_to_inner(&id_generator_table.id);
        transfer::share_object(id_generator_table);
        event::emit(PlayerTableCreated {
            id: id_generator_table_id,
        });
    }

    struct Player has key {
        id: UID,
        player_id: address,
        version: u64,
        level: u16,
        experience: u32,
    }

    public fun id(player: &Player): object::ID {
        object::uid_to_inner(&player.id)
    }

    public fun player_id(player: &Player): address {
        player.player_id
    }

    public fun version(player: &Player): u64 {
        player.version
    }

    public fun level(player: &Player): u16 {
        player.level
    }

    public(friend) fun set_level(player: &mut Player, level: u16) {
        player.level = level;
    }

    public fun experience(player: &Player): u32 {
        player.experience
    }

    public(friend) fun set_experience(player: &mut Player, experience: u32) {
        player.experience = experience;
    }

    fun new_player(
        player_id: address,
        level: u16,
        experience: u32,
        ctx: &mut TxContext,
    ): Player {
        Player {
            id: object::new(ctx),
            player_id,
            version: 0,
            level,
            experience,
        }
    }


    public(friend) fun create_player(
        player_id: address,
        level: u16,
        experience: u32,
        player_table: &mut PlayerTable,
        ctx: &mut TxContext,
    ): Player {
        let player = new_player(
            player_id,
            level,
            experience,
            ctx,
        );
        asset_player_id_not_exists_then_add(player_id, player_table, object::uid_to_inner(&player.id));
        player
    }

    public(friend) fun asset_player_id_not_exists(
        player_id: address,
        player_table: &PlayerTable,
    ) {
        assert!(!table::contains(&player_table.table, player_id), EIdAlreadyExists);
    }

    fun asset_player_id_not_exists_then_add(
        player_id: address,
        player_table: &mut PlayerTable,
        id: object::ID,
    ) {
        asset_player_id_not_exists(player_id, player_table);
        table::add(&mut player_table.table, player_id, id);
    }

    public(friend) fun transfer_object(player: Player, recipient: address) {
        assert!(player.version == 0, EInappropriateVersion);
        transfer::transfer(player, recipient);
    }

    public(friend) fun update_version_and_transfer_object(player: Player, recipient: address) {
        update_object_version(&mut player);
        transfer::transfer(player, recipient);
    }

    #[lint_allow(share_owned)]
    public(friend) fun share_object(player: Player) {
        assert!(player.version == 0, EInappropriateVersion);
        transfer::share_object(player);
    }

    public(friend) fun freeze_object(player: Player) {
        assert!(player.version == 0, EInappropriateVersion);
        transfer::freeze_object(player);
    }

    public(friend) fun update_version_and_freeze_object(player: Player) {
        update_object_version(&mut player);
        transfer::freeze_object(player);
    }

    fun update_object_version(player: &mut Player) {
        player.version = player.version + 1;
        //assert!(player.version != 0, EInappropriateVersion);
    }

    public(friend) fun drop_player(player: Player) {
        let Player {
            id,
            player_id: _player_id,
            version: _version,
            level: _level,
            experience: _experience,
        } = player;
        object::delete(id);
    }

    #[test_only]
    /// Wrapper of module initializer for testing
    public fun test_init(ctx: &mut TxContext) {
        init(ctx)
    }

}
