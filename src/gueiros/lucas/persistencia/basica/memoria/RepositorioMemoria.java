/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gueiros.lucas.persistencia.basica.memoria;

import gueiros.lucas.persistencia.basica.interfaces.Repositorio;
import gueiros.lucas.persistencia.basica.interfaces.Filtro;
import gueiros.lucas.persistencia.basica.interfaces.Identificavel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lucas
 * @param <Tipo>
 */
public class RepositorioMemoria<Tipo extends Identificavel> implements Repositorio<Tipo> {

    
    
    
    private final Map<Long,Tipo> elementos = new HashMap<>();
    private static long maxid = 1;
    
    @Override
    public void adicionar(Tipo t){
        t.setId(maxid++);
        elementos.put(t.getId(), t);
    }

    @Override
    public void remover(Filtro<Tipo> f) {
        for(Long id : elementos.keySet())
            if(f.filtrar(elementos.get(id)))
                elementos.remove(id);
    }

    @Override
    public void autualizar(Tipo t) {
        elementos.replace(t.getId(), t);
    }

    @Override
    public boolean existe(Filtro<Tipo> f) {
        for(Tipo t : elementos.values()) if(f.filtrar(t)) return true; 
        return false;
    }

    @Override
    public List<Tipo> recuperar(Filtro<Tipo> f) {
        List<Tipo> lista = new LinkedList<>();
        for(Tipo t : elementos.values())
            if(f.filtrar(t))
                lista.add(t);
        return lista;
    }

}
