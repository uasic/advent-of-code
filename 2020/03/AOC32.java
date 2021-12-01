import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AOC32 {

    public static void main(String[] args) {

        String drevesa = "";
        int dolzinaEneVrstice = 0;

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;

            int a = 0;
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                // Print the content on the console
                drevesa += trenutnaVrstica;
                
                if (dolzinaEneVrstice == 0) {
                    dolzinaEneVrstice = trenutnaVrstica.length();
                }

                a += trenutnaVrstica.length();
            }

            System.out.println(a + ", " + drevesa.length());
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println("NAPAKA: " + e.getMessage());
        }

        // Od tukaj naprej se delam, da imam v spremenljivki `drevesa` cel gozd

        /*
        Right 1, down 1.
        Right 3, down 1. (This is the slope you already checked.)
        Right 5, down 1.
        Right 7, down 1.
        Right 1, down 2.
        */

        // Res bi bilo super, ce bi imel funkcijo, ki ji podam drevesa in navodila za
        // sprehajanje, ta pa mi vrne stevilo dreves na poti.

        BigInteger s1 = new BigInteger(Integer.toString(steviloDrevesNaPoti(drevesa, 1, 1, dolzinaEneVrstice)));
        BigInteger s2 = new BigInteger(Integer.toString(steviloDrevesNaPoti(drevesa, 3, 1, dolzinaEneVrstice)));
        BigInteger s3 = new BigInteger(Integer.toString(steviloDrevesNaPoti(drevesa, 5, 1, dolzinaEneVrstice)));
        BigInteger s4 = new BigInteger(Integer.toString(steviloDrevesNaPoti(drevesa, 7, 1, dolzinaEneVrstice)));
        BigInteger s5 = new BigInteger(Integer.toString(steviloDrevesNaPoti(drevesa, 1, 2, dolzinaEneVrstice)));
        
        BigInteger gozd = s1.multiply(s2).multiply(s3).multiply(s4).multiply(s5);

        System.out.println(gozd.toString());
    }

    private static int steviloDrevesNaPoti(String drevesa, int R, int D, int L) {
        int stevec = 0;

        /*
        int x = 0;
        while (x < drevesa.length()) {
            if (drevesa.charAt(x) == '#') {
                stevec++;
            }
            x += D * L + R;
        }
        */

        /*
        for (int x = 0; x < drevesa.length(); x += D * L + R) {
            if (drevesa.charAt(x) == '#') {
                stevec++;
            }
        }
        */

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;

            int x = 0;
    
            // Read File Line By Line
            int d = 0;
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                if (d != 0) {
                    d--;
                    continue;
                }
                d = D - 1;
                // Print the content on the console
                if (trenutnaVrstica.charAt(x) == '#') {
                    stevec++;
                }
                
                x += R;
                
                if (x >= trenutnaVrstica.length()) {
                    x %= trenutnaVrstica.length();
                }
            }

            System.out.println(stevec);
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println("NAPAKAAAA " + e.getMessage());
        }
        

        return stevec;
    }
}
