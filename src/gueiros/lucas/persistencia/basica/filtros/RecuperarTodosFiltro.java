/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.persistencia.basica.filtros;

import gueiros.lucas.persistencia.basica.interfaces.Filtro;
import gueiros.lucas.persistencia.basica.interfaces.Identificavel;

/**
 *
 * @author lucas
 */
public class RecuperarTodosFiltro<Tipo extends Identificavel> implements Filtro<Tipo>{

    @Override
    public boolean filtrar(Tipo t) {
        return true;
    }

    @Override
    public String toSql() {
        return "true";
    }
    
}
