/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mendezfrancogabriel.tiendaonline.tiendaonline.tiendaonlinetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        System.out.println("LO QUE HAGO AQUÍ VA DELANTE DE TODOS LOS TEST");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("LO QUE HAGO AQUÍ VA DETRÁS DE TODOS LOS TEST");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("LO QUE HAGO AQUÍ VA DELANTE DE CADA TEST");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("LO QUE HAGO AQUÍ VA DETRÁS DE TODOS LOS TEST");
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testEsInt() {
       /* CON assertAll Junit nos indicará todos los errores que se produzcan
        en cualquier assert individualmente */
       System.out.println("- - - - - - - - - - - testEsInt - - - - - - - - - - -");
        assertAll(
            () -> assertTrue(MetodosAux.esInt("5"),"El 5 es int"),
            () -> assertTrue(MetodosAux.esInt("-5"),"El -5 es int"),
            () -> assertFalse(MetodosAux.esInt("5.5"),"5.5 NO es int"),
            () -> assertFalse(MetodosAux.esInt("dxsfgsdrfg"),"dxsfgsdrfg NO es int")    
        );
        /* SIN assertAll Junit nos indicará ERROR en el test, pero sin mostrar 
        indormación detallada de que asserts han fallado
        
      assertTrue(MetodosAux.esInt("5"),"El 5 es int");
      assertTrue(MetodosAux.esInt("-5"),"El -5 es int");
      assertFalse(MetodosAux.esInt("5.5"),"5.5 NO es int");
      assertFalse(MetodosAux.esInt("dxsfgsdrfg"),"dxsfgsdrfg NO es int");
       
      LOS METODOS QUE DEVUELVEN UN VALOR BOOLEAN TAMBIÉN SE PUEDE PROBAR CON assertEquals 
      
      assertEquals(true, MetodosAux.esInt("5"),"El 5 es int");
      assertEquals(true, MetodosAux.esInt("-5"),"El -5 es int");
      assertEquals(false, MetodosAux.esInt("5.5"),"5.5 NO es int");
      assertEquals(false, MetodosAux.esInt("dxsfgsdrfg"),"dxsfgsdrfg NO es int");
      */
    }
   /* 
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
    */
    
    /**
     * Test of esDouble method, of class MetodosAux.
     */
    @Test
    public void testEsDouble() {
        System.out.println("- - - - - - - - - - - testEsDouble - - - - - - - - - - -");
        assertAll(
            () -> assertTrue(MetodosAux.esDouble("5"),"El 5 es Double"),
            () -> assertTrue(MetodosAux.esDouble("-5"),"El -5 es un Double"),
            () -> assertTrue(MetodosAux.esDouble("5.5"),"El 5.5 es un Double"),
            () -> assertTrue(MetodosAux.esDouble("-5.5"),"El -5.5 es un Double"),
            () -> assertFalse(MetodosAux.esDouble("dxsfgsdrfg"), "dxsfgsdrfg NO es un double")
        );
    }
    /*
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
    */
    @Test
    public void testValidarDni() {
        System.out.println("- - - - - - - - - - - testValidarDni - - - - - - - - - - -");
        assertAll(
           () -> assertTrue(MetodosAux.validarDni("50375889R"), "50375889R DNI válido" ),
           () -> assertTrue(MetodosAux.validarDni("88067157L"), "88067157L DNI válido"),
           () -> assertTrue(MetodosAux.validarDni("98080335D"), "98080335D DNI válido"),
           () -> assertTrue(MetodosAux.validarDni("08194445M"), "08194445M DNI válido"),
           () -> assertTrue(MetodosAux.validarDni("22443479X"),"22443479X DNI válido"),
           () -> assertFalse(MetodosAux.validarDni(""),"Vacío no es DNI válido"),
           () -> assertFalse(MetodosAux.validarDni("22443479R"),"22443479R no es DNI válido")
        );
    }
    /*
    @Test
    public void testValidarDni(){
        System.out.println("Test para el metodo 'validarDni'.");
        assertTrue(MetodosAux.validarDni("80580845T"), "El DNI es valido.");
        assertTrue(MetodosAux.validarDni("36347775R"), "El DNI es valido.");
        assertFalse(MetodosAux.validarDni("363477754R"), "El DNI no es valido.");
        assertFalse(MetodosAux.validarDni("36347775"), "El DNI no es valido.");
    }
    */
    
}
