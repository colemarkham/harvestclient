package com.enonic.harvest.harvestclient.models;

import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.enonic.harvest.harvestclient.TimeAdapter;
import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;

@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.NONE)
public class DayEntryRequest
{

    @XmlElement(name = "hours")
    private BigDecimal hours;

    @XmlElement(name = "notes")
    private String notes;

    @XmlElement(name = "project_id")
    private Integer projectId;

    @XmlElement(name = "spent_at")
    private Date spentAt;
    
    @XmlElement(name = "started_at")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Date startedAt;
    
    @XmlElement(name = "ended_at")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Date endedAt;

    @XmlElement(name = "task_id")
    private Integer taskId;

    @XmlElement(name = "user_id")
    private Integer userId;

    public DayEntryRequest() {
	// empty request
    }

    public DayEntryRequest(DayEntry entry) {
	hours = entry.getHours();
	notes = entry.getNotes();
	projectId = entry.getProjectId();
	spentAt = entry.getSpentAt();
	startedAt = entry.getStartedAt();
	endedAt = entry.getEndedAt();
	taskId = entry.getTaskId();
	userId = entry.getUserId();
    }

    public BigDecimal getHours()
    {
        return hours;
    }

    public void setHours(BigDecimal hours)
    {
        this.hours = hours;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public Integer getProjectId()
    {
        return projectId;
    }

    public void setProjectId(Integer projectId)
    {
        this.projectId = projectId;
    }

    public Date getSpentAt()
    {
        return spentAt;
    }

    public void setSpentAt(Date spentAt)
    {
        this.spentAt = spentAt;
    }
    
    public Date getStartedAt() {
	return startedAt;
    }

    public void setStartedAt(Date startedAt) {
	this.startedAt = startedAt;
    }

    public Date getEndedAt() {
	return endedAt;
    }

    public void setEndedAt(Date endedAt) {
	this.endedAt = endedAt;
    }

    public Integer getTaskId()
    {
        return taskId;
    }

    public void setTaskId(Integer taskId)
    {
        this.taskId = taskId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public static DayEntryRequest fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(DayEntryRequest.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (DayEntryRequest) unmarshaller.unmarshal(xml);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into DayEntry.", e);
        }
    }
    
    public String toXML()
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(DayEntryRequest.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
	    marshaller.marshal(this, writer);
	    return writer.toString();
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into DayEntry.", e);
        }
    }
    
}
