/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculeMoyenneMatiere;


import javax.ejb.Stateless;

/**
 *
 * @author dmidma
 */
@Stateless
public class CalculeMoyenneMatiere implements CalculeMoyenneMatiereLocal{

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    /*
    @Override
    public double calculeMoyenneMatiereR(double noteDs, double noteTP, double noteExamen) {
        return noteDs * 0.2 + noteTP * 0.3 + noteExamen * 0.5;
    }
*/  
    public CalculeMoyenneMatiere() {
        
    }

    @Override
    public double calculeMoyenneMatiereL(double noteDs, double noteTP, double noteExamen) {
        return 95;
    }
}
