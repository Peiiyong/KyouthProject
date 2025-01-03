public class Main {
    public static void main(String[] args) {
        InventoryManager im = new InventoryManager();
        IOHandler ioHandler = new IOHandler(im);
        String[] carModels = {"Model A", "Model B", "Model C"};
        SalesReport salesReport = new SalesReport(carModels);

        ioHandler.start();
    }
}