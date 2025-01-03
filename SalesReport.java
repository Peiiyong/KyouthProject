public class SalesReport {
    private int[][] salesData;  // 2D array to track sales: [months][car models]
    private String[] carModels;  // List of car models

    // Constructor to initialize the SalesReport with the car models
    public SalesReport(String[] carModels) {
        this.carModels = carModels;
        this.salesData = new int[12][carModels.length];  // 12 months and number of car models
    }

    // Method to record a sale: month (1-12), car model index, number of cars sold
    public void recordSale(int month, int carModelIndex, int unitsSold) {
        if (month >= 1 && month <= 12 && carModelIndex >= 0 && carModelIndex < carModels.length) {
            salesData[month - 1][carModelIndex] += unitsSold;  // Record the sales in the appropriate slot
            System.out.println("Sale recorded: " + unitsSold + " units of " + carModels[carModelIndex] + " in month " + month);
        } else {
            System.out.println("Invalid month or car model index.");
        }
    }

    // Method to generate a report for a specific month
    public void generateMonthlyReport(int month) {
        if (month >= 1 && month <= 12) {
            System.out.println("Sales Report for Month: " + month);
            for (int i = 0; i < carModels.length; i++) {
                System.out.println(carModels[i] + ": " + salesData[month - 1][i] + " units sold");
            }
        } else {
            System.out.println("Invalid month.");
        }
    }

    // Method to generate the total sales report for all months
    public void generateTotalSalesReport() {
        System.out.println("Total Sales Report:");
        for (int i = 0; i < carModels.length; i++) {
            int totalSales = 0;
            // Sum up sales for each car model across all months
            for (int month = 0; month < 12; month++) {
                totalSales += salesData[month][i];
            }
            System.out.println(carModels[i] + ": " + totalSales + " units sold in total");
        }
    }

    // Method to display sales data for all months
    public void displayAllSalesData() {
        System.out.println("Sales Data for All Months:");
        for (int month = 0; month < 12; month++) {
            System.out.println("Month " + (month + 1) + ":");
            for (int i = 0; i < carModels.length; i++) {
                System.out.println(carModels[i] + ": " + salesData[month][i] + " units sold");
            }
        }
    }

    public String[] getCarModels() {
        return carModels;
    }
}
