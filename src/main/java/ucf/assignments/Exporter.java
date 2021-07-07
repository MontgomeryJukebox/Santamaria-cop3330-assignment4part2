/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

/* Our exporter class */
public class Exporter {
    // will have some export group to json method
    void exportToJSON(TDGroup group) {
        // use the GSON library
        // Writer = new Writer(getResource(filepath))
        // i believe is what is needed
        // then just pack the group into a json and do
        // writer.write(), .flush();
    }

    // and some export list to json method
    void exportToJSON(TDList list) {
        // do the same above yet only for a single list
    }
}
