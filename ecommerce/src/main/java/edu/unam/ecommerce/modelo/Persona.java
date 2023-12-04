package edu.unam.ecommerce.modelo;

import java.util.List;

/**
 * Esta clase es una interface de tipo Persona.
 * 
 * @version v1.0.0.7
 * @author Pluhator Nicolas
 * 
 */
public interface Persona {
    /**
     * Esta funcion retornara el identificador de la persona.
     * 
     * @return identificador de Persona.
     */
    public Integer getId();

    /**
     * Esta funcion retornara el nombre de la persona.
     * 
     * @return Nombre de la Persona.
     */
    public String getNombre();

    /**
     * Esta funcion retornara el telefono de la persona.
     * 
     * @return Telefono de la persona.
     */
    public String getTelefono();

    /**
     * Esta funcion retornara un listado de las transacciones de la Persona.
     * 
     * @return Listado de Transacciones.
     */
    public List<Transaccion> getTransacciones();

    /**
     * Esta funcion retornara el estado de la Persona. Es decir si esta activo o
     * dado de baja.
     * 
     * @return Estado de la persona.
     */
    public boolean getEstado();
}
