package org.ninjacrm.javautility;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class JavaUtility {

	public int getRandomNumber() {
		//Random Number
	    Random random = new Random();
	    int randomNumber=random.nextInt(10000);
	    return randomNumber;
	}
	
	public String getCurrentDate() {
		//Date
	    Date date = new Date();
	    SimpleDateFormat formatDate = new SimpleDateFormat();
	    String value = formatDate.format(date);
	    return value;
	}
	
	public String getRequiredDate() {
		//Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // choose your format
	    Calendar cal = Calendar.getInstance();  // current date
	    cal.add(Calendar.DAY_OF_MONTH, 30);     // add 30 days
	    String value = sdf.format(cal.getTime()); 
	    return value;
	}
	public String getRandomChar() {
		UUID uniqueName = UUID.randomUUID();
		String value = uniqueName.toString().replaceAll("[^a-zA-z]","");
		return value;
	}
	public String getTime() {
		
		 LocalTime time = LocalTime.now();
	     String value = time.format(DateTimeFormatter.ofPattern("HHmmss"));
	     return value;
	}

}
