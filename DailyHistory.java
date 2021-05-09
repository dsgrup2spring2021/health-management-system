/**
 * 
 * @author Atakan ALTIN
 *
 */
import java.util.Date;
import java.util.Stack;

public class DailyHistory {
	private Date date;
	private Stack<Appointment> appointments;
	
	public DailyHistory(Date date) {
		this.date=date;
		appointments=new Stack<>();
	}
	
	/**
	 * Compares local date and appointment date. If the matches returns true.
	 * @param appointment
	 * @return
	 */
	public boolean add(Appointment appointment) {
		appointments.add(appointment);
		return true;
	}
	
	public Date getDate() {
		return date;
	}
	
}
