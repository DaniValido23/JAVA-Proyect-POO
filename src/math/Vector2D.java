package math;

public class Vector2D {
    private double x,y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Vector2D(){
        x = 0;
        y = 0;
    }
    public Vector2D add(Vector2D v){
        return new Vector2D(x+v.getX(),y+v.getY());
    }
    public double getMagnituded(){
        return Math.sqrt(x*x+y*y);
    }

    public Vector2D scale(double value){
        return new Vector2D(x*value,y*value);
    }

    public Vector2D normalize(){
        return new Vector2D(x/getMagnituded(),y/getMagnituded());
    }

    public void limit(double value){
        if(x>value)
            x=value;
        if(x<-value)
            x=-value;
        if(y>value)
            y=value;
        if(y<-value)
            y=-value;

    }

    public Vector2D setDireccion(double angle){
        return new Vector2D(Math.cos(angle)*getMagnituded(),Math.sin(angle)*getMagnituded());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
