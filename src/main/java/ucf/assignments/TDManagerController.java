/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/* Our TDManagerController will be the controller for the project */
public class TDManagerController {

    TDManager manager;
    HashMap<Button, Item> buttonToItem;

    @FXML
    public VBox vbox;

    @FXML
    public Button newItemButton;

    @FXML
    public Button deleteItemButton;

    @FXML
    public Pane itemDisplay;

    @FXML
    public TextField curTDListTitle;

    @FXML
    public ComboBox filter = new ComboBox(FXCollections.observableArrayList("All Options", "Only Complete", "Only Incomplete"));

    public TDManagerController() {
        manager = new TDManager();
        buttonToItem = new HashMap<Button, Item>();
        filter.getItems().add("TEST");
    }

    public void displayTODOs(TDList list) {
        vbox.getChildren().clear();
        for (Item i : list.list) {
            ItemDisplay display = new ItemDisplay(i);
            vbox.getChildren().add(display);
        }
    }

    // when the "filter only by done items" button is clicked
    public void filterItems(ActionEvent actionEvent) {
        String choice = (String) filter.getValue();
        if (choice.equals("All items")) {
            displayTODOs(manager.list);
        } else if (choice.equals("Only Complete")) {
            TDList tmp = new TDList(manager.list.getTitle());
            for (Item i : manager.list.list) {
                if (i.done) {
                    tmp.addItem(i);
                }
            }
            displayTODOs(tmp);
        } else if (choice.equals("Only Incomplete")) {
            TDList tmp = new TDList(manager.list.getTitle());
            for (Item i : manager.list.list) {
                if (!i.done) {
                    tmp.addItem(i);
                }
            }
            displayTODOs(tmp);
        }
    }

    // when the user creates a new button
    public void createNewItem(ActionEvent actionEvent) {
        Item item = new Item("Test", true, Calendar.getInstance());
        manager.list.addItem(item);
        ItemDisplay display = new ItemDisplay(item);
        vbox.getChildren().add(display);
    }

    // when we select a new tdlist to view
    public void selectTDList(ActionEvent actionEvent) {
        // we will have to update the viewer so that it is displaying the list that was just selected
        // it will go something like...
        // grab the list that was clicked by the button (again, using the relationship between buttons and lists)
        // and then displayTODOs(list)
    }

    // and when we remove an item from our currently selected list (a tad bit more work than the above methods)
    public void deleteItem(ActionEvent actionEvent) {
        // find the list that the item belongs in
        // removeItem() from its parenting list
    }

    // when the user wants to change the description for an item
    public void doChangeItemDescription(ActionEvent actionEvent) {
        // find the item that the user is clicking
        // do setDescription()
    }

    // when the user changes the due date
    public void doChangeItemDueDate(ActionEvent actionEvent) {
        // grab the item
        // setDueDate(item);
    }

    // when the user imports the todo list from a json file
    public void doImportFromJSON(ActionEvent actionEvent) {
        System.out.println("Importing!");
        String filename = JOptionPane.showInputDialog(null, "Todolist name: ");
        try {
            manager.importList(filename);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error while importing json file: " + ioe.getMessage());
        }
    }

    // when the user exports to JSON
    public void doExportToJSON(ActionEvent actionEvent) {
        System.out.println("Exporting!");
        try {
            manager.exportList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error while exporting  json file: " + e.getMessage());
        }
    }

    public static EventHandler<ActionEvent> getCheckboxClickedSetDone() {
        return e -> {
            // TODO
        };
    }

    public void getCheckboxClickedSetDone(ActionEvent actionEvent) {
        // TODO
    }

    public void renameManagerList(ActionEvent actionEvent) {
        manager.list.rename(curTDListTitle.getText());
    }
}
