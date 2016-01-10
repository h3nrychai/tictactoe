package com.arrdude.henry.pojos;

public class BoardPojo {
	private String id;
	private TilePojo[] tiles;
	
	public BoardPojo(){
		this.tiles = new TilePojo[9];
		for (int i = 0; i<tiles.length; i++) {
			tiles[i] = new TilePojo();
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TilePojo[] getTiles() {
		return tiles;
	}
	public void setTiles(TilePojo[] tiles) {
		this.tiles = tiles;
	}
	public TilePojo getTile(int i) {
		return tiles[i];
	}
}
