package inf122;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.Scanner;

public class Calendar_app {
    private String timezone;
    private String theme;
    private User current_user;


    private HashMap<User, ArrayList<Calendar>> Usercalendar;
    private ArrayList<User> user_list;
    private ArrayList<Calendar> calendar_list;

    private static Calendar_app app = new Calendar_app();

    public static Calendar_app get_app(){
        return app;
    }


    private Calendar_app() {
        this.Usercalendar = new HashMap<>();
        this.user_list = new ArrayList<>();
        this.calendar_list = new ArrayList<>();
    }

    public void addUser(String user_name){
        boolean add = true;

        for (User u: this.user_list){
            if (u.get_userid().equals(user_name)) {
                this.current_user = u;
                add = false;
            }
        }

        if (add) {
            User new_user = new User(user_name);
            this.Usercalendar.put(new_user, new ArrayList<>());
            this.user_list.add(new_user);

            this.current_user = new_user;
        }

    }

    public void addCalendar(String calendar_name){
        boolean inside = false;
        Calendar found = null;
        for (Calendar c: this.calendar_list){
            if (c.getCalendar_name().equals(calendar_name)){
                inside = true;
                found = c;
                break;
            }
        }


        if (!inside){
            Calendar new_calendar = new Calendar(calendar_name);
            this.calendar_list.add(new_calendar);
            this.Usercalendar.get(current_user).add(new_calendar);
        }else{
            boolean exist = false;
            for (Calendar c: this.Usercalendar.get(current_user)){
                if (c.getCalendar_name().equals(calendar_name)){
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                this.Usercalendar.get(current_user).add(found);
            }
        }
    }


    public boolean updateCalendar(String calendar_name, String new_name){
        boolean available;
        boolean inside = false;
        boolean used = false;

        Calendar found = null;
        for (Calendar c: this.Usercalendar.get(current_user)){
            if (c.getCalendar_name().equals(calendar_name)){
                inside = true;
                found = c;
                break;
            }
        }

        for (Calendar c: this.calendar_list){
            if (c.getCalendar_name().equals(new_name)){
                used = true;
                break;
            }
        }

        available = inside && !used;
        if (available){
            found.setCalendar_name(new_name);
        }

        return available;
    }

    public boolean removeCalendar(String calendar_name){
        boolean inside = false;
        Calendar found = null;

        for (Calendar c: this.Usercalendar.get(current_user)){
            if (c.getCalendar_name().equals(calendar_name)){
                inside = true;
                found = c;
            }
        }

        if (inside){
            this.Usercalendar.get(current_user).remove(found);
        }

        return inside;
    }

    public Calendar checkOwnCalendar(String calendar_name){
        Calendar res = null;

        for (Calendar c: this.Usercalendar.get(current_user)){
            if (c.getCalendar_name().equals(calendar_name)){
                res = c;
            }
        }
        return res;
    }


    public void setTimezone(String timezone){
        this.timezone = timezone;
        System.out.println("Current timezone: " + this.timezone);
    }

    public void setTheme(String theme){
        this.theme = theme;
        System.out.println("Current timezone: " + this.timezone);
    }

    public String getTheme() {
        return theme;
    }

    public String getTimezone() {
        return timezone;
    }

    public void getUsers(){
        for (User u: this.user_list){
            System.out.println(u.get_userid());
        }
    }

    public String get_current_user(){
        return this.current_user.get_userid();
    }

    public void get_info() {
        StringBuffer sb = new StringBuffer();
        sb.append("Users in system: [");
        for (User u: this.user_list){
            sb.append(u.get_userid());
            sb.append(" ");
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println();

        sb = new StringBuffer("Calendars in system: [");
        for (Calendar c: this.calendar_list){
            sb.append(c.getCalendar_name());
            sb.append(" ");
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println();

        System.out.println("Current calendars: ");
        for (User key: this.Usercalendar.keySet()){
            sb = new StringBuffer();
            sb.append(key.get_userid());
            sb.append("： [");

            for (Calendar v: this.Usercalendar.get(key)){
                sb.append(v.getCalendar_name());
                sb.append(" ");
            }
            sb.append("]");

            System.out.println(sb);
        }

        System.out.println();

        System.out.println("Event in calendars: ");
        sb = new StringBuffer();
        for (Calendar c: this.calendar_list){
            sb = new StringBuffer();
            sb.append(c.getCalendar_name());
            sb.append(": [");
            sb.append(c.get_event_info());
            sb.append("]");
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println();

    }
}
