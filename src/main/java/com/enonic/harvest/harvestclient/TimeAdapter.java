/**
 * Copyright 2015 Cole Markham, all rights reserved.
 */
package com.enonic.harvest.harvestclient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Cole Markham
 *
 */
public class TimeAdapter extends XmlAdapter<String, Date> {
    DateFormat format = new SimpleDateFormat("HH:mm");

    @Override
    public Date unmarshal(String v) throws Exception {
	return format.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
	return format.format(v);
    }

}
