package inf122.event_template_method;
import inf122.Calendar;
import inf122.Calendar_app;
import inf122.Main;

import java.util.Scanner;

public abstract class EventTemplate {
    public void templateSequence(Calendar_app app){
        Scanner s = new Scanner(System.in);
        printMessage();
        String calendar_name = s.next();

        Calendar got = app.checkOwnCalendar(calendar_name);
        if (null == got){
            System.out.println("Failed. You cannot access the calendar or the calendar doesn't exist.");
            Main.print_options(app);
            return;
        }

        s.nextLine();
        System.out.println("Please enter the name of event: ");
        String event_name = s.nextLine();

        if (checkAvailable(got.check_event(event_name))){
            process(got, event_name, app);
        }

        Main.print_options(app);
    }

    protected abstract void printMessage();

    protected abstract boolean checkAvailable(boolean exist);

    protected abstract void process(Calendar got, String event_name, Calendar_app app);

}
