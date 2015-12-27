package com.chinese.jobs.view;

import com.chinese.jobs.model.Job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by xu_s on 12/26/15.
 */
public class JobView {
    private static final DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
    private final Job myJob;

    public JobView(Job myJob) {
        this.myJob = myJob;
    }

    public String getJobName() {
        return myJob.getJobName();
    }

    public String getDatePost() {
        return dateFormat.format(myJob.getDatePost());
    }

    public String getContact() {
        return myJob.getContact();
    }

    public String getLocation() {
        return myJob.getLocation();
    }

    public String getId() {
        return myJob.getId();
    }

    public String getDetails() {
        return myJob.getDetails();
    }
}
