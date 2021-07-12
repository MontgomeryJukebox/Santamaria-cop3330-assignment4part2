/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Our exporter class */
public class Exporter {
    // will need an internal gson
    private Gson gson;
    // some writer for exporting
    private Writer writer;
    // and a root directory
    private String rootDir = "";


    public Exporter(String saveDir) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        rootDir = saveDir;
    }

    // and some export list to json method
    void exportToJSON(TDList list) throws Exception {
        // we'll make sure we have the full path
        String fullPath = rootDir + "/" + list.getTitle();

        try {
            // we'll make a new writer,
            writer = Files.newBufferedWriter(Paths.get(fullPath));
            // export to json
            gson.toJson(list, writer);
            // and make sure we flush before we're done with everything
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("ExportToJSON() log:");
            ioe.printStackTrace();
            throw new Exception(); // TODO
        }
    }
}
