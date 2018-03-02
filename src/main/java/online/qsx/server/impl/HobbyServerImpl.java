package online.qsx.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.qsx.dao.impl.HobbyDaoImpl;
import online.qsx.dao.impl.JobDaoImpl;
import online.qsx.model.UserHobby;
import online.qsx.model.UserJob;

@Service
public class HobbyServerImpl {
	

	@Autowired
	private HobbyDaoImpl hobbyDaoImpl;

	public List<UserHobby> getHobbys() {
		return hobbyDaoImpl.getHobbys();
	}

	public void deleteUserHobby(UserHobby userHobby) {
		hobbyDaoImpl.deleteUserHobby(userHobby);
	}

	public UserHobby getHobby(UserHobby userHobby) {
		return hobbyDaoImpl.getHobby(userHobby);
	}

	public void edit(UserHobby userHobby) {
		hobbyDaoImpl.edit(userHobby);
	}

	public void save(UserHobby userHobby) {
		hobbyDaoImpl.save(userHobby);
		
	}


}
