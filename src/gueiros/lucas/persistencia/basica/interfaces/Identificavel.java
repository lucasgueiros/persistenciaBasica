/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.persistencia.basica.interfaces;

/**
 * Essa interface define qualquer classe onde cada objeto pode ser identificado a partir de um id único.
 * 
 * @author lucas
 */
public interface Identificavel {
    /**
     * 
     * @return o id do objeto
     */
    public Long getId();
    
    public void setId(Long id);
}
