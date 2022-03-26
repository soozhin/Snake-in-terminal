import java.util.LinkedList;

public class Snake {

    private int length;
    private int speed;
    private int movementInterval;
    private Boolean lockDirection;
    private int currentSnakeMovingDirection;
    private LinkedList<SnakeBody> snakeBody = new LinkedList<SnakeBody>();
    private final static int INITIAL_LENGTH = 5;
    private SnakeBody previousTail;
    private Boolean isWarpable = false; // canWarp || isWarpable || canWalkThroughWall
    private Boolean isRight = true;
    private Boolean isUp = false;

    public Snake() {
        this(INITIAL_LENGTH);
    }

    public Snake(int length) {
        this.length = length;
        this.speed = 100;
        this.movementInterval = 0;
        lockDirection = false;
        currentSnakeMovingDirection = 0;
        for (int i = 0; i < length; i++) {
            snakeBody.add(new SnakeBody(20 - i, 10));
        }
    }

    public void moveRight() {
        // Check if can move right
        // Remove last, push at right
        // Set current direction as right
        if (currentSnakeMovingDirection == 180) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            if (isWarpable)
                snakeBody.addFirst(new SnakeBody((headX + 1 == 39) ? 1 : headX + 1, headY));
            else
                snakeBody.addFirst(new SnakeBody(headX + 1, headY)); // Like this right? :cat_approved:
            currentSnakeMovingDirection = 0;
        }
    }

    public void moveUp() {
        // Check if can move up
        // Remove last, push at up
        // Set current direction as up
        if (currentSnakeMovingDirection == 270) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            if (isWarpable)
                snakeBody.addFirst(new SnakeBody(headX, (headY - 1 == 0) ? 18 : headY - 1));
            else
                snakeBody.addFirst(new SnakeBody(headX, headY - 1));
            currentSnakeMovingDirection = 90;
        }
    }

    public void moveLeft() {
        // Check if can move left
        // Remove last, push at left
        // Set current direction as left
        if (currentSnakeMovingDirection == 0) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            if (isWarpable)
                snakeBody.addFirst(new SnakeBody((headX - 1 == 0) ? 38 : headX - 1, headY));
            else
                snakeBody.addFirst(new SnakeBody(headX - 1, headY));
            currentSnakeMovingDirection = 180;
        }
    }

    public void moveDown() {
        // Check if can move down
        // Remove last, push at down
        // Set current direction as down
        if (currentSnakeMovingDirection == 90) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            if (isWarpable)
                snakeBody.addFirst(new SnakeBody(headX, (headY + 1 == 19) ? 1 : headY + 1));
            else
                snakeBody.addFirst(new SnakeBody(headX, headY + 1));
            currentSnakeMovingDirection = 270;
        }
    }

    public void continueMoving() {
        if (movementInterval >= 100) {
            previousTail = snakeBody.getLast();
            switch (currentSnakeMovingDirection) {
                case (0):
                    moveRight();
                    break;
                case (90):
                    moveUp();
                    break;
                case (180):
                    moveLeft();
                    break;
                case (270):
                    moveDown();
                    break;
            }
            movementInterval = 0;
            lockDirection = false;
        }
        movementInterval += speed;
    }

    /*
     * 0 = right
     * 90 = up
     * 180 = left
     * 270 = down
     */
    public void setSnakeDirection(int direction) {
        // If the input is not directly opposite of the currentSnakeMovingDirection
        if (Math.abs(direction - currentSnakeMovingDirection) != 180 && !lockDirection) {
            currentSnakeMovingDirection = direction;
            lockDirection = true;
        }
    }

    public void increaseLength() {
        int previousTailX = previousTail.getX();
        int previousTailY = previousTail.getY();
        snakeBody.add(new SnakeBody(previousTailX, previousTailY));
    }

    public void increaseSpeed() {
        // Prevent the speed to go over 100
        speed = Math.min(100, speed*=2);
        // speed *= 2;
    }

    public void decreaseSpeed() {
        // Prevent the speed to go down to 0
        speed = Math.max(1, speed /= 2);
        // speed /= 2;
    }

    public void toggleWarping() {
        isWarpable = !isWarpable;
    }

    public LinkedList<SnakeBody> getSnakeBody() {
        return snakeBody;
    }

    public void autoPilot(){
        int width = View.WIDTH - 2;
        int height = View.HEIGHT - 2;
        int x = snakeBody.peekFirst().getX();
        int y = snakeBody.peekFirst().getY();
        


        // every step
        // if x == width && y == height 
            // isUp = True
            // isRight = !isRight
        // if isUp
            // y--
            // moveup
            // if y == 1
                // isUp = !isUp
        // else if isRight
            // if y == height 
                // x++
            // else if x == width - 1
                // y++
                // isRight = !isRight
            // else
                // x++
        // else if !isRight
            // if x == 1
                // y++
                // isRight = !isRight
            // else
                // x--
        
        if (x == width && y == height){
            isUp = true;
            isRight = !isRight;
        }        
        if(isUp){
            if(y == 1){
                isUp = false;
                setSnakeDirection(180);
            }
            else
                setSnakeDirection(90);
        }
        else if(isRight){
            if(y==height){
                setSnakeDirection(0);
            }
            else if(x == width - 1){
                setSnakeDirection(270);
                isRight = !isRight;
            }
            else
                setSnakeDirection(0);
        }
        else if(!isRight){
            if(x == 1){
                isRight = !isRight;
                setSnakeDirection(270);
            }
            else{
                setSnakeDirection(180);
            }
        }
        
    }

}
