package com.chinese.jobs.common;

import com.chinese.jobs.model.Job;
import com.chinese.jobs.model.User;
import com.chinese.jobs.view.JobPostView;
import com.chinese.jobs.view.JobView;
import com.chinese.jobs.view.JobsLoadView;
import com.chinese.persistence.dbUtil;

import java.text.ParseException;
import java.util.*;


/**
 * Created by xu_s on 12/25/15.
 */
public class JobsManager {
    //For now use hard coded data.
    private final List<Job> allJobs = new ArrayList<Job>();
    private final List<JobsLoadView> jobsLoadViews = new ArrayList<JobsLoadView>();
    private final Map<Long,JobView> jobMapper = new HashMap<Long, JobView>();
    private final Map<Long,List<Job>> userJobMapper = new HashMap<Long, List<Job>>();
    public JobsManager(){
        User admin = new User("admin","abc");
        dbUtil.addDBObject(admin);
        dbUtil.addDBObject(new Job("餐馆厨师一名", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "Job1@gmail.com", "Job1 details", "NYC", admin));
        dbUtil.addDBObject(new Job("急需家务员", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "Job2@gmail.com", "Job2 details", "NYC", admin));
        dbUtil.addDBObject(new Job("家教若干", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "Job3@gmail.com", "Job3 details", "NYC", admin));
        dbUtil.addDBObject(new Job("洗碗员", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "Job4@gmail.com", "Job4 details", "NYC", admin));
        dbUtil.addDBObject(new Job("唐人街司机", new java.sql.Date(Calendar.getInstance().getTime().getTime()), "Job5@gmail.com", "Job5 details", "NYC", admin));
     }

    public List<JobsLoadView> getAllJobs() {
        return Collections.unmodifiableList(jobsLoadViews);
    }

    public JobView getJobDetails(String id){
        return jobMapper.get(id);
    }

    public void addSingleJob(long userId,JobPostView cur) throws ParseException {
        User curUser = dbUtil.loadUser(userId);
        Job curJob = new Job(cur.getJobName(), new java.sql.Date(cur.convertToDate().getTime()),cur.getContact(),cur.getDetails(),cur.getLocation(),curUser);
        dbUtil.addDBObject(curJob);
    }

    static public void addSingleUser(User user){
        dbUtil.addDBObject(user);
    }
}
