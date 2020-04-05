/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalenteri;

/**
 * Äitiluokka asiakas ja työntekijäluokalle
 * @author finja
 */
public class Henkilo {
    private String nimi, osoite, tunnus;
	
    /**
     *
     * @param tunnus Henkilön uniikki tunnus
     * @param nimi Henkilon nimi
     * @param osoite Henkiön osoite
     */
    public Henkilo(String tunnus, String nimi, String osoite) {
        this.tunnus=tunnus;
        this.nimi=nimi;
        this.osoite=osoite;
	}

    /**
     *
     * @param tunnus uniikki tunnus
     */
    public void asetaTunnus(String tunnus) {
		this.tunnus=tunnus;
	}

    /**
     *
     * @return tunnus
     */
    public String annaTunnus() {
		return tunnus;
	}

    /**
     *
     * @param nimi nimi
     */
    public void asetaNimi(String nimi){
		this.nimi=nimi;
	}

    /**
     *
     * @return nimi
     */
    public String annaNimi() {
		return nimi;
	}

    /**
     *
     * @param osoite osoite
     */
    public void asetaOsoite(String osoite) {
		this.osoite=osoite;
	}

    /**
     *
     * @return osoite
     */
    public String annaOsoite() {
		return osoite;
	}
    @Override
    public String toString(){
        return "Henkio "+tunnus+" "+nimi+" "+","+osoite;
    }
}
