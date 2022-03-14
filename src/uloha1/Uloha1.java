package uloha1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/*
* Start:    14.03.2022 ~ 01:43
* End:      14.03.2022 ~ 02:15
*
n = ?
10
n=10
cislice 1 z cisla 10
received: 0.006s.
100
n=100
cislice 5 z cisla 55
received: 0.005s.
999
n=999
cislice 9 z cisla 369
received: 0.001s.
9000
n=9000
cislice 2 z cisla 2527
received: 0.002s.
12345
n=12345
cislice 3 z cisla 3363
received: 0.001s.
99999
n=99999
cislice 1 z cisla 22221
received: 0.0s.
* */
public class Uloha1 {

    public static void main(String[] args) {
        long started = System.currentTimeMillis();
        Random random = new Random();

        String rada = "";
        ArrayList<Rozpeti> rozpetiArrayList = new ArrayList<>();
        for (int i = 1; i <= 30000; i++) { // for testing only
            int len = rada.length() + 1;
            rada += "" + i;
            rozpetiArrayList.add(new Rozpeti(len, rada.length(), i));
        }
        System.out.println(rada);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = null;
            System.out.println("Moznost psat za: " + ((double) (System.currentTimeMillis() - started)/1000) + "s.");
            System.out.println("n = ?");

            while ((line = bufferedReader.readLine()) != null) {
                try {
                    Integer n = Integer.parseInt(line);
                    long want = System.currentTimeMillis();
                    System.out.println("n=" + n + "");
                    if (n == 0) {
                        System.out.println("END");
                        return;
                    }

                    if (n > rada.length()) {
                        System.out.println("Vyzkousej nove cislo");
                        continue;
                    }

                    String cisloVRade = "" + rada.charAt(n-1);

                    int celeCislo = -1;

                    for (Rozpeti rozp : rozpetiArrayList) {
                        if (rozp.max >= n && rozp.min <= n) {
                            celeCislo = rozp.cislo;
                            continue;
                        }
                    }

                    System.out.println("cislice " + cisloVRade + " z cisla " + celeCislo);

                    System.out.println("received: " + ((double) (System.currentTimeMillis() - want)/1000) + "s.");

                } catch (NumberFormatException e) {
                    System.out.println("Napiste prosim cislo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Rozpeti {

        public int min, max, cislo;

        public Rozpeti(int min, int max, int cislo) {
            this.min = min;
            this.max = max;
            this.cislo = cislo;
        }
    }

}
