package calendar;

import java.util.*;

/*
ID (Int) //autoincrement
Datum des Termins (Calendar)
Uhrzeit (Siehe oben)
Dauer (Int minuten)
Name des Erstellers (String)
Ort (String)
Terminname (String)
Beschreibung (String)
Teilnehmende Personen (List member)
*/
public class Date {
	public Date(Integer id, Calendar dateAndTime, Integer duration,
			String author, String place, String label, String description,
			List<String> members) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.author = author;
		this.place = place;
		this.label = label;
		this.description = description;
		this.members = members;
	}
	public Integer id;
	public Calendar dateAndTime;
	public Integer duration;
	public String author;
	public String place;
	public String label;
	public String description;
	public List<String> members;	
}
