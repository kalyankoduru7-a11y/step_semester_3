import java.util.*;
import java.util.function.Function;

abstract class Room {
    protected final double units;
    Room(double units) { this.units = units; }
    abstract String label();
    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(double u) { super(u); }
    String label() { return "SINGLE"; }
    double bill() { return units * 8; }
}

class SharedRoom extends Room {
    private final int occupants;   // extra value stored inside the object
    SharedRoom(double u, int occupants) { super(u); this.occupants = occupants; }
    String label() { return "SHARED"; }
    double bill() { return units * 6 / occupants; }
}

class AcRoom extends Room {
    AcRoom(double u) { super(u); }
    String label() { return "AC"; }
    double bill() { return units * 10 + 200; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Each creator receives the tokens of one line: [type, units, (occupants)]
        Map<String, Function<String[], Room>> factory = new HashMap<>();
        factory.put("SINGLE", t -> new SingleRoom(Double.parseDouble(t[1])));
        factory.put("SHARED", t -> new SharedRoom(Double.parseDouble(t[1]), Integer.parseInt(t[2])));
        factory.put("AC", t -> new AcRoom(Double.parseDouble(t[1])));

        int n = Integer.parseInt(sc.nextLine().trim());
        List<Room> rooms = new ArrayList<>();
        while (rooms.size() < n && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] t = line.split("\\s+");
            t[0] = t[0].toUpperCase();
            rooms.add(factory.get(t[0]).apply(t));
        }

        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(r.label() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
