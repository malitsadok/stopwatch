package stopWatch.controller;

import java.util.UUID;

public class TimeWatchView {
	private String timeWatchLabel ; 
	private UUID id ; 
	
	
	
	public TimeWatchView(UUID id2, String timeWatch) {
		this.timeWatchLabel = timeWatch;
		this.id = id2 ; 
	}
	public String getTimeWatch() {
		return timeWatchLabel;
	}
	public void setTimeWatch(String timeWatch) {
		this.timeWatchLabel = timeWatch;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	

}
