package com.enonic.harvest.harvestclient;

import java.util.Date;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.enonic.harvest.harvestclient.models.Client;
import com.enonic.harvest.harvestclient.models.ClientCollection;
import com.enonic.harvest.harvestclient.models.DayEntry;
import com.enonic.harvest.harvestclient.models.DayEntryCollection;
import com.enonic.harvest.harvestclient.models.DayEntryRequest;
import com.enonic.harvest.harvestclient.models.Invoice;
import com.enonic.harvest.harvestclient.models.InvoiceCollection;
import com.enonic.harvest.harvestclient.models.InvoiceItemCategoryCollection;
import com.enonic.harvest.harvestclient.models.InvoiceMessage;
import com.enonic.harvest.harvestclient.models.InvoiceMessageCollection;
import com.enonic.harvest.harvestclient.models.InvoicePayment;
import com.enonic.harvest.harvestclient.models.InvoicePaymentCollection;
import com.enonic.harvest.harvestclient.models.Project;
import com.enonic.harvest.harvestclient.models.ProjectCollection;
import com.enonic.harvest.harvestclient.models.Task;
import com.enonic.harvest.harvestclient.models.TaskAssignmentCollection;
import com.enonic.harvest.harvestclient.models.TaskCollection;
import com.enonic.harvest.harvestclient.models.User;
import com.enonic.harvest.harvestclient.models.UserAssignmentCollection;
import com.enonic.harvest.harvestclient.models.UserCollection;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByProjectParameters;
import com.enonic.harvest.harvestclient.parameters.GetDayEntriesByUserParameters;
import com.enonic.harvest.harvestclient.parameters.GetRecentInvoicesParameters;

public interface HarvestClient
{
    UserCollection getUsers()
            throws HarvestClientException;

    UserCollection getUsers(Date updatedSince)
            throws HarvestClientException;

    User getUser(int id)
            throws HarvestClientException;

    ClientCollection getClients()
            throws HarvestClientException;

    ClientCollection getClients(Date updatedSince)
            throws HarvestClientException;

    Client getClient(int id)
            throws HarvestClientException;

    DayEntryCollection getDayEntriesByUser(GetDayEntriesByUserParameters params)
            throws HarvestClientException;

    DayEntryCollection getDayEntriesByProject(GetDayEntriesByProjectParameters params)
            throws HarvestClientException;

    void addDayEntry(DayEntryRequest request)
            throws HarvestClientException;

    void updateDayEntry(DayEntry entry) 
	    throws HarvestClientException;

    void deleteDayEntry(int id)
                   throws HarvestClientException;

    ProjectCollection getProjects()
            throws HarvestClientException;

    ProjectCollection getProjects(Date updatedSince)
            throws HarvestClientException;

    ProjectCollection getProjects(int clientId)
            throws HarvestClientException;

    ProjectCollection getProjects(int clientId, Date updatedSince)
            throws HarvestClientException;

    Project getProject(int id)
            throws HarvestClientException;

    TaskCollection getTasks()
            throws HarvestClientException;

    TaskCollection getTasks(Date updatedSince)
            throws HarvestClientException;

    Task getTask(int id)
            throws HarvestClientException;

    UserAssignmentCollection getUserAssignments(int projectId)
            throws HarvestClientException;

    UserAssignmentCollection getUserAssignments(int projectId, Date updatedSince)
            throws HarvestClientException;

    TaskAssignmentCollection getTaskAssignments(int projectId)
            throws HarvestClientException;

    TaskAssignmentCollection getTaskAssignments(int projectId, Date updatedSince)
            throws HarvestClientException;

    InvoiceCollection getRecentInvoices(GetRecentInvoicesParameters params)
            throws HarvestClientException;

    Invoice getInvoice(int id)
            throws HarvestClientException;

    InvoiceItemCategoryCollection getInvoiceItemCategories()
            throws  HarvestClientException;

    InvoiceMessageCollection getInvoiceMessages(int invoiceId)
            throws HarvestClientException;

    InvoiceMessage getInvoiceMessage(int invoiceId, int id)
            throws  HarvestClientException;

    InvoicePaymentCollection getInvoicePayments(int invoiceId)
            throws HarvestClientException;

    InvoicePayment getInvoicePayment(int invoiceId, int id)
            throws HarvestClientException;
    
}
