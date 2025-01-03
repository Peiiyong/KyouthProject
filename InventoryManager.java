import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Car> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addCar(Car car) {
        inventory.add(car);
        System.out.println("Car added successfully.");
    }

    public boolean removeCar(int id) {
        for(Car car : inventory) {
            inventory.remove(car);
            System.out.println("Car remove successfully.");
            return true;
        }
        System.out.println("Car not found.");
        return false;
    }

    public Car searchCar(int id) {
        for (Car car : inventory) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public boolean updateCar(int id, String name, String model, double price, String color) {
        for (Car car : inventory) {
            if (car.getId() == id) {
                car.setName(name);
                car.setModel(model);
                car.setPrice(price);
                car.setColor(color);
                System.out.println("Car updated successfully.");
                return true;
            }
        }
        System.out.println("Car not found.");
        return false;
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No cars in the inventory.");
        } else {
            for (Car car : inventory) {
                System.out.println(car);
            }
        }
    }

    // Method to get the size of inventory
    public int getInventorySize() {
        return inventory.size();
    }

}
