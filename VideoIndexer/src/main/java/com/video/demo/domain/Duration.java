package com.video.demo.domain;

public class Duration {
	  private String time;
	  private float seconds;


	 // Getter Methods 

	  public String getTime() {
	    return time;
	  }

	  public float getSeconds() {
	    return seconds;
	  }

	 // Setter Methods 

	  public void setTime( String time ) {
	    this.time = time;
	  }

	  public void setSeconds( float seconds ) {
	    this.seconds = seconds;
	  }

	@Override
	public String toString() {
		return "Duration [time=" + time + ", seconds=" + seconds + ", getTime()=" + getTime() + ", getSeconds()="
				+ getSeconds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	}