package com.enonic.harvest.harvestclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.enonic.harvest.harvestclient.exceptions.HarvestClientException;
import com.enonic.harvest.harvestclient.exceptions.ThrottleLimitReachedException;


class HarvestPostRequest
        extends HarvestRequest
{

    public InputStream getInputStream(String body)
            throws HarvestClientException
    {
        HttpClient client;
        HttpPost request;
        HttpResponse response;

        try
        {
            client = HttpClientBuilder.create().build();
            request = new HttpPost(this.getUrl());
            HttpEntity bodyEntity = new StringEntity(body);
            request.setEntity(bodyEntity);
            request.addHeader("Authorization", this.getAuthenticationHeader());
            request.addHeader("Accept", "application/xml");
            request.addHeader("Content-Type", "application/xml");
            request.addHeader("User-Agent", "HarvestClient");
            response = client.execute(request);
        }
        catch (Exception e)
        {
            throw new HarvestClientException("Could not perform request.", e);
        }

        if (response.getStatusLine().getStatusCode() == 503)
            throw new ThrottleLimitReachedException();
        else if (response.getStatusLine().getStatusCode() != 200 && response.getStatusLine().getStatusCode() != 201)
            throw new HarvestClientException(String.format("Returned status code %s: %s", response.getStatusLine().getStatusCode(), this.getUrl()));

        try
        {
            return response.getEntity().getContent();
        }
        catch (IOException e)
        {
            throw new HarvestClientException("Failed to get InputStream from response.", e);
        }
    }

}
