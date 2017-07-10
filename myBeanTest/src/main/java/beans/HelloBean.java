package beans;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloBeanInterface{
	private int counter = 0;
    public HelloBean() {
        System.out.println("==============================");
    }
    
    public String sayHello(){
    	counter = counter + 1;
    	String message = "Hello beanTest there! Counted " + counter + " calls...";
    	System.out.println(message);
    	return message;
    }
}
