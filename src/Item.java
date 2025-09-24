public class Item {
    String itemName;
    float price;

    public Item(String name, int x) {
        this.itemName = name;
        this.price = x;
    }

    public String getName() {
        return itemName;
    }

    public void SetName(String name) {
        this.itemName = name;
    }

    public float getPrice() {
        return price;
    }

    public void SetPrice(float x) {
        this.price = x;
    }
}
