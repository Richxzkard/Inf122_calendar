package inf122;

import inf122.event_template_method.AddEvent;
import inf122.event_template_method.DeleteEvent;
import inf122.event_template_method.UpdateEvent;

import java.util.Scanner;

public class Main {

    public static void welcome(Calendar_app app){
        System.out.println("Hello, welcome to Gregorian Calendar App, please enter your username.");
        Scanner s = new Scanner(System.in);
        String username = s.next();

        app.addUser(username);
        print_options(app);
    }

    public static void addCalendar(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name:");
        String calendar_name = s.next();
        app.addCalendar(calendar_name);

        print_options(app);
    }

    public static void updateCalendar(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name you want to update:");
        String calendar_name = s.next();
        System.out.println("Please enter new calendar name:");
        String new_name = s.next();

        boolean available = app.updateCalendar(calendar_name, new_name);
        if (available){
            System.out.println("Update success.");
        }
        else{
            System.out.println("Failed. You don't have access to this calendar or calendar doesn't exist.");
        }


        print_options(app);
    }

    public static void removeCalendar(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name you want to remove:");
        String calendar_name = s.next();

        boolean available = app.removeCalendar(calendar_name);
        if (available){
            System.out.println("Remove success.");
        }
        else{
            System.out.println("Failed. You don't have access to this calendar or calendar doesn't exist.");
        }

        print_options(app);
    }

    public static void addEvent(Calendar_app app){
        AddEvent add = new AddEvent();
        add.templateSequence(app);

    }

    public static void removeEvent(Calendar_app app){
        DeleteEvent del = new DeleteEvent();
        del.templateSequence(app);
    }

    public static void updateEvent(Calendar_app app){
        UpdateEvent update = new UpdateEvent();
        update.templateSequence(app);
    }


    public static void setTimeZone(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the time zone you're trying to set:");
        String timezone = s.next();
        app.setTimezone(timezone);

        print_options(app);
    }

    public static void setTheme(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the theme you're trying to set:");
        String theme = s.next();
        app.setTheme(theme);

        print_options(app);
    }


    public static void show(Calendar_app app){
        app.get_info(); // print current system information
        System.out.println("User: " + app.get_current_user() + "  Now please choose your actions:");
        System.out.println("Please enter your option number:");
        System.out.println("1 - switch user");
        System.out.println("2 - add calendar");
        System.out.println("3 - update calendar");
        System.out.println("4 - remove calendar");
        System.out.println("5 - add an event");
        System.out.println("6 - update an event");
        System.out.println("7 - remove an event");
        System.out.println("8 - set time zone");
        System.out.println("9 - set theme");
        System.out.println("q - quit");
        System.out.println();
    }

    public static void print_options(Calendar_app app){
        show(app);

        Scanner s = new Scanner(System.in);
        String option = s.next();

        if (option.equals("1")){
            welcome(app);
        } else if (option.equals("2")) {
            addCalendar(app);
        } else if (option.equals("3")) {
            updateCalendar(app);
        } else if (option.equals("4")) {
            removeCalendar(app);
        } else if (option.equals("5")) {
            addEvent(app);
        } else if (option.equals("6")) {
            updateEvent(app);
        } else if (option.equals("7")) {
            removeEvent(app);
        } else if (option.equals("8")) {
            setTimeZone(app);
        } else if (option.equals("9")) {
            setTheme(app);
        } else{
            System.out.println("Thank you for using, bye.");
        }
    }


    public static void main(String[] args) {
//        Singleton Design Pattern
        Calendar_app app = Calendar_app.get_app();
        welcome(app);
    }
}