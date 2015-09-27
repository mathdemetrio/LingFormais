/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.test;

import br.inf.ufsc.formais.model.Alfabeto;
import br.inf.ufsc.formais.model.Simbolo;
import br.inf.ufsc.formais.model.automato.AutomatoFinito;
import br.inf.ufsc.formais.model.automato.Estado;
import br.inf.ufsc.formais.model.automato.EstadoFinal;
import br.inf.ufsc.formais.model.automato.EstadoInicial;
import br.inf.ufsc.formais.model.automato.Transicao;
import br.inf.ufsc.formais.model.gramatica.Cadeia;
import br.inf.ufsc.formais.model.gramatica.Gramatica;
import br.inf.ufsc.formais.model.gramatica.RegraProducao;
import br.inf.ufsc.formais.model.gramatica.SimboloNaoTerminal;
import br.inf.ufsc.formais.model.gramatica.SimboloTerminal;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class AutomatoFinitoTeste {

    public void runTest() {
        Set<Estado> estados = new LinkedHashSet<>();
        Set<EstadoFinal> finais = new LinkedHashSet<>();
        Set<Simbolo> simbolos = new LinkedHashSet<>();
        Set<Transicao> transicoes = new LinkedHashSet<>();
        
        EstadoInicial q0 = new EstadoInicial("q0");
        EstadoFinal q1 = new EstadoFinal("q1");
        EstadoFinal q2 = new EstadoFinal("q2");
        
        estados.add(q0);
        estados.add(q1);
        estados.add(q2);
        
        finais.add(q1);
        finais.add(q2);
        
        
        Simbolo a = new Simbolo("a");
        Simbolo b = new Simbolo("b");
        
        simbolos.add(a);
        simbolos.add(b);
        
        Alfabeto alfa = new Alfabeto(simbolos);
        
        Transicao t1 = new Transicao(q0, a, q1);
        Transicao t2 = new Transicao(q0, b, q2);
        Transicao t3 = new Transicao(q1, a, q1);
        Transicao t4 = new Transicao(q1, b, q2);
        Transicao t5 = new Transicao(q2, a, q1);
        Transicao t6 = new Transicao(q2, b, q2);
        
        transicoes.add(t1);
        transicoes.add(t2);
        transicoes.add(t3);
        transicoes.add(t4);
        transicoes.add(t5);
        transicoes.add(t6);
        
        AutomatoFinito dfa = new AutomatoFinito(estados, alfa, transicoes, q0, finais);
        
        System.out.println(dfa.toString());
    }
}
