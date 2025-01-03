public class Car {
    private String name;
    private String model;
    private double price;
    private String color;

    // Constructor
    public Car(String name, String model, double price, String color) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    // Getter and Setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'model'
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Getter and Setter for 'price'
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for 'color'
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
