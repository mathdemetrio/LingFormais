/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.gramatica;

import br.inf.ufsc.formais.model.Simbolo;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class RegraProducao {

    private SimboloNaoTerminal simboloProducao;
    private Set<Simbolo> simbolosProduzidos;

    public RegraProducao(SimboloNaoTerminal simboloProducao, Set<Simbolo> simbolosProduzidos) {
        this.simboloProducao = simboloProducao;
        this.simbolosProduzidos = simbolosProduzidos;
    }

    public SimboloNaoTerminal getSimboloProducao() {
        return simboloProducao;
    }

    public void setSimboloProducao(SimboloNaoTerminal simboloProducao) {
        this.simboloProducao = simboloProducao;
    }

    public Set<Simbolo> getSimbolosProduzidos() {
        return simbolosProduzidos;
    }

    public void setSimbolosProduzidos(Set<Simbolo> simbolosProduzidos) {
        this.simbolosProduzidos = simbolosProduzidos;
    }

}
