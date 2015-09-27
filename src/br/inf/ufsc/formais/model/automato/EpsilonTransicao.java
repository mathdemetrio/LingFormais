/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

import br.inf.ufsc.formais.model.Simbolo;

/**
 *
 * @author Diego
 */
public class EpsilonTransicao extends Transicao {

    public EpsilonTransicao(Estado estadoAtual, Estado proximoEstado) {
        super(estadoAtual, Simbolo.EPSILON, proximoEstado);
    }

    public EpsilonTransicao() {
        this.simboloEntrada = Simbolo.EPSILON;
    }

}
