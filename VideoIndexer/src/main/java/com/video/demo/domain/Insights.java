package com.video.demo.domain;

import java.util.ArrayList;


public class Insights
{
    private ContentModeration contentModeration;

   // private ArrayList<String> brands = new ArrayList<String>();

    private ArrayList<Topics> topics = new ArrayList<Topics>();

    private ArrayList<Faces> faces = new ArrayList<Faces>();

    private ArrayList<String> framePatterns = new ArrayList<String>();

    private ArrayList<AudioEffectsCategories> audioEffectsCategories = new ArrayList<AudioEffectsCategories>();

    private ArrayList<Participants> participants = new ArrayList<Participants>();

    private ArrayList<TranscriptBlocks> transcriptBlocks = new ArrayList<TranscriptBlocks>();

    public ContentModeration getContentModeration ()
    {
        return contentModeration;
    }

    public void setContentModeration (ContentModeration contentModeration)
    {
        this.contentModeration = contentModeration;
    }

/*    public String> getBrands ()
    {
        return brands;
    }

    public void setBrands (String> brands)
    {
        this.brands = brands;
    }*/

    public ArrayList<Topics>  getTopics ()
    {
        return topics;
    }

    public void setTopics (ArrayList<Topics>  topics)
    {
        this.topics = topics;
    }

    public ArrayList<Faces> getFaces ()
    {
        return faces;
    }

    public void setFaces (ArrayList<Faces>faces)
    {
        this.faces = faces;
    }

    public ArrayList<String> getFramePatterns ()
    {
        return framePatterns;
    }

    public void setFramePatterns (ArrayList<String> framePatterns)
    {
        this.framePatterns = framePatterns;
    }

    public ArrayList<AudioEffectsCategories> getAudioEffectsCategories ()
    {
        return audioEffectsCategories;
    }

    public void setAudioEffectsCategories (ArrayList<AudioEffectsCategories> audioEffectsCategories)
    {
        this.audioEffectsCategories = audioEffectsCategories;
    }

    public ArrayList<Participants> getParticipants ()
    {
        return participants;
    }

    public void setParticipants (ArrayList<Participants> participants)
    {
        this.participants = participants;
    }

    public ArrayList<TranscriptBlocks> getTranscriptBlocks ()
    {
        return transcriptBlocks;
    }

    public void setTranscriptBlocks (ArrayList<TranscriptBlocks> transcriptBlocks)
    {
        this.transcriptBlocks = transcriptBlocks;
    }

	@Override
	public String toString() {
		return "Insights [contentModeration=" + contentModeration + ", topics=" + topics + ", faces=" + faces
				+ ", framePatterns=" + framePatterns + ", audioEffectsCategories=" + audioEffectsCategories
				+ ", participants=" + participants + ", transcriptBlocks=" + transcriptBlocks
				+ ", getContentModeration()=" + getContentModeration() + ", getTopics()=" + getTopics()
				+ ", getFaces()=" + getFaces() + ", getFramePatterns()=" + getFramePatterns()
				+ ", getAudioEffectsCategories()=" + getAudioEffectsCategories() + ", getParticipants()="
				+ getParticipants() + ", getTranscriptBlocks()=" + getTranscriptBlocks() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




}
