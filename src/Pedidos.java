import java.util.LinkedList;

public class Pedidos {
    private String clientName;
    int id;

    public Item item;
    private LinkedList<Item> listItem = new LinkedList<>();

    Pedidos () {}

    Pedidos(String name, int x) {
        this.clientName = name;
        this.id = x;
    }

    public void setName(String name) {
        this.clientName = name;
    }

    public String getName() {
        return clientName;
    }

    public void SetId(int x) {
        this.id = x;
    }

    public int getId() {
        return id;
    }

    public void SetItem(String name, int x){
        item = new Item(name, x);
        listItem.add(item);
    }

    public LinkedList<Item> getListItem() {
        return listItem;
    }
}

