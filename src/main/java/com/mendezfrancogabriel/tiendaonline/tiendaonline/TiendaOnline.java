
package com.mendezfrancogabriel.tiendaonline.tiendaonline;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author alu15d
 */

public class TiendaOnline implements Serializable {
    
    Scanner sc = new Scanner(System.in);
    
    private ArrayList <Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;

    public TiendaOnline(ArrayList<Pedido> pedidos, HashMap<String, Articulo> articulos, HashMap<String, Cliente> clientes) {
        this.pedidos = pedidos;
        this.articulos = articulos;
        this.clientes = clientes;
    }
    
    
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
    public void nuevoPedido(){
        
        ArrayList<LineaPedido> cestaCompraAux = new ArrayList();
        String dniT, idT, opc, pedidasS;
        int pedidas = 0;
        
        sc.nextLine();
        
        do{
            System.out.println("Introduzca DNI:");
            dniT = sc.nextLine().toUpperCase();
            if(dniT.isBlank()){
                break;
            }
            if(!MetodosAux.validarDni(dniT)){
                System.out.println("El DNI no es valido.");
            }
        }while(!clientes.containsKey(dniT));
        
    }
    
    
    
    
    public void stock (int unidadesPed, String id) throws StockAgotado, StockInsuficiente{
        
        int n = articulos.get(id).getExistencias();
        
        if (n==0){
            throws new StockAgotado("Stock agotado para el articulo "+ articulos.get(id).getDescription());
            
        }else if(n<unidadesPed){
            thorws new StockInsuficiente("No hay stock suficiente para el pedido. Solicita " + unidadesPed + " de "+articulos.get(id).getDescription() + " y solo se dispone de "+n);
        }
    }
    
    public String generaIdPedido(String idCliente){
        
        int contador = 0;
        String nuevoId;
        
        for(Pedido p: pedidos){
            if (p.getClientePedido().getDni().equalsIgnoreCase(idCliente)) {
                contador ++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
        
    }
}
