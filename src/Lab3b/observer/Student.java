package Lab3b.observer;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Student implements Observer{
	private String name;
	private Date midterm;

	public Student(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void study(Date date){
		this.midterm = date;
		System.out.println(name + " : Doh! I have to study hard for my midterm on " + this.midterm);
	}
	
	public void party(Date date){
		this.midterm = date;
		System.out.println(name + " : Alright! I get to party since my midterm isn't until " + this.midterm);
	}

	@Override
	public void update(Observable o, Object arg) {
		if((o instanceof Prof) && ((int)arg == 1)){
			Prof p = (Prof) o;
			this.study(p.getMidterm());
		}
		else if((o instanceof Prof) && ((int)arg == 2)){
			Prof p = (Prof) o;
			this.party(p.getMidterm());
		}
		
	}
}
