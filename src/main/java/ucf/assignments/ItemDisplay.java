/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// our item display will handle displaying each individual item
public class ItemDisplay extends Pane {
    // it will need the necessary components
    CheckBox done;
    TextField description;
    TextField dueDateLabel;
    TextField dueDate;
    Button deleteItem;

    Item item;
    public ItemDisplay() {

    }

    // and we just populate all of the parts of the item when we instantiate it
    public ItemDisplay(Item item, TDManager manager, TDManagerController controller) {
        assert(item != null);

        // it'll need some reference to the item it represents
        this.item = item;

        this.setPrefHeight(58);
        this.setPrefWidth(1258);
        this.setStyle("-fx-background-color: gray;");

        // a delete item button
        deleteItem = new Button("Delete");
        deleteItem.setLayoutX(14);
        deleteItem.setLayoutY(14);
        deleteItem.setMnemonicParsing(false);
        deleteItem.setPrefHeight(30);
        deleteItem.setPrefWidth(100);
        deleteItem.setOnAction(deleteItem(manager, controller));
        deleteItem.setVisible(true);

        // a checkbox
        done = new CheckBox("Done");
        done.setLayoutX(132);
        done.setLayoutY(20);
        done.setSelected(item.done);
        done.setMnemonicParsing(false);
        done.setOnAction(editDone());
        done.setVisible(true);

        // a description
        description = new TextField();
        description.setLayoutX(206);
        description.setLayoutY(16);
        description.setPrefHeight(26);
        description.setPrefWidth(930);
        description.setEditable(true);
        description.setText(item.getDescription());
        description.setStyle("-fx-background-color: #00FFFF;");
        description.setOnAction(editDescription());
        description.setVisible(true);

        // a due date label
        dueDateLabel = new TextField("Due Date:");
        dueDateLabel.setLayoutX(1160);
        dueDateLabel.setLayoutY(3);
        dueDateLabel.setPrefHeight(26);
        dueDateLabel.setPrefWidth(75);
        dueDateLabel.setStyle("-fx-background-color: #00FFFF;");
        dueDateLabel.setVisible(true);

        // a due date
        dueDate = new TextField();
        dueDate.setLayoutX(1150);
        dueDate.setLayoutY(30);
        dueDate.setPrefHeight(26);
        dueDate.setPrefWidth(100);
        dueDate.setStyle("-fx-background-color: #00FFFF;");
        dueDate.setVisible(true);
        dueDate.setOnAction(editDueDate());
        dueDate.setText(new SimpleDateFormat("yyyy/MM/dd").format(item.dueDate.getTime()));
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime()));
        this.getChildren().addAll(done, description, dueDateLabel, dueDate, deleteItem);
    }

    // an event handler for when the description is changed
    public EventHandler<ActionEvent> editDescription() {
        return e -> {
            // where we just call item's -> editDescription
            item.editDescription(description.getText());
        };
    }

    // an eventhandler for when we edit the due date
    public EventHandler<ActionEvent> editDueDate() {
        return e -> {
            // where we just check if the date is valid
            if (item.checkGregorian(item.dueDate)) {
                // and change it accordingly
                item.editDueDate(Calendar.getInstance());
            }
        };
    }

    // an event handler for when we edit the completion status of the item
    public EventHandler<ActionEvent> editDone() {
        return e -> {
            // where we just do item->done = button is selected
            item.done = done.isSelected();
        };
    }

    // a delete item button for when we want to delete the item.
    public EventHandler<ActionEvent> deleteItem(TDManager manager, TDManagerController controller) {
        return e -> {
            // where we remove it from the manager and then refresh the displayed items
            manager.list.list.remove(item);
            controller.displayTODOs(manager.list);
        };
    }
}
