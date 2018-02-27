package com.video.demo.domain;

import java.util.Arrays;

public class Scenes
{
    private String keyFrameThumbnailId;

    private String id;

    private TimeRange timeRange;

    private Shots[] shots;

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

    public Shots[] getShots ()
    {
        return shots;
    }

    public void setShots (Shots[] shots)
    {
        this.shots = shots;
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
		return "Scenes [keyFrameThumbnailId=" + keyFrameThumbnailId + ", id=" + id + ", timeRange=" + timeRange
				+ ", shots=" + Arrays.toString(shots) + ", keyFrame=" + keyFrame + ", getKeyFrameThumbnailId()="
				+ getKeyFrameThumbnailId() + ", getId()=" + getId() + ", getTimeRange()=" + getTimeRange()
				+ ", getShots()=" + Arrays.toString(getShots()) + ", getKeyFrame()=" + getKeyFrame() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}