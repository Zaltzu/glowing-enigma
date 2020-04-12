package tyokalenteri;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.Serializable;

/**
 * Työsuorittaja
 * @author finja
 */
public class Tyontekija implements Serializable{
    private String tunnus;
    private String nimi;
    private String osoite;
    private String puhnro;
    private int tyoaika;
    private String oikeusluokka;
	
    /**
     *
     * @param tunnus Työntekijän tunnus
     * @param nimi työntekijän nimi
     * @param osoite työntekijän osoite
     * @param tyoaika työntekijän viikkotyöaika
     * @param oikeusluokka työntekijän oikeustaso
     */ 
    public Tyontekija (String tunnus, String nimi, String osoite, String puhnro, int tyoaika, String oikeusluokka) {
        this.tunnus=tunnus;
        this.nimi=nimi;
        this.osoite=osoite;
        this.puhnro=puhnro;
        this.tyoaika=tyoaika;
        this.oikeusluokka=oikeusluokka;
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
    public void asetaPuhnro(String puhnro){
        this.puhnro=puhnro;
    }
    public String annaPuhnro(){
        return puhnro;
    }
            
    /**
     *
     * @return palauttaa työajan
     */
    public int annaTyoaika() {
		return tyoaika;
	}

    /**
     *
     * @param tyoaika viikkotyöaika
     */
    public void asetaTyoaika(int tyoaika) {
		this.tyoaika=tyoaika;
	}

    /**
     *
     * @return palauttaa oikeusluokan
     */
    public String annaOikeusluokka() {
		return oikeusluokka;
	}

    /**
     *
     * @param oikeusluokka asettaa oikeusluokan
     */
    public void asetaOikeusluokka(String oikeusluokka) {
		this.oikeusluokka=oikeusluokka;
	}
        @Override
        public String toString(){
            return "Tyontekijä: " + annaNimi()+" "+"Tunnus:"+ annaTunnus()+" "+ "Työaika: "+tyoaika+" "+"Oikeusluokka: "+oikeusluokka;
        }
    	public static void muuta() {
		
		Scanner lukija= new Scanner(System.in);
		String tunnus,nimi,osoite,puhNro,oikeusluokka;
                int tyoaika;
		String tiedosto="tyontekjat.dat";
		ArrayList<Tyontekija> kayttajat= new ArrayList<>();
		try (
		ObjectInputStream objRead=new ObjectInputStream(new FileInputStream(tiedosto));
		){
		ArrayList<Tyontekija> readUsers=(ArrayList<Tyontekija>)objRead.readObject();
		for (Tyontekija r:readUsers) {
			tunnus=r.annaTunnus();
			nimi=r.annaNimi();
			osoite=r.annaOsoite();
			puhNro=r.annaPuhnro();
			tyoaika=r.annaTyoaika();
                        oikeusluokka=r.annaOikeusluokka();
			if(nimi.isEmpty()) {
				break;
			}else {
				kayttajat.add(r);
			}
			System.out.println(tunnus+" nimi: "+nimi+", "+osoite+", "+puhNro+"viikotyöaika t: "+ tyoaika+" Oikeustaso: "+oikeusluokka);
		}
		}
		catch(IOException | ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		/**
		 * Olion tietojen kirjoittaminen
		 */
		// Testataan syötteellä

		int age;
                String apu;
		do {
		System.out.print("Anna nimi: ");
		nimi=lukija.nextLine();
		System.out.print("Anna tunnus(0 lopettaa): ");
		tunnus=lukija.nextLine();
		if (tunnus.equals("")) {tunnus="0";}
		age=Integer.parseInt(tunnus);

		System.out.print("Anna osoite: ");
		osoite=lukija.nextLine();
		System.out.print("Anna puhelinnumero: ");
		puhNro=lukija.nextLine();
                System.out.print("Anna viikkotyöaika: ");
                apu =lukija.nextLine();
                if("".equals(apu)){apu="0";}
                tyoaika=Integer.parseInt(apu);
                  

                System.out.print("Annan oikeusluokka: ");
                oikeusluokka=lukija.nextLine();
		System.out.println();
		if(age!=0) {
			Tyontekija user=new Tyontekija(tunnus,nimi,osoite, puhNro,tyoaika,oikeusluokka);
			kayttajat.add(user);
		}

		}while(tyoaika!=0);
		lukija.close();

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
			List<Tyontekija> readUsers=(List<Tyontekija>)objRead.readObject();	
			for (Tyontekija r:readUsers) {
				tunnus=r.annaTunnus();
				nimi=r.annaNimi();
				osoite=r.annaOsoite();
				puhNro=r.annaPuhnro();

			System.out.println(tunnus+" nimi: "+nimi+" ,"+osoite+", Puhelinnumero: "+puhNro);
			}
			}
			catch(IOException | ClassNotFoundException ex1) {
				System.out.println(ex1);
			}
			
	}
}
