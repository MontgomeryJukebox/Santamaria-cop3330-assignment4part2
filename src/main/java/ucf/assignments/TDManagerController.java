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
import java.util.*;

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
    public Button clearItems;

    @FXML
    public ComboBox filter = new ComboBox(FXCollections.observableArrayList("All Options", "Only Complete", "Only Incomplete"));

    public TDManagerController() {
        manager = new TDManager();
        buttonToItem = new HashMap<Button, Item>();
        filter.getItems().add("TEST");
    }

    public void displayTODOs(TDList list) {
        vbox.getChildren().clear();
        Collections.sort(list.list, new Comparator<Item>(){
            public int compare(Item p1, Item p2) {
                return p1.getDescription().compareTo(p2.getDescription());
            }
        });
        for (Item i : list.list) {
            ItemDisplay display = new ItemDisplay(i, manager, this);
            vbox.getChildren().add(display);
        }
    }

    // when the "filter only by done items" button is clicked
    public void filterItems(ActionEvent actionEvent) {
        String choice = (String) filter.getValue();
        if (choice.equals("All Items")) {
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
        ItemDisplay display = new ItemDisplay(item, manager, this);
        vbox.getChildren().add(display);
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
        curTDListTitle.setText(manager.list.getTitle());
        displayTODOs(manager.list);
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

    public void renameManagerList(ActionEvent actionEvent) {
        manager.list.rename(curTDListTitle.getText());
    }

    public void deleteItem(ActionEvent actionEvent) {
        System.out.println("Test!");
    }

    public void clearItems(ActionEvent actionEvent) {
        manager.clearItems();
        displayTODOs(manager.list);
    }
}
