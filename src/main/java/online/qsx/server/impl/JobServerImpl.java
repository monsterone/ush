package online.qsx.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.JobDaoImpl;

import online.qsx.model.UserJob;


@Service
public class JobServerImpl {
	
	@Autowired
	private JobDaoImpl jobDaoImpl;

	public List<UserJob> getJobs() {
		return jobDaoImpl.getJobs();
	}

	public void deleteUserJob(UserJob userJob) {
		jobDaoImpl.deleteUserJob(userJob);
	}

	public UserJob getJob(UserJob userJob) {
		return jobDaoImpl.getJob(userJob);
	}

	public void edit(UserJob userJob) {
		jobDaoImpl.edit(userJob);
	}

	public void save(UserJob userJob) {
		jobDaoImpl.save(userJob);
		
	}


}
