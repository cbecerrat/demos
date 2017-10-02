package utilities;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

import beans.HelloBeanInterface;

public class Client {
    private HelloBeanInterface bean;    
	
	public static void main(String[] args) throws NamingException {
		Client client = new Client();
        System.out.println(client.sayHello()); // 4. Call business logic
    }
	
	public String sayHello(){		
		return bean.sayHello();
	}
	
	public Client(){		
		doLookup();
	}
 
    private void doLookup() {
    	Context context = null;
    	
    	Properties clientProp = new Properties();
    	clientProp.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
    	clientProp.put("remote.connections", "default");
    	clientProp.put("remote.connection.default.host", "localhost"); // comes from JVM argument
    	clientProp.put("remote.connection.default.port", "4447"); // comes from JVM argument
    	clientProp.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
    	
//    	EJBClientConfiguration cc = new PropertiesBasedEJBClientConfiguration(clientProp);
//    	ContextSelector<EJBClientContext> selector = new ConfigBasedEJBClientContextSelector(cc);
//    	EJBClientContext.setSelector(selector);
    	
    	Hashtable<String, String> jndiProperties = new Hashtable<String, String>();	
        
    	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    	jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    	jndiProperties.put(Context.PROVIDER_URL,"remote://localhost:4447");
    	jndiProperties.put("jboss.naming.client.ejb.context","false");
        try {
            // 1. Obtaining Context
            context = new InitialContext(jndiProperties);
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            bean = (HelloBeanInterface) context.lookup(lookupName);
            
            if(context != null){
            	context.close();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }        
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
//        String name = "ejb:" + appName + "/" +  moduleName + "/" + beanName  + "!" + interfaceName;
        String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
        
        System.out.println(name);
 
        return name;
    }
}
