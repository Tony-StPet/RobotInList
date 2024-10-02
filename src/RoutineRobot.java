import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class RoutineRobot {

    // считаем файл и выводим список роботов в консоль
    public static List<Robot> readRobots(String fname){
        List<Robot> robotList = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fname));
            while (scanner.hasNext()) { // изменил фор на вайл
                String line = scanner.nextLine();
                String[] massiv = line.split("; ");
                String name = massiv[0];
                int x = Integer.parseInt(massiv[1]);
                int y = Integer.parseInt(massiv[2]);
                Direction direction = Direction.valueOf(massiv[3]);
                Robot robot = new Robot(name, x, y, direction);
                robotList.add(robot);
            }
        } catch (FileNotFoundException e) {
            System.out.println("что-то не так с чтением из файла");
            System.out.println(e.getMessage());
        }
        return robotList;
    }

    // создаем отдельный список и выводим в консоль роботов направлением юг
    public static void robotDirS(String fname) {
        // Читаем роботов из файла
        List<Robot> robots = RoutineRobot.readRobots(fname);
        List<Robot> robotsDirSouth = new ArrayList<>();

        // Ищем роботов, направленных на юг
        for (Robot robot : robots) {
            if (robot.direction == Direction.SOUTH) {
                robotsDirSouth.add(robot);
            }
        }

        // Выводим найденных роботов в консоль
        System.out.println("Роботы, направленные на юг:");
        for (Robot robot : robotsDirSouth) {
            System.out.println(robot.name); // вывод
        }
    }


    // 1. directionCount.put(...): Это метод класса Map, который добавляет пару "ключ-значение" в карту (directionCount).
    //   - Первый аргумент — это ключ: это направление робота (robot.direction).- Второй аргумент — это значение: количество роботов в данном направлении.
    // 2. directionCount.getOrDefault(robot.direction, 0):Метод getOrDefault используется для получения значения, связанного с ключом robot.direction.
    //   - Если в Map уже есть данное направление (robot.direction), то метод вернет текущее количество роботов в этом направлении.
    //   - Если направление отсутствует в карте, метод вернет значение по умолчанию= 0. Это означает, что роботов в этом направлении=0.
    // 3. + 1: После получения текущего значения (количества роботов) добавление 1, чтобы учесть текущего робота, который обрабатывается в цикле.
    //    записываем (или обновляем) это значение в Map directionCount для ключа robot.direction.

    // СЧИТАЕМ всех роботов по направлениям
    public static Map<Direction, Integer> countRobotsByDirection(List<Robot> robots) {
        Map<Direction, Integer> directionCount = new HashMap<>();
        for (Robot robot : robots) {
            directionCount.put(robot.direction, directionCount.getOrDefault(robot.direction, 0) + 1);
        }
        return directionCount;
    }

}
