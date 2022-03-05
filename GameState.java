import java.util.LinkedList;

public class GameState implements State{
    
    public View view;
    public Bullet bullet;

    public GameState(View view){
        this.view = view;
        bullet = new Bullet(20,10);
    }

    public State processTimeElapsed(){
        if(bullet.checkOutOfBound(view))
            return new GameState(view);
        return this;
    }

    public State processKeyTyped(String event){
        switch(event){
            case ("UP"):
                bullet.moveBullet(0,-1);
                break;
            case ("DOWN"):
                bullet.moveBullet(0,1);
                break;
            case ("LEFT"):
                bullet.moveBullet(-1,0);
                break;
            case ("RIGHT"):
                bullet.moveBullet(1,0);
                break;
        }
        if(event.equals(""))
            return new PauseState(view,this);
        return this;
    }

    public void paint(View view){
        bullet.paint(view);
        String coordinate = bullet.getX() + ", " + bullet.getY() + ", " + bullet.checkOutOfBound(view);
        view.putString(coordinate,0,0);
    }

}