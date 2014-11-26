package calendar;

import java.util.*;

/*
//return = terminID
int createTermin(Termin termin)  statefull
kreiert  den Termin samt User durch aufruf der Stateless (siehe unten)
int createTermin(Termin termin, User user) stateless
kreiert den Termin

//return = terminID
int getTerminID(Termin termin)

Boolean deleteTermin(Int terminID)   statefull 
Boolean deleteTermin(Int terminID, User user)   stateless

//return = Liste aller Termine
//timeRange in Tage - 0 = heute, 1 = heute und morgen ...
List getTermine(Termin termin, Int timeRange) statefull
List getTermine(Termin termin, Int timeRange, User user) stateless

//return = aktuellen Wert für termin
Termin updateTermin(int terminID, Termin newTermin)

//return = Liste von Termin
List searchNextFreeTermin(List member, Date fromDate, Date toDate, int terminLength) 
*/
public interface UserInterface {
	Integer createDate(Date date);
	Integer getDateID(Date date);
	Boolean deleteDate(Integer dateID);
	List<Date> getDates(Date date, Integer timeRange);
	Date updateDate(Integer dateID, Date newDate);
	List<Date> searchNextFreeTermin(List<String> member, java.util.Calendar fromDate, java.util.Calendar toDate, Integer dateLength);
}
