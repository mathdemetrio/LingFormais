/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

import br.inf.ufsc.formais.model.Simbolo;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class TransicaoNaoDeterministica extends Transicao {

    private Set<Estado> proximosEstados;

    public TransicaoNaoDeterministica(Estado estadoAtual, Simbolo simboloEntrada, Set<Estado> proximosEstados) {
        this.estadoAtual = estadoAtual;
        this.simboloEntrada = simboloEntrada;
        this.proximosEstados = proximosEstados;
    }

    @Override
    public Estado getProximoEstado() {
        return null;
    }

    @Override
    public void setProximoEstado(Estado proximoEstado) {
        // NÃO IMPLEMENTADO
    }

    public Set<Estado> getProximosEstados() {
        return proximosEstados;
    }

    public void setProximosEstados(Set<Estado> proximosEstados) {
        this.proximosEstados = proximosEstados;
    }

}
