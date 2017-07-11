package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import domain.Product;
import repositories.ProductRepository;

@Controller
public class Hello {	
	@Autowired
	ProductRepository pr;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)	
	public ModelAndView index() {
		System.out.println("Here.");
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping("/getProduct")
	@ResponseBody
	public String sayHello(ModelAndView mav, @RequestParam(value = "id") long id) {
		Product product = pr.findOne(id);
		if (null == product) {
			product = new Product();
		}
		return product.getProductAsJSON();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
}
