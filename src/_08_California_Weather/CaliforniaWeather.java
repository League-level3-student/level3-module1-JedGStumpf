package _08_California_Weather;

import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather {
    
    void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
//        String cityName = Utilities.capitalizeWords( "Encinitas" );
//        String cityName = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter a City"));
//        String condition = Utilities.capitalizeWords(JOptionPane.showInputDialog("Enter a Condition"));
        		
//        WeatherData datum = weatherData.get(condition);
//        Iterable<String> datum = weatherData.keySet();
//        for (String data : datum) {
//        	System.out.println(data);
//        }
        System.out.println("K"+weatherData.keySet());
        System.out.println("S" + weatherData.values().size());
        
//        for (Integer i = 0; i < weatherData.values().size(); i++) {
//        	System.out.println(weatherData.get("Clear"));
//        }
        int x = 0;
        for (WeatherData s : weatherData.values()) {
//        	System.out.println(s.weatherSummary);

        	if (s.weatherSummary.equals("Clear")) {
        		System.out.println(s.weatherSummary);
//        		System.out.println(weatherData.get(s.temperatureF));
        		System.out.println(s.temperatureF);
        		System.out.println(weatherData);

        	}

        }
//		for (String c : weatherData.keySet()) {
//			System.out.println("C" + weatherData.get(s));
//		}
//        System.out.println(datum);
//        Integer x = 0;
//        for (String i : weatherData.keySet()) {
//        	System.out.println(weatherData.keySet());
//        }
//        if( datum == null ) {
//            System.out.println("Unable to find weather data for: " + cityName);
//        	System.out.println("Unable to find weather data for: " + condition);
//        } else {
//            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
//        	System.out.println(condition + " is " + datum.weatherSummary);
//        }
    }
}
