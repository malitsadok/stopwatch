package stopWatch.controller;

import java.util.UUID;

public class TimeWatchView {
	private String timeWatchLabel ; 
	private UUID id ; 
	
	
	
	public TimeWatchView(UUID id2, String timePoint) {
		this.timeWatchLabel = timePoint;
		this.id = id2 ; 
	}
	public String getTimePoint() {
		return timeWatchLabel;
	}
	public void setTimePoint(String timePoint) {
		this.timeWatchLabel = timePoint;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	

}
