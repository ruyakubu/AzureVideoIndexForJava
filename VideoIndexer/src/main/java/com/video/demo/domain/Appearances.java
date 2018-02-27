package com.video.demo.domain;

public class Appearances
{
    private String startTime;

    private String endSeconds;

    private String endTime;

    private String startSeconds;

    public String getStartTime ()
    {
        return startTime;
    }

    public void setStartTime (String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndSeconds ()
    {
        return endSeconds;
    }

    public void setEndSeconds (String endSeconds)
    {
        this.endSeconds = endSeconds;
    }

    public String getEndTime ()
    {
        return endTime;
    }

    public void setEndTime (String endTime)
    {
        this.endTime = endTime;
    }

    public String getStartSeconds ()
    {
        return startSeconds;
    }

    public void setStartSeconds (String startSeconds)
    {
        this.startSeconds = startSeconds;
    }

	@Override
	public String toString() {
		return "Appearances [startTime=" + startTime + ", endSeconds=" + endSeconds + ", endTime=" + endTime
				+ ", startSeconds=" + startSeconds + ", getStartTime()=" + getStartTime() + ", getEndSeconds()="
				+ getEndSeconds() + ", getEndTime()=" + getEndTime() + ", getStartSeconds()=" + getStartSeconds()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
