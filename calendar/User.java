package calendar;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;


@Stateless
public class User implements UserRemoteInterface {
	
	@PersistenceContext(unitName = "calenderPersistenceUnit")
	private EntityManager em;
	
    public User() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public Integer createDate() {
    	// Ist diese Methode Notwendig?
    	System.out.println("createDate()");
    	Calendar cal = new GregorianCalendar(2013,1,28,13,24,56);
    	Date d = new Date(cal, 30, "bla", "cok", "suking", "gangban", null);
    	em.persist(d);
		return d.getId();
    }    
    
	@Override
	public Integer createDate( Date date) {
		System.out.println("createDate(Date date)");	// Funktionsaufruf in Server-Console ausgeben
		Date d = new Date();
		d = date;
		/*d.setAuthor(date.getAuthor());
		d.setDateAndTime(date.getDateAndTime());
		d.setDescription(date.getDescription());
		d.setDuration(date.getDuration());
		d.setLabel(date.getLabel());
		d.setPlace(date.getPlace()); */
		em.persist(d);
		return d.getId();	// Return der ID des angelegten Termins
	}

	@Override
	public Integer getDateID(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteDate(Integer dateID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Date> getDates(Date date, Integer timeRange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date updateDate(Integer dateID, Date newDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Date> searchNextFreeTermin(List<String> member,
			Calendar fromDate, Calendar toDate, Integer dateLength) {
		// TODO Auto-generated method stub
		return null;
	}

}
