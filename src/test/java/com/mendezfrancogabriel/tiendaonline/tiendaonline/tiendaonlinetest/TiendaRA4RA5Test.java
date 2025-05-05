/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mendezfrancogabriel.tiendaonline.tiendaonline.tiendaonlinetest;

import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockAgotado;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockInsuficiente;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.TiendaOnline;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author gabri
 */
public class TiendaRA4RA5Test {
    
    public TiendaRA4RA5Test(){
        
    }
    
    TiendaOnline t=new TiendaOnline();
  
    @BeforeEach
    public void antesDeCadaTest() {
        t.cargaDatos();
    }
    @Test
    public void testCargaDatos() {
       assertAll(
            () -> assertEquals(9, t.getArticulos().size()),
            () -> assertEquals(7, t.getClientes().size()),
            () -> assertEquals(7, t.getPedidos().size())
        );
    }

    @Test
    public void testTotalCliente() {
        assertAll(
            () -> assertEquals(3565, t.totalCliente(t.getClientes().get("80580845T"))),
            () -> assertEquals(2370, t.totalCliente(t.getClientes().get("36347775R"))),
            () -> assertEquals(2160, t.totalCliente(t.getClientes().get("63921307Y"))),
            () -> assertEquals(580, t.totalCliente(t.getClientes().get("43211307Y"))),
            () -> assertEquals(190, t.totalCliente(t.getClientes().get("53472775R")))
        );
    }

    @Test
    public void testStock() {
        assertAll(  
            () -> assertThrows(StockInsuficiente.class,()-> {t.stock(22, "1-11");},"El Stock es insuficiente"),
            () -> assertThrows(StockAgotado.class, ()-> {t.stock(5, "2-33");}, "El Stock esta agotado")
        );
    }
    
    @Test
    public void testTotalPedido() {
        assertAll(
            () -> assertEquals(585, t.totalPedido(t.getPedidos().get(0))),
            () -> assertEquals(2980, t.totalPedido(t.getPedidos().get(1))),
            () -> assertEquals(390, t.totalPedido(t.getPedidos().get(2))),
            () -> assertEquals(1980, t.totalPedido(t.getPedidos().get(3))),
            () -> assertEquals(2160, t.totalPedido(t.getPedidos().get(4)))
        );
    }
   
    @Test
    public void testTotalCliente2() {
       assertAll(
            () -> assertEquals(3565, t.totalCliente(t.getClientes().get("80580845T"))),
            () -> assertEquals(2370, t.totalCliente(t.getClientes().get("36347775R"))),
            () -> assertEquals(2160, t.totalCliente(t.getClientes().get("63921307Y"))),
            () -> assertEquals(580, t.totalCliente(t.getClientes().get("43211307Y"))),
            () -> assertEquals(190, t.totalCliente(t.getClientes().get("53472775R")))
        );
    }    
}
