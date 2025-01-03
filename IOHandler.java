import java.util.Scanner;

public class IOHandler {
    private Scanner scanner;
    private InventoryManager inventoryManager;

    public IOHandler(InventoryManager inventoryManager) {
        this.scanner = new Scanner(System.in);
        this.inventoryManager = inventoryManager;
    }

    public void start() {
        int choice;
        do {
            choice = showMainMenu();
            processChoice(choice);
        } while (choice != 0);
    }

    public int showMainMenu() {
        System.out.println("\n=== Car Dealership Management System ===");
        System.out.println("1. Add New Car");
        System.out.println("2. Remove Car");
        System.out.println("3. Search Car");
        System.out.println("4. Update Car");
        System.out.println("5. Display Inventory");
        System.out.println("0. Exit");
        return getIntInput("Enter your choice (0-5): ", 0, 5);
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1 -> handleAddCar();
            case 2 -> handleRemoveCar();
            case 3 -> handleSearchCar();
            case 4 -> handleUpdateCar();
            case 5 -> handleDisplayInventory();
            case 0 -> System.out.println("Thank you for using the system!");
            default -> System.out.println("Invalid choice!");
        }
    }

    private void handleAddCar() {
        Car car = inputCarDetails();
        inventoryManager.addCar(car);
    }

    private void handleRemoveCar() {
        int id = getCarId();
        inventoryManager.removeCar(id);
    }

    private void handleSearchCar() {
        int id = getCarId();
        Car car = inventoryManager.searchCar(id);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found!");
        }
    }

    private void handleUpdateCar() {
        int id = getCarId();
        Car updatedCar = inputUpdateDetails(id);
        inventoryManager.updateCar(id, updatedCar.getName(), 
            updatedCar.getModel(), updatedCar.getPrice(), 
            updatedCar.getColor());
    }

    private void handleDisplayInventory() {
        inventoryManager.displayInventory();
    }

    public Car inputCarDetails() {
        System.out.println("\nEnter Car Details:");
        int id = getIntInput("Enter Car ID", 1, 9999);
        String name = getStringInput("Enter Car Name");
        String model = getStringInput("Enter Car Model");
        double price = getDoubleInput("Enter Car Price: $", 0, 1000000);
        String color = getStringInput("Enter Car Color");
        return new Car(id, name, model, price, color);
    }

    public Car inputUpdateDetails(int id) {
        String name = getStringInput("Enter New Name");
        String model = getStringInput("Enter New Model");
        double price = getDoubleInput("Enter New Price: $", 0, 1000000);
        String color = getStringInput("Enter New Color");
        return new Car(id, name, model, price, color);
    }

    public int getCarId() {
        return getIntInput("Enter Car ID", 1, 9999);
    }

    private String getStringInput(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            }
        } while (input.isEmpty());
        return input;
    }

    private int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a number between %d and %d\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private double getDoubleInput(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a value between %.2f and %.2f\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}