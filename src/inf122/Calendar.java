package inf122;

import java.util.ArrayList;
import java.util.Date;

public class Calendar {
    private ArrayList<Event> event_list;
    private String calendar_name;


    public Calendar(String name){
        this.calendar_name = name;
        this.event_list = new ArrayList<>();
    }

    public String getCalendar_name(){
        return this.calendar_name;
    }

    public void setCalendar_name(String name){
        this.calendar_name = name;
    }

    public boolean check_event(String name){
        boolean res = false;

        for (Event e: this.event_list){
            if (e.getEvent_name().equals(name)){
                res = true;
            }
        }
        return res;
    }

    public void add_event(String name, String location, String description, Integer start_year, Integer start_month,
                          Integer start_day, Integer start_hour, Integer start_minute, Integer end_year, Integer end_month,
                          Integer end_day, Integer end_hour, Integer end_minute){
        Date start = new Date(start_year, start_month, start_day, start_hour, start_minute);
        Date end = new Date(end_year, end_month, end_day, end_hour, end_minute);

        Event new_event = new Event(name, location, description, start, end);
        this.event_list.add(new_event);
        System.out.println();
        System.out.println("Event added");
        System.out.println("Event name: " + new_event.getEvent_name());
        System.out.println("Event location: " + new_event.getLocation());
        System.out.println("Event description: " + new_event.getDescription());
        System.out.println("Event start: " + new_event.getStart_time());
        System.out.println("Event end: " + new_event.getEnd_time());
        System.out.println();
    }

    public void remove_event(String event_name){
        Event found = null;
        for (Event e: this.event_list){
            if (e.getEvent_name().equals(event_name)){
                found = e;
                break;
            }
        }
        this.event_list.remove(found);
    }

    public void update_event(String option, String value, String event_name){
        Event found = null;
        for (Event e: this.event_list){
            if (e.getEvent_name().equals(event_name)){
                found = e;
                break;
            }
        }

        if (option.equals("1")){
            assert found != null;
            found.set_event_name(value);
        } else if (option.equals("2")) {
            assert found != null;
            found.set_description(value);
        } else if (option.equals("3")) {
            assert found != null;
            found.set_location(value);
        }

        System.out.println();
        System.out.println("Event updated");
        System.out.println("Event name: " + found.getEvent_name());
        System.out.println("Event location: " + found.getLocation());
        System.out.println("Event description: " + found.getDescription());
        System.out.println("Event start: " + found.getStart_time());
        System.out.println("Event end: " + found.getEnd_time());
        System.out.println();
    }

    public String get_event_info(){
        StringBuffer sb = new StringBuffer();
        for (Event e: event_list){
            sb.append(e.getEvent_name());
            sb.append(" ");
        }
        return sb.toString();
    }

}
