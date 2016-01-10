package com.arrdude.henry.pojos;

public class GamePojo {
	BoardPojo board;
	PlayerPojo[] players;
	int currentTurn;

	public GamePojo(PlayerPojo[] players){
		this.board = new BoardPojo();
		this.players = players;
		this.currentTurn = 0;
	}
	public BoardPojo getBoard() {
		return board;
	}
	public void setBoard(BoardPojo board) {
		this.board = board;
	}
	public PlayerPojo[] getPlayers() {
		return players;
	}
	public void setPlayers(PlayerPojo[] players) {
		this.players = players;
	}
	public int getCurrentTurn() {
		return currentTurn;
	}
	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}
}
