package ucf.assignments;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ItemDisplay extends Pane {
    CheckBox done;
    TextField description;
    TextField dueDateLabel;
    TextField dueDate;

    public ItemDisplay() {
    }

    public ItemDisplay(Item item) {
        assert(item != null);

        this.setPrefHeight(58);
        this.setPrefWidth(1258);
        this.setStyle("-fx-background-color: gray;");

        done = new CheckBox("Done");
        done.setLayoutX(14);
        done.setLayoutY(16);
        done.setSelected(item.done);
        done.setMnemonicParsing(false);
        done.setOnAction(TDManagerController.getCheckboxClickedSetDone());
        done.setVisible(true);

        description = new TextField();
        description.setLayoutX(85);
        description.setLayoutY(16);
        description.setPrefHeight(26);
        description.setPrefWidth(1050);
        description.setEditable(true);
        description.setText(item.getDescription());
        description.setStyle("-fx-background-color: #00FFFF;");
        description.setVisible(true);

        dueDateLabel = new TextField("Due Date:");
        dueDateLabel.setLayoutX(1160);
        dueDateLabel.setLayoutY(3);
        dueDateLabel.setPrefHeight(26);
        dueDateLabel.setPrefWidth(75);
        dueDateLabel.setStyle("-fx-background-color: #00FFFF;");
        dueDateLabel.setVisible(true);

        dueDate = new TextField("YYYY/MM/DD");
        dueDate.setLayoutX(1150);
        dueDate.setLayoutY(30);
        dueDate.setPrefHeight(26);
        dueDate.setPrefWidth(100);
        dueDate.setStyle("-fx-background-color: #00FFFF;");
        dueDate.setVisible(true);
        dueDate.setText(item.dueDate.toString());
        this.getChildren().addAll(done, description, dueDateLabel, dueDate);
    }
}
