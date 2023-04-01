package inf122.event_template_method;

import inf122.Calendar;
import inf122.Calendar_app;
import inf122.Main;

import java.util.Scanner;

public class UpdateEvent extends EventTemplate{
    @Override
    protected void printMessage() {
        System.out.println("Please enter the calendar name you want to update:");
    }

    @Override
    protected boolean checkAvailable(boolean exist) {
        if (!exist){
            System.out.println("Failed. The event doesn't exists in the calendar.");
            return false;
        }

        return true;
    }

    @Override
    protected void process(Calendar got, String event_name, Calendar_app app) {
        Scanner s = new Scanner(System.in);

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
                return;
            }
        }

        got.update_event(option, value, event_name);
    }
}
