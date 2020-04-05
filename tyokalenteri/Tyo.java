package tyokalenteri;

import java.io.Serializable;


/**
 * Yksittäinen työ tai tehtävä
 * @author finja
 * Työkalenteriin kerätään kaikki työt
 * työn tunnus määrittää työn ja ajan sekä asiakkaan
 * tekijä määrittää tekijän
 * 
 */
public class Tyo extends Kategoria implements Serializable{
    	private String tehtava;
	private int aika;
	private String tunnus; 
        private String tekijaID;
        private char tila;
	
    /**
     *
     * @param koodi Kategorian tunnus
     * @param kuvaus Kategorian kuvaus
     * @param tehtava Tehtävän kuvaus
     * @param aika Työhon kuluva normiaika
     * @param tunnus Yksittäisen työn uniikki id, joka liitetään asiakkaaseen
     * @param tekijaID Tunnus, jolla selviä työntekijä (future ues)
     * @param tila Työntlia (A=avoin,K=kesken, V=valmis)
     */
    public Tyo(String koodi, String kuvaus, String tehtava, int aika, String tunnus, String tekijaID, char tila){
		super(koodi,kuvaus);
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
		return "Kategoria:" +super.annaKoodi()+" "+"Kuvaus: "+super.annaKuvaus()+" "+"Tehtävä: "+tehtava+" "+"Varattu aika min: "+aika+" "+"Tila -> A=avoin,K=kesken,V=valmis: "+tila; 
	}
    
}
