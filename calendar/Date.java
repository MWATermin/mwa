package calendar;

import java.util.*;

import javax.persistence.*;

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

@Entity
public class Date {

	// Test für Hello World
	public String text;
	
	public String getText() {
		return text;
	}

	public void setText(String msg) {
		this.text = msg;
	}
	// Ende Test
	
	
	private int id;
	
	@Id
	@GeneratedValue // Sorgt dafür, das ID automatisch erzeugt wird
	public int getId() {
		return id;
	}
	
	public Calendar dateAndTime;
	public Integer duration;
	public String author;
	public String place;
	public String label;
	public String description;
	public List<String> members;
	
	public Date(){
		super();
	}
	
	public Date(Calendar dateAndTime, Integer duration,
			String author, String place, String label, String description,
			List<String> members) {
		super();
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		this.author = author;
		this.place = place;
		this.label = label;
		this.description = description;
		this.members = members;
	}
	
	
	public void setId(int newId){
		id = newId;
	}
}
