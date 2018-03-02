package online.qsx.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.common.BaseDao;
import online.qsx.model.UserJob;


@Repository
public class JobDaoImpl {
	
	@Autowired
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	public List<UserJob> getJobs() {
		return (List<UserJob> )baseDao.getHibernateTemplate().find("from UserJob");
	}

	public void deleteUserJob(UserJob userJob) {
		baseDao.getHibernateTemplate().delete(userJob);
	}

	public UserJob getJob(UserJob userJob) {
		 return baseDao.getHibernateTemplate().get(UserJob.class, userJob.getJobid());
	}

	public void edit(UserJob userJob) {
		baseDao.getHibernateTemplate().saveOrUpdate(userJob);
	}

	public void save(UserJob userJob) {
		baseDao.getHibernateTemplate().saveOrUpdate(userJob);
	}

}
