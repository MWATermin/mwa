package calendar;

import javax.ejb.*;

@Remote
public interface UserRemoteInterface extends UserInterface {
	public Integer createDate(Date date);
}
