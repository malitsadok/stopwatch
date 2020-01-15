package stopWatch.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stopWatch.dao.StopWatchRepository;
import stopWatch.model.TimeWatch;


@RestController
@RequestMapping("/stopWatch")
@CrossOrigin(origins = "http://localhost:4200")
public class StopWatchController {
	
	
	@Autowired
	private StopWatchRepository stopWatchRepository ; 
	
    @GetMapping("/all")
	public  List<TimeWatchView> getAllTimes() {
	 Mapper mapper = new Mapper() ; 
	return mapper.mapToTimePointView( stopWatchRepository.getAllTimeWatches( ));  
   }
	
	
	 @PostMapping("/add/{time}")
	 public TimeWatchView addTimePoint( @PathVariable long time) {
	    TimeWatch timePoint = new TimeWatch(time)   ;     
	    stopWatchRepository.saveTimeWatch(timePoint);
	    Mapper mapper = new Mapper() ;
	    return  mapper.mapToTimePointView(timePoint) ; 	    		 	 
	 }
	  
	 @PostMapping("/delete")
	 public void resetAllTimes() {	 
		 stopWatchRepository.deleteAllTimeWatches(); 
	  }
 

}
