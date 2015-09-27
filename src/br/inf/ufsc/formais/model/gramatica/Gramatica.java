/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.gramatica;

import br.inf.ufsc.formais.model.Alfabeto;
import br.inf.ufsc.formais.model.Simbolo;
import br.inf.ufsc.formais.model.automato.AutomatoFinito;
import br.inf.ufsc.formais.model.automato.Estado;
import br.inf.ufsc.formais.model.automato.EstadoFinal;
import br.inf.ufsc.formais.model.automato.EstadoInicial;
import br.inf.ufsc.formais.model.automato.Transicao;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Diego
 */
public class Gramatica {

    private Set<SimboloNaoTerminal> simbolosNaoTerminais;
    private Set<SimboloTerminal> simbolosTerminais;
    private Set<RegraProducao> regrasDeProducao;
    private SimboloNaoTerminal simboloInicial;

    public Gramatica(Set<SimboloNaoTerminal> simbolosNaoTerminais, Set<SimboloTerminal> simbolosTerminais, Set<RegraProducao> regrasDeProducao, SimboloNaoTerminal simboloInicial) {
        this.simbolosNaoTerminais = simbolosNaoTerminais;
        this.simbolosTerminais = simbolosTerminais;
        this.regrasDeProducao = regrasDeProducao;
        this.simboloInicial = simboloInicial;
    }

    public Set<SimboloNaoTerminal> getSimbolosNaoTerminais() {
        return simbolosNaoTerminais;
    }

    public void setSimbolosNaoTerminais(Set<SimboloNaoTerminal> simbolosNaoTerminais) {
        this.simbolosNaoTerminais = simbolosNaoTerminais;
    }

    public Set<SimboloTerminal> getSimbolosTerminais() {
        return simbolosTerminais;
    }

    public void setSimbolosTerminais(Set<SimboloTerminal> simbolosTerminais) {
        this.simbolosTerminais = simbolosTerminais;
    }

    public Set<RegraProducao> getRegrasDeProducao() {
        return regrasDeProducao;
    }

    public void setRegrasDeProducao(Set<RegraProducao> regrasDeProducao) {
        this.regrasDeProducao = regrasDeProducao;
    }

    public SimboloNaoTerminal getSimboloInicial() {
        return simboloInicial;
    }

    public void setSimboloInicial(SimboloNaoTerminal simboloInicial) {
        this.simboloInicial = simboloInicial;
    }

    public AutomatoFinito toAutomatoFinito() {
        Set<Simbolo> simbAlfa = new LinkedHashSet<>();
        simbAlfa.addAll(simbolosTerminais);
        Alfabeto alfa = new Alfabeto(simbAlfa);

        EstadoInicial estadoInicial = new EstadoInicial(simboloInicial.getReferencia());

        Set<Estado> estados = new LinkedHashSet<>();
        for (SimboloNaoTerminal snt : simbolosNaoTerminais) {
            Estado est = new Estado(snt.getReferencia());
            estados.add(est);
        }

        Set<EstadoFinal> finais = new LinkedHashSet<>();
        EstadoFinal fim = new EstadoFinal("T");
        finais.add(fim);

        Set<Transicao> transicoes = new LinkedHashSet<>();
        for (RegraProducao regra : regrasDeProducao) {
            Transicao transicao = new Transicao();

            Estado atual = new Estado(regra.getSimboloProducao().getReferencia());
            Estado prox = null;

            Simbolo entrada = regra.getCadeiaProduzida().getSimboloTerminal();
            if (regra.getCadeiaProduzida().isTerminal()) {
                prox = fim;
            } else {
                prox = new Estado(regra.getCadeiaProduzida().getSimboloNaoTerminal().getReferencia());
            }
            
            transicao.setEstadoAtual(atual);
            transicao.setProximoEstado(prox);
            transicao.setSimboloEntrada(entrada);

            transicoes.add(transicao);
        }

        return new AutomatoFinito(estados, alfa, transicoes, estadoInicial, finais);

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        
        for (RegraProducao regra : regrasDeProducao) {
            out.append(regra.toString()).append("\n");
        }
        
        return out.toString();
    }
}
