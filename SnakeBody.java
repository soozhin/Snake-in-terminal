public class SnakeBody {
    
    private double x;  // x-coordinate
    private double y;  // y-coordinate

    public SnakeBody(double x, double y){
        this.x = x;
        this.y = y;
    }

    // Get x-coordinate
    public double getX(){
        return x;
    }

    // Get y-coordinate
    public double getY(){
        return y;
    }

    // Paint
    public void paint(View view){
        view.put('o',(int)x,(int)y);
    }

}