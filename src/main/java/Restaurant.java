import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    // List for Reservations / Tables (Add Person to table)
    public static Map<Table, Person> tables = new HashMap<Table, Person>();
    public static Person nobody = new Person("");
    public static Table table1 = new Table(1);
    public static Table table2 = new Table(2);
    
    // Queue for Waitlist
    public static Queue<Person> waitList = new LinkedList<Person>();
    
    public static void checkIn(Person guest) {
        // Prior to this, create a new person
        // for loop to see if tables contains nobody, then 
        // replace that table with new guest
        // for (Person person: tables.values()) {
        if(tables.isEmpty()) {
            createTables();
        }

        if(tables.containsValue(nobody)) {
            // Table emptyTable = tables.keySet().stream().findFirst().get();
            // Stream<String> keyStream1 = keys(capitalCountryMap, "South Africa");
            // String capital = keyStream1.findFirst().get();

            // Stream<String> keyStream2 = keys(capitalCountryMap, "South Africa");
            // Set<String> capitals = keyStream2.collect(Collectors.toSet());
            if(tables.get(table1).equals(nobody)) {
                tables.replace(table1, guest);
                tables.values();
                Main.log("I've got them checked into Table 1! Happy dining!");
            } else if(tables.get(table2).equals(nobody)) {
                tables.replace(table1, nobody, guest);
                Main.log("I've got them checked into Table 2! Happy dining!");
            }
        } else {
            Main.log("Sorry! Our tables are full at the moment. \nWe will put you on the waitlist and you will get the next available table according to where you are in the line. \nThank you!");
            waitList.add(guest);
            Main.log("You have been added!");
        }

        // map.values().stream()
        // .filter(e -> e.message.equalsIgnoreCase(searchValue))
        // .findFirst()
        // .get();
        // for (Map.Entry<Table, Person> table: tables.entrySet()) {
        //     if(table.getValue().equals(nobody)) {
        //     table.setValue(guest);
        //         Main.log("I've got them checked in! Happy dining!");

        // }
    }

    public static void checkOut(String name) {
        for (Map.Entry<Table, Person> t: tables.entrySet()) {
            if(t.getValue().equals(name)) {
                tables.remove(t);
                if(!waitList.isEmpty()) {
                    Person nextGuest = waitList.remove();
                    t.setValue(nextGuest);
                }
            } else {
                Main.log("Sorry! We cannot find that reservation at the moment.");
            }
        }
    }

    public static void createTables() {
        tables.clear();
        tables.put(table1, nobody);
        tables.put(table2, nobody);
        Main.log("\nTables created! \n");
    }

    public static void viewTables() {
        Main.log("\nHere are all of our current tables:");
        for (Map.Entry<Table, Person> tableEntry: tables.entrySet()) {
            Main.log("\n" + tableEntry.getKey() + ": " + tableEntry.getValue());
        }
    }
}
