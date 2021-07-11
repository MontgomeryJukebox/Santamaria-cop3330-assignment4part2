/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        gson = new GsonBuilder().setPrettyPrinting().create();
        rootDir = saveDirectory;
    }

    TDList importListFromJSON(String filepath) throws IOException {
        TDList ret;
        String fullPath = rootDir + "/" + filepath;
        reader = Files.newBufferedReader(Paths.get(fullPath));
        assert(reader != null);
        ret = gson.fromJson(reader, TDList.class);
        return ret;
    }
}
