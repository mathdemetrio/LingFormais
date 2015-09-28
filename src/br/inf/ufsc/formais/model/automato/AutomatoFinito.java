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

    protected Set<Estado> estados;
    protected Alfabeto alfabeto;
    protected EstadoInicial estadoInicial;
    protected Set<EstadoFinal> estadosAceitacao;
    protected Set<Transicao> transicoes;
    private boolean generalizado;

    public AutomatoFinito(Set<Estado> estados, Alfabeto alfabeto, Set<? extends Transicao> transicoes,
            EstadoInicial estadoInicial, Set<EstadoFinal> estadosAceitacao) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.transicoes = (Set<Transicao>) transicoes;
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

    public Set<Transicao> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<Transicao> transicoes) {
        this.transicoes = transicoes;
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

            SimboloTerminal term = new SimboloTerminal(transicao.getSimboloEntrada().getReferencia());
            regra.getCadeiaProduzida().setSimboloTerminal(term);

            if (transicao.getProximoEstado() != null
                    && !transicao.getProximoEstado().equals(transicao.getEstadoAtual())) {
                SimboloNaoTerminal prox = new SimboloNaoTerminal(transicao.getProximoEstado().getId());
                regra.getCadeiaProduzida().setSimboloNaoTerminal(prox);
            } else if (transicao.getProximoEstado() != null
                    && transicao.getProximoEstado().equals(transicao.getEstadoAtual())) {
                RegraProducao loop = new RegraProducao();
                loop.setSimboloProducao(producao);
                loop.getCadeiaProduzida().setSimboloTerminal(term);
                loop.getCadeiaProduzida().setSimboloNaoTerminal(
                        new SimboloNaoTerminal(transicao.getProximoEstado().getId()));
                regras.add(loop);
            }

            regras.add(regra);
        }

        return new Gramatica(naoTerminais, terminais, regras, simboloInicial);
    }

    public void generalizar() {
        EstadoInicial novoEstadoInicial = new EstadoInicial("NS");
        EpsilonTransicao transicaoInicio = new EpsilonTransicao(novoEstadoInicial, estadoInicial);

        EstadoFinal novoFinal = new EstadoFinal("NF");
        Set<EpsilonTransicao> transToFim = new LinkedHashSet<>();
        Set<Estado> antigosFinais = new LinkedHashSet<>();

        for (EstadoFinal estado : estadosAceitacao) {
            EpsilonTransicao et = new EpsilonTransicao(estado, novoFinal);
            Estado est = new Estado(estado.getId());

            for (Transicao tr : transicoes) {
                if (tr.getEstadoAtual().equals(estado)) {
                    tr.setEstadoAtual(est);
                }

                if (tr.getProximoEstado().equals(estado)) {
                    tr.setProximoEstado(est);
                }
            }

            antigosFinais.add(est);
            transToFim.add(et);
        }

        estados.removeAll(estadosAceitacao);
        estados.addAll(antigosFinais);

        for (Estado estado : estados) {
            for (Estado est : estados) {
                EpsilonTransicao et = new EpsilonTransicao(estado, est);
                transicoes.add(et);
            }
        }

        estadosAceitacao = new LinkedHashSet<>();
        estadosAceitacao.add(novoFinal);

        estadoInicial = novoEstadoInicial;
        transicoes.addAll(transToFim);
        transicoes.add(transicaoInicio);

        estados.add(novoEstadoInicial);
        estados.add(novoFinal);
        
        generalizado = true;
    }

    public boolean isGeneralizado() {
        return generalizado;
    }
    
    public EstadoFinal getEstadoFinal() {
        if(generalizado) {
            return estadosAceitacao.toArray(new EstadoFinal[1])[0];
        }
        
        return null;
    }

}
