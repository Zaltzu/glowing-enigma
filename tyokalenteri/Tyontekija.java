package tyokalenteri;

import java.io.Serializable;

/**
 * Työsuorittaja
 * @author finja
 */
public class Tyontekija extends Henkilo implements Serializable{
    private int tyoaika;
    private int oikeusluokka;
	
    /**
     *
     * @param tunnus Työntekijän tunnus
     * @param nimi työntekijän nimi
     * @param osoite työntekijän osoite
     * @param tyoaika työntekijän viikkotyöaika
     * @param oikeusluokka työntekijän oikeustaso
     */ 
    public Tyontekija (String tunnus, String nimi, String osoite, int tyoaika, int oikeusluokka) {
        super(tunnus,nimi,osoite);
        this.tyoaika=tyoaika;
        this.oikeusluokka=oikeusluokka;
	}

    /**
     *
     * @param tunnus työtekijän uniikki tunnus
     * @param nimi työntekijän nimi
     */
    public Tyontekija(String tunnus, String nimi){
        super(tunnus,nimi,"");
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
    public int annaOikeusluokka() {
		return oikeusluokka;
	}

    /**
     *
     * @param oikeusluokka asettaa oikeusluokan
     */
    public void asetaOikeusluokka(int oikeusluokka) {
		this.oikeusluokka=oikeusluokka;
	}
        @Override
        public String toString(){
            return "Tyontekijä: " + super.annaNimi()+" "+"Tunnus:"+ super.annaTunnus()+" "+ "Työaika: "+tyoaika+" "+"Oikeusluokka: "+oikeusluokka;
        }
    
}
