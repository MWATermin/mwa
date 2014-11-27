package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import javax.naming.*;

public class calenderClient {
	
	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
	}

	private static void invokeStatelessBean() throws NamingException {
		final UserRemoteInterface CalenderInterface = doLoopup();
		System.out.println("Obtained a Quoter for invocation"); 
		Calendar cal = new GregorianCalendar(2013,1,28,13,24,56);
		Date date = new Date(cal, 30, "bla", "cok", "suking", "gangban",null);
		CalenderInterface.createDate(date);
	}

	// Looks up and returns the proxy to remote interface
	private static UserRemoteInterface doLoopup() throws NamingException{
		final Hashtable jndiProperties = new Hashtable(); 
		jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming"); 
		final Context context = new InitialContext(jndiProperties);
		// The app is typically the ear name
		final String appName = "";
		// This is the module name of the deployed EJBs on the server
		final String moduleName = "Calendar";
		final String distinctName = "";
		// The EJB name which by default is the simple class name of the bean // implementation class
		final String beanName = User.class.getSimpleName();
		// the remote view fully qualified class name
		final String viewClassName = UserRemoteInterface.class.getName(); // let's do the lookup
		String lookupName = "ejb:" + appName + "/" + moduleName + "/"
				+ distinctName + "/" + beanName + "!" + viewClassName;
		System.out.println(lookupName);
		return (UserRemoteInterface) context.lookup(lookupName);
	}
}
