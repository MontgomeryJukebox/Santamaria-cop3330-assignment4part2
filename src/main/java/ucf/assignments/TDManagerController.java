/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 David Santamaria
 */

package ucf.assignments;

import javafx.event.ActionEvent;

/* Our TDManagerController will be the controller for the project */
public class TDManagerController {
    // we will have methods for:

    // when an item's "done" button is clicked
    public void checkboxClickedSetDone(ActionEvent actionEvent) {
        // we will simply find the item within the group and use its setDone() method
    }

    // when the "filter only by done items" button is clicked
    public void setDisplayDoneItems(ActionEvent actionEvent) {
        // we will simply loop through all of our items and
        // store the ones that are not yet done in a temporary tdlist
        // and then displayTODOs(tdlist) the result
    }

    // when the user creates a new button
    public void createNewItem(ActionEvent actionEvent) {
        // we will create a new item instance here (ideally we would use another window for this)
        // and then we will simply addItem() to the currently selected list
    }

    // when we select a new tdlist to view
    public void selectTDList(ActionEvent actionEvent) {
        // we will have to update the viewer so that it is displaying the list that was just selected
        // it will go something like...
        // grab the list that was clicked by the button (again, using the relationship between buttons and lists)
        // and then displayTODOs(list)
    }

    // when we create a new list within our current tdgroup
    public void createNewList(ActionEvent actionEvent) {
        // ideally again, this would have its own window
        // give it a title, and optionally populate it with some items
    }

    // when we delete a tdlist from our group
    public void deleteTDList(ActionEvent actionEvent) {
        // find the tdlist being referenced by the button,
        // removeList() from it's parenting group
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
        // call importer.importFromJSON()
    }

    // when the user exports to JSON
    public void doExportToJSON(ActionEvent actionEvent) {
        // call exporter.exportToJSON()
    }
}
