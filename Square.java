public class Square extends Figure implements Printable{
    private int a;
    public Square(int x){a=x;}
    public Square(){a=1;}

    public double calculateArea() {
        return a*a;
    }
    public double calculatePerimeter() {
        return 4*a;
    }

    @Override
    public void print() {
        System.out.println("Bok: "+a+"\n"+"Pole: "+calculateArea()+"\n"+"Obwod: "+calculatePerimeter());
    }
}
