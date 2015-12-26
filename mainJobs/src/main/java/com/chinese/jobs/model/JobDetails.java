package com.chinese.jobs.model;

import java.util.Date;

/**
 * Created by xu_s on 12/25/15.
 */
public class JobDetails extends Job {
    private final String details;
    public JobDetails(String jobName, Date datePost,
                      String contact, String details,String location,String id) {
        super(jobName, datePost, contact,location,id);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
