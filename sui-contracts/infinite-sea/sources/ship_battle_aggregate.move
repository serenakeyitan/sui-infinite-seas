// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea::ship_battle_aggregate {
    use infinite_sea::player::Player;
    use infinite_sea::roster::Roster;
    use infinite_sea::ship_battle;
    use infinite_sea::ship_battle_initiate_battle_logic;
    use infinite_sea::ship_battle_make_move_after_timeout_logic;
    use infinite_sea::ship_battle_make_move_logic;
    use sui::clock::Clock;
    use sui::tx_context;

    friend infinite_sea::skill_process_service;

    public entry fun initiate_battle(
        player: &Player,
        initiator: &mut Roster,
        responder: &mut Roster,
        clock: &Clock,
        ctx: &mut tx_context::TxContext,
    ) {
        let ship_battle_initiated = ship_battle_initiate_battle_logic::verify(
            player,
            initiator,
            responder,
            clock,
            ctx,
        );
        let ship_battle = ship_battle_initiate_battle_logic::mutate(
            &ship_battle_initiated,
            initiator,
            responder,
            ctx,
        );
        ship_battle::set_ship_battle_initiated_id(&mut ship_battle_initiated, ship_battle::id(&ship_battle));
        ship_battle::share_object(ship_battle);
        ship_battle::emit_ship_battle_initiated(ship_battle_initiated);
    }

    public entry fun make_move(
        ship_battle: &mut ship_battle::ShipBattle,
        player: &Player,
        initiator: &mut Roster,
        responder: &mut Roster,
        clock: &Clock,
        command: u8,
        ctx: &mut tx_context::TxContext,
    ) {
        let ship_battle_move_made = ship_battle_make_move_logic::verify(
            player,
            initiator,
            responder,
            clock,
            command,
            ship_battle,
            ctx,
        );
        ship_battle_make_move_logic::mutate(
            &ship_battle_move_made,
            initiator,
            responder,
            ship_battle,
            ctx,
        );
        ship_battle::update_object_version(ship_battle);
        ship_battle::emit_ship_battle_move_made(ship_battle_move_made);
    }

    public entry fun make_move_after_timeout(
        ship_battle: &mut ship_battle::ShipBattle,
        initiator: &mut Roster,
        responder: &mut Roster,
        clock: &Clock,
        ctx: &mut tx_context::TxContext,
    ) {
        let ship_battle_move_made_after_timeout = ship_battle_make_move_after_timeout_logic::verify(
            initiator,
            responder,
            clock,
            ship_battle,
            ctx,
        );
        ship_battle_make_move_after_timeout_logic::mutate(
            &ship_battle_move_made_after_timeout,
            initiator,
            responder,
            ship_battle,
            ctx,
        );
        ship_battle::update_object_version(ship_battle);
        ship_battle::emit_ship_battle_move_made_after_timeout(ship_battle_move_made_after_timeout);
    }

}