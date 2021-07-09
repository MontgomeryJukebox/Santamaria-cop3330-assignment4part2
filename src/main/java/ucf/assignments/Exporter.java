/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Our exporter class */
public class Exporter {
    private Gson gson;
    private Writer writer;
    private String rootDir = "";

    public Exporter(String saveDir) {
        gson = new Gson();
        rootDir = saveDir;
    }

    // and some export list to json method
    void exportToJSON(TDList list) throws Exception {
        try {
            writer = Files.newBufferedWriter(Paths.get(rootDir + list.getTitle()));
            gson.toJson(list, writer);
        } catch (IOException ioe) {
            writer.close();
            System.out.println("ExportToJSON() log:");
            ioe.printStackTrace();
            throw new Exception(); // TODO
        }
    }
}
