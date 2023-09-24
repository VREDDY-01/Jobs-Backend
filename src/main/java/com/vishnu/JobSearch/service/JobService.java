package com.vishnu.JobSearch.service;

import com.vishnu.JobSearch.model.Job;
import com.vishnu.JobSearch.model.Type;
import com.vishnu.JobSearch.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
	@Autowired
	IJobRepo jobRepo;

	public String addJob(Job job) {
		jobRepo.save(job);
		return "job added successfully";
	}

	public String addJobs(List<Job> jobs) {
		jobRepo.saveAll(jobs);
		return "all jobs added successfully";
	}

	public List<Job> getAllJobs() {
		return (List<Job>) jobRepo.findAll();
	}

	public Job getJobWithId(Integer id) {
		return  jobRepo.findById(id).get();
	}

	public Job getJobWithTypeAndSalaryAbove(Type jobtype, Double salary) {
		return jobRepo.findByJobTypeEqualsAndSalaryGreaterThanEqual(jobtype,salary);
	}

	public String updateSalary(Double salary, Integer id) {
		Job presentJob = jobRepo.findById(id).orElse(null);
		if(presentJob != null)
		{
			presentJob.setSalary(salary);
			jobRepo.save(presentJob);
			return "price updated!!";
		}
		else {
			return "stock not found!";
		}
	}

	public String deleteJobById(Integer id) {
		jobRepo.deleteById(id);
		return "deleted a Job";
	}

	@Transactional
	public String updateJobTypeSalaryHike(float hike, Type type) {
		jobRepo.updateJobTypeWithHike(hike,type.name());
		return "updates all salaries";
	}

	@Transactional
	public String deleteJobsByType(Type type) {
		jobRepo.deleteJobsByType(type.name());
		return "deleted all jobs with type "+type;
	}

	public Job getJobWithLocationAndTitle(String title, String location) {
		return jobRepo.findByTitleAndLocation(title,location);
	}

	public List<Job> getJobsWithSalaryAbove(Double salary) {
		return jobRepo.findTop10BySalaryGreaterThan(salary);
	}

	public List<Job> getJobByLocation(String location) {
		return jobRepo.findByLocationEquals(location);
	}

	@Transactional
	public String deleteJobsByLocation(String location) {
		jobRepo.deleteJobsInLocation(location);
		return "deleted all jobs in "+location;
	}

	@Transactional
	public String updateJobsEmail(String company, String email) {
		jobRepo.updateJobsEmail(company,email);
		return "updates all emails";
	}
}
