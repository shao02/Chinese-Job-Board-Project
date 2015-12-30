package com.chinese.jobs.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xu_s on 12/30/15.
 */
public class JobPostView {
    private static final DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
    private String details;
    private String jobName;
    private String datePost;
    private String contact;
    private String location;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date convertToDate() throws ParseException {
        return dateFormat.parse(datePost);
    }
}
