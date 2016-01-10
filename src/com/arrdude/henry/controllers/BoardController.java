package com.arrdude.henry.controllers;
import com.arrdude.henry.pojos.BoardPojo;
import com.arrdude.henry.pojos.PlayerPojo;
import com.arrdude.henry.pojos.TilePojo;
import com.arrdude.henry.pojos.TilePojo.TileType;

public class BoardController {
	private BoardPojo board;
	//boardState 0 = ongoing, 1 = tied, 2 = X_Player_Wins, 3 = Y_Player_Wins
	int boardState = 0;	
	
	public BoardController(BoardPojo board){
		this.board = board;
	}
	public BoardPojo getBoard() {
		return board;
	}
	public boolean isTileEmpty(int position) {
		return board.getTile(position-1).getState() == TileType.BLANK;
	}
	public void procMove(int daMove, PlayerPojo currentPlayer) {
		board.getTile(daMove - 1).setState(currentPlayer.getType());
	}
	public int getBoardSize() {
		return board.getTiles().length;
	}
	public int checkBoardState(){
		int counter = 0;
		//Gets the active board
		getBoard();
		//Horizontal Victory
		if(getBoard().getTile(0).getState() != TileType.BLANK && 
				getBoard().getTile(0).getState() == 
				getBoard().getTile(1).getState() && getBoard().getTile(1).getState() == 
				getBoard().getTile(2).getState()){
			if(getBoard().getTile(0).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		if(getBoard().getTile(3).getState() != TileType.BLANK && 
				getBoard().getTile(3).getState() == 
				getBoard().getTile(4).getState() && getBoard().getTile(4).getState() == 
				getBoard().getTile(5).getState()){
			if(getBoard().getTile(3).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		if(getBoard().getTile(6).getState() != TileType.BLANK && 
				getBoard().getTile(6).getState() == 
				getBoard().getTile(7).getState() && getBoard().getTile(7).getState() == 
				getBoard().getTile(8).getState()){
			if(getBoard().getTile(6).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		//Vertical victory
		if(getBoard().getTile(0).getState() != TileType.BLANK && 
				getBoard().getTile(0).getState() == 
				getBoard().getTile(3).getState() && getBoard().getTile(3).getState() == 
				getBoard().getTile(6).getState()){
			if(getBoard().getTile(0).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		if(getBoard().getTile(1).getState() != TileType.BLANK && 
				getBoard().getTile(1).getState() == 
				getBoard().getTile(4).getState() && getBoard().getTile(4).getState() == 
				getBoard().getTile(7).getState()){
			if(getBoard().getTile(1).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		if(getBoard().getTile(6).getState() != TileType.BLANK && 
				getBoard().getTile(2).getState() == 
				getBoard().getTile(5).getState() && getBoard().getTile(7).getState() == 
				getBoard().getTile(8).getState()){
			if(getBoard().getTile(6).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		//Diagonal victory
		if(getBoard().getTile(0).getState() != TileType.BLANK && 
				getBoard().getTile(0).getState() == 
				getBoard().getTile(4).getState() && getBoard().getTile(4).getState() == 
				getBoard().getTile(8).getState()){
			if(getBoard().getTile(0).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		if(getBoard().getTile(3).getState() != TileType.BLANK && 
				getBoard().getTile(2).getState() == 
				getBoard().getTile(4).getState() && getBoard().getTile(4).getState() == 
				getBoard().getTile(6).getState()){
			if(getBoard().getTile(3).getState() == TileType.X_PLAYER){
				boardState = 2;
			}else{
				boardState = 3;
			}
			return boardState;
		}
		//Tie
		for(int i=0; i<getBoardSize(); i++){
			if(board.getTile(i).getState() != TileType.BLANK){
				counter = counter + 1;
			}
			if(counter==9){
				boardState = 1;
				return boardState;
			}
		}

		return boardState;
	}
}
