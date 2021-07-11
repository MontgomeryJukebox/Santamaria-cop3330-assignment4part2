/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */
package ucf.assignments;

import java.io.IOException;
import java.util.ArrayList;

/* Our TDManager will be our data model */
public class TDManager {
    // we will have to store the group(s) of tdlist(s) currently active/imported
    TDList list;
    Importer importer;
    Exporter exporter;
    String rootDir = "TestIO";

    public TDManager() {
        list = new TDList();
        importer = new Importer(rootDir);
        exporter = new Exporter(rootDir);
    }
    // we should be able to grab the current active list
    TDList getList() {
        return list;
    }

    TDList getFilteredList() {
        TDList ret = new TDList();
        ret.rename(list.getTitle());
        for (Item i : list.list) {
            if (i.done) {
                ret.addItem(i);
            }
        }
        return ret;
    }

    void importList(String filename) throws IOException {
        list = importer.importListFromJSON(filename);
    }

    void exportList() throws Exception {
        exporter.exportToJSON(list);
    }

    void setList(TDList list) {
        this.list = list;
    }

    void clearItems() {
        list.clearItems();
    }
}
