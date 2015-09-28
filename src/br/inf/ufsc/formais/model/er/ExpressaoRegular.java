/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.er;

import br.inf.ufsc.formais.model.Simbolo;
import java.util.ArrayList;
import java.util.List;
import br.inf.ufsc.formais.model.automato.AutomatoFinito;

/**
 *
 * @author Diego
 */
public class ExpressaoRegular {

    private List<Simbolo> simbolos;

    public ExpressaoRegular(List<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

    public ExpressaoRegular() {
        this.simbolos = new ArrayList<>();
    }

    public void concatenar(Simbolo simbolo) {
        simbolos.add(simbolo);
    }

    public void concatenar(ExpressaoRegular er) {
        simbolos.add(SimboloOperacional.ABRE_GRUPO);
        for (Simbolo simbolo : er.simbolos) {
            simbolos.add(simbolo);
        }
        simbolos.add(SimboloOperacional.FECHA_GRUPO);
    }

    private void agrupar(ExpressaoRegular er) {
        er.simbolos.add(0, SimboloOperacional.ABRE_GRUPO);
        er.simbolos.add(SimboloOperacional.FECHA_GRUPO);
    }

    public void alternancia(Simbolo simbolo) {
        agrupar(this);
        concatenar(SimboloOperacional.ALTERNANCIA);
        concatenar(simbolo);
    }

    public void alternancia(ExpressaoRegular er) {
        agrupar(this);
        agrupar(er);
        concatenar(SimboloOperacional.ALTERNANCIA);
        concatenar(er);
    }

    public void concatenarSimboloFecho(Simbolo simbolo) {
        concatenar(simbolo);
        concatenar(SimboloOperacional.FECHO);
    }

    public void concatenarERFecho(ExpressaoRegular er) {
        agrupar(er);
        concatenar(er);
        concatenar(SimboloOperacional.FECHO);
    }

    public AutomatoFinito toAutomato() {
        //TODO
        return null;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Simbolo simbolo : simbolos) {
            out.append(simbolo.getReferencia());
        }

        return out.toString();
    }

}
