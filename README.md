# Santamaria-cop3330-assignment4part2
Dedicated to Rey.

## Help

### Editting A Description
When a new item appears, it's description will come up in an awful, bright blue. Changing the text in this section and hitting enter will change the description of the item.
**NOTE**
When editing an item's description, the user _must hit the enter key to register the edit_. Not hitting the enter key will cause the item to keep its previous
description, and to lost it if the list of items is refreshed (via a filtering) and changes will not show up when exporting to a file.

### Editting a Due Date
The user may edit the due date in the textfields towards the right of an item's display under "Due Date:". The application will check whether or not the given
date is a valid gregorian date, and will not store the new editted date if it is not valid.

### Adding an Item
The top left button titled "New Item" will add a new empty item to the application and to the list

### Removing an Item
Each item will come with a `Delete` button that will delete said item from the list when clicked. Do not click it by accident! As there is not yet an undo feature.

### Clearing all Items
In the top left, next to `New Item` there is a button titled `Clear All Items`. Hitting this button will clear all items from the list. Be especially careful with this
button as there is yet no undo feature implemented.

### Marking an Item as Complete/Incomplete.
All items are either complete or incomplete. To mark an item as complete simply hit the checkbox to the left of the item's display, labeled: `Done`.

### Diplaying a filter on items
Towards the top right section of the Application there is a dropdown menu with different selections for viewing either all items, completed items only, or incompleted
items only. Do with it as you please.

### Importing/Exporting to external files
Hit `File` -> `Import`/`Export` list. If exporting a list, a new json file will be created with the name of the list (in the editable textfield in the center top).
If importing a file, the name of the list must be specified.
