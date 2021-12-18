package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.w3c.dom.html.HTMLLabelElement;

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
    @FXML Label playerTurn;
    //this is the label which will read "Player 1 moves" or "Player 0 moves".
    @FXML Label gameStatus;
    //this is the label which will show the game status after every turn it will also show the name of the winner in the end.
    @FXML
    private Dice dice;
    @FXML
    private Player player1;//Player1
    @FXML
    private Player player2;//Player2
    @FXML
    private int[][] snakes = {{99,80},{95,75},{92,88},{74,53},{62,19},{64,60},{46,25},{49,11},{16,6}};
    //A list of all the snakes
    @FXML
    private int[][] ladders = { {2,38},{7,14},{8,31},{15,26},{21,42},{36,44},{51,67},{71,91},{78,98},{87,94}};
    //A list of all the ladders

    @FXML
    public void but1(ActionEvent event) {

    }
    @FXML
    public void but2(ActionEvent event) {

    }

    private int iterator = 0;
    @FXML
    public void rollDie(ActionEvent event){
        /**
         * Label l1 will show the number on the die.
         * That number will be sent from here.
         */
        int num = dice.rollDice();
        l1.setText(String.valueOf(num));
        //this will show the number on the die.
        //This will check if it is the turn of the first player or the second player to move.
        int toMove = -1;
        if(iterator%2==0){
            playerTurn.setText("Player 0 moves.");
            toMove = 0;
        }
        else{
            playerTurn.setText("Player 1 moves.");
            toMove = 1;
        }
        movePlayer(toMove,num);
        iterator++;
    }
    private int player1Pos = 0;
    private int player2Pos = 0;
    public void movePlayer(int id,int diceNum){
        if(id==0){
            //Algorithm to move player 0
            int temp = player1Pos+ diceNum;
            /**
             * Cases:-
             * He might have landed on a snake
             * He might have landed on a ladder bottom
             * He might be on a normal block
             * He might be on the 100th block
             * He might have gone beyond the 100th block
             */
            if(temp>100){
                gameStatus.setText("CANNOT GO OVER 100 BRO!!");
                temp = player1Pos;
            }
            if(temp == 100){
                gameStatus.setText("GAME OVER. PLAYER 0 WINS. CONGRATS BRO!!");
            }
            for(int[] item : snakes){
                if(temp == item[0]){
                    gameStatus.setText("BITTEN BY A SNAKE AT POSITION "+item[0]+" WILL GO TO "+item[1]);
                    temp = item[1];
                }
            }
            for(int[] item : ladders){
                if(temp == item[0]){
                    gameStatus.setText("CAN CLIMB A LADDER FROM POSITION "+item[0]+" WILL GO TO "+item[1]);
                    temp = item[1];
                }
            }
            gameStatus.setText(temp +" IS JUST A NORMAL BLOCK. BORING!!");
            player1Pos = temp;
        }
        if(id==1){
            int temp = player2Pos+ diceNum;
            //Algorithm to move player 1
            if(temp>100){
                gameStatus.setText("CANNOT GO OVER 100 BRO!!");
                temp = player2Pos;
            }
            if(temp == 100){
                gameStatus.setText("GAME OVER. PLAYER 1 WINS. CONGRATS BRO!!");
            }
            for(int[] item : snakes){
                if(temp == item[0]){
                    gameStatus.setText("BITTEN BY A SNAKE AT POSITION "+item[0]+" WILL GO TO "+item[1]);
                    temp = item[1];
                }
            }
            for(int[] item : ladders){
                if(temp == item[0]){
                    gameStatus.setText("CAN CLIMB A LADDER FROM POSITION "+item[0]+" WILL GO TO "+item[1]);
                    temp = item[1];
                }
            }
            gameStatus.setText(temp +" IS JUST A NORMAL BLOCK. BORING!!");
            player2Pos = temp;
        }
    }
    //The Code for the movement of Player Tokens is still to be written

}

/**
 * SNAKES:
 * 99,80
 * 95,75
 * 92,88
 * 74,53
 * 62,19
 * 64,60
 * 46,25
 * 49,11
 * 16,6

 * LADDERS:
 * 2,38
 * 7,14
 * 8,31
 * 15,26
 * 21,42
 * 36,44
 * 51,67
 * 71,91
 * 78,98
 * 87,94

 */