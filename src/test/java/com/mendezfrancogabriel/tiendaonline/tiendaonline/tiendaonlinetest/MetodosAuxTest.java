/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mendezfrancogabriel.tiendaonline.tiendaonline.tiendaonlinetest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.metodosAux.MetodosAux;

/**
 *
 * @author alu15d
 */

public class MetodosAuxTest {
    
    public MetodosAuxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testEsInt(){
        System.out.println("Test para el metodo 'esInt'.");
        assertTrue(MetodosAux.esInt("-5"), "El -5 es Int.");
        assertTrue(MetodosAux.esInt("5"), "El 5 es Int.");
        assertTrue(MetodosAux.esInt("0"), "El 0 es Int");
        assertFalse(MetodosAux.esInt("5.5"), "El 5.5 no es Int.");
        assertFalse(MetodosAux.esInt("xzy"), "xzy no es Int.");
        assertFalse(MetodosAux.esInt(" "), "El espacio en blanco no es un Int.");
        assertFalse(MetodosAux.esInt(""), "Null no es Int.");
        assertFalse(MetodosAux.esInt("975409825743875540578068956"), "975409825743875540578068956 no es Int.");
    }
    
    @Test
    public void testEsDouble(){
        System.out.println("Test para el metodo 'esDouble'.");
        assertTrue(MetodosAux.esDouble("-5"), "El -5 es Double.");
        assertTrue(MetodosAux.esDouble("5"), "El 5 es Double.");
        assertTrue(MetodosAux.esDouble("0"), "El 0 es Double");
        assertTrue(MetodosAux.esDouble("5.5"), "El 5.5 es Double.");
        assertTrue(MetodosAux.esDouble("975409825743875540578068956"), "975409825743875540578068956 es Double.");
        assertFalse(MetodosAux.esDouble("xzy"), "xzy no es Double.");
        assertFalse(MetodosAux.esDouble(" "), "El espacio en blanco no es un Double.");
        assertFalse(MetodosAux.esDouble(""), "Null no es Double.");
    }
    
    @Test
    public void testValidarDni(){
        System.out.println("Test para el metodo 'validarDni'.");
        assertTrue(MetodosAux.validarDni("80580845T"), "El DNI es valido.");
        assertTrue(MetodosAux.validarDni("36347775R"), "El DNI es valido.");
        assertFalse(MetodosAux.validarDni("363477754R"), "El DNI no es valido.");
        assertFalse(MetodosAux.validarDni("36347775"), "El DNI no es valido.");
    }
    
}
