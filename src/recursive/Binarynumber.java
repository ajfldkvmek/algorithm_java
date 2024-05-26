package recursive;

public class Binarynumber {

    public void bin(int n){
        if(n == 0) return;
        bin(n/2);
        System.out.print(n%2);
    }

    public static void main(String[] args) {
        Binarynumber bn = new Binarynumber();
        bn.bin(11);
    }
}
