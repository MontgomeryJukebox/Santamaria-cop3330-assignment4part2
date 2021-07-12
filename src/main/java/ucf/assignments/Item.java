/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* An item */
public class Item {
    // will have a description
    private String description;
    // a "done" flag to signify it has been done
    boolean done;
    // and a due date
    Calendar dueDate;

    public Item(String description, boolean done, Calendar dueDate) {
        this.description = description;
        this.done = done;
        this.dueDate = dueDate;
        checkGregorian(dueDate);
    }

    // our checkDate() method
    public boolean checkGregorian(Calendar calendar) {
        // will just make sure the date is a gregorian date
        return "gregory".equals(calendar.getCalendarType());
    }

    // we should be able to grab the item's description
    public String getDescription() {
        return description;
    }

    // and to be able to edit the description
    public void editDescription(String description) {
        this.description = description;
    }

    // the item's description must be between 1 and 256 characters in length
    public boolean checkDescription() {
        int size = description.length();
        return size >= 1 && size <= 256;
    }

    // we should be able to edit the due date
    public void editDueDate(Calendar newDate) {
        this.dueDate = newDate;
    }

    // we should be able to set it to be done
    public void setDone(boolean done) {
        this.done = done;
    }
}
