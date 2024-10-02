import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("читаем файл");

        List<Robot> txt1 = RoutineRobot.readRobots("Input.txt");
        System.out.println(txt1);

        RoutineRobot.robotDirS("Input.txt");
        System.out.println("вывод роботов по направлениям");
        Map<Direction, Integer> robotCount = RoutineRobot.countRobotsByDirection(txt1);

        // Выводим количество роботов по направлениям
        for (Map.Entry<Direction, Integer> entry : robotCount.entrySet()) {
            System.out.println("Направление: " + entry.getKey() + ", Количество роботов: " + entry.getValue());
        }
    }
}
