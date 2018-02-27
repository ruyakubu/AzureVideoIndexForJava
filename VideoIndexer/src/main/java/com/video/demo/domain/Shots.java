package com.video.demo.domain;
                 
public class Shots
{
    private String keyFrameThumbnailId;

    private String id;

    private TimeRange timeRange;

    private String keyFrame;

    public String getKeyFrameThumbnailId ()
    {
        return keyFrameThumbnailId;
    }

    public void setKeyFrameThumbnailId (String keyFrameThumbnailId)
    {
        this.keyFrameThumbnailId = keyFrameThumbnailId;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public TimeRange getTimeRange ()
    {
        return timeRange;
    }

    public void setTimeRange (TimeRange timeRange)
    {
        this.timeRange = timeRange;
    }

    public String getKeyFrame ()
    {
        return keyFrame;
    }

    public void setKeyFrame (String keyFrame)
    {
        this.keyFrame = keyFrame;
    }

	@Override
	public String toString() {
		return "Shots [keyFrameThumbnailId=" + keyFrameThumbnailId + ", id=" + id + ", timeRange=" + timeRange
				+ ", keyFrame=" + keyFrame + ", getKeyFrameThumbnailId()=" + getKeyFrameThumbnailId() + ", getId()="
				+ getId() + ", getTimeRange()=" + getTimeRange() + ", getKeyFrame()=" + getKeyFrame() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}