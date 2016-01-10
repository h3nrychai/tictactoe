package com.arrdude.henry.pojos;
import com.arrdude.henry.pojos.TilePojo.TileType;

public class PlayerPojo {
	private UserPojo user;
	private int color;
	private String displayName;
	private TileType type;
	
	public PlayerPojo(UserPojo user, int color, String displayName, TileType type){
		this.user = user;
		this.color = color;
		this.displayName = displayName;
		this.type = type;
	}
	public TileType getType() {
		return type;
	}
	public UserPojo getUser() {
		return user;
	}
	public void setUser(UserPojo user) {
		this.user = user;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
