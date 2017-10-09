package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

	@RequestMapping(value = { "/servicing/index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		System.out.println("Here.");
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping("/servicing/getProduct")
	@ResponseBody
	public String sayHello(ModelAndView mav, @RequestParam(value = "id") long id) {
		Product product = pr.findOne(id);
		if (null == product) {
			product = new Product();
		}
		return product.getProductAsJSON();
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Usuario o password inv�lido!");
		}

		if (logout != null) {
			model.addObject("msg", "Has terminado tu sesi�n.");
		}
		model.setViewName("login");
		return model;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;
	}
}
