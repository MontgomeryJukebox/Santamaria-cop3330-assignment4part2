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
    private Gson gson;
    private Writer writer;
    private String rootDir = "";

    public Exporter(String saveDir) {
        gson = new GsonBuilder().setPrettyPrinting().create();
        rootDir = saveDir;
    }

    // and some export list to json method
    void exportToJSON(TDList list) throws Exception {
        String fullPath = rootDir + "/" + list.getTitle();
        System.out.printf("EXPORTER\n");
        System.out.printf("rootDir is %s, list title is %s. Fullpath is %s\n", rootDir, list.getTitle(), fullPath);
        try {
            writer = Files.newBufferedWriter(Paths.get(fullPath));
            gson.toJson(list, writer);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("ExportToJSON() log:");
            ioe.printStackTrace();
            throw new Exception(); // TODO
        }
    }
}
