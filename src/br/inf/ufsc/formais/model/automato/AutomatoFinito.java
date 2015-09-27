/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

import br.inf.ufsc.formais.model.Alfabeto;
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
public class AutomatoFinito {

    private Set<Estado> estados;
    private Alfabeto alfabeto;
    private Set<Transicao> transicoes;
    private EstadoInicial estadoInicial;
    private Set<EstadoFinal> estadosAceitacao;

    public AutomatoFinito(Set<Estado> estados, Alfabeto alfabeto, Set<Transicao> transicoes, EstadoInicial estadoInicial, Set<EstadoFinal> estadosAceitacao) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.transicoes = transicoes;
        this.estadoInicial = estadoInicial;
        this.estadosAceitacao = estadosAceitacao;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Set<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<Transicao> transicoes) {
        this.transicoes = transicoes;
    }

    public EstadoInicial getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(EstadoInicial estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Set<EstadoFinal> getEstadosAceitacao() {
        return estadosAceitacao;
    }

    public void setEstadosAceitacao(Set<EstadoFinal> estadosAceitacao) {
        this.estadosAceitacao = estadosAceitacao;
    }

    public Gramatica toGramatica() {
        SimboloNaoTerminal simboloInicial = new SimboloNaoTerminal(estadoInicial.getId());
        Set<SimboloNaoTerminal> naoTerminais = new LinkedHashSet<>();
        Set<SimboloTerminal> terminais = new LinkedHashSet<>();
        Set<RegraProducao> regras = new LinkedHashSet<>();

        for (Estado estado : estados) {
            if (estado instanceof EstadoFinal) {
                SimboloTerminal term = new SimboloTerminal(estado.getId());
                terminais.add(term);
            } else {
                SimboloNaoTerminal nterm = new SimboloNaoTerminal(estado.getId());
                naoTerminais.add(nterm);
            }
        }

        for (Transicao transicao : transicoes) {
            RegraProducao regra = new RegraProducao();
            SimboloNaoTerminal producao = new SimboloNaoTerminal(transicao.getEstadoAtual().getId());
            regra.setSimboloProducao(producao);

            SimboloTerminal term = (SimboloTerminal) transicao.getSimboloEntrada();
            regra.getCadeiaProduzida().setSimboloTerminal(term);
            
            if(!(transicao.getProximoEstado() instanceof EstadoFinal)) {
                SimboloNaoTerminal prox = new SimboloNaoTerminal(transicao.getProximoEstado().getId());
                regra.getCadeiaProduzida().setSimboloNaoTerminal(prox);
            }
            
            regras.add(regra);
        }

        return new Gramatica(naoTerminais, terminais, regras, simboloInicial);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("M = (E,A,T,I,F)\n");
        
        out.append("E = {");
        for (Estado estado : estados) {
            out.append(estado.getId()).append(", ");
        }
        out.delete(out.length() - 3, out.length() - 1);
        out.append("}\n");
        
        out.append(alfabeto.toString()).append("\n");
        
        for (Transicao trans : transicoes) {
            out.append(trans.toString()).append("\n");
        }
        
        out.append("I = ").append(estadoInicial.getId()).append("\n");
        
        out.append("F = {");
        for(EstadoFinal estAceita : estadosAceitacao) {
            out.append(estAceita.getId()).append(", ");
        }
        out.delete(out.length() - 3, out.length() - 1);
        out.append("}\n");
        
        return out.toString();
    }
}
