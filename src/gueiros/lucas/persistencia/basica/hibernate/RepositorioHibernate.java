/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gueiros.lucas.persistencia.basica.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import gueiros.lucas.persistencia.basica.interfaces.Filtro;
import gueiros.lucas.persistencia.basica.interfaces.Identificavel;
import gueiros.lucas.persistencia.basica.interfaces.Repositorio;

/**
 *
 * @author lucas
 * @param <T>
 */
public class RepositorioHibernate<T extends Identificavel> implements Repositorio<T>{

    protected HibernateUtil dao = HibernateUtil.getInstance();
    private final String name =  ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getName();
    
    @Override
    public void adicionar(T t){
        dao.persist(t);
    }

    private String getClasse() {
        return name;
    }

    @Override
    public boolean existe(Filtro<T> f) {
        
        return false;
    }

    @Override
    public List<T> recuperar(Filtro<T> f) {
        List<T> lista = dao.recover("from " + name + " where " + f.toSql());
        //for(Object o : dao.recover("from " + name)){
        //    T t = (T) o;
        //    lista.add(t);
        //}
        return lista;
    }

    @Override
    public void remover(Filtro<T> f) {
        for(T t : this.recuperar(f)){
            dao.delete(t);
        }
    }

    @Override
    public void autualizar(T t) {
        dao.update(t);
    }
    
}
