package com.chinese.jobs.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Job {
	private static final DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
	private String jobName;
	private Date datePost;
	private String contact;
	private String location;
	private String id;
	private String details;

	public Job(String jobName, Date datePost, String contact,String details,String location,String id) {
		this.jobName = jobName;
		this.datePost = datePost;
		this.contact = contact;
		this.location = location;
		this.id = id;
		this.details = details;
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

	public String getId() {
		return id;
	}

	public String getDetails() {
		return details;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Job{" +
				"jobName='" + jobName + '\'' +
				", datePost=" + dateFormat.format(datePost) +
				", contact='" + contact + '\'' +
				", location='" + location + '\'' +
				", id='" + id + '\'' +
				'}';
	}
}