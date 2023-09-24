package com.vishnu.JobSearch.repo;

import com.vishnu.JobSearch.model.Job;
import com.vishnu.JobSearch.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Integer> {

	Job findByJobTypeEqualsAndSalaryGreaterThanEqual(Type jobtype, Double salary);

	Job findByTitleAndLocation(String title, String location);

	List<Job> findTop10BySalaryGreaterThan(Double salary);

	List<Job> findByLocationEquals(String location);

	@Modifying
	@Query(value = "UPDATE JOB SET SALARY = (SALARY+SALARY*(:hike)) WHERE JOB_TYPE = :jobType",nativeQuery = true)
	void updateJobTypeWithHike(float hike, String jobType);

	@Modifying
	@Query(value = "DELETE FROM JOB WHERE JOB_TYPE = :jobType",nativeQuery = true)
	void deleteJobsByType(String jobType);

	@Modifying
	@Query(value = "DELETE FROM JOB WHERE LOCATION = :location",nativeQuery = true)
	void deleteJobsInLocation(String location);

	@Modifying
	@Query(value = "UPDATE JOB SET COMPANY_EMAIL = :email WHERE COMPANY_NAME = :company",nativeQuery = true)
	void updateJobsEmail(String company, String email);
}
