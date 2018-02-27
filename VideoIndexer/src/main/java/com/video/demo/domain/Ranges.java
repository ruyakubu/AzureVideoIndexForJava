package com.video.demo.domain;


public class Ranges
{
	private TimeRange timeRange;
	
	private String type;
	
	public TimeRange getTimeRange ()
	{
	return timeRange;
	}
	
	public void setTimeRange (TimeRange timeRange)
	{
	this.timeRange = timeRange;
	}
	
	public String getType ()
	{
	return type;
	}
	
	public void setType (String type)
	{
	this.type = type;
	}

	@Override
	public String toString() {
		return "Ranges [timeRange=" + timeRange + ", type=" + type + ", getTimeRange()=" + getTimeRange()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}