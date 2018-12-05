package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button1;
    Button button2;
    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
	// Start of the Project
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Title of window
        window = primaryStage;
        primaryStage.setTitle("Library Management System");

        button1 = new Button("Books");
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(100);
        layout1.getChildren().addAll(button1);
        scene1 = new Scene(layout1,500,500);

        button2 = new Button("Search by Category");
        button1.setOnAction(e -> window.setScene(scene1));


        VBox layout2 = new VBox(100);
        layout2.getChildren().addAll(button2);
        scene2 = new Scene(layout2,500,500);

        window.setScene(scene1);
        window.setTitle("Library Management System");
        window.show();


    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource()==button1){
            System.out.println();
        }

    }


}
