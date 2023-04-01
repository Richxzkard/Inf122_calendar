package inf122.event_template_method;

import inf122.Calendar;
import inf122.Calendar_app;

public class DeleteEvent extends EventTemplate{
    @Override
    protected void printMessage() {
        System.out.println("Please enter the calendar name you want to remove the event:");
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
        got.remove_event(event_name);
        System.out.println("Event removed.");
    }
}
