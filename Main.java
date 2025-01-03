public class Main {
    public static void main(String[] args) {
        // Initialize car models
        String[] carModels = {"Sedan", "SUV", "Sports Car", "Truck", "Van"};
        IOHandler ioHandler = null;
        
        try {
            // Create management objects
            InventoryManager inventoryManager = new InventoryManager();
            SalesReport salesReport = new SalesReport(carModels);
            ioHandler = new IOHandler(inventoryManager, salesReport, carModels);
            
            // Start the application
            ioHandler.start();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Clean up resources
            if (ioHandler != null) {
                ioHandler.close();
            }
        }
    }
}