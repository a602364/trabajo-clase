package model;

public class Juegos {
	private Long appid;
	private String name;
	
	public Long getAppid() {
		return appid;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Juegos [appid=" + appid + ", name=" + name + "]";
	}
	
	
}
