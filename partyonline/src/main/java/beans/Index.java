package beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();		
		model.setViewName("index");
		return model;
	}
}
