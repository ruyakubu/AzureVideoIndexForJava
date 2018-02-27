package com.video.demo.domain;

import java.util.ArrayList;

public class TranscriptBlocks
{
	
	private ArrayList<Ranges> ranges = new ArrayList<Ranges>();
	
    private ArrayList<String> sentimentIds = new ArrayList<String>();

    private String id;

    private String sentiment;

    private ArrayList<String> ocrs = new ArrayList<String>();

    private ArrayList<Faces> faces = new ArrayList<Faces>();

    private ArrayList<AudioEffectInstances> audioEffectInstances= new ArrayList<AudioEffectInstances>();

    private ArrayList<Scenes> scenes = new ArrayList<Scenes>();

    private ArrayList<String> thumbnailsIds = new ArrayList<String>();

    private ArrayList<Lines> lines= new ArrayList<Lines>();

    private ArrayList<Annotations> annotations = new ArrayList<Annotations>();

    public ArrayList<String> getSentimentIds ()
    {
        return sentimentIds;
    }

    public void setSentimentIds (ArrayList<String> sentimentIds)
    {
        this.sentimentIds = sentimentIds;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSentiment ()
    {
        return sentiment;
    }

    public void setSentiment (String sentiment)
    {
        this.sentiment = sentiment;
    }

    public ArrayList<String> getOcrs ()
    {
        return ocrs;
    }

    public void setOcrs (ArrayList<String> ocrs)
    {
        this.ocrs = ocrs;
    }

    public ArrayList<Faces> getFaces ()
    {
        return faces;
    }

    public void setFaces (ArrayList<Faces> faces)
    {
        this.faces = faces;
    }

    public ArrayList<AudioEffectInstances> getAudioEffectInstances ()
    {
        return audioEffectInstances;
    }

    public void setAudioEffectInstances (ArrayList<AudioEffectInstances> audioEffectInstances)
    {
        this.audioEffectInstances = audioEffectInstances;
    }

    public ArrayList<Scenes> getScenes ()
    {
        return scenes;
    }

    public void setScenes (ArrayList<Scenes> scenes)
    {
        this.scenes = scenes;
    }

    public ArrayList<String> getThumbnailsIds ()
    {
        return thumbnailsIds;
    }

    public void setThumbnailsIds (ArrayList<String> thumbnailsIds)
    {
        this.thumbnailsIds = thumbnailsIds;
    }

    public ArrayList<Lines> getLines ()
    {
        return lines;
    }

    public void setLines (ArrayList<Lines> lines)
    {
        this.lines = lines;
    }

    public ArrayList<Annotations> getAnnotations ()
    {
        return annotations;
    }

    public void setAnnotations (ArrayList<Annotations> annotations)
    {
        this.annotations = annotations;
    }

	@Override
	public String toString() {
		return "TranscriptBlocks [ranges=" + ranges + ", sentimentIds=" + sentimentIds + ", id=" + id + ", sentiment="
				+ sentiment + ", ocrs=" + ocrs + ", faces=" + faces + ", audioEffectInstances=" + audioEffectInstances
				+ ", scenes=" + scenes + ", thumbnailsIds=" + thumbnailsIds + ", lines=" + lines + ", annotations="
				+ annotations + ", getSentimentIds()=" + getSentimentIds() + ", getId()=" + getId()
				+ ", getSentiment()=" + getSentiment() + ", getOcrs()=" + getOcrs() + ", getFaces()=" + getFaces()
				+ ", getAudioEffectInstances()=" + getAudioEffectInstances() + ", getScenes()=" + getScenes()
				+ ", getThumbnailsIds()=" + getThumbnailsIds() + ", getLines()=" + getLines() + ", getAnnotations()="
				+ getAnnotations() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
