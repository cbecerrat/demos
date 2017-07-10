package beans;

import javax.ejb.Stateless;

@Stateless
public class HelloLocalBean implements HelloLocal{
	@Override
	public String sayHello() {
		return "Hello there!";
	}
}
