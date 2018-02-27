package com.video.demo.domain;

import java.util.ArrayList;

public class Sentiments
{
    private String sentimentKey;

    private ArrayList<Appearances> appearances = new ArrayList<Appearances>();

    private String seenDurationRatio;

    public String getSentimentKey ()
    {
        return sentimentKey;
    }

    public void setSentimentKey (String sentimentKey)
    {
        this.sentimentKey = sentimentKey;
    }

    public ArrayList<Appearances> getAppearances ()
    {
        return appearances;
    }

    public void setAppearances (ArrayList<Appearances> appearances)
    {
        this.appearances = appearances;
    }

    public String getSeenDurationRatio ()
    {
        return seenDurationRatio;
    }

    public void setSeenDurationRatio (String seenDurationRatio)
    {
        this.seenDurationRatio = seenDurationRatio;
    }

	@Override
	public String toString() {
		return "Sentiments [sentimentKey=" + sentimentKey + ", appearances=" + appearances + ", seenDurationRatio="
				+ seenDurationRatio + ", getSentimentKey()=" + getSentimentKey() + ", getAppearances()="
				+ getAppearances() + ", getSeenDurationRatio()=" + getSeenDurationRatio() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
