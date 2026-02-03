import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    String getName() {
        return name;
    }

    LocalDate getDate() {
        return date;
    }
}

public class EventProcessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            events.add(new Event(name, date));
        }

        int month = sc.nextInt();

        // 1. Sort events chronologically
        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());

        // Print sorted event names
        sortedEvents.forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();

        // 2. Earliest event
        Event earliest = sortedEvents.get(0);
        System.out.println(earliest.getName());

        // 3. Latest event
        Event latest = sortedEvents.get(sortedEvents.size() - 1);
        System.out.println(latest.getName());

        int latestYear = latest.getDate().getYear();





         // 4. Events in given month of the latest year
         sortedEvents.stream()
        .filter(e -> e.getDate().getMonthValue() == month
                && e.getDate().getYear() == latestYear)
        .forEach(e -> System.out.print(e.getName() + " "));


        sc.close();
    }
}
