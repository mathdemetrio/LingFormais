/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.test;

import br.inf.ufsc.formais.model.automato.AutomatoFinitoDeterministico;
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
public class GramaticaTeste {
    public void runTest() {
        Set<SimboloNaoTerminal> snt = new LinkedHashSet<>();
        Set<SimboloTerminal> terms = new LinkedHashSet<>();
        Set<RegraProducao> regras = new LinkedHashSet<>();
        
        SimboloNaoTerminal ini = new SimboloNaoTerminal("S");
        snt.add(ini);
        SimboloNaoTerminal symbNTA = new SimboloNaoTerminal("A");
        snt.add(symbNTA);
        SimboloNaoTerminal symbNTB = new SimboloNaoTerminal("B");
        snt.add(symbNTB);
        
        SimboloTerminal symbTA = new SimboloTerminal("a");
        terms.add(symbTA);
        SimboloTerminal symbTB = new SimboloTerminal("b");
        terms.add(symbTB);
        
        Cadeia cadIniA = new Cadeia(symbTA, symbNTA);  
        RegraProducao rp1 = new RegraProducao(ini, cadIniA);
        regras.add(rp1);
        
        Cadeia cadIniB = new Cadeia(symbTB, symbNTB);  
        RegraProducao rp2 = new RegraProducao(ini, cadIniB);
        regras.add(rp2);
        
        Cadeia cadA1 = new Cadeia(symbTA);  
        RegraProducao rp3 = new RegraProducao(symbNTA, cadA1); 
        regras.add(rp3);
        RegraProducao rp4 = new RegraProducao(symbNTA, cadIniB);
        regras.add(rp4);
        
        Cadeia cadB1 = new Cadeia(symbTB);  
        RegraProducao rp5 = new RegraProducao(symbNTB, cadB1);
        regras.add(rp5);
        RegraProducao rp6 = new RegraProducao(symbNTB, cadIniA);
        regras.add(rp6);
        
        Gramatica gr = new Gramatica(snt, terms, regras, ini);
        
        System.out.println(gr.toString());
        
        AutomatoFinitoDeterministico fsa = gr.toAutomatoFinito();
        
        System.out.println(fsa.toString());
    }
}
