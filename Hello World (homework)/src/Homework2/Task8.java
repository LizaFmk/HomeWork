package Homework2;

public class Task8 {
    public static void main(String[] args) {
        int[] masRating = {1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2};
        int[] masStipend = new int[masRating.length];
        int sum = 0;
        for (int i = 0; i < masRating.length; i++) {
            masStipend[i] = 1;
        }
        for (int m = 0; m < masRating.length / 2; m++) {

            for (int i = 1; i < masStipend.length; i++) {
                if (masRating[i - 1] < masRating[i]) {
                    if (masStipend[i - 1] >= masStipend[i]) {
                        masStipend[i] = masStipend[i - 1] + 1;
                    }
                }

                if (masRating[i - 1] > masRating[i]) {
                    if (masStipend[i - 1] <= masStipend[i]) {
                        masStipend[i - 1] = masStipend[i] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < masStipend.length; i++) {
            System.out.print(masStipend[i] + " ");
            sum += masStipend[i];
        }

        System.out.println(" = " + sum);
    }
}
