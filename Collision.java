public class Collision {

    /*
     * Check if snake collides with object
     */
    public static Boolean checkCollision(Object objA, Object objB) {
        if (objA.getX() == objB.getX() && objA.getY() == objB.getY())
            return true;
        return false;
    }

    public static Boolean checkBodyCollision(Object obj, Snake snake) {
        for (int i = 1; i < snake.getSnakeBody().size(); i++) {
            if (checkCollision(obj, snake.getSnakeBody().get(i)))
                return true;
        }
        return false;
    }

    /*
     * Check if snake touches wall
     */
    public static Boolean isOutOfBound(Object obj) {
        return obj.getX() < 1 || obj.getX() > View.WIDTH - 2 || obj.getY() < 1 || obj.getY() > View.HEIGHT - 2;
    }

}
