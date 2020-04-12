package tyokalenteri;


import java.util.Scanner;

/**
 *
 * @author finja
 */
public class Tyokalenteri {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
               int x=1;
              String valinta;
 //               while(x!=0){

                Scanner menu = new Scanner(System.in);
                   System.out.println("Asiakkaiden käsittely =1");
                   System.out.println("Töiden käsittely=2");
                   System.out.println("Työntekijän tietojen käsittely=3");
                   System.out.println("Kalenteritoiminnot=4");
                   System.out.println("Lopetus =0");
                   System.out.println();
                   System.out.print("Anna valinta: ");
                   valinta=menu.nextLine();   
                   System.out.println("valintasi "+valinta);
                   x=Integer.parseInt(valinta);
                if(x<0||x>4){x=0;}
                if(x!=0){
                   switch(x){
                        case 0:
                            break;
                        case 1:
                            Asiakas.asiakkaat();
                            break;
                        case 2:
                            Tyo.tyot();
                            break;
                        case 3:
                            Tyontekija.muuta();
                            break;                        
                           
                   }
                }
            
              
  
    }
}


            
            
        
            
            
       



