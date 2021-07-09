/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/* Our importer for handling TODO list imports from files */
public class Importer {
    private Gson gson;
    private Reader reader;
    private String rootDir = "";

    public Importer(String saveDirectory) {
        gson = new Gson();
        rootDir = saveDirectory;
    }

    TDList importListFromJSON(String filepath) {
        TDList ret;
        try {
            reader = Files.newBufferedReader(Paths.get(rootDir + filepath));
            ret = gson.fromJson(reader, TDList.class);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
        return ret;
    }
}
