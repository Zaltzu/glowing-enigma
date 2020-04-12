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
 * Yksittäinen työ tai tehtävä
 * @author finja
 * Työkalenteriin kerätään kaikki työt
 * työn tunnus määrittää työn ja ajan sekä asiakkaan
 * tekijä määrittää tekijän
 * 
 */
public class Tyo implements Serializable{
    	private String tehtava;
	private int aika;
	private String tunnus; 
        private String tekijaID;
        private char tila;
	
    /**
     *
     * @param tehtava Tehtävän kuvaus
     * @param aika Työhon kuluva normiaika
     * @param tunnus Yksittäisen työn uniikki id, joka liitetään asiakkaaseen
     * @param tekijaID Tunnus, jolla selviä työntekijä (future ues)
     * @param tila Työntlia (A=avoin,K=kesken, V=valmis)
     */
    public Tyo(String tehtava, int aika, String tunnus, String tekijaID, char tila){
		this.tehtava=tehtava;
		this.aika=aika;
		this.tunnus=tunnus;
                this.tekijaID=tekijaID;
                this.tila=tila;
                
	}

    /**
     *
     * @param tehtava Mitä tehtävänä
     */
    public void asetaTehtavas(String tehtava){
		this.tehtava=tehtava;
	}

    /**
     *
     * @return tehtävän
     */
    public String annaTehtava() {
		return tehtava;
	}

    /**
     *
     * @param aika käytettävä aika
     */
    public void asetaAika(int aika) {
		this.aika=aika;
	}

    /**
     *
     * @return palauttaa ajan
     */
    public int annaAika() {
		return aika;
	}

    /**
     *
     * @param tunnus tyon uniikki tunnus
     */
    public void asetaTunnus(String tunnus) {
		this.tunnus=tunnus;
	}

    /**
     *
     * @return palauttaa uniikin tunnuksen
     */
    public String annaTunnus() {
		return tunnus;
	}

    /**
     *
     * @param tekijaID tyontekijän tunnus
     */
    public void asetaTekijaID(String tekijaID){
            this.tekijaID=tekijaID;
        }

    /**
     *
     * @return palauttaa tekijän tunnuksen
     */
    public String annaTekijaID(){
            return tekijaID;
        }
    /**
     * 
     * @param tila mika vaihe menossa
     */
    public void asetaTila(char tila){
        this.tila=tila;
    }
    /**
     * 
     * @return vaiheen
     */
    public char annaTila(){
        return tila;
    }
 
    @Override
    public String toString() {
            return "Tehtävä: "+tehtava+" "+"Varattu aika min: "+aika+" "+"Tila -> A=avoin,K=kesken,V=valmis: "+tila; 
    }
    public static void tyot(){
        String tiedosto="tyot.dat";
        ArrayList<Tyo> tyot=new ArrayList<>();
            String tunnus,tehtava,tekijaID;
            int aika;
            char tila;
            try (
            Scanner lukija=new Scanner(System.in);		// TODO Auto-generated method stub

		){
                try (
                        ObjectInputStream objRead=new ObjectInputStream(new FileInputStream(tiedosto));
                        ){
                        ArrayList<Tyo> readUsers=(ArrayList<Tyo>)objRead.readObject();
                        for (Tyo r:readUsers) {
                            tunnus=r.annaTunnus();
                            tehtava=r.annaTehtava();
                            aika=r.annaAika();
                            tila=r.annaTila();
                            tekijaID=r.annaTekijaID();
                            if(tunnus.isEmpty()) {
                                break;
                        }else {
                            tyot.add(r);
                        }
                        System.out.println(tunnus+" nimi: "+tehtava+", "+aika+"t, "+"tila: "+tila+"Tekijä: "+tekijaID);
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
                String time;
                do {
                    System.out.print("Anna tehtävä: ");
                    tehtava=lukija.nextLine();
                    System.out.print("Työn kestoaika (min): ");
                    time=lukija.nextLine(); 
                    if(time.equals("")){
                            time="0";}
                    aika=Integer.parseInt(time)+1;
                    System.out.print("Tekijän tunnus: ");
                    tekijaID=lukija.nextLine(); 
                    System.out.print("Anna tyon tunnus (9-lopettaa): ");
                    tunnus=lukija.nextLine();
                    System.out.print("Anna tila: ");
                    String apu=lukija.nextLine();
                    if(apu.equals("")){apu="0";}
                    tila=apu.charAt(0);
                    if (tunnus.equals("")){tunnus="9";}
                    loppu=Integer.parseInt(tunnus);
                    if(loppu!=9) {
                        Tyo user=new Tyo(tehtava,aika,tunnus,tekijaID,tila);
                        tyot.add(user);
                    }
                }while(loppu!=9);
                 lukija.close();

		try (
			ObjectOutputStream objKirjoita=new ObjectOutputStream(new FileOutputStream(tiedosto));
		){
			objKirjoita.writeObject(tyot);
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
                        List<Tyo> readUsers=(List<Tyo>)objRead.readObject();
                        int index=0;
                        for (Tyo r:readUsers) {
                            tehtava=r.annaTehtava();
                            aika=r.annaAika();
                            tunnus=r.annaTunnus();
                            tekijaID=r.annaTekijaID();
                            tila=r.annaTila();

                       System.out.println(tunnus+" nimi: "+tehtava+", "+aika+"t, "+"tila: "+tila+"Tekijä: "+tekijaID);
                            index++;
                        }
                    }
                    catch(IOException | ClassNotFoundException ex1) {
			System.out.println(ex1);
                    }
	}
    
    }
        
    
}
