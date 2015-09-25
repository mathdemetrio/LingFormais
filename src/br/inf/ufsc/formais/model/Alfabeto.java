/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model;

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
}
