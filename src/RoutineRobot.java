import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class RoutineRobot {

    // считаем файл и выводим список роботов в консоль
    public static Map<Robot, String> readRobots(String fname){
        Map<Robot, String> robotMap = new HashMap<>();
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
                robotMap.put(robot, name);
            }
        } catch (FileNotFoundException e) {
            System.out.println("что-то не так с чтением из файла");
            System.out.println(e.getMessage());
        }
        return robotMap;
    }

    // создаем отдельный список и выводим в консоль роботов направлением юг
    public static void robotDirS(String fname) {
        Map<Robot, String> robots = RoutineRobot.readRobots(fname);
        List<Robot> robotsDirSouth = new ArrayList<>();

        for (Map.Entry<Robot, String> entry : robots.entrySet()) {
            Robot robot = entry.getKey();
            if (robot.direction == Direction.SOUTH) {
                robotsDirSouth.add(robot);
            }
        }
        System.out.println("Роботы, направленные на юг:");
        for (Robot robot : robotsDirSouth) { System.out.println(robot.name + robot); }
        //System.out.println(robotsDirSouth);
    }



}
