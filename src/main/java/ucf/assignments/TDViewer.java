/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/* A TDViwer will be our viewing mechanism */
public class TDViewer extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TDManager.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.setTitle("TODO Application");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // we shouldl be able to diplay the TDGroup within TDManager
    void displayTODOs(TDList list) {
        // to display a TDGroup, we should
        // first grab
        // size = group.numberOfTDLists()
        // for i in size:
        //      make a new tdListButton = new TDListButton(list);
        //      TODO ^ make sure this keeps some link between the button and the list,
        //          not only that it keeps the name and then forgets about it
        //          we will need something to find a reference to the list when the button is clicked
        //      push_back(tdListButton) to the scrollpane
        //
        // if we have a selected TDListButton, then
        //   for each item in tdListButton.getList(), do:
        //   make new itemDisplay(item)
        //   push_back(itemDisplay) to the second scrollpane for viewing
        //   items
    }

    // and also have a little helper function for the above
    void filteredDisplayTODOs(TDList list, boolean showDone) {
        // the same as above, only with an individual list.
        // ideally this should be a helper funciton.
    }
}