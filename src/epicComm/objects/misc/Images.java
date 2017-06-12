package epicComm.objects.misc;

public class Images {
	
	String icon,
		   medium,
		   medium_stats,
		   large,
		   large_stats;
	
	public Images(String icon, String medium, String medium_stats, String large, String large_stats){
		this.icon=icon;		
		this.medium=medium;
		this.medium_stats=medium_stats;
		this.large=large;
		this.large_stats=large_stats;
	}

	public String getIcon() {
		return icon;
	}

	public String getMedium() {
		return medium;
	}

	public String getMedium_stats() {
		return medium_stats;
	}

	public String getLarge() {
		return large;
	}

	public String getLarge_stats() {
		return large_stats;
	}

}
