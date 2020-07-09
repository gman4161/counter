//Garrett Engel 7/7/2020
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class Main extends Application{
    public int healthPoints=0;
    public String playerName="Player Name";
    public void start(Stage primaryStage){
        primaryStage.setTitle("Player Health Counter");
        BorderPane borderPane=new BorderPane();

    //GridPane
        GridPane gridPane = new GridPane();
        borderPane.setCenter(gridPane);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

//Main Functionality
    //buttons
        Button plusBtn = new Button("+");
        Button minusBtn = new Button("-");
        plusBtn.resize(200,200);
        minusBtn.resize(200,200);
    //labels
        Label healthLabel = new Label("--");
        Label outOfHealthLabel = new Label("/--");
        Label playerNameLabel = new Label(playerName);
        healthLabel.setFont(Font.font(50));
        outOfHealthLabel.setFont(Font.font(50));
        playerNameLabel.setFont(Font.font(50));

        DecimalFormat decimalFormat = new DecimalFormat("00");
    //button actions

        plusBtn.setOnAction(actionEvent -> {
            healthPoints++;
            healthLabel.setText(decimalFormat.format(healthPoints));
        });
        minusBtn.setOnAction(actionEvent -> {
            healthPoints--;
            healthLabel.setText(decimalFormat.format(healthPoints));
        });
        gridPane.add(minusBtn,1,1);
        gridPane.add(healthLabel,2,1);
        gridPane.add(outOfHealthLabel,3,1);
        gridPane.add(plusBtn,4,1);
        gridPane.add(playerNameLabel,0,0);

//Menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Labels");
        menuBar.getMenus().add(menu);

        MenuItem changeName = new MenuItem("Set Player Name");
        MenuItem changeHealthTotal = new MenuItem("Set Total Health");
        MenuItem changeFontSize = new MenuItem("Change Font Size");

        menu.getItems().addAll(changeName,changeHealthTotal,changeFontSize);
        borderPane.setTop(menuBar);

//Menu Function
    //change name
        TextField nameField = new TextField();
        Button changeNameBtn = new Button("Set Name");
        changeName.setOnAction(action ->{
            gridPane.add(nameField,0,2);
            gridPane.add(changeNameBtn,0,3);

        });
        changeNameBtn.setOnAction(action ->{
            playerNameLabel.setText(nameField.getText());
            primaryStage.setTitle(nameField.getText());
            gridPane.getChildren().removeAll(nameField,changeNameBtn);
        });
    //set total health
        TextField healthField = new TextField();
        Button changeHealthBtn = new Button("Set Health");
        changeHealthTotal.setOnAction(action ->{
            gridPane.add(healthField,0,2);
            gridPane.add(changeHealthBtn,0,3);
        });
        changeHealthBtn.setOnAction(event ->{
            outOfHealthLabel.setText("/"+decimalFormat.format(Integer.parseInt(healthField.getText())));
            gridPane.getChildren().removeAll(healthField,changeHealthBtn);
        });
    //change font size
        TextField fontField = new TextField();
        Button changeFontBtn = new Button("Set Font");
        changeFontSize.setOnAction(action ->{
            gridPane.add(fontField,0,2);
            gridPane.add(changeFontBtn,0,3);
        });
        changeFontBtn.setOnAction(action ->{
            healthLabel.setFont(Font.font(Integer.parseInt(fontField.getText())));
            outOfHealthLabel.setFont(Font.font(Integer.parseInt(fontField.getText())));
            playerNameLabel.setFont(Font.font(Integer.parseInt(fontField.getText())));
            gridPane.getChildren().removeAll(fontField,changeFontBtn);
        });

        primaryStage.setScene(new Scene(borderPane,1000,700));
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }
}