package stopWatch.dao;

import java.util.List;

import stopWatch.model.TimeWatch;

public interface StopWatchRepository   {
	void saveTimeWatch(TimeWatch timeWatch) ; 
	
	void deleteAllTimeWatches(); 
	
	List<TimeWatch> getAllTimeWatches() ; 

}
