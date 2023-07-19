package pl.programming4you.lectures5.lecture9.Task19;

import java.util.*;
import java.util.stream.Collectors;

public class Task19 {

    public static Set<Computer> getAirplaneLegalComputers(List<Computer> computers) {
        Set<Computer> airplaneAllowedDevices = new HashSet<>();
        for (Computer computer : computers) {
            if (!(computer instanceof Laptop) || ((Laptop) computer).getBatteryCapacityWh() < 100) {
                airplaneAllowedDevices.add(computer);
            }
        }

        return airplaneAllowedDevices;
    }

    public static void main(String[] args) {
        List<Computer> computers = List.of(
                new Computer(8, 4, 3200, GraphicsCardType.DEDICATED),
                new Computer(8, 4, 3200, GraphicsCardType.DEDICATED),
                new Laptop(16, 8, 3400, GraphicsCardType.INTEGRATED, 95),
                new Laptop(16, 8, 3400, GraphicsCardType.INTEGRATED, 95),
                new Laptop(32, 16, 3800, GraphicsCardType.DEDICATED, 105));

        System.out.println(String.join("\n", getAirplaneLegalComputers(computers).stream().map(Computer::toString).collect(Collectors.toSet())));

    }
}




