/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.gramatica;

/**
 *
 * @author Diego
 */
public class Cadeia {

    private SimboloTerminal simboloTerminal;
    private SimboloNaoTerminal simboloNaoTerminal;

    public Cadeia(SimboloTerminal simboloTerminal, SimboloNaoTerminal simboloNaoTerminal) {
        this.simboloTerminal = simboloTerminal;
        this.simboloNaoTerminal = simboloNaoTerminal;
    }

    public Cadeia(SimboloTerminal simboloTerminal) {
        this.simboloTerminal = simboloTerminal;
    }

    public boolean isTerminal() {
        return simboloNaoTerminal == null;
    }

    public SimboloTerminal getSimboloTerminal() {
        return simboloTerminal;
    }

    public void setSimboloTerminal(SimboloTerminal simboloTerminal) {
        this.simboloTerminal = simboloTerminal;
    }

    public SimboloNaoTerminal getSimboloNaoTerminal() {
        return simboloNaoTerminal;
    }

    public void setSimboloNaoTerminal(SimboloNaoTerminal simboloNaoTerminal) {
        this.simboloNaoTerminal = simboloNaoTerminal;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(simboloTerminal.getReferencia());
        if(simboloNaoTerminal != null) {
            out.append(simboloNaoTerminal.getReferencia());
        }
        
        return out.toString();
    }

}
