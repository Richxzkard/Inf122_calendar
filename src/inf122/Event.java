package inf122;

import java.util.Date;

public class Event {
    private String event_name;
    private Date start_time;
    private Date end_time;
    private String location;
    private String description;

    public Event(String name, String location, String description, Date start, Date end){
        this.event_name = name;
        this.location = location;
        this.start_time = start;
        this.end_time = end;
        this.description = description;
    }

    public void set_location(String location){
        this.location = location;
    }

    public void set_description(String description){
        this.description = description;
    }

    public void set_start_time(Date start){
        this.start_time = start;
    }

    public void set_end_time(Date end){
        this.end_time = end;
    }

    public void set_event_name(String name){
        this.event_name = name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getLocation() {
        return location;
    }

    public String getEnd_time() {
        return end_time.toString();
    }

    public String getStart_time() {
        return start_time.toString();
    }

    public String getDescription() {
        return description;
    }
}
