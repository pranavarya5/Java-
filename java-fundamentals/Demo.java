import java.util.Scanner;

class User {
    String name;
    int age;
    int xp;
}

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User[] users = new User[100]; // big limit
        int count = 0;

        while(true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Learner");
            System.out.println("2. Display All Learners");
            System.out.println("3. Calculate Average XP");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch(choice) {

                case 1:

                    if(count >= users.length) {
                        System.out.println("Storage full!");
                        break;
                    }

                    users[count] = new User();

                    System.out.print("Enter name: ");
                    users[count].name = sc.nextLine();

                    System.out.print("Enter age: ");
                    users[count].age = sc.nextInt();

                    System.out.print("Enter xp: ");
                    users[count].xp = sc.nextInt();

                    sc.nextLine(); // clear buffer

                    count++;

                    System.out.println("Learner added successfully!");
                    break;

                case 2:

                    if(count == 0) {
                        System.out.println("No learners found!");
                        break;
                    }

                    for(int i = 0; i < count; i++) {

                        System.out.println("\nLearner " + (i + 1));
                        System.out.println("Name: " + users[i].name);
                        System.out.println("Age: " + users[i].age);
                        System.out.println("XP: " + users[i].xp);
                    }

                    break;

                case 3:

                    if(count == 0) {
                        System.out.println("No learners to calculate!");
                        break;
                    }

                    int sum = 0;

                    for(int i = 0; i < count; i++) {
                        sum += users[i].xp;
                    }

                    double avg = (double) sum / count;

                    System.out.println("Average XP: " + avg);

                    break;

                case 4:

                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}