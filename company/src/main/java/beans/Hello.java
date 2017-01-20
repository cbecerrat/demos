package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import domain.Product;
import repositories.ProductRepository;

@Controller
public class Hello {
	private int calledCounter = 0; 
	@Autowired
	ProductRepository pr;
	@RequestMapping({"/","/index"})	
	public ModelAndView index() {							
		ModelAndView model = new ModelAndView("index");		
		return model;		
	}
	
	@RequestMapping(value={"/","/index"}, params={"id"})	
	public ModelAndView index(@RequestParam(value = "id", required=false) long id) {			
		ModelAndView model = new ModelAndView("index");		
		return model;		
	}
	
	@RequestMapping("/getProduct")
	@ResponseBody
	public String sayHello(ModelAndView mav, @RequestParam(value = "id") long id) {			
		Product product = pr.findOne(id);
		if(null == product){
			product = new Product();
		}		
		return product.toString();
	}		
}
