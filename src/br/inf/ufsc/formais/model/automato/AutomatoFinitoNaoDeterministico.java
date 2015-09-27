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
public class AutomatoFinitoNaoDeterministico extends AutomatoFinito {

    private Set<TransicaoNaoDeterministica> transicoes;

    public AutomatoFinitoNaoDeterministico(Set<TransicaoNaoDeterministica> transicoes,
            Set<Estado> estados, Alfabeto alfabeto, EstadoInicial estadoInicial,
            Set<EstadoFinal> estadosAceitacao) {
        super(estados, alfabeto, estadoInicial, estadosAceitacao);
        this.transicoes = transicoes;
    }

    public Set<TransicaoNaoDeterministica> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<TransicaoNaoDeterministica> transicoes) {
        this.transicoes = transicoes;
    }

}
