package com.mickail.todolist;

import datamodel.TodoData;
import datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

        private List<TodoItem> todoItems;
        @FXML
        private ListView<TodoItem> todoListView;
        @FXML
        private TextArea itemDetailsTextArea;
        @FXML
        private Label deadlineLabel;


        public void initialize(){
//            TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
//                    LocalDate.of(2023, Month.APRIL,25));
//            TodoItem item2 = new TodoItem("Doctor's appointment", "See Dr.Smith at 123 Main street",
//                    LocalDate.of(2023, Month.MAY,23));
//            TodoItem item3 = new TodoItem("Finish design proposal for client", "I promised Mike I'd" +
//                    " email him website mockups by Friday 22nd APRIL",
//                    LocalDate.of(2023, Month.APRIL,22));
//            TodoItem item4 = new TodoItem("Pickup Doug at the train station", "Doug is arriving on " +
//                    "March on the 5:00 train",
//                    LocalDate.of(2023, Month.MARCH,23));
//            TodoItem item5 = new TodoItem("Pickup dry cleaning", "The clothes should be ready by Wednesday",
//                    LocalDate.of(2023, Month.APRIL,20));
//
//            todoItems = new ArrayList<TodoItem>();
//            todoItems.add(item1);
//            todoItems.add(item2);
//            todoItems.add(item3);
//            todoItems.add(item4);
//            todoItems.add(item5);
//
//            TodoData.getInstance().setTodoItems(todoItems);

            todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
                @Override
                public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                    if (observableValue !=null){
                        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                        itemDetailsTextArea.setText(item.getDetails());
                        DateTimeFormatter df =DateTimeFormatter.ofPattern("MMMM ,d, yyyy");
                        deadlineLabel.setText(df.format(item.getDeadLine()));
                    }
                }
            });

            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            todoListView.getSelectionModel().selectFirst();
        }

    @FXML
    public  void handleClickLisView(){
            TodoItem item = todoListView.getSelectionModel().getSelectedItem();
            itemDetailsTextArea.setText(item.getDetails());
            deadlineLabel.setText(item.getDeadLine().toString());
//            System.out.println("The selected item is "+item);
//            StringBuilder sb = new StringBuilder(item.getDetails());
//            sb.append("\n\n\n\n");
//            sb.append("Due: ");
//            sb.append(item.getDeadLine().toString());
//            itemDetailsTextArea.setText(sb.toString());

    }
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}