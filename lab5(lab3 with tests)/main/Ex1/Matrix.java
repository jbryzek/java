package Ex1;

import java.util.Iterator;

public class Matrix<T> implements Iterable<Object> {

    private int length;
    private int width;
    private T [][] matrix;

    public Matrix(int length, int width, T[][] matrix,int init){
        this.length=length;
        this.width=width;
        this.matrix=matrix;
        for(int i=0; i< length;i++){
            for(int j=0; j<width;j++){
                matrix[i][j]=(T)(Integer)init;
            }
        }
    }

    public void add(Matrix m) throws Exception{
        if(this.length!=m.length){
            throw new IllegalArgumentException("Matrix length and width must be equal");
        }
        if(this.width!=m.width){
            throw new IllegalArgumentException("Matrix length and width must be equal");
        }
        for(int i=0; i< length;i++){
            for(int j=0; j<width;j++){
                matrix[i][j]=(T)(Integer)((Integer)matrix[i][j]+(Integer)m.matrix[i][j]);
            }
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorM();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        Iterator<Object> iterator = this.iterator();
        int tempPos = 0;
        while (iterator.hasNext()){
            sb.append(iterator.next() + "\t");

            if(tempPos % width == width-1){
                sb.append("\n");
            }

            tempPos++;
        }

        sb.append("]");
        return sb.toString();
    }

    public class IteratorM implements Iterator {
        private int position = 0;

        public boolean hasNext() {
            if (position < length * width) {
                return true;
            } else {
                return false;
            }
        }

        public String next() {
            if (this.hasNext()){
                int col = (int)Math.ceil(position / width);
                int row = position - col * width;
                position++;
                return matrix[col][row].toString();
            } else{
                return null;
            }
        }

    }
}
