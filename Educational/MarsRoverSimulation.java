import java.util.HashSet;
import java.util.Set;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command Classes
class MoveCommand implements Command {
    private Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveForward();
    }
}

class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}

class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}
class Rover {
    private int x;
    private int y;
    private String direction;
    private Grid grid;

    private static final String[] DIRECTIONS = {"N", "E", "S", "W"};

    public Rover(int x, int y, String direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void moveForward() {
        switch (direction) {
            case "N":
                if (grid.isValidMove(x, y + 1)) {
                    y += 1;
                }
                break;
            case "E":
                if (grid.isValidMove(x + 1, y)) {
                    x += 1;
                }
                break;
            case "S":
                if (grid.isValidMove(x, y - 1)) {
                    y -= 1;
                }
                break;
            case "W":
                if (grid.isValidMove(x - 1, y)) {
                    x -= 1;
                }
                break;
        }
    }

    public void turnLeft() {
        int currentIndex = java.util.Arrays.asList(DIRECTIONS).indexOf(direction);
        direction = DIRECTIONS[(currentIndex - 1 + DIRECTIONS.length) % DIRECTIONS.length];
    }

    public void turnRight() {
        int currentIndex = java.util.Arrays.asList(DIRECTIONS).indexOf(direction);
        direction = DIRECTIONS[(currentIndex + 1) % DIRECTIONS.length];
    }

    public String getStatus() {
        return "Rover is at (" + x + ", " + y + ") facing " + direction + ".";
    }
}


class Grid {
    private int width;
    private int height;
    private Set<Obstacle> obstacles;

    public Grid(int width, int height, Set<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean isValidMove(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height && !isObstacle(x, y)) {
            return true;
        }
        return false;
    }

    private boolean isObstacle(int x, int y) {
        for (Obstacle obs : obstacles) {
            if (obs.getX() == x && obs.getY() == y) {
                return true;
            }
        }
        return false;
    }
}

class Obstacle {
    private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


public class MarsRoverSimulation {
    public static void main(String[] args) {
        // Define grid size and obstacles
        Set<Obstacle> obstacles = new HashSet<>();
        obstacles.add(new Obstacle(2, 2));
        obstacles.add(new Obstacle(3, 5));
        Grid grid = new Grid(10, 10, obstacles);

        // Create a rover starting at (0, 0) facing North
        Rover rover = new Rover(0, 0, "N", grid);

        // Define commands to be executed
        Command[] commands = {
            new MoveCommand(rover),
            new MoveCommand(rover),
            new TurnRightCommand(rover),
            new MoveCommand(rover)
        };

        // Execute each command
        for (Command command : commands) {
            command.execute();
        }

        // Print final rover status
        System.out.println(rover.getStatus());
    }
}
