import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;


public class GUI extends Application{

    private GridPane grid = new GridPane();
    private VBox rootV = new VBox();
    private HBox row1 = new HBox();
    private HBox row2 = new HBox();
    private VBox row2v1 = new VBox();
    private VBox row2v2 = new VBox();
    private HBox row3 = new HBox();
    private HBox row4 = new HBox();
    private HBox row5 = new HBox();
    private HBox row6 = new HBox();
    private HBox row7 = new HBox();
    private HBox row8 = new HBox();
    private Scene mainScene = new Scene(rootV, Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2.0,Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2.0);
    private static int iconWidth = 40;

    private Probability prob;


    private ComboBox<String> diceBox1 = new ComboBox<>();
    private ComboBox<String> diceBox2 = new ComboBox<>();
    private ComboBox<String> diceBox3 = new ComboBox<>();
    private ComboBox<String> diceBox4 = new ComboBox<>();
    private ComboBox<String> diceBox5 = new ComboBox<>();
    private ComboBox<String> diceBox6 = new ComboBox<>();

    private ComboBox<String> setBox1 = new ComboBox<>();
    private ComboBox<String> setBox2 = new ComboBox<>();
    private ComboBox<String> setBox3 = new ComboBox<>();
    private ComboBox<String> setBox4 = new ComboBox<>();
    private ComboBox<String> setBox5 = new ComboBox<>();
    private ComboBox<String> setBox6 = new ComboBox<>();

    private Button calculateButton = new Button();
    private Label rollsLabel = new Label("Number of rolls?");
    private TextField numberRolls = new TextField("");
    private Label simulationLabel = new Label("Number of simulations?");
    private TextField numberSimulations = new TextField("");
    private Label result = new Label("The probability of this roll is: ");

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        // Set up choice boxes for each die.

        diceBox1.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox1.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox1.setButtonCell(new StringImageCell());

        diceBox2.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox2.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox2.setButtonCell(new StringImageCell());

        diceBox3.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox3.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox3.setButtonCell(new StringImageCell());

        diceBox4.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox4.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox4.setButtonCell(new StringImageCell());

        diceBox5.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox5.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox5.setButtonCell(new StringImageCell());

