public class Bullet{

    private int x; //x coordinate
    private int y; //y coordinate
    private int dy = 1;

    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveBullet(int x, int y){
        this.x += x;
        this.y += y;
    }

    public void paint(View view){
        view.put('o',x,y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean checkOutOfBound(View view){
        return x < 1 || x > view.WIDTH - 2 || y < 1 || y > view.HEIGHT - 2;
    }
}