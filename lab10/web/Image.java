package lab10_.demo.web;

public class Image {
    private int id;
    private Size size;

    public Image(int number,Size size){
        id = number;
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
