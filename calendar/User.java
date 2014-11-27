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
	public Integer createDate(String text) {
		Date d = new Date();  
		d.setText(text);
		em.persist(d);
		return d.getId();
	}
    
    
    public String readText(int id) {
    	Date q = em.find(Date.class, id);
		return q.getText();
    	
    }
    
	@Override
	public Integer createDate(Date date) {
		Date d = new Date();  
		d = date;
		em.persist(d);
		return d.getId();
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
