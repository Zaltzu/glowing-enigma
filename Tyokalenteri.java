/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalenteri;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Työkalenteri, jossa kaikki toiminta
 * @author finja
 */
public class Tyokalenteri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner menu=new Scanner(System.in);
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
    }    
}
class AvaaTiedosto{
    public void avaa(String tiedostoNimi){
        File testaa=new File(tiedostoNimi);
            if (testaa.exists()){
                try {
                    Scanner tiedosto=new Scanner(new File(tiedostoNimi));
                } catch (FileNotFoundException ex) {
                    System.out.println("Tiedostoa ei löydy");
                    Logger.getLogger(AvaaTiedosto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println("Perustetaanko "+tiedostoNimi+ "K/E");
                Scanner lukija=new Scanner(System.in);
                String x=lukija.nextLine();
                if("K".equals(x)||"k".equals(x)){
                try {
                    PrintWriter tiedosto = new PrintWriter(new File(tiedostoNimi));
                } catch (FileNotFoundException ex) {
                    System.out.println("Tiedostoa ei voitu perustaa");
                    }
                }
            }
    }
         
}
