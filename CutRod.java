public class CutRod {
    public static void main(String[] args){
        int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 9;
        int[] r = new int[n+1];
        int[] s = new int[n+1];

        for (int j = 1; j <= n; j++){
            int q = (int)Double.NEGATIVE_INFINITY;

            for (int i = 1; i <= j; i++){
                if (q < p[i] + r[j-i]){
                    q = p[i] + r[j-i];
                    s[j] = i;
                    r[j] = q;
                }
            }
        }

        System.out.println(r[n]);
        while (n > 0){
            System.out.print(s[n]);
            System.out.print(" ");
            n -= s[n];
        }
    }
}
