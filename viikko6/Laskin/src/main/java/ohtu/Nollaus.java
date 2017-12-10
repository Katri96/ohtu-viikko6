/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;
import javax.swing.JTextField;
/**
 *
 * @author mkatri
 */
public class Nollaus implements Operaatio {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    public int viimeisin;

    public Nollaus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {}
        viimeisin = sovellus.tulos(); 
        sovellus.nollaa();
        
        int laskunTulos = sovellus.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
    }
    
    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + viimeisin);
        sovellus.set(viimeisin);
    }
}
