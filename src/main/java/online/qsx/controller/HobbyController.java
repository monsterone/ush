package online.qsx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import online.qsx.model.UserHobby;
import online.qsx.model.UserJob;
import online.qsx.model.UserModel;
import online.qsx.server.impl.HobbyServerImpl;
import online.qsx.server.impl.JobServerImpl;

@Controller
@RequestMapping(value="hobby")
public class HobbyController {
	
	@Autowired
	private HobbyServerImpl hobbyServerImpl;
	
	private List<UserHobby> list;
	private UserHobby userHobby;

	public List<UserHobby> getList() {
		return list;
	}

	public void setList(List<UserHobby> list) {
		this.list = list;
	}

	public UserHobby getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(UserHobby userHobby) {
		this.userHobby = userHobby;
	}

		//http://localhost:8080/ush/hobby/to_login
		@RequestMapping("to_login")
		public String to_index(){	
			
			return "login";
		}
	
		//http://localhost:8080/ush/hobby/to_list
		@RequestMapping(value = "to_list", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView findJobs(ModelAndView modelAndView) {
			list = hobbyServerImpl.getHobbys();
		modelAndView.addObject("list",list)  ;
		modelAndView.setViewName("/hobby/list_h");
			return modelAndView;
		}
	    
		//http://localhost:8080/ush/hobby/delete
		@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete(UserHobby userHobby) {
			hobbyServerImpl.deleteUserHobby(userHobby);
		//	list = userServerImpl.getUsers();
			return "redirect:/hobby/to_list";
		}
		
		//http://localhost:8080/ush/hobby/to_info
		@RequestMapping(value = "to_info", method = { RequestMethod.GET, RequestMethod.POST })
		public String info(UserHobby userHobby) {
			userHobby=hobbyServerImpl.getHobby(userHobby);
			return "info_h";
		}
		
		//http://localhost:8080/ush/hobby/to_edit
		@RequestMapping(value = "to_edit", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView to_edit(UserHobby userHobby,ModelAndView modelAndView) {
			userHobby=hobbyServerImpl.getHobby(userHobby);
			modelAndView.addObject("userHobby",userHobby);
			modelAndView.setViewName("/hobby/edit_h");
			return modelAndView;
		}
		
		//http://localhost:8080/ush/hobby/do_edit
		@RequestMapping(value = "do_edit", method = { RequestMethod.GET, RequestMethod.POST })
		public String do_edit(UserHobby userHobby) {
			hobbyServerImpl.edit(userHobby);
			//list = userServerImpl.getUsers();
			return "redirect:/hobby/to_list";
		}
		
		//http://localhost:8080/ush/hobby/to_save
		@RequestMapping(value = "to_save", method = { RequestMethod.GET, RequestMethod.POST })
		public String to_save() {
			return "/hobby/save_h";
		}
		
		//http://localhost:8080/ush/hobby/do_save
		@RequestMapping(value = "do_save", method = { RequestMethod.GET, RequestMethod.POST },produces="text/html;charset=UTF-8")
		public String do_save(UserHobby userHobby) {
			hobbyServerImpl.save(userHobby);
			return "redirect:/hobby/to_list";
		}


}
