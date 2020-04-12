package tyokalenteri;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Kalenteri, johon kerätään työt
 * @author finja
 * Työt tähän kalenteriin. Tunnuksella löytyvät detaljit
 */
public class Kalenteri implements Serializable{
    String id;
    private int paiva,aloitusAika,lopetusAika;

    
    /**
     *
     * @param id Työn tunnus
     * @param paiva Työn suunniteltu päivä
     * @param aloitusAika Työn suunniteltu aloitusaika: hh:mm
     * @param lopetusAika Työn suunniteltu lopetusaika: hh:mm
     */
    public Kalenteri(String id, int paiva, int aloitusAika, int lopetusAika){
        this.id=id;
        this.paiva=paiva;
        this.aloitusAika=aloitusAika;
        this.lopetusAika=lopetusAika;
    }

    /**
     *
     * @param id 
     */
    public void asetaId(String id){
        this.id=id;
    }

    /**
     *
     * @return
     */
    public String annaId(){
        return id;
    }

    /**
     *
     * @param paiva
     */
    public void asetaPaiva(int paiva){
        this.paiva=paiva;
    }

    /**
     *
     * @return
     */
    public int annaPaiva(){
        return paiva;
    }

    /**
     *
     * @param aloitusAika
     */
    public void asetaAloitusAika(int aloitusAika){
        this.aloitusAika=aloitusAika;
    }

    /**
     *
     * @return
     */
    public int annaAloitusAika(){
        return aloitusAika;
    }

    /**
     *
     * @param lopetusAika
     */
    public void asetaLopetueAika(int lopetusAika){
        this.lopetusAika=lopetusAika;
    }
    public int annaLopetusAika(){
        return lopetusAika;
    }
    @Override
    public String toString(){
        return id+","+paiva+","+aloitusAika+","+lopetusAika;
     }
    public static void kalenteri(){
        String tiedosto="kalenteri.dat";  
        Calendar kalent=Calendar.getInstance();
        Date nyt = kalent.getTime();
        System.out.println(nyt);
        ArrayList<Kalenteri> kayttajat=new ArrayList<>();
        String id;
        int paiva,aloitusAika,lopetusAika;
        try (
            Scanner lukija=new Scanner(System.in);		// TODO Auto-generated method stub

		){
                try (
                        ObjectInputStream objRead=new ObjectInputStream(new FileInputStream(tiedosto));
                        ){
                        ArrayList<Kalenteri> readUsers=(ArrayList<Kalenteri>)objRead.readObject();
                        for (Kalenteri r:readUsers) {
                            id=r.annaId();
                            paiva=r.annaPaiva();
                            aloitusAika=r.annaAloitusAika();
                            lopetusAika=r.annaLopetusAika();
                            if(id.equals("")){
                                break;
                            }

                            kayttajat.add(r);
                        System.out.println("työn tunnus;"+id+" paiva: "+paiva+", aloiusaika: "+aloitusAika+", lopetusaika: "+lopetusAika);
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
                String pvm,apuPvm,apuKk, apuv;
                do {
                    System.out.print("Anna tehtävän päivämäärä (vvkkpp): ");
                    pvm=lukija.nextLine();
                    apuPvm=pvm.substring(4, pvm.length());
                    apuKk=pvm.substring(2, 4);
                    apuv=pvm.substring(0,2);
                    System.out.print("Anna aloitusaika (hh:mm) ");
                    paiva=Integer.parseInt(apuPvm+apuKk+apuv);
                    aloitusAika= lukija.nextInt();
                    lopetusAika=aloitusAika+60;
                   
                    System.out.print("Anna tunnus (9-lopettaa): ");
                    id=lukija.nextLine();
                    if (id.equals("")){id="9";}
                    loppu=Integer.parseInt(id);                
                    if(loppu!=9) {
                        Kalenteri user=new Kalenteri(id,paiva,aloitusAika,lopetusAika);
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
                        List<Kalenteri> readUsers=(List<Kalenteri>)objRead.readObject();
                        int index=0;
                        for (Kalenteri r:readUsers) {
                            id=r.annaId();
                            paiva=r.annaPaiva();
                            aloitusAika=r.annaAloitusAika();
                            lopetusAika=r.annaLopetusAika();

                            System.out.println("indeksi: "+index+" ID: "+id+" päivä: "+paiva+" aloitusaika"+aloitusAika+", valmis: "+lopetusAika);
                            index++;
                        }
                    }
                    catch(IOException | ClassNotFoundException ex1) {
			System.out.println(ex1);
                    }
	}
    } 
  
}
