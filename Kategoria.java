/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalenteri;

/**
 * Kategoriat joihin tyot jaotellaan
 * @author finja
 */
public class Kategoria {
	private String koodi;
	private String kuvaus;
	
    /**
     *
     * @param koodi kategorian koodi
     * @param kuvaus Kategorian kuvus
     */
    public Kategoria(String koodi, String kuvaus) {
		this.koodi=koodi;
		this.kuvaus=kuvaus;
	}

    /**
     *
     * @return koodin
     */
    public String annaKoodi() {
		return koodi;
	}

    /**
     *
     * @param koodi asetaa koodin
     */
    public void asetaKoodi(String koodi) {
		this.koodi=koodi;
	}

    /**
     *
     * @return kuvauksen
     */
    public String annaKuvaus() {
		return kuvaus;
	}

    /**
     *
     * @param kuvaus asettaa kuvauksen
     */
    public void asetaKuvaus(String kuvaus) {
		this.kuvaus=kuvaus;
	}
        @Override
        public String toString() {
		return "Kategoria: "+koodi+": "+kuvaus; 
	}
}
