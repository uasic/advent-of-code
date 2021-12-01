import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AOC41 {

    public static void main(String[] args) {

        int steviloVeljavnihPotnihListov = 0;

        try {
            FileInputStream datoteka = new FileInputStream("input.txt");
            BufferedReader bralec = new BufferedReader(new InputStreamReader(datoteka));
            
            String trenutnaVrstica;

            Passport passport = new Passport();
    
            // Read File Line By Line
            while ((trenutnaVrstica = bralec.readLine()) != null)   {

                if (trenutnaVrstica.isEmpty()) {
                    // najprej preveri ali je `Passport` veljaven
                    if (passport.isValid()) {
                        // povecaj stevec veljavnih potnih listov
                        steviloVeljavnihPotnihListov++;
                    }

                    // resetiraj `Passport`
                    passport = new Passport();

                    continue;
                }

                passport.obkljukaj(trenutnaVrstica);
                
            }

            if (passport.aliJeBilNastavljen()) {
                if (passport.isValid()) {
                    // povecaj stevec veljavnih potnih listov
                    steviloVeljavnihPotnihListov++;
                }
            }
    
            // Close the input stream
            datoteka.close();
        } catch (Exception e) {
            System.err.println("NAPAKA " + e.getMessage());
        }

        System.out.println(steviloVeljavnihPotnihListov);

        // Objektno programiranje
        Marker odUrske = new Marker();
        Marker odGregorja = new Marker();

        odUrske.porabi(95);
        odGregorja.porabi(10);

        System.out.println(odUrske.aliRabimNovega() + ", " + odGregorja.aliRabimNovega());

    }

    public static class Marker {
        int kolicinaPolnila = 100;

        public boolean aliRabimNovega() {
            return kolicinaPolnila < 10;
        }

        public void porabi(int koliko) {
            kolicinaPolnila -= koliko;
        }
    }

    public static class Passport {
        
        int byr; // (Birth Year)
        int iyr; // (Issue Year)
        int eyr; // (Expiration Year)
        int hgt; // (Height)
        String unit;
        String hcl; // (Hair Color)
        String ecl; // (Eye Color)
        String pid; // (Passport ID)
        String cid; // (Country ID)

        public boolean isValid() {
            return isByrValid() && isEclValid() 
                && isEyrValid() && isHclValid() 
                && isHgtValid() && isIyrValid()
                && isPidValid() && isCidValid();
        }

        private boolean isCidValid() {
            return true;
        }

        private boolean isPidValid() {
            if (pid == null) return false;
            try {
                Integer.parseInt(pid);
                return pid.length() == 9;
            } catch (Exception e) {}
            return false;
        }

        private boolean isIyrValid() {
            return iyr >= 2010 && iyr <= 2020;
        }

        private boolean isHgtValid() {
            if (unit == null) return false;
            if (unit.equals("cm")) {
                return hgt >= 150 && hgt <= 193;
            } else {
                return hgt >= 59 && hgt <= 76;
            }
        }

        private boolean isHclValid() {
            if (hcl == null) return false;
            if (hcl.length() == 7) {
                for (int i = 1; i < hcl.length(); i++) {
                    char c = hcl.charAt(i);
                    if (!(c >= 48 && c < 58 || c > 64 && c <= 90 || c > 96 && c <= 122)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        private boolean isEyrValid() {
            return eyr >= 2020 && eyr <= 2030;
        }

        private boolean isEclValid() {
            if (ecl == null) return false;
            String[] validEcls = new String[] {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
            for (String string : validEcls) {
                if (string.equals(ecl)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isByrValid() {
            return byr >= 1920 && byr <= 2002;
        }

        public boolean aliJeBilNastavljen() {
            return byr != 0 || ecl != null
            || eyr != 0 || hcl != null
            || hgt != 0 || iyr != 0
            || pid != null || cid != null;
        }

        public void obkljukaj(String vrstica) {
            // vrstica = "ecl:#eef340 eyr:2023 hcl:#c0946f pid:244684338 iyr:2020 cid:57 byr:1969 hgt:152cm"

            // polja = ["ecl:#eef340", "eyr:2023", ...]
            String[] polja = vrstica.split(" ");

            for (int i = 0; i < polja.length; i++) {
                String[] vrednosti = polja[i].split(":");
                if (vrednosti[0].equals("byr")) {
                    try {
                        byr = Integer.parseInt(vrednosti[1]);
                    } catch (Exception e) {}
                } else if (vrednosti[0].equals("iyr")) {
                    try {
                        iyr = Integer.parseInt(vrednosti[1]);
                    } catch (Exception e) {}
                } else if (vrednosti[0].equals("eyr")) {
                    try {
                        eyr = Integer.parseInt(vrednosti[1]);
                    } catch (Exception e) {}
                } else if (vrednosti[0].equals("hgt")) {
                    try {
                        String stevilka = vrednosti[1].substring(0, vrednosti[1].length() - 2);
                        unit = vrednosti[1].substring(vrednosti[1].length() - 2, vrednosti[1].length());
                        hgt = Integer.parseInt(stevilka);
                    } catch (Exception e) {}
                } else if (vrednosti[0].equals("hcl")) {
                    hcl = vrednosti[1];
                } else if (vrednosti[0].equals("ecl")) {
                    ecl = vrednosti[1];
                } else if (vrednosti[0].equals("pid")) {
                    pid = vrednosti[1];
                } else if (vrednosti[0].equals("cid")) {
                    cid = vrednosti[1];
                }
            }
        }

    }
}
