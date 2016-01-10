package com.arrdude.henry;
import com.arrdude.henry.pojos.GamePojo;
import com.arrdude.henry.pojos.PlayerPojo;
import com.arrdude.henry.pojos.TilePojo.TileType;
import com.arrdude.henry.pojos.UserPojo;
import java.util.Scanner;
import com.arrdude.henry.controllers.GameController;
import com.arrdude.henry.pojos.BoardPojo;

public class HenryGame {
	GamePojo game;
	GameController gameController;
	private static Scanner scanner;
	
	public HenryGame(PlayerPojo[] players){
		this.game = new GamePojo(players);
		this.gameController = new GameController(game);
	}
	public static void main(String[] args){
		scanner = new Scanner(System.in);
		PlayerPojo[] players = new PlayerPojo[2];
		players[0] = new PlayerPojo(new UserPojo("", ""), 0, "HenryTheFirst", TileType.X_PLAYER);
		players[1] = new PlayerPojo(new UserPojo("", ""), 1, "HenryTheSecond", TileType.Y_PLAYER);

		HenryGame henry = new HenryGame(players);
		while(!henry.gameController.isGameOver()){
			henry.showPlayer();
			henry.showBoard();
			int daMove = henry.getPlayerMove();
			henry.gameController.procMove(daMove);
		}
//		henry.gameController.nextTurn();
		henry.showBoard();
	}
	private void showBoard() {
		BoardPojo board = gameController.getBoard();
		System.out.println("board");
		System.out.println("   |   |   ");
		System.out.println(" " + getLetter(board.getTile(0).getState())
			+ " | " + getLetter(board.getTile(1).getState()) 
			+ " | " + getLetter(board.getTile(2).getState()));
		System.out.println("  1|  2|  3");
		System.out.println("===========");
		System.out.println("   |   |   ");
		System.out.println(" " + getLetter(board.getTile(3).getState())
			+ " | " + getLetter(board.getTile(4).getState()) 
			+ " | " + getLetter(board.getTile(5).getState()));
		System.out.println("  4|  5|  6");
		System.out.println("===========");
		System.out.println("   |   |   ");
		System.out.println(" " + getLetter(board.getTile(6).getState())
			+ " | " + getLetter(board.getTile(7).getState()) 
			+ " | " + getLetter(board.getTile(8).getState()));
		System.out.println("  7|  8|  9");
	}
	//show current player
	private void showPlayer(){
		System.out.println("Turn: " + gameController.getCurrentPlayer().getDisplayName());
	}
	private String getLetter(TileType state){
		switch (state) {
		case BLANK:
			return " ";
		case X_PLAYER:
			return "X";
		case Y_PLAYER:
			return "O";
		default:
			return "";
		}
	}
	public int getPlayerMove(){
		int retthis = 0;
		System.out.println("Input tile number: ");
		try{
			retthis =  scanner.nextInt();
		}
		catch(Exception e){
			System.err.println("You must type a number between 1 and 9");
			return getPlayerMove();
		}
		if(!gameController.isLegalMove(retthis)){
			System.err.println("Illegal Move" + retthis);
			return getPlayerMove();
		}
		//set the tile a value
		//game.getBoard().setTile(move - 1);
		
		return retthis;
	}
}
