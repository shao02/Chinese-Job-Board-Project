package com.chinese.jobs.controller;

import com.chinese.jobs.common.JobsManager;
import com.chinese.jobs.view.JobPostView;
import com.chinese.jobs.view.JobView;
import com.chinese.jobs.view.JobsLoadView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@Controller
public class JobController {
	private static JobsManager jobsLoader = new JobsManager();

	@RequestMapping(value="/loadList",
					method = RequestMethod.GET,
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<JobsLoadView> getJobListJSON() {
		return jobsLoader.getAllJobs();
	}

	@RequestMapping(value="/loadJob",
					method = RequestMethod.GET,
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public JobView getJobDetailJSON(
			@RequestParam(required=true) String id) {
		return jobsLoader.getJobDetails(id);
	}

	@RequestMapping(value="/add/postJob",
					method = RequestMethod.POST,
					headers = {"Content-type=application/json"})
	@ResponseBody
	public ResponseEntity postJobDetailJSON(@RequestBody JobPostView job) throws ParseException {
		jobsLoader.addSingleJob(job);
		return new ResponseEntity(HttpStatus.OK);
	}

}