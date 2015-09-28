/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

import br.inf.ufsc.formais.model.Alfabeto;
import br.inf.ufsc.formais.model.er.ExpressaoRegular;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class AutomatoFinitoNaoDeterministico extends AutomatoFinito {

    public AutomatoFinitoNaoDeterministico(Set<Estado> estados, Alfabeto alfabeto,
            Set<TransicaoNaoDeterministica> transicoes, EstadoInicial estadoInicial,
            Set<EstadoFinal> estadosAceitacao) {
        super(estados, alfabeto, transicoes, estadoInicial, estadosAceitacao);
    }

    public ExpressaoRegular toER() {
        if (!isGeneralizado()) {
            generalizar();
        }

        ExpressaoRegular er = new ExpressaoRegular();
        Estado[] kEstados = estados.toArray(new Estado[estados.size()]);
        int i = 0;
        while (kEstados.length > 2) {
            Estado atual = kEstados[i];
            if (!atual.equals(estadoInicial) && atual.equals(getEstadoFinal())) {
                Set<Transicao> trans = new LinkedHashSet<>();
                for (Transicao tran : transicoes) {
                    if (tran.getEstadoAtual().equals(atual) || tran.getProximoEstado().equals(atual)) {
                        trans.add(tran);
                    }
                }
                
                for (Transicao tran : trans) {
                    // HERE THE MAGIC IS DONE!!!
                    // Implementar o triângulo do amor
                }
            }
        }

        return er;
    }

}
