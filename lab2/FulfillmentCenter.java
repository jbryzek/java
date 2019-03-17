import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FulfillmentCenter implements Comparator <Item> {
    private String warehouseName;
    private double maxMass;
    private List <Item> products=new ArrayList<>();

    public FulfillmentCenter(String n,double m){
        warehouseName=n;
        maxMass=m;
    }

    public void add(Item n){
        for(Item item:products){
            if(n.getName().equals(item.getName())){
                if(item.getQuantity()+n.getQuantity()<maxMass){
                    item.setQuantity(item.getQuantity() + n.getQuantity());
                break;}
                else{
                    System.err.println("There's not enough place");
                }
            }
        }
        products.add(n);
    }

    public void getProduct(Item m){
        if(m.getQuantity()>1){
            m.setQuantity(m.getQuantity()-1);
        }
        else{
            removeProduct(m);
        }
    }

    public void removeProduct(Item o){
        products.remove(o);
    }

    @Override
    public int compare(Item i, Item j){
        if(i.getName()==j.getName()) return 0;
        else return 1;
    }

    public Item search(String name){
        Item tmp=new Item(name,ItemCondition.NEW,0,0);

        for(Item j:products){
            int result = compare(j, tmp);
            if(result==0) tmp=j;
        }
        return tmp;
    }

    public List<Item> searchPartial(String p){
        List <Item> lista=new ArrayList<>();
        Pattern pattern=Pattern.compile(p);
        for(Item i:products) {
            Matcher matcher = pattern.matcher(i.getName());
            if(matcher.find()){
                lista.add(i);
            }
        }
        return lista;
    }

    public int countByCondition(ItemCondition r){
        int s=0;
        for(Item i:products){
            if(r.equals(i.getCondition())){
                s++;
            }
        }
        return s;
    }

    public void summary(){
        for(Item i:products) {
            i.print();
        }
    }

    public void sortByName(){
        Collections.sort(products);
    }

    public void sortByAmount(){
        Collections.sort(products, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.getQuantity(),o2.getQuantity());
            }
        });
    }

    public Item maxx(){

        return Collections.max(products, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.getQuantity(),o2.getQuantity());
            }
        });
    }

    public String toString(){
        return "Warehouse name: "+warehouseName+" max mass: "+maxMass;
    }

    public List<Item> getProducts() {
        return products;
    }

    public double getMaxMass() {
        return maxMass;
    }
}
