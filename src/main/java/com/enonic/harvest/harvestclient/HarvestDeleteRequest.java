package com.enonic.harvest.harvestclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.enonic.harvest.harvestclient.exceptions.ThrottleLimitReachedException;


class HarvestDeleteRequest
        extends HarvestRequest
{

    public void execute()
            throws HarvestClientException
    {
        HttpClient client;
        HttpDelete request;
        HttpResponse response;

        try
        {
            client = HttpClientBuilder.create().build();
            request = new HttpDelete(this.getUrl());
            request.addHeader("Authorization", this.getAuthenticationHeader());
            request.addHeader("Accept", "application/xml");
            request.addHeader("User-Agent", "HarvestClient");
            response = client.execute(request);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Could not perform request.", e);
        }

        if (response.getStatusLine().getStatusCode() == 503)
            throw new ThrottleLimitReachedException();
        else if (response.getStatusLine().getStatusCode() != 200)
            throw new HarvestClientException(String.format("Returned status code %s: %s", response.getStatusLine().getStatusCode(), this.getUrl()));

    }

}
