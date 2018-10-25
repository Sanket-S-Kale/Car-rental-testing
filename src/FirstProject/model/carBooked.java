package FirstProject.model;

public class carBooked {
	
	int reservation_id;
//	int car_id;
	String user_name;
	String car_name;
	String start_date;
	String end_date;
	String start_time;
	String end_time;
	public String getstart_date() {
		return start_date;
	}
	public void setstart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getend_date() {
		return end_date;
	}
	public void setend_date(String end_date) {
		this.end_date = end_date;
	}
	public String getstart_time() {
		return start_time;
	}
	public void setstart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getend_time() {
		return end_time;
	}
	public void setend_time(String end_time) {
		this.end_time = end_time;
	}
	public String getcar_name() {
		return car_name;
	}
	public void setcar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getuser_name() {
		return user_name;
	}
	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}
//	public int getCar_id() {
//		return car_id;
//	}
//	public void setCar_id(int car_id) {
//		this.car_id = car_id;
//	}
	public int getreservation_id() {
		return reservation_id;
	}
	public void setreservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	
}
