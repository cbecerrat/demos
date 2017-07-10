package beans;

import javax.ejb.Remote;

@Remote
public interface HelloBeanInterface {
	public String sayHello();
}
