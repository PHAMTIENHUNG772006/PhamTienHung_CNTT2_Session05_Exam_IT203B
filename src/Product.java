public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    public static int count = 0;

    public Product(String name, double price, int quantity, String category) {
        this.id = count++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product : " +
                " | ID : " + id +
                " | Name : " + name + '\'' +
                " | Price : " + price +
                " | Quantity : " + quantity +
                " | Category : " + category ;
    }


}
