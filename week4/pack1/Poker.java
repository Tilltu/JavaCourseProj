package pack1;

public class Poker {
    public enum PKCOLOR{
        Club,Diamond,Heart,Spade;
    }
    int[] PKPoint;
    String color;

    public Poker(){
        PKPoint = new int[13];
        for(int i = 0;i < 13;i++){
            PKPoint[i] = i + 1;
        }
    }

    public String getColor(int num){
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
        return color;
    }

    public String getPoint(int num){
        String  point;
        switch (num){
            case 1:{
                point = "A";
                break;
            }
            case 10:{
                point = "10";
                break;
            }
            case 11:{
                point = "J";
                break;
            }
            case 12:{
                point = "Q";
                break;
            }
            case 13:{
                point = "K";
                break;
            }
            default:{
                char temp = (char) (num + '0');
                point     = String.valueOf(temp);
            }
        }
        return point;
    }



}
