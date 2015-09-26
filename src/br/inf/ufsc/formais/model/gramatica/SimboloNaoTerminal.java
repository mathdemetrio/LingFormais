/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.gramatica;

import br.inf.ufsc.formais.model.Simbolo;

/**
 *
 * @author Diego
 */
public class SimboloNaoTerminal extends Simbolo {
    
    public SimboloNaoTerminal(String referencia) {
        super(referencia);
    }

    @Override
    public void setReferencia(String referencia) {
        super.setReferencia(referencia.toUpperCase());
    }
}
