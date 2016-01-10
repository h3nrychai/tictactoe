package com.arrdude.henry.pojos;

public class TilePojo {
	public enum TileType {
		BLANK, X_PLAYER, Y_PLAYER
	};
	private String id;
	private TileType state;
	
	public TilePojo(){
		this.setState(TileType.BLANK);
		this.setId("");
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TileType getState() {
		return state;
	}
	public void setState(TileType state) {
		this.state = state;
	}
}
