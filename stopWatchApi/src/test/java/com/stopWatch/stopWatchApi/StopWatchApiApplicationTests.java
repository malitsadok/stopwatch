package com.stopWatch.stopWatchApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class StopWatchApiApplicationTests {

	@Test
	void contextLoads() {
		long millis  = 2973 ; 
		
		   long minutes = (millis / 1000) / 60;
	       long seconds = (millis / 1000) % 60;  
	       long millLeft = millis - minutes- seconds ; 
	       String.format("%02d:%02d:%02d",minutes,seconds,millLeft/10) ; 
		   
	}

}
