public class SalesReport {
    private int[][] sales; // Rows: months, Columns: cars

    // Constructor
    public SalesReport(int numberOfCars) {
        sales = new int[12][numberOfCars];//the length of the array of sold car
    }

    // Add sales data
    public void addSale(int month, int carIndex, int count) {
        if (month >= 1 && month <= 12 && carIndex >= 0 && carIndex < sales[0].length) {
            sales[month - 1][carIndex] += count;
        }
    }

}
