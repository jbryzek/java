import java.util.ArrayList;
import java.util.List;

public class Management {
    public static void main(String[]args) {
        FulfillmentCenterContainer managers = new FulfillmentCenterContainer();
        FulfillmentCenter asmet = managers.addCenter("Asmet", 120);
        FulfillmentCenter bispol = managers.addCenter("Bispol", 200);
        FulfillmentCenter another = managers.addCenter("Another",150);
        Item miedz = new Item("miedz", ItemCondition.USED, 30, 15);
        Item zloto = new Item("zloto",ItemCondition.NEW,12,24);
        Item srebro = new Item("srebro",ItemCondition.NEW,10,20);
        Item cynk = new Item("cynk",ItemCondition.REFURBISHED,14,12);
        Item olow = new Item("olow",ItemCondition.REFURBISHED,16,5);
        Item cyna = new Item("cyna",ItemCondition.USED,30,15);
        Item tytan = new Item("tytan",ItemCondition.NEW,2,1);
        asmet.add(miedz);
        asmet.add(zloto);
        asmet.add(srebro);
        asmet.add(tytan);
        bispol.add(cynk);
        bispol.add(olow);
        bispol.add(cyna);
        miedz.print();
        asmet.getProduct(miedz);
        miedz.print();
        tytan.print();
        asmet.getProduct(tytan);
        tytan.print();
        System.out.println("Result of search: ");
        asmet.search("miedz").print();
        System.out.println("Result of searchPartial: ");
        List<Item> sPart =bispol.searchPartial("cy");
        for(Item i:sPart){
            System.out.println("Name: "+i.getName());
        }
        System.out.println("Result of countByCondition: "+asmet.countByCondition(ItemCondition.NEW));
        System.out.println("Summary of "+bispol);
        bispol.summary();
        bispol.sortByName();
        System.out.println("Sort by name: ");
        for(Item i:bispol.getProducts()){
            i.print();
        }
        bispol.sortByAmount();
        System.out.println("Sort by amount: ");
        for(Item i:bispol.getProducts()){
            i.print();
        }
        System.out.println("Product with max quantity: ");
        Item maks=bispol.maxx();
        maks.print();
        System.out.println("Empty warehouse: ");
        ArrayList<FulfillmentCenter> fempty = managers.findEmpty();
        for(FulfillmentCenter f:fempty){
            System.out.println(f);
        }
        System.out.println("Summary ");
        managers.summary();
    }
}
