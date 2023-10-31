package _09_World_Clocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/*
 * You task is to create a java program that:
 * 1. Displays the time for multiple cities around the world on one display.
 * 2. Gives the user the ability to add a city to the display. One possible
 *    way to do this is to create a HashMap of city names and their
 *    corresponding time zones, e.g. HashMap<String, TimeZone>, then use each
 *    city's TimeZone to get the current date/time every second using a
 *    Timer object (see example code below).
 * 
 * The code below is an example of how to print out a clock for San Diego.
 * Use the ClockUtilities class to find the time zone of each city, then use
 * Calendar.getInstance to return a Calendar object to get the current time for
 * that city. Example:
 *   TimeZone timeZone = clockUtil.getTimeZoneFromCityName("San Diego, US");
 *   Calendar c = Calendar.getInstance(timeZone);
 *   System.out.println("Full date and time: " + calendar.getTime());
 * 
 * NOTE: The program may take a second or two to execute
 * 
 * Calendar class:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
 */

public class WorldClocks implements ActionListener {
    ClockUtilities clockUtil;
    Timer timer;
    TimeZone timeZone;

    JFrame frame;
    JPanel panel;
    JTextArea textArea;
    
    String city;
    String dateStr;
    String timeStr;
    
    boolean addTimes = true;
    
    HashMap<String, String> citiesData;
    ArrayList<String> cities;
    ArrayList<String> times;
    public WorldClocks() {
    	cities = new ArrayList<String>();
    	times = new ArrayList<String>();
    	citiesData = new HashMap<String, String>();
    	frame = new JFrame();
    	frame.setSize(1200, 600);
    	panel = new JPanel();
    	
    	while (addTimes) {
            clockUtil = new ClockUtilities();

            // The format for the city must be: city, country (all caps)
//            city = "Chicago, US";
            city = JOptionPane.showInputDialog("Which US City?") + ", US";
//            System.out.println(city);
            timeZone = clockUtil.getTimeZoneFromCityName(city);
            
            Calendar calendar = Calendar.getInstance(timeZone);
            String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            String dayOfWeek = calendar.getDisplayName( Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
            dateStr = dayOfWeek + " " + month + " " + calendar.get(Calendar.DAY_OF_MONTH) + " " + calendar.get(Calendar.YEAR);

            citiesData.put(city, dateStr);
            
            String addAnother = JOptionPane.showInputDialog("Would you like to add another city?");
            if (addAnother.toLowerCase().startsWith("n")) {
            	addTimes = false;
            }
    	} 

            // Sample starter program

            for (String newCity : citiesData.keySet()) {
            	System.out.println(newCity);
            	cities.add(newCity);

            }                	
            for (String time : citiesData.values()) {
            	System.out.println(time);
            	times.add(time);
            }
            System.out.println(cities.size() + " " + times.size());
            
//            for (int i = 0; i < cities.size(); i++) {
//            	textArea = new JTextArea();
//            	textArea.setText(cities.get(i) + "\n\n"+ times.get(i)+ "\n" + timeStr);
//            	
////            	System.out.println(cities.get(i) + "\n\n"+ times.get(i));
//            	
//            	panel.add(textArea);
//            	
//            }
//            
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//            frame.add(panel);
//            frame.pack();
            

    	          
            // This Timer object is set to call the actionPerformed() method every
            // 1000 milliseconds
            timer = new Timer(1000, this);
            timer.start();
    }

            


    @Override
    public void actionPerformed(ActionEvent arg0) {
        Calendar c = Calendar.getInstance(timeZone);
        String militaryTime = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
        String twelveHourTime = " [" + c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "]";
        timeStr = militaryTime + twelveHourTime;
        
//        System.out.println(timeStr);
//        textArea.setText(city + "\n" + dateStr + "\n" + timeStr);
        
        if (panel.getComponentCount() < cities.size()) {
            for (int i = 0; i < cities.size(); i++) {
            	textArea = new JTextArea();
            	textArea.setText(cities.get(i) + "\n\n"+ times.get(i)+ "\n" + timeStr);
            	
//            	System.out.println(cities.get(i) + "\n\n"+ times.get(i));
            	
            	panel.add(textArea);
            	
            }
        }
        

//        System.out.println(panel.getComponentCount());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
//        frame.pack();
    }
}
