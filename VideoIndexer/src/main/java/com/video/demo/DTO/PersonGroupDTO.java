package com.video.demo.DTO;

import java.util.List;
import java.util.ArrayList;

public class PersonGroupDTO {
	
	private String PersonGroup;
	private String personId;
	private String persistedFaceId;
	private String name;
	private List<String> urls = new ArrayList();
	
	public String getPersonGroup() {
		return PersonGroup;
	}
	public void setPersonGroup(String personGroup) {
		PersonGroup = personGroup;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersistedFaceId() {
		return persistedFaceId;
	}
	public void setPersistedFaceId(String persistedFaceId) {
		this.persistedFaceId = persistedFaceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
}