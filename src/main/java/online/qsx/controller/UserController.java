package online.qsx.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import online.qsx.model.UserJob;
import online.qsx.model.UserModel;
import online.qsx.server.impl.JobServerImpl;
import online.qsx.server.impl.UserServerImpl;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	
//http://localhost:8080/ush/user/to_login
	@RequestMapping("to_login")
	public String to_index(){	
		
		return "login";
	}
		
	@Autowired
	private JobServerImpl jobServerImpl;
	private List<UserJob> userJobs =new ArrayList<>();

	public List<UserJob> getUserJobs() {
		return userJobs;
	}


	public void setUserJobs(List<UserJob> userJobs) {
		this.userJobs = userJobs;
	}

	@Autowired
	private UserServerImpl userServerImpl;
	
	private List<UserModel> list;
	private UserModel userModel;
	
	//http://localhost:8080/ush/user/to_list
		@RequestMapping(value = "to_list", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView findUsers(ModelAndView modelAndView) {
		list = userServerImpl.getUsers();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("list");
		
			return modelAndView;
		}
		

	//http://localhost:8080/ush/user/login
	@RequestMapping(value = "login", method = { RequestMethod.GET, RequestMethod.POST })
	 public ModelAndView login(String username, String password,ModelAndView mav) {
			list = userServerImpl.getUsers();
			for (UserModel user : list) {
				if (username.equals(user.getName()) && password.equals(user.getPassword())) {
					mav.setViewName("redirect:/user/to_list");
					return mav;
				}
			}
			mav.addObject("mav", "账号或密码错误,请重新输入");
			mav.setViewName("login");
			return mav;
		}

    
	//http://localhost:8080/ush/user/delete
	@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(UserModel userModel) {
		userServerImpl.deleteUserModel(userModel);
	//	list = userServerImpl.getUsers();
		return "redirect:/user/to_list";
	}
	
	//http://localhost:8080/ush/user/to_info
	@RequestMapping(value = "to_info", method = { RequestMethod.GET, RequestMethod.POST })
	public String info(UserModel userModel) {
		userModel=userServerImpl.getUser(userModel);
		return "info";
	}
	
	//http://localhost:8080/ush/user/to_edit
	@RequestMapping(value = "to_edit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView to_edit(UserModel userModel,ModelAndView modelAndView) {
		userModel=userServerImpl.getUser(userModel);
		userJobs = jobServerImpl.getJobs();
		modelAndView.addObject("userModel",userModel);
		modelAndView.addObject("userJobs",userJobs);
		modelAndView.setViewName("edit");
		return modelAndView;
	}
	
	//http://localhost:8080/ush/user/do_edit
	@RequestMapping(value = "do_edit", method = { RequestMethod.GET, RequestMethod.POST })
	public String do_edit(UserModel userModel) {
		userServerImpl.edit(userModel);
		//list = userServerImpl.getUsers();
		return "redirect:/user/to_list";
	}
	
	//http://localhost:8080/ush/user/to_save
	@RequestMapping(value = "to_save", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findJobs(ModelAndView modelAndView) {
		userJobs = jobServerImpl.getJobs();
	   modelAndView.addObject("userJobs",userJobs)  ;
	   modelAndView.setViewName("save");
		return modelAndView;
	}
	
	//http://localhost:8080/ush/user/do_save
	@RequestMapping(value = "do_save", method = { RequestMethod.GET, RequestMethod.POST })
	public String do_save(UserModel userModel) {
		userServerImpl.save(userModel);
		System.out.println("do..save");
		return "redirect:/user/to_list";
	}

	
	public List<UserModel> getList() {
		
		return list;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
}
