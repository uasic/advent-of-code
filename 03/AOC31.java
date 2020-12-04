import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AOC31 {

    public static void main(String[] args) {

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;

            int stevec = 0;
            int x = 0;
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                // Print the content on the console
                if (trenutnaVrstica.charAt(x % trenutnaVrstica.length()) == '#') {
                    stevec++;
                }

                x += 3;
            }

            System.out.println(stevec);
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println("NAPAKAAAA " + e.getMessage());
        }
    }
}
