package com.video.demo.domain;

import java.util.ArrayList;

public class Faces
{
    private String id;

    private String title;

    private String shortId;

    private String description;

    private String name;

    private String thumbnailId;

    private String seenDuration;

    private ArrayList<Appearances> appearances = new ArrayList<Appearances>();

    private String confidence;

    private String seenDurationRatio;

    private String bingId;

    private String thumbnailFullUrl;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getShortId ()
    {
        return shortId;
    }

    public void setShortId (String shortId)
    {
        this.shortId = shortId;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getThumbnailId ()
    {
        return thumbnailId;
    }

    public void setThumbnailId (String thumbnailId)
    {
        this.thumbnailId = thumbnailId;
    }

    public String getSeenDuration ()
    {
        return seenDuration;
    }

    public void setSeenDuration (String seenDuration)
    {
        this.seenDuration = seenDuration;
    }

    public ArrayList<Appearances> getAppearances ()
    {
        return appearances;
    }

    public void setAppearances (ArrayList<Appearances> appearances)
    {
        this.appearances = appearances;
    }

    public String getConfidence ()
    {
        return confidence;
    }

    public void setConfidence (String confidence)
    {
        this.confidence = confidence;
    }

    public String getSeenDurationRatio ()
    {
        return seenDurationRatio;
    }

    public void setSeenDurationRatio (String seenDurationRatio)
    {
        this.seenDurationRatio = seenDurationRatio;
    }

    public String getBingId ()
    {
        return bingId;
    }

    public void setBingId (String bingId)
    {
        this.bingId = bingId;
    }

    public String getThumbnailFullUrl ()
    {
        return thumbnailFullUrl;
    }

    public void setThumbnailFullUrl (String thumbnailFullUrl)
    {
        this.thumbnailFullUrl = thumbnailFullUrl;
    }

	@Override
	public String toString() {
		return "Faces [id=" + id + ", title=" + title + ", shortId=" + shortId + ", description=" + description
				+ ", name=" + name + ", thumbnailId=" + thumbnailId + ", seenDuration=" + seenDuration
				+ ", appearances=" + appearances + ", confidence=" + confidence + ", seenDurationRatio="
				+ seenDurationRatio + ", bingId=" + bingId + ", thumbnailFullUrl=" + thumbnailFullUrl + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getShortId()=" + getShortId() + ", getDescription()="
				+ getDescription() + ", getName()=" + getName() + ", getThumbnailId()=" + getThumbnailId()
				+ ", getSeenDuration()=" + getSeenDuration() + ", getAppearances()=" + getAppearances()
				+ ", getConfidence()=" + getConfidence() + ", getSeenDurationRatio()=" + getSeenDurationRatio()
				+ ", getBingId()=" + getBingId() + ", getThumbnailFullUrl()=" + getThumbnailFullUrl() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}