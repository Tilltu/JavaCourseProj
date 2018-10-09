package pack1;

public class Poker {
    public enum PKCOLOR{
        Club,Diamond,Heart,Spade;
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
                color = PKCOLOR.Club.toString();
                break;
            }
            case 1:{
                color = PKCOLOR.Diamond.toString();
                break;
            }
            case 2:{
                color = PKCOLOR.Heart.toString();
                break;
            }
            case 3:{
                color = PKCOLOR.Spade.toString();
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
                point = "A";
                break;
            }
            case 9:{
                point = "10";
                break;
            }
            case 10:{
                point = "J";
                break;
            }
            case 11:{
                point = "Q";
                break;
            }
            case 12:{
                point = "K";
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
}

