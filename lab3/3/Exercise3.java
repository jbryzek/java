package Ex3;

public class Exercise3 {
    public int substring(String a,String b){
        int numberOfRepetitions=0;
        if(!a.contains(b)){
            return -1;
        }
        StringBuilder sbuilder = new StringBuilder();
        while (!sbuilder.toString().contains(a) && sbuilder.length() < a.length() + b.length()) {
            sbuilder.append(b);
            numberOfRepetitions += 1;
        }
        return numberOfRepetitions;
    }
}
