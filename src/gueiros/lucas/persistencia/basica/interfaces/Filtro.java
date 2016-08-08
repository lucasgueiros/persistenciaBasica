/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.persistencia.basica.interfaces;

/**
 *
 * Permite realizar consultas específicas.
 * O filtro inclui, em geral, um método para o filtro de objeto e outro
 * para HQL. Os dois 
 * 
 * @author lucas
 * @param <Tipo> mesmo tipo do repositório.
 */
public interface Filtro<Tipo extends Identificavel> {
    
    /**
     * Diz se um objeto deve ser incluído no resultado de uma consulta ou não
     * @param t o objeto que será ou não incluído.
     * @return true caso o objeto deva ser incluído.
     */
    public boolean filtrar(Tipo t);

    /**
     * Retorna a clásula WHERE do código SQL que realiza a consulta, sem o nome WHERE.
     * Executar esse HQL com o from class na frente deve ser equivalente a:
     * 
     * ```java
     * for(Object o : dao.recover("from class")){
     *    T t = (T) o;
     *    lista.add(t);
     * }
     * ```
     * 
     * Exemplo de retorno: "id=3"
     * 
     * @return o código HQL
     */
    public String toSql();
    
}
