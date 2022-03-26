import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Food extends Object {

    private static char image = 'X';
    private int upperboundX = View.WIDTH - 2; // 0-37 + 1 = 1-38
    private int upperboundY = View.HEIGHT - 2; // 0-17 + 1 = 1-18
    Random rand = new Random();
    private ArrayList<ArrayList<Point>> spawnableFoodPosition;
    private boolean remove;

    // [0,1,2,7,8,9,10]

    public Food(int x, int y) {
        super(x, y, image);
        spawnableFoodPosition = new ArrayList<>(upperboundY);
    }

    public void generateFoodPosition(Snake snake) {
        inititateSpawnableFoodPosition();
        deleteSnakePosition(snake);
        int randomY = rand.nextInt(spawnableFoodPosition.size());
        int randomX = (int) (spawnableFoodPosition.get(randomY).size() * Math.random());
        Point spawnPoint = spawnableFoodPosition.get(randomY).get(randomX);
        this.setX(spawnPoint.x);
        this.setY(spawnPoint.y);
    }

    private void inititateSpawnableFoodPosition() {
        spawnableFoodPosition = new ArrayList<>(upperboundY);
        for (int i = 0; i < View.HEIGHT - 2; i++) {
            spawnableFoodPosition.add(new ArrayList<>(upperboundX));
            for (int j = 0; j < View.WIDTH - 2; j++) {
                spawnableFoodPosition.get(i).add(new Point(j + 1, i + 1));
            }
        }
    }

    private void deleteSnakePosition(Snake snake) {
        for (Object obj : snake.getSnakeBody()) {
            int snakeX = obj.getX() - 1;
            int snakeY = obj.getY() - 1;
            spawnableFoodPosition.get(snakeY).get(snakeX).x = -1;
            spawnableFoodPosition.get(snakeY).get(snakeX).y = -1;
        }
        for (int i = 0; i < spawnableFoodPosition.size(); i++)
            for (Iterator<Point> it = spawnableFoodPosition.get(i).iterator(); it.hasNext();)
                if (it.next().x == -1)
                    it.remove();
        for (Iterator<ArrayList<Point>> it = spawnableFoodPosition.iterator(); it.hasNext();)
            if (it.next().isEmpty())
                it.remove();
    }

    public ArrayList<ArrayList<Point>> getSpawnableFoodPosition() {
        return spawnableFoodPosition;
    }

}
