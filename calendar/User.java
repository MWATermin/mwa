package calendar;

import java.util.*;
import javax.ejb.*;


@Stateless
public class User implements UserRemoteInterface {
	
    public User() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Integer createDate(Date date) {
		// TODO Auto-generated method stub
		return null;
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
