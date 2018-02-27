package com.video.demo.domain;

public class Breakdowns
{
    private String accountId;

    private String publishedProxyUrl;

    private String failureMessage;

    private String state;

    private String processingProgress;

    private String externalId;

    private String linguisticModelId;

    private String viewToken;

    private String id;

    private String sourceLanguage;

    private String thumbnailUrl;

    private Insights insights;

    private String indexingPreset;

    private String language;

    private String failureCode;

    private String externalUrl;

    private String publishedUrl;

    private String metadata;

    public String getAccountId ()
    {
        return accountId;
    }

    public void setAccountId (String accountId)
    {
        this.accountId = accountId;
    }

    public String getPublishedProxyUrl ()
    {
        return publishedProxyUrl;
    }

    public void setPublishedProxyUrl (String publishedProxyUrl)
    {
        this.publishedProxyUrl = publishedProxyUrl;
    }

    public String getFailureMessage ()
    {
        return failureMessage;
    }

    public void setFailureMessage (String failureMessage)
    {
        this.failureMessage = failureMessage;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getProcessingProgress ()
    {
        return processingProgress;
    }

    public void setProcessingProgress (String processingProgress)
    {
        this.processingProgress = processingProgress;
    }

    public String getExternalId ()
    {
        return externalId;
    }

    public void setExternalId (String externalId)
    {
        this.externalId = externalId;
    }

    public String getLinguisticModelId ()
    {
        return linguisticModelId;
    }

    public void setLinguisticModelId (String linguisticModelId)
    {
        this.linguisticModelId = linguisticModelId;
    }

    public String getViewToken ()
    {
        return viewToken;
    }

    public void setViewToken (String viewToken)
    {
        this.viewToken = viewToken;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSourceLanguage ()
    {
        return sourceLanguage;
    }

    public void setSourceLanguage (String sourceLanguage)
    {
        this.sourceLanguage = sourceLanguage;
    }

    public String getThumbnailUrl ()
    {
        return thumbnailUrl;
    }

    public void setThumbnailUrl (String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Insights getInsights ()
    {
        return insights;
    }

    public void setInsights (Insights insights)
    {
        this.insights = insights;
    }

    public String getIndexingPreset ()
    {
        return indexingPreset;
    }

    public void setIndexingPreset (String indexingPreset)
    {
        this.indexingPreset = indexingPreset;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getFailureCode ()
    {
        return failureCode;
    }

    public void setFailureCode (String failureCode)
    {
        this.failureCode = failureCode;
    }

    public String getExternalUrl ()
    {
        return externalUrl;
    }

    public void setExternalUrl (String externalUrl)
    {
        this.externalUrl = externalUrl;
    }

    public String getPublishedUrl ()
    {
        return publishedUrl;
    }

    public void setPublishedUrl (String publishedUrl)
    {
        this.publishedUrl = publishedUrl;
    }

    public String getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (String metadata)
    {
        this.metadata = metadata;
    }

	@Override
	public String toString() {
		return "Breakdowns [accountId=" + accountId + ", publishedProxyUrl=" + publishedProxyUrl + ", failureMessage="
				+ failureMessage + ", state=" + state + ", processingProgress=" + processingProgress + ", externalId="
				+ externalId + ", linguisticModelId=" + linguisticModelId + ", viewToken=" + viewToken + ", id=" + id
				+ ", sourceLanguage=" + sourceLanguage + ", thumbnailUrl=" + thumbnailUrl + ", insights=" + insights
				+ ", indexingPreset=" + indexingPreset + ", language=" + language + ", failureCode=" + failureCode
				+ ", externalUrl=" + externalUrl + ", publishedUrl=" + publishedUrl + ", metadata=" + metadata
				+ ", getAccountId()=" + getAccountId() + ", getPublishedProxyUrl()=" + getPublishedProxyUrl()
				+ ", getFailureMessage()=" + getFailureMessage() + ", getState()=" + getState()
				+ ", getProcessingProgress()=" + getProcessingProgress() + ", getExternalId()=" + getExternalId()
				+ ", getLinguisticModelId()=" + getLinguisticModelId() + ", getViewToken()=" + getViewToken()
				+ ", getId()=" + getId() + ", getSourceLanguage()=" + getSourceLanguage() + ", getThumbnailUrl()="
				+ getThumbnailUrl() + ", getInsights()=" + getInsights() + ", getIndexingPreset()="
				+ getIndexingPreset() + ", getLanguage()=" + getLanguage() + ", getFailureCode()=" + getFailureCode()
				+ ", getExternalUrl()=" + getExternalUrl() + ", getPublishedUrl()=" + getPublishedUrl()
				+ ", getMetadata()=" + getMetadata() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
