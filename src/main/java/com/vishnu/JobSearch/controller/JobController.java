package com.vishnu.JobSearch.controller;

import com.vishnu.JobSearch.model.Job;
import com.vishnu.JobSearch.model.Type;
import com.vishnu.JobSearch.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class JobController {
	@Autowired
	JobService jobService;

	@PostMapping("job")
	public String postJob(@RequestBody @Valid Job job){
		return jobService.addJob(job);
	}
	@PostMapping("jobs")
	public String postJobs(@RequestBody List<Job> jobs){
		return jobService.addJobs(jobs);
	}

	@GetMapping("jobs")
	public List<Job> getJobs(){
		return jobService.getAllJobs();
	}
	@GetMapping("job/{id}")
	public Job getJobWithId(@PathVariable Integer id){
		return jobService.getJobWithId(id);
	}
	@GetMapping("jobs/type/{jobType}/salary")
	public Job getJobWithTypeAndSalaryAbove(@PathVariable Type jobType,@RequestParam Double salary){
		return jobService.getJobWithTypeAndSalaryAbove(jobType,salary);
	}
	@GetMapping("jobs/title/{title}/location")
	public Job getJobWithLocationAndTitle(@PathVariable String title,@RequestParam String location){
		return jobService.getJobWithLocationAndTitle(title,location);
	}
	@GetMapping("jobs/salary")
	public List<Job> getJobsWithSalaryAbove(@RequestParam Double salary){
		return jobService.getJobsWithSalaryAbove(salary);
	}
	@GetMapping("jobs/location/{location}")
	public List<Job> getJobByLocation(@PathVariable String location){
		return jobService.getJobByLocation(location);
	}

	@PutMapping("jobs/id/{id}/salary")
	public String updateJobSalary(@RequestParam Double salary,@PathVariable Integer id){
		return jobService.updateSalary(salary,id);
	}
	@PutMapping("jobs/type/{type}/hike")
	public String updateJobByType(@RequestParam float hike,@PathVariable Type type){
		return jobService.updateJobTypeSalaryHike(hike,type);
	}
	@PutMapping("jobs/company/email")
	public String updateJobsEmail(@RequestParam String company,@RequestParam String email){
		return jobService.updateJobsEmail(company,email);
	}

	@DeleteMapping("jobs/id/{id}")
	public String deleteJob(@PathVariable Integer id){
		return jobService.deleteJobById(id);
	}
	@DeleteMapping("jobs/type")
	public String deleteJobsWithType(@RequestParam Type type){
		return jobService.deleteJobsByType(type);
	}
	@DeleteMapping("jobs/location")
	public String deleteJobsByLocation(@RequestParam String location){
		return jobService.deleteJobsByLocation(location);
	}
}
