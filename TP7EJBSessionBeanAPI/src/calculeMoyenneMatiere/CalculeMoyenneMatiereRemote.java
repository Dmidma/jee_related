/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculeMoyenneMatiere;

import javax.ejb.Remote;

/**
 *
 * @author dmidma
 */
@Remote
public interface CalculeMoyenneMatiereRemote {
    public double calculeMoyenneMatiereR (double noteDs, double noteTP, double noteExamen);
}
