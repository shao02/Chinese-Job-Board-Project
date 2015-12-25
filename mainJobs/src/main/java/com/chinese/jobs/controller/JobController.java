package com.chinese.jobs.controller;

import com.chinese.jobs.common.JobsLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinese.jobs.model.Job;

import java.util.List;

@Controller
public class JobController {
	private static JobsLoader jobsLoader = new JobsLoader();

	@RequestMapping(value="/loadList",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Job> getJobListJSON() {
		return jobsLoader.getAllJobs();
	}
}