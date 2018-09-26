package pack2;

import java.util.*;
import pack1.Poker;

class HandCard{
    String[] color;
    String  [] point;

    HandCard(){
        color = new String[5];
        point = new String  [5];
    }

    public void setCard(String color, String point, int index){
        this.color[index] = color;
        this.point[index] = point;
    }

    public void printCard(){
        int i;
        System.out.print(" Cards Are : \n");
        for(i = 0;i < 5;i++){
            System.out.println(color[i] + " " + point[i]);
        }
    }
}


public class PokerTest {
    public static void main(String[] args){
        Random random = new Random();
        
        Poker poker = new Poker();
        HandCard[] handCard = new HandCard[4];
        int i;
        for(i = 0;i < 4;i++){
            handCard[i] = new HandCard();
        }
        for(i = 0;i < 4; i++){
            for(int j = 0;j < 5;j++) {
                handCard[i].setCard(poker.getColor(random.nextInt(4)),
                                    poker.getPoint(random.nextInt(13) + 1), j);
            }
        }
        for(i = 0;i < 4;i++){
            System.out.print("Player " + (i+1) + "'s");
            handCard[i].printCard();
        }


    }
}
