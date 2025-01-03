import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        boolean startProgram = true;
        Scanner sc = new Scanner(System.in);

        while (startProgram) { 
            displayMenu();
            int choice =sc.nextInt();
            
            switch (choice) {
                case 1:
                     //im.addCar(car);
                     break;
                case 2:
                     //im.removeCar();
                     break;
                case 3:
                     //im.earchCar();
                     break;
                case 4:
                    //im.updateCar();
                    break;
                case 5:
                    //im.displayInventory();
                    break;
                case 6:
                    {
                    System.out.println("Exit!");
                    startProgram = false;
                    break;
                    }
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nCar Dealership Management System");
        System.out.println("1. Add Car");
        System.out.println("2. Remove Car");
        System.out.println("3. Search Car");
        System.out.println("4. Update Car");
        System.out.println("5. Display Inventory");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}