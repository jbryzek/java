public class Triangle extends Figure implements Printable{
    private double a,b,c;
    public Triangle(int x, int y, int z){a=x;b=y;c=z;}
    public Triangle(){a=1;b=1;c=1;}

    public double calculateArea() {
        double p=(a+b+c)/2;
        System.out.println(p+"\n");
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public double calculatePerimeter() {
        return c+b+a;
    }

    @Override
    public void print() {
        System.out.println("Boki: "+a+" "+b+" "+c+"\n"+"Pole: "+calculateArea()+"\n"+"Obwod: "+calculatePerimeter());
    }
}
