package com.video.demo.domain;

import java.util.ArrayList;

public class BreakdownRoot {
	  private String accountId;
	  private String id;
	  private String partition = null;
	  private String name;
	  private String description;
	  private String userName;
	  private String createTime;
	  private String organization;
	  private String privacyMode;
	  private String state;
	  private boolean isOwned;
	  private boolean isEditable;
	  private boolean isBase;
	  private float durationInSeconds;
	  SummarizedInsights SummarizedInsightsObject;
	  ArrayList<Breakdowns> breakdowns = new ArrayList<Breakdowns>();
	  Social SocialObject;


	 // Getter Methods 

	  public String getAccountId() {
	    return accountId;
	  }

	  public String getId() {
	    return id;
	  }

	  public String getPartition() {
	    return partition;
	  }

	  public String getName() {
	    return name;
	  }

	  public String getDescription() {
	    return description;
	  }

	  public String getUserName() {
	    return userName;
	  }

	  public String getCreateTime() {
	    return createTime;
	  }

	  public String getOrganization() {
	    return organization;
	  }

	  public String getPrivacyMode() {
	    return privacyMode;
	  }

	  public String getState() {
	    return state;
	  }

	  public boolean getIsOwned() {
	    return isOwned;
	  }

	  public boolean getIsEditable() {
	    return isEditable;
	  }

	  public boolean getIsBase() {
	    return isBase;
	  }

	  public float getDurationInSeconds() {
	    return durationInSeconds;
	  }

	  public SummarizedInsights getSummarizedInsights() {
	    return SummarizedInsightsObject;
	  }

	  public Social getSocial() {
	    return SocialObject;
	  }

	 // Setter Methods 

	  public void setAccountId( String accountId ) {
	    this.accountId = accountId;
	  }

	  public void setId( String id ) {
	    this.id = id;
	  }

	  public void setPartition( String partition ) {
	    this.partition = partition;
	  }

	  public void setName( String name ) {
	    this.name = name;
	  }

	  public void setDescription( String description ) {
	    this.description = description;
	  }

	  public void setUserName( String userName ) {
	    this.userName = userName;
	  }

	  public void setCreateTime( String createTime ) {
	    this.createTime = createTime;
	  }

	  public void setOrganization( String organization ) {
	    this.organization = organization;
	  }

	  public void setPrivacyMode( String privacyMode ) {
	    this.privacyMode = privacyMode;
	  }

	  public void setState( String state ) {
	    this.state = state;
	  }

	  public void setIsOwned( boolean isOwned ) {
	    this.isOwned = isOwned;
	  }

	  public void setIsEditable( boolean isEditable ) {
	    this.isEditable = isEditable;
	  }

	  public void setIsBase( boolean isBase ) {
	    this.isBase = isBase;
	  }

	  public void setDurationInSeconds( float durationInSeconds ) {
	    this.durationInSeconds = durationInSeconds;
	  }

	  public void setSummarizedInsights( SummarizedInsights summarizedInsightsObject ) {
	    this.SummarizedInsightsObject = summarizedInsightsObject;
	  }

	  public void setSocial( Social socialObject ) {
	    this.SocialObject = socialObject;
	  }

	@Override
	public String toString() {
		return "BreakdownRoot [accountId=" + accountId + ", id=" + id + ", partition=" + partition + ", name=" + name
				+ ", description=" + description + ", userName=" + userName + ", createTime=" + createTime
				+ ", organization=" + organization + ", privacyMode=" + privacyMode + ", state=" + state + ", isOwned="
				+ isOwned + ", isEditable=" + isEditable + ", isBase=" + isBase + ", durationInSeconds="
				+ durationInSeconds + ", SummarizedInsightsObject=" + SummarizedInsightsObject + ", breakdowns="
				+ breakdowns + ", SocialObject=" + SocialObject + ", getAccountId()=" + getAccountId() + ", getId()="
				+ getId() + ", getPartition()=" + getPartition() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + ", getUserName()=" + getUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getOrganization()=" + getOrganization() + ", getPrivacyMode()=" + getPrivacyMode()
				+ ", getState()=" + getState() + ", getIsOwned()=" + getIsOwned() + ", getIsEditable()="
				+ getIsEditable() + ", getIsBase()=" + getIsBase() + ", getDurationInSeconds()="
				+ getDurationInSeconds() + ", getSummarizedInsights()=" + getSummarizedInsights() + ", getSocial()="
				+ getSocial() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	  

	}


