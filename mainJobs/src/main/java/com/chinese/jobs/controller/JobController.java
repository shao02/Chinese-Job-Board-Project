package com.chinese.jobs.controller;

import com.chinese.jobs.common.CredentialManager;
import com.chinese.jobs.common.JobsManager;
import com.chinese.jobs.filter.RestAuthenticationFilter;
import com.chinese.jobs.model.User;
import com.chinese.jobs.view.JobPostView;
import com.chinese.jobs.view.JobView;
import com.chinese.jobs.view.JobsLoadView;
import org.springframework.http.HttpHeaders;
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

	@RequestMapping(value="/job/postJob",
					method = RequestMethod.POST,
					headers = {"Content-type=application/json"})
	@ResponseBody
	public ResponseEntity postJobDetailJSON(@RequestBody JobPostView job) throws ParseException {
		jobsLoader.addSingleJob(job);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value="/createUser",
			method = RequestMethod.POST,
			headers = {"Content-type=application/json"})
	@ResponseBody
	public ResponseEntity postCreateUserIdJson(@RequestBody User user) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		try{
			if(CredentialManager.isUserNameUsed(user.getUserId()))
				return new ResponseEntity(HttpStatus.IM_USED);

			CredentialManager.addUser(user);
			headers.set(RestAuthenticationFilter.AUTHENTICATION_HEADER,user.convertToCode());
		}catch (Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(headers,HttpStatus.OK);
	}

	@RequestMapping(value="/isUser",
			method = RequestMethod.POST,
			headers = {"Content-type=application/json"})
	@ResponseBody
	public ResponseEntity postIsUserJson(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		try{
			if(!CredentialManager.validateUser(user))
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			headers.set(RestAuthenticationFilter.AUTHENTICATION_HEADER, user.convertToCode());
		}catch (Exception e){
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(headers,HttpStatus.OK);
	}
}