/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.gramatica;

import java.util.Set;

/**
 *
 * @author Diego
 */
public class Gramatica {

    private Set<SimboloNaoTerminal> simbolosNaoTerminais;
    private Set<SimboloTerminal> simbolosTerminais;
    private Set<RegraProducao> regrasDeProducao;
    private SimboloNaoTerminal simboloInicial;

    public Gramatica(Set<SimboloNaoTerminal> simbolosNaoTerminais, Set<SimboloTerminal> simbolosTerminais, Set<RegraProducao> regrasDeProducao, SimboloNaoTerminal simboloInicial) {
        this.simbolosNaoTerminais = simbolosNaoTerminais;
        this.simbolosTerminais = simbolosTerminais;
        this.regrasDeProducao = regrasDeProducao;
        this.simboloInicial = simboloInicial;
    }

    public Set<SimboloNaoTerminal> getSimbolosNaoTerminais() {
        return simbolosNaoTerminais;
    }

    public void setSimbolosNaoTerminais(Set<SimboloNaoTerminal> simbolosNaoTerminais) {
        this.simbolosNaoTerminais = simbolosNaoTerminais;
    }

    public Set<SimboloTerminal> getSimbolosTerminais() {
        return simbolosTerminais;
    }

    public void setSimbolosTerminais(Set<SimboloTerminal> simbolosTerminais) {
        this.simbolosTerminais = simbolosTerminais;
    }

    public Set<RegraProducao> getRegrasDeProducao() {
        return regrasDeProducao;
    }

    public void setRegrasDeProducao(Set<RegraProducao> regrasDeProducao) {
        this.regrasDeProducao = regrasDeProducao;
    }

    public SimboloNaoTerminal getSimboloInicial() {
        return simboloInicial;
    }

    public void setSimboloInicial(SimboloNaoTerminal simboloInicial) {
        this.simboloInicial = simboloInicial;
    }

}
