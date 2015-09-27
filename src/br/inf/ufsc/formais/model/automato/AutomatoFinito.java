/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

import br.inf.ufsc.formais.model.Alfabeto;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class AutomatoFinito {

    protected Set<Estado> estados;
    protected Alfabeto alfabeto;
    protected EstadoInicial estadoInicial;
    protected Set<EstadoFinal> estadosAceitacao;

    public AutomatoFinito(Set<Estado> estados, Alfabeto alfabeto, EstadoInicial estadoInicial, Set<EstadoFinal> estadosAceitacao) {
        this.estados = estados;
        this.alfabeto = alfabeto;
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
