public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int lastnumber = 0;
        int[] interval = null;
        while (lastnumber != 1) {
            if (interval == null) {
                interval = new int[m];
                for (int i = 0; i < m; i++) {
                    interval[i] = i + 1;
                    if (i == n) {
                        interval[i] = i + 1 - n;
                    } else {
                        interval[i] = i + 1;
                    }
                }
                lastnumber = interval[m - 1];
                System.out.print(interval[0]);
            } else {
                lastnumber = interval[m - 1];
                interval = new int[m];
                for (int i = 0; i < m; i++) {
                    if (i == 0) {
                        interval[i] = lastnumber;
                    } else {
                        if (lastnumber + i <= n) {
                            interval[i] = lastnumber + i;
                        } else {
                            interval[i] = lastnumber + i - n;
                        }
                    }
                }
                lastnumber = interval[m - 1];
                System.out.print(interval[0]);
            }
//            for (int i = 0; i < interval.length ; i++) {
//                System.out.print(interval[i]);
//            }
//            System.out.print(" ");
        }
    }
}

//Если предыдущий интервал не заполнен то создать новый по M и N
//Если предыдущий интервал заполнен то создать новый по M, N и
// последней цифоре в предыдущем интервале