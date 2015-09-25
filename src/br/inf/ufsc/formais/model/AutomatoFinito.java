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
public class AutomatoFinito {

    private Set<Estado> estados;
    private Alfabeto alfabeto;
    private Set<Transicao> transicoes;
    private EstadoInicial estadoInicial;
    private Set<EstadoFinal> estadosAceitacao;

    public AutomatoFinito(Set<Estado> estados, Alfabeto alfabeto, Set<Transicao> transicoes, EstadoInicial estadoInicial, Set<EstadoFinal> estadosAceitacao) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.transicoes = transicoes;
        this.estadoInicial = estadoInicial;
        this.estadosAceitacao = estadosAceitacao;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Set<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public EstadoInicial getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(EstadoInicial estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Set<EstadoFinal> getEstadosAceitacao() {
        return estadosAceitacao;
    }

    public void setEstadosAceitacao(Set<EstadoFinal> estadosAceitacao) {
        this.estadosAceitacao = estadosAceitacao;
    }
}
