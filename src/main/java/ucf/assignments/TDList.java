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

    public TDList() {
        list = new ArrayList<Item>();
    }

    public TDList(String title) {
        this();
        this.title = title;
    }

    // we should be able to grab the title
    public String getTitle() {
        return title;
    }
    // and rename the list
    public void rename(String title) {
        this.title = title;
    }
    // and add items to the list, appropriately
    public void addItem(Item item) {
        assert(item != null);
        list.add(item);
    }

    public void clearItems() {
        list.clear();
    }
}
