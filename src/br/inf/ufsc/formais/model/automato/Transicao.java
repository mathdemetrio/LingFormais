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
public class Transicao {

    private Estado estadoAtual;
    private Simbolo simboloEntrada;
    private Estado proximoEstado;

    public Transicao(Estado estadoAtual, Simbolo simboloEntrada, Estado proximoEstado) {
        this.estadoAtual = estadoAtual;
        this.simboloEntrada = simboloEntrada;
        this.proximoEstado = proximoEstado;
    }

    public Estado getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(Estado estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public Simbolo getSimboloEntrada() {
        return simboloEntrada;
    }

    public void setSimboloEntrada(Simbolo simboloEntrada) {
        this.simboloEntrada = simboloEntrada;
    }

    public Estado getProximoEstado() {
        return proximoEstado;
    }

    public void setProximoEstado(Estado proximoEstado) {
        this.proximoEstado = proximoEstado;
    }

}
