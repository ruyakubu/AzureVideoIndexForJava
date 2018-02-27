package com.video.demo.domain;

import java.util.ArrayList;

public class AudioEffectInstances
{
    private ArrayList<Ranges> ranges = new ArrayList<Ranges>();

    private String type;

    public ArrayList<Ranges>getRanges ()
    {
        return ranges;
    }

    public void setRanges (ArrayList<Ranges> ranges)
    {
        this.ranges = ranges;
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
		return "AudioEffectInstances [ranges=" + ranges + ", type=" + type + ", getRanges()=" + getRanges()
				+ ", getType()=" + getType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}