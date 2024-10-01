class Robot {
    private int x = 0, y = 0;   //private - запрет на "телепортацию"
    Direction direction = Direction.NORTH;


    public Robot() {
    }        //конструктор без параметров
    //он итак есть неявно, если нет других конструкторов


    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void stepForward() {
        System.out.println("шаг вперед");
        switch (direction) {
            case Direction.NORTH: y++; break;
            case Direction.SOUTH: y--; break;
            case Direction.WEST:  x++; break;
            case Direction.EAST:  x--; break;
        }
    }

    public void turnLeft() {
        System.out.println("поворот налево");
        switch (direction) {
            case Direction.NORTH:direction = Direction.WEST; break;
            case Direction.SOUTH:direction = Direction.EAST; break;
            case Direction.WEST:direction = Direction.SOUTH; break;
            case Direction.EAST:direction = Direction.NORTH; break;
        }
    }

    public void turnRight() {
        System.out.println("поворот направо");
        switch (direction) {
            case Direction.NORTH: direction = Direction.EAST; break;
            case Direction.SOUTH: direction = Direction.WEST; break;
            case Direction.WEST: direction = Direction.NORTH; break;
            case Direction.EAST: direction = Direction.SOUTH; break;
        }
    }

    public void runProgamm(String programma){
        for (char command:  programma.toCharArray()   ) {
//            Command c = String.valueOf(command); из файла считать на вход стринг, к массиву символов а из массива символов к массиву энюмов
            switch (c){
                case Command.S: stepForward(); break;
                case Command.L:  turnLeft(); break;
                case Command.R: turnRight(); break;
                default:
                    System.out.println("неизвестная команда");
            }
        }
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
