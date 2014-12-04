package calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.ListIterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class calenderClient {
	
	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
	}

	private static void invokeStatelessBean() throws NamingException {
		final UserRemoteInterface CalendarInterface = doLoopup();
		System.out.println("Obtained a Quoter for invocation"); 
		
		System.out.println("createQuote\n");
		/* int myid = CalenderInterface.createDate("HelloDate");
		System.out.println("CalendarID: " + myid + "\n");
		
		System.out.println("readQuote\n");
		System.out.println(CalenderInterface.readText( myid));
		*/ 
		
		
		Calendar cal = new GregorianCalendar(2013,1,28,13,24,56);
		
		Date date = new Date(cal, 30, "bla", "cok", "suking", "gangban111", null);
		//int myid = CalenderInterface.createDate();
		Integer myid = CalendarInterface.createDate( date);
		System.out.println("CalendarID1: " + myid + "\n");
		
		cal = new GregorianCalendar(2014,1,28,13,25,56);
		date = new Date(cal, 30, "bla", "cok", "suking", "gangban222", null);
		myid = CalendarInterface.createDate( date);
		System.out.println("CalendarID2: " + myid + "\n");
		
		
		//Update Date Test-Case
		Date d = new Date(cal, 30, "blab", "bad", "beer", "gangban11", "member");
		CalendarInterface.updateDate(1, d);
		System.out.println("updateDate(1, d)");
		
		
		CalendarInterface.deleteDate(2);
		
		
		// Print ArrayList<Date>
		ArrayList<Date> DateList;
		DateList = CalendarInterface.getAllDatesInDB();
		System.out.println("getAllDatesInDB()");
		
		ListIterator<Date> li = DateList.listIterator();
		System.out.println("size: " + DateList.size() + "\n");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		while( li.hasNext()) {
			Date serverDate = DateList.get( li.nextIndex());
			System.out.println( "ID: " + serverDate.getId() + "\n" + 
					"Description: " + serverDate.getDescription() + "\n" +
					"Label: " + serverDate.getLabel() + "\n" +
					"Members: " + serverDate.getMembers() + "\n" +
					"Place: " + serverDate.getPlace() + "\n" +
					"Duration: " + serverDate.getDuration() + "\n" + 
					"DateAndTime: " + dateFormat.format( serverDate.getDateAndTime().getTime()) + "\n"
					);
			
			li.next();
			
		}
		// ENDE Print ArrayList<Date>
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
