package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.Random;
public class Controller {
    @FXML
    private Label l1;
    @FXML
    public Label l2;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private ImageView dice;
    @FXML
    public void but1(ActionEvent event) {
        game=true;
        this.l1.setText(String.valueOf(game));
    }
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

    public boolean game=false;
    public int pla=0;//This will calculate the number of times we have player the game. Rolled the die
    @FXML Label gameStatus;
    //A label to show the Game Status at a particular time.

    int i=0;
    int[][] ar=new int[100][2];

    @FXML
    public void but2(ActionEvent event) {
        pla++;
        Image img = null;
        Random rand = new Random();
        int result = rand.nextInt(6);
        int num = result+1;//This will be a number somewhere between [1,6].
        l1.setText(String.valueOf(num));//this will show the number on the die.
        int toMove = 0;
        if(num==1){
            img=new Image(getClass().getResourceAsStream("no1.png"));
        }
        if(num==2){
            img=new Image(getClass().getResourceAsStream("no2.png"));
        }
        if(num==3){
            img=new Image(getClass().getResourceAsStream("no3.png"));
        }
        if(num==4){
            img=new Image(getClass().getResourceAsStream("no4.png"));
        }
        if(num==5){
            img=new Image(getClass().getResourceAsStream("no5.png"));
        }
        if(num==6){
            img=new Image(getClass().getResourceAsStream("no6.png"));
        }
        dice.setImage(img);
        if(pla%2!=0){

            this.l1.setText("PLAYER-1 GOT "+ num);
//            pla++;
        }
        if(pla%2==0){
            this.l1.setText("PLAYER-2 GOT "+ num);
//            pla++;
        }

        //This will make the player token move.
        movePlayer(toMove,num);

    }
    private int player1Pos = 0;
    private int player2Pos = 0;
    public void movePlayer(int id,int diceNum){
        /**
         * Cases:-
         * He might have landed on a snake
         * He might have landed on a ladder bottom
         * He might be on a normal block
         * He might be on the 100th block
         * He might have gone beyond the 100th block
         */
        //Algorithm to move player 1
        if(id==1){
            int temp = player1Pos+ diceNum;
            if(temp>100){
                gameStatus.setText("CANNOT GO OVER 100 BRO!!");
                temp = player1Pos;
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
            player1Pos = temp;
        }
        //Algorithm to move player 2
        if(id==2){
            //Algorithm to move player 0
            int temp = player2Pos+ diceNum;
            if(temp>100){
                gameStatus.setText("CANNOT GO OVER 100 BRO!!");
                temp = player2Pos;
            }
            if(temp == 100){
                gameStatus.setText("GAME OVER. PLAYER 2 WINS. CONGRATS BRO!!");
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

    public void clk1(MouseEvent mouseEvent) {
        l2.setText("X:"+String.valueOf(mouseEvent.getSceneX()+" Y:"+String.valueOf(mouseEvent.getSceneY())));
        ar[i][0]= (int) mouseEvent.getSceneX();
        ar[i][1]= (int) mouseEvent.getSceneY();
        System.out.println(Arrays.deepToString(ar));
        i++;
    }
    public void rollDie(MouseEvent mouseEvent) {

    }
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
