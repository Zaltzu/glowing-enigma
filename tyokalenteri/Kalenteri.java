package tyokalenteri;
import java.time.*;

/**
 * Kalenteri, johon kerätään työt
 * @author finja
 * Työt tähän kalenteriin. Tunnuksella löytyvät detaljit
 */
public class Kalenteri{
    String id;
    LocalDate paiva;
    LocalTime aloitusAika;
    LocalTime lopetusAika;
    
    /**
     *
     * @param id Työn tunnus
     * @param paiva Työn suunniteltu päivä
     * @param aloitusAika Työn suunniteltu aloitusaika: hh:mm
     * @param lopetusAika Työn suunniteltu lopetusaika: hh:mm
     */
    public Kalenteri(String id, LocalDate paiva, LocalTime aloitusAika, LocalTime lopetusAika){
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
    public void asetaPaiva(LocalDate paiva){
        this.paiva=paiva;
    }

    /**
     *
     * @return
     */
    public LocalDate annaPaiva(){
        return paiva;
    }

    /**
     *
     * @param aloitusAika
     */
    public void asetaAloitusAika(LocalTime aloitusAika){
        this.aloitusAika=aloitusAika;
    }

    /**
     *
     * @return
     */
    public LocalTime annaAloitusAika(){
        return aloitusAika;
    }

    /**
     *
     * @param lopetusAika
     */
    public void asetaLopetueAika(LocalTime lopetusAika){
        this.lopetusAika=lopetusAika;
    }
    @Override
    public String toString(){
        return id+","+paiva+","+aloitusAika+","+lopetusAika;
     }
    
}
