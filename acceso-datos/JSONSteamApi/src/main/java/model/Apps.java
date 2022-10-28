package model;

public class Apps {
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
		return "Apps [appid=" + appid + ", name=" + name + "]";
	}

	
	
}
