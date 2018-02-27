package com.video.demo.domain;

import java.util.ArrayList;

public class SummarizedInsights {
	  private String name;
	  private String shortId;
	  private float privacyMode;
	  Duration DurationObject;
	  private String thumbnailUrl;
	  ArrayList<Faces> faces = new ArrayList<Faces>();
	  ArrayList<Topics> topics = new ArrayList<Topics>();
	  ArrayList<Sentiments> sentiments = new ArrayList<Sentiments>();
	  ArrayList<AudioEffects> audioEffects = new ArrayList<AudioEffects>();
	  ArrayList<Annotations> annotations = new ArrayList<Annotations>();
	  //ArrayList<Brands> brands = new ArrayList<Brands>();

	    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getShortId() {
		return shortId;
	}



	public void setShortId(String shortId) {
		this.shortId = shortId;
	}



	public float getPrivacyMode() {
		return privacyMode;
	}



	public void setPrivacyMode(float privacyMode) {
		this.privacyMode = privacyMode;
	}



	public Duration getDurationObject() {
		return DurationObject;
	}



	public void setDurationObject(Duration durationObject) {
		DurationObject = durationObject;
	}



	public String getThumbnailUrl() {
		return thumbnailUrl;
	}



	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}



	public ArrayList<Faces> getFaces() {
		return faces;
	}



	public void setFaces(ArrayList<Faces> faces) {
		this.faces = faces;
	}



	public ArrayList<Topics> getTopics() {
		return topics;
	}



	public void setTopics(ArrayList<Topics> topics) {
		this.topics = topics;
	}



	public ArrayList<Sentiments> getSentiments() {
		return sentiments;
	}



	public void setSentiments(ArrayList<Sentiments> sentiments) {
		this.sentiments = sentiments;
	}



	public ArrayList<AudioEffects> getAudioEffects() {
		return audioEffects;
	}



	public void setAudioEffects(ArrayList<AudioEffects> audioEffects) {
		this.audioEffects = audioEffects;
	}



	public ArrayList<Annotations> getAnnotations() {
		return annotations;
	}



	public void setAnnotations(ArrayList<Annotations> annotations) {
		this.annotations = annotations;
	}



	@Override
	public String toString() {
		return "SummarizedInsights [name=" + name + ", shortId=" + shortId + ", privacyMode=" + privacyMode
				+ ", DurationObject=" + DurationObject + ", thumbnailUrl=" + thumbnailUrl + ", faces=" + faces
				+ ", topics=" + topics + ", sentiments=" + sentiments + ", audioEffects=" + audioEffects
				+ ", annotations=" + annotations + "]";
	}


	}