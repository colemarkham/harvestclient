package com.enonic.harvest.harvestclient.models;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.enonic.harvest.harvestclient.TimeAdapter;
import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;

@XmlRootElement(name="day-entry")
@XmlAccessorType(XmlAccessType.NONE)
public class DayEntry
{

    @XmlElement(name = "hours")
    private BigDecimal hours;

    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "notes")
    private String notes;

    @XmlElement(name = "project-id")
    private Integer projectId;

    @XmlElement(name = "spent-at")
    private Date spentAt;
    
    @XmlElement(name = "started-at")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Date startedAt;
    
    @XmlElement(name = "ended-at")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private Date endedAt;

    @XmlElement(name = "task-id")
    private Integer taskId;

    @XmlElement(name = "user-id")
    private Integer userId;

    @XmlElement(name = "is-billed")
    private boolean isBilled;

    @XmlElement(name = "is-closed")
    private boolean isClosed;

    @XmlElement(name = "updated-at")
    private Date updatedAt;

    @XmlElement(name = "created-at")
    private Date createdAt;

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public BigDecimal getHours()
    {
        return hours;
    }

    public void setHours(BigDecimal hours)
    {
        this.hours = hours;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public boolean isClosed()
    {
        return isClosed;
    }

    public void setClosed(boolean isClosed)
    {
        this.isClosed = isClosed;
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

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public boolean isBilled()
    {
        return isBilled;
    }

    public void setBilled(boolean isBilled)
    {
        this.isBilled = isBilled;
    }
    
    public static DayEntry fromInputStream(final InputStream xml)
            throws HarvestClientException
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(DayEntry.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (DayEntry) unmarshaller.unmarshal(xml);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Unable to parse XML into DayEntry.", e);
        }
    }
}
