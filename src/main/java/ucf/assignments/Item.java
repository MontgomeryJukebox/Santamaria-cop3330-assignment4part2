/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import java.util.Date;

/* An item */
public class Item {
    // will have a description
    private String description;
    // a "done" flag to signify it has been done
    boolean done;
    // and a due date
    Date dueDate;

    // we should be able to grab the item's description
    public String getDescription() {
        return description;
    }

    // and to be able to edit the description
    public void editDescription(String description) {
        // this item's description = description;
    }

    // we should be able to edit the due date
    public void editDueDate(Date newDate) {
        // this item's due date = newDate;
    }

    // we should be able to set it to be done
    public void setDone(boolean done) {
        // item.done = done;
    }
}
