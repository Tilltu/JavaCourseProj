package gui.utils;

public class Poker {
    public enum PKCOLOR{
        club,diamond,heart,spade,red_joker,black_joker;
    }
    public String color;
    int status;
    public String  point;

    public Poker(){
        status = 1; // 1 is idle, 0 is occupied
    }
    public int getStatus(){
        return this.status;
    }
    public void occupy() {
        this.status = 0;
    }

    public void setColor(int num){
        switch (num){
            case 0:{
                color = PKCOLOR.club.toString();
                break;
            }
            case 1:{
                color = PKCOLOR.diamond.toString();
                break;
            }
            case 2:{
                color = PKCOLOR.heart.toString();
                break;
            }
            case 3:{
                color = PKCOLOR.spade.toString();
                break;
            }
            case 4: {
                color = PKCOLOR.red_joker.toString();
                break;
            }
            case 5: {
                color = PKCOLOR.black_joker.toString();
                break;
            }
            default:{
                break;
            }
        }
    }

    public void setPoint(int num){
        switch (num){
            case 0:{
                point = "ace";
                break;
            }
            case 9:{
                point = "10";
                break;
            }
            case 10:{
                point = "jack";
                break;
            }
            case 11:{
                point = "queen";
                break;
            }
            case 12:{
                point = "king";
                break;
            }
            default:{
                char temp = (char) (num + '1');
                point     = String.valueOf(temp);
                break;
            }
        }
    }
    public String getColor(){
        return color;
    }
    public String getPoint(){
        return point;
    }

    @Override
    public String toString() {
        if(color.equals("red_joker") || color.equals("black_joker")) {
            return color;
        }
        return (point + "_of_" + color + "s");
    }
}

