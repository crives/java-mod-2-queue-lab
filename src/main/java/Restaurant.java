import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    // List for Reservations / Tables (Add Person to table)
    public Map<Table, String> tables = new HashMap<Table, String>();
    public Table table1 = new Table(1);
    public Table table2 = new Table(2);
    
    // Queue for Waitlist
    public Queue<String> waitList = new LinkedList<String>();
    
    public void checkIn(String guest) {
        if(tables.isEmpty()) {
            createTables();
        }

        if(tables.containsValue("")) {
            if(tables.get(table1).equals("")) {
                tables.replace(table1, guest);
                Main.log("\nI've got them checked into Table 1! Happy dining!");
            } else if(tables.get(table2).equals("")) {
                tables.replace(table2, guest);
                Main.log("\nI've got them checked into Table 2! Happy dining!");
            }
        } else {
            Main.log("\nSorry! Our tables are full at the moment. \nWe will put you on the waitlist - you will get the next available table!");
            waitList.add(guest);
            Main.log("You have been added!");
        }
    }

    public void checkOut(String name) {
        if(tables.get(table1).equals(name)) {
            tables.replace(table1, "");
            Main.log("We've got them checked out!");
            if(!waitList.isEmpty()) {
                String nextGuest = waitList.remove();
                tables.replace(table1, nextGuest);
                Main.log("Added a guest from the waitlist to Table 1!");
            }
        } else if(tables.get(table2).equals(name)) {
                tables.replace(table2, "");
                Main.log("We've got them checked out!");
                if(!waitList.isEmpty()) {
                    String nextGuest = waitList.remove();
                    tables.replace(table2, nextGuest);
                    Main.log("Added a guest from the waitlist to Table 2!");
                }
        } else {
            Main.log("Sorry! We cannot find that guest at the moment.");
        }
    }

    public void createTables() {
        tables.clear();
        tables.put(table2, "");
        tables.put(table1, "");
    }

    public void viewTables() {
        if(tables.isEmpty()) {
            createTables();
        }
    
        Main.log("\nHere are all of our current tables:");
        for (Map.Entry<Table, String> tableEntry: tables.entrySet()) {
            Main.log("\n" + tableEntry.getKey() + ": " + tableEntry.getValue());
        }
    }
}
