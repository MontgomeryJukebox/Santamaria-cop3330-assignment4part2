/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import java.util.ArrayList;

/* A todo list */
public class TDList {
    // will have a title
    private String title;
    // and contain a vector of items
    ArrayList<Item> list;

    // we should be able to grab the title
    public String getTitle() {
        return "TODO LIST";
    }
    // and rename the list
    public void rename(String title) {
        // set this title to the parameter passed through
    }
    // and add items to the list, appropriately
    public void addItem(Item item) {
        // add this item to the list of items
    }
}
