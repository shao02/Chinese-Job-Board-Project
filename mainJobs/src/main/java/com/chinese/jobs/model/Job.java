package com.chinese.jobs.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Job {
	private static final DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
	private final String jobName;
	private final Date datePost;
	private final String contact;
	private final String location;

	public Job(String jobName, Date datePost, String contact,String location) {
		this.jobName = jobName;
		this.datePost = datePost;
		this.contact = contact;
		this.location = location;
	}

	public String getJobName() {
		return jobName;
	}

	public Date getDatePost() {
		return datePost;
	}

	public String getContact() {
		return contact;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Job{" +
				"jobName='" + jobName + '\'' +
				", datePost=" + dateFormat.format(datePost) +
				", contact='" + contact + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}