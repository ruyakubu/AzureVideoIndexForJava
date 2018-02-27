package com.video.demo.domain;
                 
public class Participants
{
    private String id;

    private String pictureUrl;

    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getPictureUrl ()
    {
        return pictureUrl;
    }

    public void setPictureUrl (String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Participants [id=" + id + ", pictureUrl=" + pictureUrl + ", name=" + name + ", getId()=" + getId()
				+ ", getPictureUrl()=" + getPictureUrl() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}