        diceBox6.getItems().addAll("1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        diceBox6.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        diceBox6.setButtonCell(new StringImageCell());

        setBox1.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox1.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox1.setButtonCell(new StringImageCell());

        setBox2.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox2.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox2.setButtonCell(new StringImageCell());

        setBox3.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox3.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox3.setButtonCell(new StringImageCell());

        setBox4.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox4.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox4.setButtonCell(new StringImageCell());

        setBox5.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox5.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox5.setButtonCell(new StringImageCell());

        setBox6.getItems().addAll("n/a","1", "2", "3","a","h","e","w");
        //Set the cellFactory property
        setBox6.setCellFactory(listview -> new StringImageCell());
        // Set the buttonCell property
        setBox6.setButtonCell(new StringImageCell());

        // Default value setting
        diceBox1.setValue("1");
        diceBox2.setValue("2");
        diceBox3.setValue("3");
        diceBox4.setValue("a");
        diceBox5.setValue("h");
        diceBox6.setValue("e");
        setBox1.setValue("n/a");
        setBox2.setValue("n/a");
        setBox3.setValue("n/a");
        setBox4.setValue("n/a");
        setBox5.setValue("n/a");
        setBox6.setValue("n/a");
        numberRolls.setText("3");
        numberSimulations.setText("100000");


        // Event handling for calculate button
        calculateButton.setText("Calculate Probability");
        calculateButton.setOnAction(event -> rollDice());

        // Setting up UI layout
        rootV.getChildren().addAll(row1,row2, row3, row4, row5, row6, row7, row8);
        row1.getChildren().add(new Label("Please select your desired roll below. * represents any die. (eg. 3+ Attacks" +
                        " is 3 Attack and 3 *)"));

        row2.getChildren().addAll(row2v1,row2v2);
        row2v1.getChildren().addAll(simulationLabel,numberSimulations);
        row2v2.getChildren().addAll(rollsLabel,numberRolls);

        row3.getChildren().addAll(new Label("Set your desired roll."));

        row4.getChildren().addAll(diceBox1,diceBox2,diceBox3,diceBox4,diceBox5,diceBox6);

        row5.getChildren().addAll(new Label("Set your current roll. Leave blank or set N/A if you have no current roll."));

        row6.getChildren().addAll(setBox1,setBox2,setBox3,setBox4,setBox5,setBox6);

        row7.getChildren().addAll(calculateButton);
        row8.getChildren().addAll(result);

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        row4.setAlignment(Pos.CENTER);
        row5.setAlignment(Pos.CENTER);
        row6.setAlignment(Pos.CENTER);
        row7.setAlignment(Pos.CENTER);
        row8.setAlignment(Pos.CENTER);




        primaryStage.setTitle("King of Tokyo Probability Calculator");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

/*
    public void stop(){
        System.out.println(diceBox1.getValue().concat(diceBox2.getValue()).concat(diceBox3.getValue()).concat(diceBox4.getValue()).concat(diceBox5.getValue()).concat(diceBox6.getValue()));
        System.out.println(setBox1.getValue().concat(setBox2.getValue().concat(setBox3.getValue().concat(setBox4.getValue().concat(setBox5.getValue().concat(setBox6.getValue()))))));
        System.out.println(numberSimulations.getText());
        System.out.println(numberRolls.getText());

    }
*/

    private void rollDice(){
        try{
            int numberOfRolls = Integer.parseInt(numberRolls.getText());
            int numberOfSimulations = Integer.parseInt(numberSimulations.getText());
            String desiredRoll = "";
            desiredRoll = desiredRoll.concat(diceBox1.getValue()).concat(diceBox2.getValue()).concat(diceBox3.getValue()).concat(diceBox4.getValue()).concat(diceBox5.getValue()).concat(diceBox6.getValue());
            String setRoll = "";
            setRoll = setRoll.concat(setBox1.getValue().concat(setBox2.getValue().concat(setBox3.getValue().concat(setBox4.getValue().concat(setBox5.getValue().concat(setBox6.getValue()))))));
            if (desiredRoll.length()!=6 || (setRoll.length()!=6 && setRoll.length()!=18)){
                result.setText("Error in selection.");
                throw(new Exception());
            }
            if (setRoll.length()==6){
                //System.out.println("up here");
                prob = new Probability(desiredRoll,numberOfRolls,setRoll);
            }
            else {
                //System.out.println("down here");
                prob = new Probability(desiredRoll, numberOfRolls);
            }
            float value = prob.Calculate(numberOfSimulations);
            result.setText("The probability is ".concat(Float.toString(value*100)).concat("%."));
        }
        catch(Exception e){
            numberRolls.setText("");
            numberSimulations.setText("");
        }
    }
    static class StringImageCell extends ListCell<String> {

        Label label;

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setItem(null);
                setGraphic(null);
            } else {
                if(item.equals("n/a")){
                    setText("n/a");
                }
                else{
                    setText("");
                }
                //setText(item);
                ImageView image = getImageView(item);
                label = new Label("",image);
                setGraphic(label);
            }
        }

    }

    private static ImageView getImageView(String imageName) {
        ImageView imageView = null;
        switch (imageName) {
            case "1":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("1.jpg"),iconWidth,iconWidth,true,true));
                break;
            case "2":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("2.jpg"),iconWidth,iconWidth,true,true));
                break;
            case "3":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("3.jpg"),iconWidth,iconWidth,true,true));
                break;
            case "a":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("attack.jpg"),iconWidth,iconWidth,true,true));
                break;
            case "h":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("heal.jpg"),iconWidth,iconWidth,true,true));
               break;
            case "e":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("energy.jpg"),iconWidth,iconWidth,true,true));
               break;
            case "w":
                imageView = new ImageView(new Image(GUI.class.getResourceAsStream("wildcard.jpg"),iconWidth,iconWidth,true,true));
               break;
            default:
                imageName = null;
        }
        return imageView;
    }



}
