public class towerOfHanoi {
    public static void main(String[] args) {

        int n = 3;
        TOH(n, 'A', 'B', 'C');
    }

    public static void TOH(int n, char RodA, char RodB, char RodC) {
        if (n == 1) {
            System.out.println("Disk 1 from " + RodA + " to " + RodC);
        } else {
            TOH(n - 1, RodA, RodC, RodB);
            System.out.println("Disk " + n + " from " + RodA + " to " + RodC);
            TOH(n - 1, RodB, RodA, RodC);
        }
    }
}
