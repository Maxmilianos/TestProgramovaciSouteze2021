package uloha1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/*
* Start: 14.03.2022 ~ 01:43
* End: ?
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
