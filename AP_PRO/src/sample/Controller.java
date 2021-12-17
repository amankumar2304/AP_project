package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    @FXML
    private Button b1;

    @FXML
    private Button b2;
    //This is the button which will roll the die

    @FXML
    private Label l1;
    //This is the label which will show the number appearing on the die.

    @FXML
    private Dice dice;

    @FXML
    private Player player1;//Player1

    @FXML
    private Player player2;//Player2

    @FXML
    private List<Jumpers> snakes = new ArrayList<>();
    //An arrayList of all the snakes

    @FXML
    private List<Jumpers> ladders = new ArrayList<>();
    //An arrayList of all the ladders

    @FXML
    public void but1(ActionEvent event) {

    }
    @FXML
    public void but2(ActionEvent event) {

    }

    @FXML
    public void rollDie(){
        /**
         * Label l1 will show the number on the die.
         * That number will be sent
         */
        int num = dice.rollDice();
        l1.setText(String.valueOf(num));
        //this will show the number on the die.
    }

}

