package gui.utils;

import java.util.*;
import gui.utils.Poker;

class PokerSet{
    Poker[][] set;

    PokerSet(){
        int i, j;
        set = new Poker[6][];

        for(i = 0;i < 4;i++) {
            set[i] = new Poker[13];
            for (j = 0; j < 13; j++) {
                set[i][j] = new Poker();
            }
        }
        for(i = 4;i < 6;i++) {
            set[i] = new Poker[1];
        }
        set[4][0] = new Poker();
        set[5][0] = new Poker();

        for(i = 0;i < 6;i++) {
            if(i != 4 && i != 5) {
                for (j = 0; j < 13; j++) {
                    set[i][j].setColor(i);
                    set[i][j].setPoint(j);
                }
            } else {
                set[i][0].setColor(i);
            }

        }
    }

    Poker setSet(PokerSet pokerSet) {
        Random   random = new Random();
        Poker hand_card = new Poker();
        boolean   flag  = true;

        while(flag) {
            int   color = random.nextInt(6);
            int   point;
            if(color == 4 || color == 5) {
                point = random.nextInt(1);
            }
            else {
                point = random.nextInt(13);
            }
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





public class GetHandCard {

    public HandCard getHandCard() {
        PokerSet pokerSet = new PokerSet();
        HandCard handCard = new HandCard();


        for (int j = 0; j < 5; j++) {
            handCard.setCard(pokerSet.setSet(pokerSet), j);
        }


        return handCard;
    }
}

