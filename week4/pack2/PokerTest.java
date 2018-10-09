package pack2;

import java.util.*;
import pack1.Poker;

class PokerSet{
    Poker[][] set;

    PokerSet(){
        int i, j;
        set = new Poker[4][];
        /*for(i = 0;i < 4;i++) {
            set[i] = new Poker[13];
        }*/
        for(i = 0;i < 4;i++) {
            set[i] = new Poker[13];
            for (j = 0; j < 13; j++) {
                set[i][j] = new Poker();
            }
        }
        for(i = 0;i < 4;i++) {
            for(j = 0;j < 13;j++) {
                set[i][j].setColor(i);
                set[i][j].setPoint(j);
            }
        }
    }

    Poker setSet(PokerSet pokerSet) {
        Random   random = new Random();
        Poker hand_card = new Poker();
        boolean   flag  = true;

        while(flag) {
            int   color = random.nextInt(4);
            int   point = random.nextInt(13);
            if(pokerSet.set[color][point].getStatus() != 0) {
                pokerSet.set[color][point].occupy();
                hand_card.setColor(color);
                hand_card.setPoint(point);
                hand_card.occupy();
                flag    = false;
            }
        }

        return hand_card;
    }

}


class HandCard{
    Poker[] handcard;

    HandCard(){
        handcard = new Poker[5];
        for(int i = 0;i < 5;i++) {
            handcard[i] = new Poker();
        }
    }

    public void setCard(String color, String point, int index){
        this.handcard[index].color = color;
        this.handcard[index].point = point;
    }
    public void setCard(Poker card, int index) {
        handcard[index] = card;
    }

    public void printCard(){
        int i;
        System.out.print(" Cards Are : \n");
        for(i = 0;i < 5;i++){
            System.out.println(handcard[i].color + " " + handcard[i].point);
        }
    }
}


public class PokerTest {
    public static void main(String[] args){
        PokerSet pokerSet = new PokerSet();
        HandCard[] handCard = new HandCard[4];
        int i;

        for(i = 0;i < 4;i++){
            handCard[i] = new HandCard();
        }
        for(i = 0;i < 4; i++){
            for(int j = 0;j < 5;j++) {
                handCard[i].setCard(pokerSet.setSet(pokerSet), j);
            }
        }
        for(i = 0;i < 4;i++){
            System.out.print("Player " + (i + 1) + "'s");
            handCard[i].printCard();
        }


    }
}

