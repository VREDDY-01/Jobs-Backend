# Jobs-Backend

A Simple Spring boot backent application to manage the jobs.



## Tech Stack

**Client:** Postman

**Server:** Java, Maven, SpringBoot



## Functions Used

**Controller:** addJob,addJobs,getJobs,getJobWithId,getJobWithLocationAndTitle,getJobsWithSalaryAbove,getJobByLocation,updateJobSalary,updateJobByType,updateJobsEmail,deleteJob,deleteJobsWithType,deleteJobsByLocation
 
**Services:** addJob,addJobs,getJobs,getJobWithId,getJobWithLocationAndTitle,getJobsWithSalaryAbove,getJobByLocation,updateJobSalary,updateJobByType,updateJobsEmail,deleteJob,deleteJobsWithType,deleteJobsByLocation

**Database Design:** Job[id,title,description,location,salary,companyEmail,compnayName,employerName,jobType,appliedDate]

**Repository:** findByJobTypeEqualsAndSalaryGreaterThanEqual,findByTitleAndLocation,findTop10BySalaryGreaterThan,findByLocationEquals,updateJobTypeWithHike,deleteJobsByType,deleteJobsInLocation,updateJobsEmail



## Data-Structures Used

This project uses:

- h2

## Project Summary

This Project is based on spring boot framework and maven dependency manager.This is a simple backend application for manageing the jobs.

