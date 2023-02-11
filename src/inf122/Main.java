package inf122;

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
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name you want to put the event in:");
        String calendar_name = s.next();

//        check if the user owns the calendar
        Calendar got = app.checkOwnCalendar(calendar_name);
        if (null == got){
            System.out.println("Failed. You cannot access the calendar or the calendar doesn't exist.");
            print_options(app);
            return;
        }

        System.out.println("Please enter the name of event: ");
        String event_name = s.next();

//         check if the event already exists;
        if (got.check_event(event_name)){
            System.out.println("Failed. The event already exists in Tthe calendar.");
            print_options(app);
            return;
        }
        s.nextLine();

//        else create the event and add to calendar
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

        got.add_event(event_name, event_location, event_description, start_year, start_month, start_day, start_hour, start_minute,
                end_year, end_month, end_day, end_hour, end_minute);

        System.out.println("Event: " + event_name + " added.");
        print_options(app);

    }

    public static void removeEvent(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name you want to remove the event:");
        String calendar_name = s.next();

//        check if the user owns the calendar
        Calendar got = app.checkOwnCalendar(calendar_name);
        if (null == got){
            System.out.println("Failed. You cannot access the calendar or the calendar doesn't exist.");
            print_options(app);
            return;
        }

        s.nextLine();
        System.out.println("Please enter the name of event: ");
        String event_name = s.nextLine();

//         check if the event already exists;
        if (!got.check_event(event_name)){
            System.out.println("Failed. The event doesn't exists in the calendar.");
            print_options(app);
            return;
        }

        got.remove_event(event_name);
        System.out.println("Event removed.");

        print_options(app);
    }

    public static void updateEvent(Calendar_app app){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the calendar name you want to update:");
        String calendar_name = s.next();

//        check if the user owns the calendar
        Calendar got = app.checkOwnCalendar(calendar_name);
        if (null == got){
            System.out.println("Failed. You cannot access the calendar or name already used.");
            print_options(app);
            return;
        }

        System.out.println("Please enter the name of event: ");
        String event_name = s.next();

//         check if the event already exists;
        if (!got.check_event(event_name)){
            System.out.println("Failed. The event doesn't exists in the calendar.");
            print_options(app);
            return;
        }

        System.out.println("Please enter the field you want to change for the event: ");
        System.out.println("1 - event name");
        System.out.println("2 - event description");
        System.out.println("3 - event location");
        String option = s.next();

        s.nextLine();
        System.out.println("Please enter the field you want to change for the event: ");
        String value = s.nextLine();

        if (option.equals("1")){
            if (got.check_event(value)){
                System.out.println("Failed. The event name is being used.");
                print_options(app);
                return;
            }
        }

        got.update_event(option, value, event_name);

        print_options(app);
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

    public static void print_options(Calendar_app app){
        app.get_info();
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
        Calendar_app app = new Calendar_app();
        welcome(app);
    }
}