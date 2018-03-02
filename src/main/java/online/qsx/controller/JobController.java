package online.qsx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import online.qsx.model.UserJob;

import online.qsx.server.impl.JobServerImpl;


@Controller
@RequestMapping(value="job")
public class JobController {
	
	@Autowired
	private JobServerImpl jobServerImpl;
	
	private List<UserJob> list;
	private UserJob userJob;
	
	
	
	public List<UserJob> getList() {
		return list;
	}

	public void setList(List<UserJob> list) {
		this.list = list;
	}

	public UserJob getUserJob() {
		return userJob;
	}

	public void setUserJob(UserJob userJob) {
		this.userJob = userJob;
	}

		//http://localhost:8080/ush/job/to_login
		@RequestMapping("to_login")
		public String to_index(){	
			
			return "login";
		}
	
		//http://localhost:8080/ush/job/to_list
		@RequestMapping(value = "to_list", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView findJobs(ModelAndView modelAndView) {
			list = jobServerImpl.getJobs();
		modelAndView.addObject("list",list)  ;
		modelAndView.setViewName("/job/list_j");
			return modelAndView;
		}
	    
		//http://localhost:8080/ush/job/delete
		@RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String delete(UserJob userJob) {
			jobServerImpl.deleteUserJob(userJob);
		//	list = userServerImpl.getUsers();
			return "redirect:/job/to_list";
		}
		
		//http://localhost:8080/ush/user/to_info
		@RequestMapping(value = "to_info", method = { RequestMethod.GET, RequestMethod.POST })
		public String info(UserJob userJob) {
			userJob=jobServerImpl.getJob(userJob);
			return "info_j";
		}
		
		//http://localhost:8080/ush/job/to_edit
		@RequestMapping(value = "to_edit", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView to_edit(UserJob userJob,ModelAndView modelAndView) {
			userJob=jobServerImpl.getJob(userJob);
			modelAndView.addObject("userJob",userJob);
			modelAndView.setViewName("/job/edit_j");
			return modelAndView;
		}
		
		//http://localhost:8080/ush/job/do_edit
		@RequestMapping(value = "do_edit", method = { RequestMethod.GET, RequestMethod.POST })
		public String do_edit(UserJob userJob) {
			jobServerImpl.edit(userJob);
			//list = userServerImpl.getUsers();
			return "redirect:/job/to_list";
		}
		
		//http://localhost:8080/ush/job/to_save
		@RequestMapping(value = "to_save", method = { RequestMethod.GET, RequestMethod.POST })
		public String to_save() {
			return "/job/save_j";
		}
		
		//http://localhost:8080/ush/job/do_save
		@RequestMapping(value = "do_save", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView do_save(UserJob userJob,ModelAndView modelAndView) {
			jobServerImpl.save(userJob);	
			modelAndView.addObject("save",userJob) ;
			modelAndView.setViewName("redirect:/job/to_list");
				//return modelAndView;
			return modelAndView;
		}

	
	

}
