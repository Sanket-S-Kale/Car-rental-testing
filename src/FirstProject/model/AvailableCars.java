package FirstProject.model;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AvailableCars {
	
	int car_id;
	String car_name;
	int capacity;
	double weekday_rate;
	double weekend_rate;
	double weekly_rate;
	double gps_rate;
	double onstar_rate;
	double sirusXM_rate;
	double amount;
	String pickupdate;
	String dropoffdate;
	String pickuptime;
	String dropofftime;
	String gps;
	String onstar;
	String siriusxp;
	String clubmember;
	public String getPickuptime() {
		return pickuptime;
	}
	public void setPickuptime(String pickuptime) {
		this.pickuptime = pickuptime;
	}
	public String getDropofftime() {
		return dropofftime;
	}
	public void setDropofftime(String dropofftime) {
		this.dropofftime = dropofftime;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getOnstar() {
		return onstar;
	}
	public void setOnstar(String onstar) {
		this.onstar = onstar;
	}
	public String getSiriusxp() {
		return siriusxp;
	}
	public void setSiriusxp(String siriusxp) {
		this.siriusxp = siriusxp;
	}
	public String getClubmember() {
		return clubmember;
	}
	public void setClubmember(String clubmember) {
		this.clubmember = clubmember;
	}
	public String getDropoffdate() {
		return dropoffdate;
	}
	public void setDropoffdate(String dropoffdate) {
		this.dropoffdate = dropoffdate;
	}
	public String getPickupdate() {
		return pickupdate;
	}
	public void setPickupdate(String pickupdate) {
		this.pickupdate = pickupdate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getWeekday_rate() {
		return weekday_rate;
	}
	public void setWeekday_rate(double weekday_rate) {
		this.weekday_rate = weekday_rate;
	}
	public double getWeekend_rate() {
		return weekend_rate;
	}
	public void setWeekend_rate(double weekend_rate) {
		this.weekend_rate = weekend_rate;
	}
	public double getWeekly_rate() {
		return weekly_rate;
	}
	public void setWeekly_rate(double weekly_rate) {
		this.weekly_rate = weekly_rate;
	}
	public double getGps_rate() {
		return gps_rate;
	}
	public void setGps_rate(double gps_rate) {
		this.gps_rate = gps_rate;
	}
	public double getOnstar_rate() {
		return onstar_rate;
	}
	public void setOnstar_rate(double onstar_rate) {
		this.onstar_rate = onstar_rate;
	}
	public double getSirusXM_rate() {
		return sirusXM_rate;
	}
	public void setSirusXM_rate(double sirusXM_rate) {
		this.sirusXM_rate = sirusXM_rate;
	}
	
	public static double payment_amount(double  Weekday_rate,double  Weekly_rate,double  gps_rate,double onstar_rate,double  sirusxm_rate,String pickupdate,String dropoffdate, String gps,String onstar, String sirusxm, String clubmember ) throws ParseException
	 {
	 	 double amount = 0;
	 	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
	 	 java.util.Date pickup_date = sdf1.parse(pickupdate);
	 	 java.util.Date dropoff_date = sdf1.parse(dropoffdate);
	 	 long diff = dropoff_date.getTime()-pickup_date.getTime();
	 	 int days=(int)(diff / (1000 * 60 * 60 * 24));
	 	 System.out.println(gps);
	 	 if(Math.abs((days/7))==0)
	 	 {
	 		 amount=(days%7)*Weekday_rate;
	 	 }
	 	 if(days/7!=0)
	 	 {
	 		int weeks=days/7;
	 		 amount=(weeks*Weekly_rate) + (days - (weeks*7))*Weekday_rate;
	 	 }
	 	 
	 	 
	 	 
	 	 if(gps!=null && gps.equals("1"))
	 	 {
	 		 amount=amount+days*gps_rate;
	 	 }
	 	 if(onstar!=null && onstar.equals("2"))
	 	 {
	 		 amount=amount+days*onstar_rate; 
	 	 }
	 	 if(sirusxm!=null&&sirusxm.equals("3"))
	 	 {
	 		 amount=amount+days*sirusxm_rate;
	 	 }
	 	 if(clubmember!=null&&clubmember.equals("4"))
	 	 {
	 		 amount=amount- (0.01*amount);
	 	 }
	 	 
	 	 amount= amount+ (0.0825*amount);

	 	amount =Double.parseDouble(new DecimalFormat("##.##").format(amount));
	 	 return amount;
	 	   
	 }
	}

	

