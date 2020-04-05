package tyokalenteri;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.*;

/**
 * Työkalenteri, jossa kaikki toiminta
 * @author finja
 */
public class Tyokalenteri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner menu=new Scanner(System.in);
            LocalDate nyt=LocalDate.now();
            // Testataan loytyyko tiedosto
            System.out.println("Lisää asiakas=1");
            System.out.println("Näytä asiakas=2");
            System.out.println("Poista asiakas=3");
            System.out.println("Lisäätyöntekijä=4");
            System.out.println("Näytä työntekijä=5");
            System.out.println("Poista työntekijä=6");
            System.out.println("Lisää työ=7");
            System.out.println("Näytä työ=8");
            System.out.println("Poista työ=9");
            int X=menu.nextInt();
            
            switch(X){
                case 1:
                    ArrayList<String> asiakkaat=new ArrayList<>();
                    File asiakas = new File("asiakas.txt");
                    if(asiakas.createNewFile()){
                        System.out.println("Tiedosto perustettu: "+asiakkaat);
                    }else{
                        Scanner lukija = new Scanner(asiakas);
                        // luetaan asiakkaat ArrayListiin
                        while (lukija.hasNextLine()){
                            String data =lukija.nextLine();
                            asiakkaat.add(data);
                        }   
                        Scanner uusi=new Scanner(System.in);
                        System.out.print("Anna asiakkaan nimi: ");
                        String nimi = uusi.nextLine();
                        System.out.print("anna tunnus: ");
                        String tunnus = uusi.nextLine();
                        System.out.print("Anna osoite: ");
                        String osoite = uusi.nextLine();
                        System.out.print("Anna puhelinnumero: ");
                        String puhnro = uusi.nextLine();
                        Asiakas uusias = new Asiakas(tunnus,nimi,osoite,puhnro);
                        asiakkaat.add(uusias.toString());
                        FileWriter kirjoittaja=new FileWriter(asiakas);
                        for (String as : asiakkaat) {
                            System.out.println(as);
                            kirjoittaja.write(as);
                            }
                                }
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
            }
            
            try (Scanner tiedostonLukija = new Scanner(new File("tyot.txt"))) {
                
                ArrayList<Tyo> tyot=new ArrayList<>();
                // luetaan tiedostoja kunnes kaikki rivit on luettu
                while (tiedostonLukija.hasNextLine()) {
                    // luetaan yksi rivi
                    String tyo = tiedostonLukija.nextLine();
                    // tulostetaan luettu rivi
                    System.out.println(tyo);
                }
            } catch (Exception e) {
                System.out.println("Virhe: " + e.getMessage());
                Scanner kirjoita = new Scanner(System.in);
                System.out.println("Perustetaanko tiedosto tyot K/E?");
                String x=kirjoita.nextLine();
                if(x.equals("K")||x.equals("k")){
                    try {
                        PrintWriter tiedosto = new PrintWriter(new File("tyot.txt"));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Tyokalenteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else {
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tyokalenteri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}

