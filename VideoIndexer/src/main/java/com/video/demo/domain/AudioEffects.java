package com.video.demo.domain;

import java.util.ArrayList;

public class AudioEffects
{
    private String audioEffectKey;

    private String seenDuration;

    private ArrayList<Appearances> appearances = new ArrayList<Appearances>();

    private String seenDurationRatio;

    public String getAudioEffectKey ()
    {
        return audioEffectKey;
    }

    public void setAudioEffectKey (String audioEffectKey)
    {
        this.audioEffectKey = audioEffectKey;
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
		return "AudioEffects [audioEffectKey=" + audioEffectKey + ", seenDuration=" + seenDuration + ", appearances="
				+ appearances + ", seenDurationRatio=" + seenDurationRatio + ", getAudioEffectKey()="
				+ getAudioEffectKey() + ", getSeenDuration()=" + getSeenDuration() + ", getAppearances()="
				+ getAppearances() + ", getSeenDurationRatio()=" + getSeenDurationRatio() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}