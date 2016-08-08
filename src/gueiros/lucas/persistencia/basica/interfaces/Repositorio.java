/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gueiros.lucas.persistencia.basica.interfaces;

import java.util.List;

/**
 *
 * Essa classe serve para guarda objetos de um único tipo!
 * @author lucas
 * @param <Tipo> o tipo dos objetos que serão guardados.
 */
public interface Repositorio<Tipo extends Identificavel> {
        
    /**
     * Adiciona um objeto ao repositório. Caso o id dele já esteja definido, será substituído.
     * @param t um objeto para ser adicionado
     */
    public void adicionar(Tipo t);
    
    /**
     * Remove o objeto t.
     * @param t
     */
    public void remover(Filtro<Tipo> f);
    
    /**
     * Atualiza as variáveis de instância do objeto que tem o mesmo id de T.
     * @param t uma versão mais atualizada de um objeto no repositório, mas com o mesmo id.
     */
    public void autualizar(Tipo t);
    
    /**
     * Ver se existe algum objeto com o id pedido no repositório. Desconsidera as outras variáveis de instância.
     * @param t o objeto
     * @return se o objeto está  ou não.
     */
    public boolean existe(Filtro<Tipo> f);
    
    /**
     * Recupera todos os objetos que estão no repositório.
     * @return uma coleção com todos os objetos do repositório.
     */
    public List<Tipo> recuperar(Filtro<Tipo> f);
    
}
