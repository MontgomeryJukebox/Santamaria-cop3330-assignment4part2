/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */
package ucf.assignments;

import java.util.ArrayList;

/* Our TDManager will be our data model */
public class TDManager {
    // we will have to store the group(s) of tdlist(s) currently active/imported
    TDList list;
    // we should be able to grab the current active group
    TDList getList() {
        return list;
    }
    // and all groups active
    ArrayList<TDList> getLists() {
        return null;
    }
}
