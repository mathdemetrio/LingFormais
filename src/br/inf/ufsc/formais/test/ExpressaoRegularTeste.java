/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.test;

import br.inf.ufsc.formais.model.Simbolo;
import br.inf.ufsc.formais.model.er.ExpressaoRegular;

/**
 *
 * @author Diego
 */
public class ExpressaoRegularTeste {

    public void runTest() {
        ExpressaoRegular er = new ExpressaoRegular();
        Simbolo a = new Simbolo("a");
        Simbolo b = new Simbolo("b");
        
        er.concatenar(a);
        er.concatenarSimboloFecho(a);
        er.concatenar(b);
        
        System.out.println(er.toString());
    }

}
