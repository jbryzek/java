public class Circle extends Figure implements Printable {
    private int r;
    public Circle(int x){r=x;}
    public Circle(){r=1;}

    public double calculateArea() {
        return Math.PI * r * r;
    }
    public double calculatePerimeter() {
        return Math.PI * 2* r;
    }

    @Override
    public void print() {
        System.out.println("Promien: "+r+"\n"+"Pole: "+calculateArea()+"\n"+"Obwod: "+calculatePerimeter());
    }
}
