import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Naloga2 {

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
                int prviIndex = Integer.parseInt(omejitvi[0]);
                int drugiIndex = Integer.parseInt(omejitvi[1]);

                char crka = besede[1].charAt(0);

                char crkaNaPrvemIndeksu = besede[2].charAt(prviIndex - 1);
                char crkaNaDrugemIndeksu = besede[2].charAt(drugiIndex - 1);

                if (crkaNaPrvemIndeksu == crka && crkaNaDrugemIndeksu != crka 
                || crkaNaPrvemIndeksu != crka && crkaNaDrugemIndeksu == crka) {
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
