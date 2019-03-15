public class Prism extends Figure implements Printable {
    private int a;
    private int h;
    public Prism(int a,int b){this.a=a;h=b;}

    public double calculateArea() {
        return 2*a*a+4*h*a;
    }

    public double calculateCapacity(){
        return a*a*h;
    }


    public double calculatePerimeter() {
        return 8*a+4*h;
    }

    @Override
    public void print() {
        System.out.println("Bok: "+a+" Wysokosc: "+h+"\n"+"Pole: "+calculateArea()+"\n"+"Objetosc: "+calculateCapacity());
    }
}
