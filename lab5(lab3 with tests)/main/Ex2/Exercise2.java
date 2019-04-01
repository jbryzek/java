package Ex2;

import java.util.List;

public class Exercise2 {

    public int solution(List<Integer> list) throws TooBigSizeException {
        int min=1;
        if(list.size()>1000){
            throw new TooBigSizeException();
        }
        for (int j = 0; j < list.size(); j++) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == min) {
                    min++;
                }
            }
        }
        return min;
    }
}
