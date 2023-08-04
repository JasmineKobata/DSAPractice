public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            System.out.print(start);
            System.out.print(" ");
            System.out.println(end);
            if (guess(mid) == 1) {
                start = mid;
            } else if ( guess(mid) == -1) {
                end = mid;
            } else {
                System.out.println("A");
                return mid;
            }
        }
        return start;
    }
}