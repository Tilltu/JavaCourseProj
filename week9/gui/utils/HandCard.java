package gui.utils;

public class HandCard{
    public Poker[] handcard;

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
        //System.out.print("Cards Are : \n");
        for(i = 0;i < 5;i++){
            System.out.println(handcard[i].color + " " + handcard[i].point);
        }
    }
}