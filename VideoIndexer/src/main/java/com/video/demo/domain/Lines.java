package com.video.demo.domain;

public class Lines
{
    private String id;

    private AdjustedTimeRange adjustedTimeRange;

    private String text;

    private TimeRange timeRange;

    private String participantId;

    private String confidence;

    private String isIncluded;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public AdjustedTimeRange getAdjustedTimeRange ()
    {
        return adjustedTimeRange;
    }

    public void setAdjustedTimeRange (AdjustedTimeRange adjustedTimeRange)
    {
        this.adjustedTimeRange = adjustedTimeRange;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public TimeRange getTimeRange ()
    {
        return timeRange;
    }

    public void setTimeRange (TimeRange timeRange)
    {
        this.timeRange = timeRange;
    }

    public String getParticipantId ()
    {
        return participantId;
    }

    public void setParticipantId (String participantId)
    {
        this.participantId = participantId;
    }

    public String getConfidence ()
    {
        return confidence;
    }

    public void setConfidence (String confidence)
    {
        this.confidence = confidence;
    }

    public String getIsIncluded ()
    {
        return isIncluded;
    }

    public void setIsIncluded (String isIncluded)
    {
        this.isIncluded = isIncluded;
    }

    @Override
	public String toString() {
		return "Lines [id=" + id + ", adjustedTimeRange=" + adjustedTimeRange + ", text=" + text + ", timeRange="
				+ timeRange + ", participantId=" + participantId + ", confidence=" + confidence + ", isIncluded="
				+ isIncluded + ", getId()=" + getId() + ", getAdjustedTimeRange()=" + getAdjustedTimeRange()
				+ ", getText()=" + getText() + ", getTimeRange()=" + getTimeRange() + ", getParticipantId()="
				+ getParticipantId() + ", getConfidence()=" + getConfidence() + ", getIsIncluded()=" + getIsIncluded()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}