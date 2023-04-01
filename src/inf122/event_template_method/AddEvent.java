package inf122.event_template_method;

import inf122.Calendar;
import inf122.Calendar_app;
import inf122.Main;

import java.util.Date;
import java.util.Scanner;

public class AddEvent extends EventTemplate {

    @Override
    protected void printMessage() {
        System.out.println("Please enter the calendar name you want to put the event in:");
    }

    @Override
    protected boolean checkAvailable(boolean exist) {
        if (exist){
            System.out.println("Failed. The event already exists in the calendar.");
            return false;
        }
        return true;
    }

    @Override
    protected void process(Calendar got, String event_name, Calendar_app app) {
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the event description: ");
        String event_description = s.nextLine();
        System.out.println("Please enter the event location: ");
        String event_location = s.nextLine();


        System.out.println("Please enter the start year of event:");
        Integer start_year = Integer.valueOf(s.next());
        System.out.println("Please enter the start month of event:");
        Integer start_month = Integer.valueOf(s.next());
        System.out.println("Please enter the start day of event:");
        Integer start_day = Integer.valueOf(s.next());
        System.out.println("Please enter the start hour of event:");
        Integer start_hour = Integer.valueOf(s.next());
        System.out.println("Please enter the start minute of event:");
        Integer start_minute = Integer.valueOf(s.next());

        System.out.println("Please enter the end year of event:");
        Integer end_year = Integer.valueOf(s.next());
        System.out.println("Please enter the end month of event:");
        Integer end_month = Integer.valueOf(s.next());
        System.out.println("Please enter the end day of event:");
        Integer end_day = Integer.valueOf(s.next());
        System.out.println("Please enter the end hour of event:");
        Integer end_hour = Integer.valueOf(s.next());
        System.out.println("Please enter the end minute of event:");
        Integer end_minute = Integer.valueOf(s.next());

        Date start = new Date(start_year, start_month, start_day, start_hour, start_minute);
        Date end = new Date(end_year, end_month, end_day, end_hour, end_minute);

        got.add_event(event_name, event_location, event_description, start, end);

        System.out.println("Event: " + event_name + " added.");
    }
}
