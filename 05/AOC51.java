import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AOC51 {

    public static void main(String[] args) {

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;

            Seat maxSedez = null;
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {
                // Preverimo, ali smo v spremenljivko `maxSedez` ze kaj shranili
                if (maxSedez == null) {
                    // Ce nismo, nastavimo kar trenutni sedez
                    // namig: to se zgodi, ko prvic pridemo v zanko
                    maxSedez = new Seat(trenutnaVrstica);
                } else {
                    Seat trenutniSedez = new Seat(trenutnaVrstica);

                    // ce je id trenutnega sedeza vecji od id-ja
                    // do sedaj naj najvecjega sedeza
                    if (trenutniSedez.getId() > maxSedez.getId()) {
                        // si zapomni ta sedez
                        maxSedez = trenutniSedez;
                    }
                }

            }

            // izpisi id sedeza z najvisjim id-jem
            System.out.println(maxSedez.getId());
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println("NAPAKA " + e.getMessage());
        }
    }
    
    // nacrt za kreiranje objektov `Seat`
    public static class Seat {
    
        // private -> do spremenljivke lahko dostopamo samo znotraj razreda
        // final -> vrednosti ne moremo spreminjati (uporabno za konstante, npr. pi, e ...)
        // static -> to lastnost si delijo vsi objekti tega razreda (npm markerji imajo isto znamko)
        private final static int numRows = 128;
        private final static int numColumns = 8;

        // privatni lastnosti objekta
        private int row;
        private int column;

        // Konstruktor objekta `Seat`, ki sprejme String (predpostavis lahko, da je dolzine 10)
        // npr.: FBFBBFFRLR
        public Seat(String sequence) {
            // metoda `substring` vrne *podniz* niza (npr. "abcde".substring(1,3) -> "bc")
            setRow(sequence.substring(0, 7));
            setColumn(sequence.substring(7, 10));
        }

        // Prejme String dolzine 7
        // npr.: FBFBBFF
        private void setRow(String rs) {
            // implementacija *binarnega iskanja*. Premikamo zgornjo
            // in spodnjo mejo glede na trenutni znak v nizu `rs` na mestu `i`
            int s = 0;
            int z = numRows;

            // zanka `for` -> "sprehodi" se cez niz `rs` in naredi ...
            for (int i = 0; i < rs.length(); i++) {
                if (rs.charAt(i) == 'F') {
                    z = (s + z) / 2;
                    row = z; // !POMEMBNO! : dejansko nastavi vrednost lastnosti `row`
                } else {
                    s = (s + z) / 2;
                    row = s; // !POMEMBNO! : -||-
                }
            }
        }
        
        // Prejme String dolzine 3
        // npr.: RLR
        private void setColumn(String cs) {
            int s = 0;
            int z = numColumns;
            for (int i = 0; i < cs.length(); i++) {
                if (cs.charAt(i) == 'L') {
                    z = (s + z) / 2;
                    column = z;
                } else {
                    s = (s + z) / 2;
                    column = s;
                }
            }
        }

        // izracunaj in vrni id sedeza
        public int getId() {
            return row * 8 + column;
        }
    }
}
