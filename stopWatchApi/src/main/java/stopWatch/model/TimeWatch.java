package stopWatch.model;


import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TIME_WATCH")
public class TimeWatch {
	
	
    @Id
	@GeneratedValue
    private UUID id;
    @Column
	private long timeWatchLong  ;

   public TimeWatch() {
	
   }
	
	public TimeWatch(long time) {
		this.timeWatchLong = time ; 
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public long getTimePoint() {
		return timeWatchLong;
	}

	public void setTimePoint(long timePoint) {
		this.timeWatchLong = timePoint;
	} 

}
