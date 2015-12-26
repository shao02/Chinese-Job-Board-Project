package com.chinese.jobs.common;

import com.chinese.jobs.model.Job;
import com.chinese.jobs.model.JobDetails;

import java.util.*;


/**
 * Created by xu_s on 12/25/15.
 */
public class JobsLoader {
    //For now use hard coded data.
    private final List<Job> allJobs = new ArrayList<Job>();
    private final Map<String,JobDetails> jobMapper = new HashMap<String, JobDetails>();
    public JobsLoader(){
        allJobs.add(new JobDetails("餐馆厨师一名", Calendar.getInstance().getTime(),"Job1@gmail.com","Job1 details","NYC","123"));
        allJobs.add(new JobDetails("急需家务员", Calendar.getInstance().getTime(),"Job2@gmail.com","Job2 details","NYC","124"));
        allJobs.add(new JobDetails("家教若干",Calendar.getInstance().getTime(),"Job3@gmail.com","Job3 details","NYC","125"));
        allJobs.add(new JobDetails("洗碗员",Calendar.getInstance().getTime(),"Job4@gmail.com","Job4 details","NYC","126"));
        allJobs.add(new JobDetails("唐人街司机",Calendar.getInstance().getTime(),"Job5@gmail.com","Job5 details","NYC","121"));

        jobMapper.put("123",new JobDetails("餐馆厨师一名", Calendar.getInstance().getTime(),"Job1@gmail.com","Job1 details","NYC","123"));
        jobMapper.put("124",new JobDetails("急需家务员", Calendar.getInstance().getTime(),"Job2@gmail.com","Job2 details","NYC","124"));
        jobMapper.put("125",new JobDetails("家教若干",Calendar.getInstance().getTime(),"Job3@gmail.com","Job3 details","NYC","125"));
        jobMapper.put("126",new JobDetails("洗碗员",Calendar.getInstance().getTime(),"Job4@gmail.com","Job4 details","NYC","126"));
        jobMapper.put("121",new JobDetails("唐人街司机",Calendar.getInstance().getTime(),"Job5@gmail.com","Job5 details","NYC","121"));
    }

    public List<Job> getAllJobs() {
        return Collections.unmodifiableList(allJobs);
    }

    public JobDetails getJobDetails(String id){
        return jobMapper.get(id);
    }
}
