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

        AutomatoFinitoNaoDeterministico af = new AutomatoFinitoNaoDeterministico(
                estados, alfa, transicoes, einicial,
                estadosAceitacao);

        return af;
    }

    public AutomatoFinitoNaoDeterministico FechoDeAF(AutomatoFinitoNaoDeterministico af) {
        Set<Transicao> transicoes = af.getTransicoes();
        for (EstadoFinal efinal : af.getEstadosAceitacao()) {
            transicoes.add(new EpsilonTransicao(efinal, af.getEstadoInicial()));
        }
        af.setTransicoes(transicoes);
        return af;
    }

    public AutomatoFinito OuEntreAFs(AutomatoFinitoNaoDeterministico af1, AutomatoFinitoNaoDeterministico af2) {
        EstadoInicial novoInicial = new EstadoInicial("S");
        Set<Estado> proxEstados = new LinkedHashSet<>();
        proxEstados.add(af1.getEstadoInicial());
        proxEstados.add(af2.getEstadoInicial());
        TransicaoNaoDeterministica tnd = new TransicaoNaoDeterministica(novoInicial,Simbolo.EPSILON,proxEstados );
        //FALTA MUDAR ESTADOS INICIAIS ANTIGOS PARA ESTADOS NORMAIS
        
        //Junção de estados
        //precisamos alterar o id dos estados que possivelmente serão iguais
        Set<Estado> estados = new LinkedHashSet<>();
        estados.addAll(af1.getEstados());
        estados.addAll(af2.getEstados());
        estados.add(novoInicial);
        
        //Junção de estados finais
        Set<EstadoFinal> estadosAceitacao = new LinkedHashSet<>();
        estadosAceitacao.addAll(af1.getEstadosAceitacao());
        estadosAceitacao.addAll(af2.getEstadosAceitacao());
        
        //Junção de Alfabeto
        Set<Simbolo> simbolos = new LinkedHashSet<>();
        simbolos.addAll(af1.getAlfabeto().getSimbolos());
        simbolos.addAll(af2.getAlfabeto().getSimbolos());
        Alfabeto alfa = new Alfabeto(simbolos);
        
        //Junção de transições
        Set<Transicao> transicoes = new LinkedHashSet<>();
        transicoes.addAll(af1.getTransicoes());
        transicoes.addAll(af2.getTransicoes());
        transicoes.add(tnd);
        
        AutomatoFinito afnd = new AutomatoFinito(estados, alfa,
            transicoes, novoInicial,
            estadosAceitacao);
        
        return afnd;
    }

    public AutomatoFinito ConcatenaAFs(AutomatoFinito af1, AutomatoFinito af2) {
        Set<Transicao> transicoes = new LinkedHashSet<>();
        //Cria uma trasição de cada estado final de af1 para o estado inicial de af2
        for(EstadoFinal e : af1.getEstadosAceitacao()){
            transicoes.add(new EpsilonTransicao(e, af2.getEstadoInicial()));
        }
        //FALTA MUDAR ESTADOS FINAIS DE AF1 E INICIAL DE AF2 PARA ESTADOS NORMAIS
        
        //Junção de estados
        //precisamos alterar o id dos estados que possivelmente serão iguais
        Set<Estado> estados = new LinkedHashSet<>();
        estados.addAll(af1.getEstados());
        estados.addAll(af2.getEstados());
        
        //Estados finais
        Set<EstadoFinal> estadosAceitacao = new LinkedHashSet<>();
        estadosAceitacao.addAll(af2.getEstadosAceitacao());
        
        //Junção de Alfabeto
        Set<Simbolo> simbolos = new LinkedHashSet<>();
        simbolos.addAll(af1.getAlfabeto().getSimbolos());
        simbolos.addAll(af2.getAlfabeto().getSimbolos());
        Alfabeto alfa = new Alfabeto(simbolos);
        
        //Junção de transições
        
        transicoes.addAll(af1.getTransicoes());
        transicoes.addAll(af2.getTransicoes());
        
        AutomatoFinito afnd = new AutomatoFinito(estados, alfa,
            transicoes, af1.getEstadoInicial(),
            estadosAceitacao);
        
        return afnd;
    }

    public AutomatoFinito AFLingVazia() {
        EstadoInicial einicial = new EstadoInicial("S");
        Set<Estado> estados = new LinkedHashSet<>();
        estados.add(einicial);
        Alfabeto a = new Alfabeto(null);
        Set<Transicao> t = new LinkedHashSet<>();
        Set<EstadoFinal> ef = new LinkedHashSet<>();

        AutomatoFinito af = new AutomatoFinito(estados, a, t, einicial, ef);
        return af;
    }

    public AutomatoFinito AFPalavraVazia() {
        //Não Implementado
        return null;
    }
}
