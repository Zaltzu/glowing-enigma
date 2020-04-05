package tyokalenteri;

import java.io.Serializable;

/**
 * Asiakkaan, sopijan perustiedot
 * @author finja
 */
public class Asiakas implements Serializable{
	private String puhnro;
	
    /**
     *
     * @param tunnus Uniikkitunnus 
     * @param nimi Nimi
     * @param osoite Osoite
     * @param puhnro Puhelinnumero
     */
    public Asiakas(String tunnus, String nimi, String osoite, String puhnro) {
		super();
		this.puhnro=puhnro;
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
		return "Asiakasnumero: "+ super.toString()+"Puhelinnumero: "+puhnro;
	}
}