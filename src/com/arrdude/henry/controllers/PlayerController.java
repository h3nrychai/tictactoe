package com.arrdude.henry.controllers;
import com.arrdude.henry.pojos.GamePojo;
import com.arrdude.henry.pojos.PlayerPojo;
import com.arrdude.henry.pojos.TilePojo;
import com.arrdude.henry.pojos.TilePojo.TileType;
import com.arrdude.henry.pojos.UserPojo;

public class PlayerController {
	private GamePojo game;
	private TilePojo tile;

	public PlayerController(GamePojo game){
		this.game = game;
	}
	public int getPlayerCount() {
		return game.getPlayers().length;
	}
	public PlayerPojo getCurrentPlayer() {
		PlayerPojo[] players = game.getPlayers();
		return players[game.getCurrentTurn()];
	}
	public PlayerPojo getNextPlayer() {
		PlayerPojo[] players = game.getPlayers();
		return players[(game.getCurrentTurn()+1) % getPlayerCount()];
	}
}
