package online.qsx.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.qsx.common.BaseDao;
import online.qsx.model.UserHobby;

@Repository
public class HobbyDaoImpl {
	

	@Autowired
	private BaseDao baseDao;
	
	@SuppressWarnings("unchecked")
	public List<UserHobby> getHobbys() {
		return (List<UserHobby> )baseDao.getHibernateTemplate().find("from UserHobby");
	}

	public void deleteUserHobby(UserHobby userHobby) {
		baseDao.getHibernateTemplate().delete(userHobby);
	}

	public UserHobby getHobby(UserHobby userHobby) {
		 return baseDao.getHibernateTemplate().get(UserHobby.class, userHobby.getId());
	}

	public void edit(UserHobby userHobby) {
		baseDao.getHibernateTemplate().saveOrUpdate(userHobby);
	}

	public void save(UserHobby userHobby) {
		baseDao.getHibernateTemplate().saveOrUpdate(userHobby);
	}

	


}
