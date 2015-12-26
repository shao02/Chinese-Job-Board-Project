package com.chinese.jobs.common;

import com.chinese.jobs.model.Job;
import com.chinese.jobs.view.JobView;
import com.chinese.jobs.view.JobsLoadView;

import java.util.*;


/**
 * Created by xu_s on 12/25/15.
 */
public class JobsLoader {
    //For now use hard coded data.
    private final List<Job> allJobs = new ArrayList<Job>();
    private final List<JobsLoadView> jobsLoadViews = new ArrayList<JobsLoadView>();
    private final Map<String,JobView> jobMapper = new HashMap<String, JobView>();
    public JobsLoader(){
        allJobs.add(new Job("餐馆厨师一名", Calendar.getInstance().getTime(),"Job1@gmail.com","Job1 details","NYC","123"));
        allJobs.add(new Job("急需家务员", Calendar.getInstance().getTime(),"Job2@gmail.com","Job2 details","NYC","124"));
        allJobs.add(new Job("家教若干",Calendar.getInstance().getTime(),"Job3@gmail.com","Job3 details","NYC","125"));
        allJobs.add(new Job("洗碗员",Calendar.getInstance().getTime(),"Job4@gmail.com","Job4 details","NYC","126"));
        allJobs.add(new Job("唐人街司机",Calendar.getInstance().getTime(),"Job5@gmail.com","Job5 details","NYC","121"));

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
}
