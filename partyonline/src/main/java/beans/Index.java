package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repositories.UserRepository;

@Controller
public class Index {
	@Autowired
	UserRepository pr;	

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();		
		model.setViewName("index");
		return model;
	}
}
