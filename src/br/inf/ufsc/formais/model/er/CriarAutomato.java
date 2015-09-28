/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.er;

import br.inf.ufsc.formais.model.Alfabeto;
import br.inf.ufsc.formais.model.Simbolo;
import br.inf.ufsc.formais.model.automato.AutomatoFinito;
import br.inf.ufsc.formais.model.automato.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Matheus
 */
public class CriarAutomato {

    public AutomatoFinitoNaoDeterministico AFdeSimbolo(Simbolo s) {

        EstadoInicial einicial = new EstadoInicial("S");
        EstadoFinal efinal = new EstadoFinal("F");

        Set<Estado> estados = new LinkedHashSet<>();
        estados.add(einicial);
        estados.add(efinal);
        
        Set<Estado> proxEstados = new LinkedHashSet<>();
        proxEstados.add(efinal);
        
        Set<EstadoFinal> estadosAceitacao = new LinkedHashSet<>();
        estadosAceitacao.add(efinal);

        Set<Simbolo> simbolos = new LinkedHashSet<>();
        simbolos.add(s);
        Alfabeto alfa = new Alfabeto(simbolos);

        TransicaoNaoDeterministica t = new TransicaoNaoDeterministica(einicial, s, proxEstados);
        Set<TransicaoNaoDeterministica> transicoes = new LinkedHashSet<>();
        transicoes.add(t);

        AutomatoFinitoNaoDeterministico af = new AutomatoFinitoNaoDeterministico(transicoes,
            estados, alfa, einicial,
            estadosAceitacao);

        return af;
    }

    public AutomatoFinitoNaoDeterministico FechoDeAF(AutomatoFinitoNaoDeterministico af) {
        Set<TransicaoNaoDeterministica> transicoes = af.getTransicoes();
        Set<Estado> proxEstados = new LinkedHashSet<>();
        proxEstados.add(af.getEstadoInicial());
        for (EstadoFinal efinal : af.getEstadosAceitacao()) {
            transicoes.add(new TransicaoNaoDeterministica(efinal, Simbolo.EPSILON, proxEstados));
        }
        af.setTransicoes(transicoes);
        return af;
    }

    public AutomatoFinito OuEntreAFs(AutomatoFinito af1, AutomatoFinito af2) {
        //Não Implementado
        return null;
    }

    public AutomatoFinito ConcatenaAFs(AutomatoFinito af1, AutomatoFinito af2) {
        //Não Implementado
        return null;
    }

    public AutomatoFinito AFLingVazia() {
        //Não Implementado
        return null;
    }

    public AutomatoFinito AFPalavraVazia() {
        //Não Implementado
        return null;
    }
}
