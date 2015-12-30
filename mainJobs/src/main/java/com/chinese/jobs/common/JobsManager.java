package com.chinese.jobs.common;

import com.chinese.jobs.model.Job;
import com.chinese.jobs.view.JobPostView;
import com.chinese.jobs.view.JobView;
import com.chinese.jobs.view.JobsLoadView;

import java.text.ParseException;
import java.util.*;


/**
 * Created by xu_s on 12/25/15.
 */
public class JobsManager {
    //For now use hard coded data.
    private final List<Job> allJobs = new ArrayList<Job>();
    private final List<JobsLoadView> jobsLoadViews = new ArrayList<JobsLoadView>();
    private final Map<String,JobView> jobMapper = new HashMap<String, JobView>();
    public JobsManager(){
        allJobs.add(new Job("餐馆厨师一名", Calendar.getInstance().getTime(),"Job1@gmail.com","Job1 details","NYC",UUID.randomUUID().toString()));
        allJobs.add(new Job("急需家务员", Calendar.getInstance().getTime(),"Job2@gmail.com","Job2 details","NYC",UUID.randomUUID().toString()));
        allJobs.add(new Job("家教若干",Calendar.getInstance().getTime(),"Job3@gmail.com","Job3 details","NYC",UUID.randomUUID().toString()));
        allJobs.add(new Job("洗碗员",Calendar.getInstance().getTime(),"Job4@gmail.com","Job4 details","NYC",UUID.randomUUID().toString()));
        allJobs.add(new Job("唐人街司机",Calendar.getInstance().getTime(),"Job5@gmail.com","Job5 details","NYC",UUID.randomUUID().toString()));

        for(Job cur : allJobs){
            jobsLoadViews.add(new JobsLoadView(cur));
            jobMapper.put(cur.getId(), new JobView(cur));
        }
     }

    public List<JobsLoadView> getAllJobs() {
        return Collections.unmodifiableList(jobsLoadViews);
    }

    public JobView getJobDetails(String id){
        return jobMapper.get(id);
    }

    public void addSingleJob(JobPostView cur) throws ParseException {
        Job curJob = new Job(cur.getJobName(), cur.convertToDate(),cur.getContact(),cur.getDetails(),cur.getLocation(),UUID.randomUUID().toString());
        allJobs.add(curJob);
        jobsLoadViews.add(new JobsLoadView(curJob));
        jobMapper.put(curJob.getId(), new JobView(curJob));
    }
}
