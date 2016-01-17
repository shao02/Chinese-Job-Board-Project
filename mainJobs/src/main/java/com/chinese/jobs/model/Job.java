package com.chinese.jobs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="JOB")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="job_id")
	private Long jobId;

	@Column(name="jobName")
	private String jobName;

	@Column(name="contact")
	private String contact;

	@Column(name="location")
	private String location;

	@Column(name="job_detail")
	private String jobDetail;

	@Column(name="post_date")
	private Date postDate;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User jobUser;

	public Job() {

	}

	public Job(String jobName, Date postDate, String contact,String jobDetail, String location,User jobUser) {
		this.jobName = jobName;
		this.postDate = postDate;
		this.contact = contact;
		this.location = location;
		this.jobDetail = jobDetail;
		this.jobUser = jobUser;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
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

	public String getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public User getJobUser() {
		return jobUser;
	}

	public void setJobUser(User jobUser) {
		this.jobUser = jobUser;
	}
}
