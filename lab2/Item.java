public class Item implements Comparable<Item>{
    private String name;
    private ItemCondition condition;
    private double mass;
    private int quantity;

    @Override
    public int compareTo(Item i)
    {
        return this.name.compareTo(i.name);
    }

    public Item(String n,ItemCondition c,double m,int q) {
        name = n;
        condition = c;
        mass = m;
        quantity = q;
    }

    public void print(){
        System.out.println("Name: "+name+" condition: "+condition+" mass: "+mass+" quantity: "+quantity);
    }

    public double getMass(){
        return mass;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getName() {
        return name;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
