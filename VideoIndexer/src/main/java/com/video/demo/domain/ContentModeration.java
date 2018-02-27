package com.video.demo.domain;

public class ContentModeration
{
    private String bannedWordsRatio;

    private String adultClassifierValue;

    private String racyClassifierValue;

    private String isAdult;

    private String reviewRecommended;

    private String bannedWordsCount;

    public String getBannedWordsRatio ()
    {
        return bannedWordsRatio;
    }

    public void setBannedWordsRatio (String bannedWordsRatio)
    {
        this.bannedWordsRatio = bannedWordsRatio;
    }

    public String getAdultClassifierValue ()
    {
        return adultClassifierValue;
    }

    public void setAdultClassifierValue (String adultClassifierValue)
    {
        this.adultClassifierValue = adultClassifierValue;
    }

    public String getRacyClassifierValue ()
    {
        return racyClassifierValue;
    }

    public void setRacyClassifierValue (String racyClassifierValue)
    {
        this.racyClassifierValue = racyClassifierValue;
    }

    public String getIsAdult ()
    {
        return isAdult;
    }

    public void setIsAdult (String isAdult)
    {
        this.isAdult = isAdult;
    }

    public String getReviewRecommended ()
    {
        return reviewRecommended;
    }

    public void setReviewRecommended (String reviewRecommended)
    {
        this.reviewRecommended = reviewRecommended;
    }

    public String getBannedWordsCount ()
    {
        return bannedWordsCount;
    }

    public void setBannedWordsCount (String bannedWordsCount)
    {
        this.bannedWordsCount = bannedWordsCount;
    }

	@Override
	public String toString() {
		return "ContentModeration [bannedWordsRatio=" + bannedWordsRatio + ", adultClassifierValue="
				+ adultClassifierValue + ", racyClassifierValue=" + racyClassifierValue + ", isAdult=" + isAdult
				+ ", reviewRecommended=" + reviewRecommended + ", bannedWordsCount=" + bannedWordsCount
				+ ", getBannedWordsRatio()=" + getBannedWordsRatio() + ", getAdultClassifierValue()="
				+ getAdultClassifierValue() + ", getRacyClassifierValue()=" + getRacyClassifierValue()
				+ ", getIsAdult()=" + getIsAdult() + ", getReviewRecommended()=" + getReviewRecommended()
				+ ", getBannedWordsCount()=" + getBannedWordsCount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


}