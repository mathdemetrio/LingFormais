/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.test;

/**
 *
 * @author Diego
 */
public class TestRunner {
    public static void main(String[] args) {
        GramaticaTeste gT = new GramaticaTeste();
        AutomatoFinitoDeterministicoTeste dfaT = new AutomatoFinitoDeterministicoTeste();
        ExpressaoRegularTeste erT = new ExpressaoRegularTeste();
        
        gT.runTest();
        dfaT.runTest();
        erT.runTest();
    }
}
