package Lab3b.jem;

import java.util.ArrayList;

/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.List;

public class Prof {
	private String name;
	private Date midtermDate;
	private List<CourseListener> listeners;

	public Prof(String aName) {
		this.name = aName;
		listeners = new ArrayList<CourseListener>();
	}

	public String getName() {
		return this.name;
	}

	public synchronized void addCourseListener(CourseListener c) {
		listeners.add(c);
	}

	public synchronized void removeCourseListener(CourseListener c) {
		listeners.remove(c);
	}
	
	public void setMidterm(Date date) {
		midtermDate = date;
		//List<CourseListener> listeners = ((Prof)source).getListeners();
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl : listeners) {
			cl.midtermAnnounced(e);
		}
	}

	public void postponeMidterm(Date date) {
		midtermDate = date;
		//List<CourseListener> listeners = ((Prof)source).getListeners();
		CourseEvent e = new CourseEvent(this);
		for (CourseListener cl : listeners) {
			cl.midtermAnnounced(e);
		}
	}
	
	public Date getMidterm() {
		return this.midtermDate;
	}

	public List<CourseListener> getListeners() {
		return listeners;
	}

	public static void main(String[] args) {

		Prof p = new Prof("Babak");
		CourseListener s = new Student("Homer");
		CourseListener s2 = new Student("Bart");
		CourseListener ta = new TeachingAssistant("Michael");

		p.addCourseListener(s);
		p.addCourseListener(s2);
		p.addCourseListener(ta);

		Date midterm = new Date();
		CourseEvent event = new CourseEvent(p);
		p.setMidterm(midterm);
		p.postponeMidterm(new Date(midterm.getTime() + 1000000000));
	}

}
