package tyokalenteri;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Asiakkaan, sopijan perustiedot
 * @author finja
 */
public class Asiakas implements Serializable{
	private String tunnus;
        private String nimi;
        private String osoite;
        private String puhnro;
	
    /**
     *
     * @param tunnus Uniikkitunnus 
     * @param nimi Nimi
     * @param osoite Osoite
     * @param puhnro Puhelinnumero
     */
    public Asiakas(String tunnus, String nimi, String osoite, String puhnro) {
	this.tunnus=tunnus;
        this.nimi=nimi;
        this.osoite=osoite;
        this.puhnro=puhnro;
    }
    public void asetaTunnus(String tunnus){
        this.tunnus=tunnus;
    }
    public String annaTunnus(){
        return tunnus;
    }
    public void asetaNimi(String nimi){
        this.nimi=nimi;
    }
    public String annaNimi(){
        return nimi;
    }
    public void asetaOsoite(String osoite){
        this.osoite=osoite;
    }
    public String annaOsoite(){
        return osoite;
    }
        

    /**
     *
     * @return puhelin numero
     */
    public String annaPuhnro() {
		return puhnro;
	}

    /**
     *
     * @param puhnro puhelinnumero
     */
    public void asetaPuhnro(String puhnro) {
		this.puhnro=puhnro;
	}
        @Override
	public String toString() {
		return "Asiakasnumero: "+ tunnus + ": "+nimi+"Osoite: "+osoite+" Puhelinnumero: "+puhnro;
	}
    public static void asiakkaat(){
        String tiedosto="asiakkaat.dat";  

        ArrayList<Asiakas> kayttajat=new ArrayList<>();
        String tunnus,nimi,osoite,puhnro;
        try (
            Scanner lukija=new Scanner(System.in);		// TODO Auto-generated method stub

		){
                try (
                        ObjectInputStream objRead=new ObjectInputStream(new FileInputStream(tiedosto));
                        ){
                        ArrayList<Asiakas> readUsers=(ArrayList<Asiakas>)objRead.readObject();
                        for (Asiakas r:readUsers) {
                            tunnus=r.annaTunnus();
                            nimi=r.annaNimi();
                            osoite=r.annaOsoite();
                            puhnro=r.annaPuhnro();
                            if(nimi.isEmpty()) {
                                break;
                        }else {
                            kayttajat.add(r);
                        }
                        System.out.println(tunnus+" nimi: "+nimi+", "+osoite+", "+puhnro);
                    }
                }
                catch(IOException | ClassNotFoundException ex) {
                    System.out.println(ex);
                }
                /**
                 * Olion tietojen kirjoittaminen
                 */
                // Testataan syötteellä
 //               String nimi;
                int loppu;
                do {
                    System.out.print("Anna nimi: ");
                    nimi=lukija.nextLine();
                    System.out.print("Anna osoite: ");
                    osoite=lukija.nextLine(); 
                    System.out.print("Anna puhelinnumero: ");
                    puhnro=lukija.nextLine(); 
                    System.out.print("Anna tunnus (9-lopettaa): ");
                    tunnus=lukija.nextLine();
                    if (tunnus.equals("")){tunnus="9";}
                    loppu=Integer.parseInt(tunnus);                
                    if(loppu!=9) {
                        Asiakas user=new Asiakas(tunnus,nimi,osoite,puhnro);
                        kayttajat.add(user);
                    }
                }while(loppu!=9);

 //                lukija.close();

		try (
			ObjectOutputStream objKirjoita=new ObjectOutputStream(new FileOutputStream(tiedosto));
		){
			objKirjoita.writeObject(kayttajat);
			objKirjoita.flush();
		}
		catch(IOException ex1) {
			System.out.println(ex1);
		}
		
		

			/**
			 * Olion tietojen lukeminen
			 */
		try (
                    ObjectInputStream objRead=new ObjectInputStream(new FileInputStream(tiedosto));
                    ){
                        List<Asiakas> readUsers=(List<Asiakas>)objRead.readObject();
                        int index=0;
                        for (Asiakas r:readUsers) {
                            tunnus=r.annaTunnus();
                            nimi=r.annaNimi();
                            osoite=r.annaOsoite();
                            puhnro=r.annaPuhnro();

                            System.out.println("indeksi: "+index+" tunnus: "+tunnus+" nimi: "+nimi+" ,"+osoite+", Puhelinnumero: "+puhnro);
                            index++;
                        }
                    }
                    catch(IOException | ClassNotFoundException ex1) {
			System.out.println(ex1);
                    }
	}
    }
}