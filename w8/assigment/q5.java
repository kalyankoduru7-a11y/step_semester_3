import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    abstract int validityDays();
    LocalDate renewalDate(LocalDate start) { return start.plusDays(validityDays()); }
}

class BasicPlan extends Plan    { int validityDays() { return 30; } }
class StandardPlan extends Plan { int validityDays() { return 90; } }
class PremiumPlan extends Plan  { int validityDays() { return 365; } }

class Subscriber {
    private final String name;
    private final Plan plan;
    private final LocalDate start;
    Subscriber(String name, Plan plan, LocalDate start) {
        this.name = name; this.plan = plan; this.start = start;
    }
    String getName() { return name; }
    LocalDate renewalDate() { return plan.renewalDate(start); }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Plan> plans = new HashMap<>();
        plans.put("BASIC", new BasicPlan());
        plans.put("STANDARD", new StandardPlan());
        plans.put("PREMIUM", new PremiumPlan());

        int n = sc.nextInt();
        List<Subscriber> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            list.add(new Subscriber(name, plans.get(type), start));
        }

        for (Subscriber s : list) {
            System.out.println(s.getName() + ": " + s.renewalDate());
        }
    }
}
