package com.video.demo.domain;

import java.util.ArrayList;

public class Annotations
{
    private String name;

    private ArrayList<Appearances> appearances = new ArrayList<Appearances>();

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public ArrayList<Appearances> getAppearances ()
    {
        return appearances;
    }

    public void setAppearances (ArrayList<Appearances> appearances)
    {
        this.appearances = appearances;
    }

	@Override
	public String toString() {
		return "Annotations [name=" + name + ", appearances=" + appearances + ", getName()=" + getName()
				+ ", getAppearances()=" + getAppearances() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
