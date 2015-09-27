/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model;

import br.inf.ufsc.formais.model.automato.Estado;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class Alfabeto {
    private Set<Simbolo> simbolos;

    public Alfabeto(Set<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

    public Set<Simbolo> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(Set<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

    @Override
    public String toString() {
         StringBuilder out = new StringBuilder("A = (");

        for (Simbolo simb : simbolos) {
            out.append(simb.getReferencia()).append(", ");
        }
        out.delete(out.length() - 2, out.length());
        out.append("}\n");
        
        return out.toString();
    }
    
}
