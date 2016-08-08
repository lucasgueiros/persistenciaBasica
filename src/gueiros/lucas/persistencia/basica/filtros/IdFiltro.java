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
 * Esse filtro procura um objeto com o Id específico.
 * 
 * @author lucas
 * @param <T> mesmo tipo do repositório.
 */
public class IdFiltro<T extends Identificavel> implements Filtro<T>{

    private final long id;

    public IdFiltro(long id) {
        this.id=id;
    }
    
    @Override
    public boolean filtrar(T t) {
        return t.getId()==id;
    }

    @Override
    public String toSql() {
        return  "id=" + id;
    }
    
}
