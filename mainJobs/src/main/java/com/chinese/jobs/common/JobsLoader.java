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
    public JobsLoader(){
        allJobs.add(new JobDetails("餐馆厨师一名", Calendar.getInstance().getTime(),"Job1@gmail.com","Job1 details","NYC"));
        allJobs.add(new JobDetails("急需家务员", Calendar.getInstance().getTime(),"Job2@gmail.com","Job2 details","NYC"));
        allJobs.add(new JobDetails("家教若干",Calendar.getInstance().getTime(),"Job3@gmail.com","Job3 details","NYC"));
        allJobs.add(new JobDetails("洗碗员",Calendar.getInstance().getTime(),"Job4@gmail.com","Job4 details","NYC"));
        allJobs.add(new JobDetails("唐人街司机",Calendar.getInstance().getTime(),"Job5@gmail.com","Job5 details","NYC"));
    }

    public List<Job> getAllJobs() {
        return Collections.unmodifiableList(allJobs);
    }
}
