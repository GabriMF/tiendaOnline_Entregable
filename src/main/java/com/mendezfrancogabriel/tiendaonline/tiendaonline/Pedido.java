
package com.mendezfrancogabriel.tiendaonline.tiendaonline;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author alu15d
 */

public class Pedido implements Serializable, Comparable <Pedido> {
    
    private String idPedido;
    private Cliente clientePedido;
    private LocalDate fechaPedido;
    private ArrayList<LineaPedido> cestaCompra;

    public Pedido(String idPedido, Cliente clientePedido, LocalDate fechaPedido, ArrayList<LineaPedido> lineaPedido) {
        this.idPedido = idPedido;
        this.clientePedido = clientePedido;
        this.fechaPedido = fechaPedido;
        this.cestaCompra = lineaPedido;
    }

    
    public String getIdPedido() {
        return idPedido;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public ArrayList<LineaPedido> getCestaCompra() {
        return cestaCompra;
    }

    
    
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCestaCompra(ArrayList<LineaPedido> cestaCompra) {
        this.cestaCompra = cestaCompra;
    }

    @Override
    public int compareTo(Pedido p) {
        return this.idPedido.compareTo(p.idPedido);
    }
}
