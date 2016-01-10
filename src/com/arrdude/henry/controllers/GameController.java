package com.arrdude.henry.controllers;
import com.arrdude.henry.pojos.BoardPojo;
import com.arrdude.henry.pojos.GamePojo;
import com.arrdude.henry.pojos.PlayerPojo;
import com.arrdude.henry.pojos.TilePojo.TileType;

public class GameController {
	private GamePojo game;
	private BoardController boardController;
	private PlayerController playerController;
	private int boardState;
	private String winningPlayerName;
	
	public GameController(GamePojo game){
		this.game = game;
		this.boardController = new BoardController(this.game.getBoard());
		this.playerController = new PlayerController(this.game);
	}
	public BoardPojo getBoard(){
		return boardController.getBoard();
	}
	public void nextTurn(){
		this.game.setCurrentTurn((this.game.getCurrentTurn()+1) % playerController.getPlayerCount());
	}
	public PlayerPojo getCurrentPlayer(){
		return playerController.getCurrentPlayer();
	}
	public boolean isLegalMove(int position){
		return position>0
				&& position<boardController.getBoardSize()+1
				&& boardController.isTileEmpty(position);
	}
	public void procMove(int daMove) {
		boardController.procMove(daMove, playerController.getCurrentPlayer());
		nextTurn();
	}
	public boolean isGameOver() {
		boardState = boardController.checkBoardState();
		if(boardState >= 2 && boardState <=3){
			System.out.println("Winner: " + playerController.getNextPlayer().getDisplayName());			
			return true;
		}
		if(boardState == 1){
			System.out.println("Cat's game has occured");
			return true;
		}
		return false;
	}
}
