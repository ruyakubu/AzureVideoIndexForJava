package com.video.demo.domain;

public class Social {
	  private boolean likedByUser;
	  private float likes;
	  private float views;


	 // Getter Methods 

	  public boolean getLikedByUser() {
	    return likedByUser;
	  }

	  public float getLikes() {
	    return likes;
	  }

	  public float getViews() {
	    return views;
	  }

	 // Setter Methods 

	  public void setLikedByUser( boolean likedByUser ) {
	    this.likedByUser = likedByUser;
	  }

	  public void setLikes( float likes ) {
	    this.likes = likes;
	  }

	  public void setViews( float views ) {
	    this.views = views;
	  }

	@Override
	public String toString() {
		return "Social [likedByUser=" + likedByUser + ", likes=" + likes + ", views=" + views + ", getLikedByUser()="
				+ getLikedByUser() + ", getLikes()=" + getLikes() + ", getViews()=" + getViews() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	}