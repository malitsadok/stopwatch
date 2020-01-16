import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TimeWatch} from "../model/timeWatch";

@Component({
  selector: 'app-stop-watch',
  templateUrl: './stop-watch.component.html',
  styleUrls: ['./stop-watch.component.css']
})
export class StopWatchComponent implements OnInit {


	  minute = 0;
	  second = 0 ;
	  millisecond = 0 ;
	  elapsedTime =  0 ;
	  intervalId   ;
	  x   =10	 ;
	  flagState   =true  ;
    controlBtnText  ="Start";


  private BASE_URL = "//localhost:8080/stopWatch";
  times : TimeWatch[]=[];


  constructor(private http: HttpClient){

  }

  ngOnInit() {

    this.getAlltimesWatches() ;
  }


 onPlay(){
  this.flagState = false ;
  this.controlBtnText="Pause";


  this.intervalId=setInterval(()=>{
  this.updateTime()
     },100);

  }


  onPause(){
    this.flagState = true ;
    this.controlBtnText="Play";
    clearInterval(this.intervalId);

  }


  add(){
  this.elapsedTime = this.minute*1000*60 + this.second*1000 + this.millisecond*10  ;


  return this.http.post(this.BASE_URL+"/add/" + this.elapsedTime).subscribe(
     res => {
		 this.times.push(res) ;
      },
      err => {
        alert("An error has occurred while sending feedback");
      }

  )}


  getAlltimesWatches(){
     this.http.get<TimeWatch[]>(this.BASE_URL+"/all").subscribe(
	     res=>{
	     this.times = res ;
      },
      err => {
        alert("An error has occurred;")
      }
     );
  }


  remove(index){
     this.times.splice(index,1);

  }



    updateTime(){

	    this.millisecond+=this.x;

	    if(this.millisecond>90){
	        this.millisecond=0;
	        this.second++;
	    }

	    if(this.second>59){
	        this.second=0;
	        this.minute++;
	    }

	    if(this.minute>59){
	        this.minute=0;
	    }

   }


   reset(){
    this.elapsedTime = 0 ;
    return this.http.post(this.BASE_URL+"/delete" ).subscribe(
      res=>{
      		 location.reload();
      },
      err => {
        alert("An error has occurred;")
      }
    );
   }




  }


