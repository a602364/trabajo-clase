package model;

public class Datos {
	private String type;
	private String name;
	private Long steam_appid;
	private String detailed_description;
	private String about_the_game;
	private String header_image;
	private String website;
	private String short_description;	
	private price_overview price_overview;
	
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public Long getSteam_appid() {
		return steam_appid;
	}
	public String getDetailed_description() {
		return detailed_description;
	}
	public String getAbout_the_game() {
		return about_the_game;
	}
	public String getHeader_image() {
		return header_image;
	}
	public String getWebsite() {
		return website;
	}
	public String getShort_description() {
		return short_description;
	}
	public price_overview getPrice_overview() {
		return price_overview;
	}
	
	@Override
	public String toString() {
		return "Datos [type=" + type + ", name=" + name + ", steam_appid=" + steam_appid + ", detailed_description="
				+ detailed_description + ", about_the_game=" + about_the_game + ", header_image=" + header_image
				+ ", website=" + website + ", short_description=" + short_description + ", price_overview="
				+ price_overview + "]";
	}
	
	
}
