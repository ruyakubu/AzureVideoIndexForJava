package com.video.demo.domain;

import java.util.ArrayList;
                 
public class Topics
	{
	    private String id;

	    private String name;

	    private String isTranscript;

	    private ArrayList<Appearances> appearances = new ArrayList<Appearances>();

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getIsTranscript ()
	    {
	        return isTranscript;
	    }

	    public void setIsTranscript (String isTranscript)
	    {
	        this.isTranscript = isTranscript;
	    }

	    public ArrayList<Appearances>  getAppearances ()
	    {
	        return appearances;
	    }

	    public void setAppearances (ArrayList<Appearances> appearances)
	    {
	        this.appearances = appearances;
	    }


	}
				
				






	 