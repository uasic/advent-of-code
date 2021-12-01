import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Naloga02 {

    public static void main(String[] args) {
        System.out.println("Pozdravljena Urska");

        List<Integer> seznamStevil = new ArrayList<Integer>();

        // Open the file
        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                // Print the content on the console
                // System.out.println(trenutnaVrstica);
                seznamStevil.add(Integer.parseInt(trenutnaVrstica));
            }
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        // Od tukaj naprej se delam, da je `seznamStevil` ze poln
        
        for (int i = 0; i < seznamStevil.size(); i++) {
            int trenutnoStevilo = seznamStevil.get(i);
            
            for(int j = i + 1; j < seznamStevil.size(); j++) {
                int notranjeStevilo = seznamStevil.get(j);

                for(int k = 0; k < seznamStevil.size(); k++) {
                    int tretjeStevilo = seznamStevil.get(k);
    
                    if (k != i && k != j) {
                        int vsota = trenutnoStevilo + notranjeStevilo + tretjeStevilo;
                        if (vsota == 2020) {
                            int zmnozek = trenutnoStevilo * notranjeStevilo * tretjeStevilo;
                            System.out.println(trenutnoStevilo + " * " + notranjeStevilo + " * " + tretjeStevilo + " = " + zmnozek);
                        }
                    }
                }
            }
        }
    }
}