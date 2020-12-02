import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Naloga1 {

    private static int count(String besedilo, char crka) {
        int stevec = 0;
        for (int i = 0; i < besedilo.length(); i++) {
            char trenutnaCrka = besedilo.charAt(i);
            if (trenutnaCrka == crka) {
                stevec++;
            }
        }
        return stevec;
    }

    public static void main(String[] args) {

        int rezultat = 0;

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                // Print the content on the console
                String[] besede = trenutnaVrstica.split(" ");
                
                String[] omejitvi = besede[0].split("-");
                int spodnjaMeja = Integer.parseInt(omejitvi[0]);
                int zgornjaMeja = Integer.parseInt(omejitvi[1]);

                char crka = besede[1].charAt(0);

                int steviloCrkVBesedi = count(besede[2], crka);

                if (steviloCrkVBesedi >= spodnjaMeja && steviloCrkVBesedi <= zgornjaMeja) {
                    rezultat++;
                }
            }
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(rezultat);
    }
}
