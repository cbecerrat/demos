package utilities;
import javax.naming.Context;
import javax.naming.NamingException;

import beans.HelloBeanInterface;

public class Client {	
    private HelloBeanInterface bean;
	
	public static void main(String[] args) {
		Client client = new Client();
        System.out.println(client.sayHello()); // 4. Call business logic
    }
	
	public String sayHello(){
		return bean.sayHello();
	}
	
	public Client(){
		this.bean = doLookup();
	}
 
    private static HelloBeanInterface doLookup() {
        Context context = null;
        HelloBeanInterface bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            bean = (HelloBeanInterface) context.lookup(lookupName);
            context.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }    

	private static String getLookupName() {
        /*
         * The app name is the EAR name of the deployed EJB without .ear suffix.
         * Since we haven't deployed the application as a .ear, the app name for
         * us will be an empty string
         */
        String appName = "";
 
        /*
         * The module name is the JAR name of the deployed EJB without the .jar
         * suffix.
         */
        String moduleName = "myBeanTest";
 
        /*
         * AS7 allows each deployment to have an (optional) distinct name. This
         * can be an empty string if distinct name is not specified.
         */
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName = "HelloBean";
 
        // Fully qualified remote interface name
        final String interfaceName = "beans.HelloBeanInterface";
 
        // Create a look up string name
        String name = "ejb:" + appName + "/" +  moduleName + "/" + beanName  + "!" + interfaceName;
        
        System.out.println(name);
 
        return name;
    }
}
