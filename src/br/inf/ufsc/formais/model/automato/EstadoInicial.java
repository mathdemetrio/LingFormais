/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inf.ufsc.formais.model.automato;

/**
 *
 * @author Diego
 */
public class EstadoInicial extends Estado {

    public EstadoInicial(String id) {
        super("-> " + id);
    }

    @Override
    public void setId(String id) {
        super.setId("-> " + id);
    }

}