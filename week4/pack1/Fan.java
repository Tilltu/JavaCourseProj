package pack1;

enum COLOR{
    RED,ORANGE,YELLOW,INDIGO,BLUE,WHITE,BLACK;
}

public class Fan {

   static final int SLOW   = 1;
   static final int MEDIUM = 2;
   static final int FAST   = 3;

   private int     speed;
   private boolean on;
   private double  radius;
   String          color;

   public Fan(){
       speed  = SLOW;
       on     = false;
       radius = 5;
       color  = COLOR.BLUE.toString();
   }
   public void setSpeed(int in_speed){
       switch (in_speed){
           case SLOW:  {
               speed = SLOW;
               break;
           }
           case MEDIUM:{
               speed = MEDIUM;
               break;
           }
           case FAST:  {
               speed = FAST;
               break;
           }
           default:{
               break;
           }
       }
   }

    public void setColor(int color) {
        switch (color){
            case 0:{
                this.color = COLOR.RED.toString();
                break;
            }
            case 1:{
                this.color = COLOR.ORANGE.toString();
                break;
            }
            case 2:{
                this.color = COLOR.YELLOW.toString();
                break;
            }
            case 3:{
                this.color = COLOR.INDIGO.toString();
                break;
            }
            case 4:{
                this.color = COLOR.BLUE.toString();
                break;
            }
            case 5:{
                this.color = COLOR.WHITE.toString();
                break;
            }
            case 6:{
                this.color = COLOR.BLACK.toString();
                break;
            }
        }
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public boolean isOn() {
        return on;
    }


    public String toString() {
       StringBuilder res = new StringBuilder();
       if(on) {
           res.append("Speed = " + speed + " Color = " + color +
                      " Radius = " + radius);
           return res.toString();
       }
       else {
           res.append("Fan Is Off! " + " Color = " + color +
                      " Radius = " + radius);
           return res.toString();
       }
    }
}
