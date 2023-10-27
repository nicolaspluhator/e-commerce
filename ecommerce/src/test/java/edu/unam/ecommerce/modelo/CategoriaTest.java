package edu.unam.ecommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CategoriaTest {
    private Categoria categoria;

    @BeforeEach
    public void inicio() {
        categoria = new Categoria();
    }

    @Test
    public void testAsignarNombreDescripcion() {
        inicio();
        categoria.setNombreCategoria("Verano");
        categoria.setDescripcionCategoria("Ropa para el verano");
        var actualNombre = categoria.getNombreCategoria();
        var actualDescripcion = categoria.getDescripcionCategoria();
        var nombreEsperado = "Verano";
        var descripcionEsperado = "Ropa para el verano";
        assertEquals(nombreEsperado, actualNombre);
        assertEquals(descripcionEsperado, actualDescripcion);
    }
}
