import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int a=1;

        while(a!=0){
            System.out.println("Nastepujace czynnoscie: wybor figury, podanie danych, wyswietlenie");
            System.out.println("1-trojkat 2-okrag 3-kwadrat 4-graniastoslup prawidlowy czworokatny 0-wyjscie");
            try{
                Scanner scanner3 = new Scanner(System.in);
                a = scanner3.nextInt();}
            catch(InputMismatchException e){
                System.out.println("Musisz podac liczbe 0-3");
            }
        switch(a){
            case 1:
                System.out.println("Podaj dlugosci bokow");
                int b=1,c=1,d=1;
                try{
                Scanner scanner = new Scanner(System.in);
                b = scanner.nextInt();
                c = scanner.nextInt();
                d = scanner.nextInt();}
                catch(InputMismatchException e){
                    System.out.println("Musisz podac liczbe");
                    System.exit(0);
                }
                if(b+c<=d || c+d<=b || b+d<=c){
                    System.out.println("To nie jest trojkat");
                    System.exit(0);
                }
                Triangle t=new Triangle(b,c,d);
                t.print();
                break;
            case 2:
                System.out.println("Podaj dlugosc promienia");
                int e=1;
                try{
                Scanner scanner1 = new Scanner(System.in);
                e = scanner1.nextInt();}
                catch(InputMismatchException f){
                    System.out.println("Musisz podac liczbe");
                    System.exit(0);
                }
                Circle ci=new Circle(e);
                ci.print();
                break;
            case 3:
                System.out.println("Podaj dlugosc boku");
                int f=1;
                try{
                Scanner scanner2 = new Scanner(System.in);
                f = scanner2.nextInt();}
                catch(InputMismatchException h){
                    System.out.println("Musisz podac liczbe");
                    System.exit(0);
                }
                Square s=new Square(f);
                s.print();
                break;
            case 4:
                System.out.println("Podaj dlugosc boku i wysokosc");
                int i=1;
                int j=1;
                try{
                    Scanner scanner4 = new Scanner(System.in);
                    i = scanner4.nextInt();
                    j=scanner4.nextInt();
                }
                catch(InputMismatchException k){
                    System.out.println("Musisz podac liczbe");
                    System.exit(0);
                }
                Prism p=new Prism(i,j);
                p.print();
                break;
        }}
    }}

