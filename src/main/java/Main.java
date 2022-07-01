/*
 * Let's create a lightweight, simplified, restaurant reservation system:
    1.) Our restaurant has 2 tables
    2.) In an input loop, ask the user if they want to check someone in or check someone out
    3.) If they want to check someone in, check if a table is available.
        a.) If a table is available, check them in
        b.) If a table is not available, put them on a waiting list
    4.) If they want to check someone out:
        a.) Free one of the table that is taken
        b.) Immediately assign the table to the next person on the waiting list
Hints:

1.) You can use an array, a list, a map or a queue for your tables - 
each data structure has pros and cons, but you can make each 
one work for the list of tables
2.) Use a queue for your wait list, as that's the most natural data structure 
for this type of scenario
3.) You may want to use a class named Restaurant that holds both your table 
list and your waitlist
4.) Your Restaurant class will have a method you might call checkin and a 
method called checkout that will be responsible for implementing the logic we described above
 */
import java.util.Scanner;

public class Main {
    public static boolean repeat = true;
    public static Scanner sc = new Scanner(System.in);
    public static String welcomeMenu = "\nWould you like to: \n1. Check someone in for dining with us \n2. Check someone out \n3. View all tables \n4. Exit \n \n(Enter below the number corresponding to your choice.)";
    public static String checkInQ = "What is the name of the person you'd like to check in?";
    public static String checkOutQ = "What is the name of the person you would like to check out?";
    public static Restaurant restaurant = new Restaurant();

    public static void main(String[] args) {
        log("\n~*~*~*~ \nWelcome to the Virtual Restaurant! \n~*~*~*");
        host();
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void host() {
        while (repeat) {
            log(welcomeMenu);
            int hostAnswer = sc.nextInt();
            sc.nextLine();
            switch (hostAnswer) {
                case 1:
                    log(checkInQ);
                    String guest = sc.nextLine();
                    restaurant.checkIn(guest);
                    break;
                case 2:
                    log(checkOutQ);
                    String nameOut = sc.nextLine();
                    restaurant.checkOut(nameOut);
                    host();
                    break;
                case 3:
                    restaurant.viewTables();
                    host();
                    break;
                case 4:
                    log("Goodbye!");
                    repeat = false;
                    System.exit(0);
                    break;
            }
        }
    }

}
