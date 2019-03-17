import java.util.*;

public class FulfillmentCenterContainer {
    private Map<String,FulfillmentCenter> mapWarehouses=new HashMap<String, FulfillmentCenter>();

    public FulfillmentCenter addCenter(String a, double b){
        FulfillmentCenter n= new FulfillmentCenter(a,b);
        mapWarehouses.put(a,n);
        return n;
    }

    public void removeCenter(String a){
        mapWarehouses.remove(a);
    }

    public ArrayList<FulfillmentCenter> findEmpty(){
        ArrayList <FulfillmentCenter> list=new ArrayList<>();
        Set<Map.Entry<String,FulfillmentCenter>> entrySet=mapWarehouses.entrySet();

        for(Map.Entry<String,FulfillmentCenter> entry:entrySet){
            if(entry.getValue().getProducts().size()==0){
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public void summary(){
        Set<Map.Entry<String,FulfillmentCenter>> entrySet=mapWarehouses.entrySet();
        double z=0;
        for(Map.Entry<String,FulfillmentCenter> entry:entrySet){
            for(Item i:entry.getValue().getProducts()){
                z+=i.getMass();
            }
            z=(z/entry.getValue().getMaxMass())*100;
            System.out.println(entry.getKey()+" zapelnienie: "+z+"%");
            z=0;
        }
    }

    FulfillmentCenter get(String name) {
            return mapWarehouses.get(name);
    }
}
