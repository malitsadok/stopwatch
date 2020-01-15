package stopWatch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import stopWatch.model.TimeWatch;

public class Mapper {
	
	public List<TimeWatchView> mapToTimePointView(  List<TimeWatch> list) {
		 List<TimeWatchView> resForView = new ArrayList<TimeWatchView>() ;  ; 
		 for (TimeWatch timeWatch: list) {
			   resForView.add( mapToTimePointView(  timeWatch)) ; 
		   }
	       return resForView ;
	}
	
	
	public TimeWatchView mapToTimePointView(  TimeWatch  timeWatch) {
		 return  new TimeWatchView(timeWatch.getId(), msToTime(timeWatch.getTimePoint())) ; 
	}
	
	   
	   public String   msToTime(long millis) {  
		   long minutes = (millis / 1000) / 60;
	       long seconds = (millis / 1000) % 60;  
	       int milliseconds = (int) ((millis%1000)/10) ;  
	       return String.format("%02d:%02d:%02d",minutes,seconds,milliseconds) ; 		   	
     }
	   

}
