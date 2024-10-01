import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("читаем файл");
        Map<Robot, String> txt1 = RoutineRobot.readRobots("Input.txt");
        System.out.println(txt1);

        RoutineRobot.robotDirS("Input.txt");

    }
}