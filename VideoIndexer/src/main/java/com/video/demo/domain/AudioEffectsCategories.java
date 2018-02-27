package com.video.demo.domain;

public class AudioEffectsCategories
{
    private String type;

    private String key;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

	@Override
	public String toString() {
		return "AudioEffectsCategories [type=" + type + ", key=" + key + ", getType()=" + getType() + ", getKey()="
				+ getKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}