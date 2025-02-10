
package com.mendezfrancogabriel.tiendaonline.tiendaonline;

import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockAgotado;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockInsuficiente;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.metodosAux.MetodosAux;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    /*
    -------------------------------- Menus --------------------------------
    */
   
    public void stock (int unidadesPed, String id) throws StockAgotado, StockInsuficiente{
        
        int n = articulos.get(id).getExistencias();
        
        if (n==0){
            throw new StockAgotado("Stock agotado para el articulo "+ articulos.get(id).getDescripcion());
            
        }else if(n < unidadesPed){
            throw new StockInsuficiente("No hay stock suficiente para el pedido. Solicita "
                    + unidadesPed + " de "+articulos.get(id).getDescripcion() 
                    + " y solo se dispone de "+n);
        }
    }
   
    
    public void nuevoPedido() {
        //ARRAYLIST AUXILIAR PARA CREAR EL PEDIDO
        ArrayList<LineaPedido> CestaCompraAux = new ArrayList();
        String dniT, idT, opc, pedidasS;
        int pedidas=0;
       
        sc.nextLine();
       
        do{
            System.out.println("CLIENTE PEDIDO (DNI):");
            dniT=sc.nextLine().toUpperCase();
            
            if (dniT.isBlank()){
                System.out.println("DNI en blanco. Saliendo del pedido...");
                break;
            }
            if (!MetodosAux.validarDni(dniT)){
                System.out.println("El DNI no es un DNI válido");
            }
        }while (!clientes.containsKey(dniT));
        
        if (!dniT.isBlank()){
          
            System.out.println("INTRODUZCA LOS ARTÍCULOS DEL PEDIDO UNO A UNO: ");
            
            do{
                System.out.println("INTRODUCE CODIGO ARTICULO (99 PARA TERMINAR): ");
                idT=sc.next();
                
                if (!idT.equals("99") && articulos.containsKey(idT)){
                    System.out.print("(" + articulos.get(idT).getDescripcion()+ ") - UNIDADES? ");
                    
                    do {
                        pedidasS=sc.next();
                        
                    }while(!MetodosAux.esInt(pedidasS)); 
                    
                    pedidas=Integer.parseInt(pedidasS);
                                     
                    try{
                        stock(pedidas,idT); // LLAMO AL METODO STOCK, PUEDEN SALTAR 2 EXCEPCIONES
                        CestaCompraAux.add(new LineaPedido(idT,pedidas));
                        
                    }catch (StockAgotado e){
                        System.out.println(e.getMessage());
                        
                    }catch (StockInsuficiente e){
                        System.out.println(e.getMessage());
                        int disponibles=articulos.get(idT).getExistencias();
                        
                        System.out.print("QUIERES LAS " + disponibles + " UNIDADES DISPONIBLES? (S/N) ");
                        opc=sc.next();
                        
                        if (opc.equalsIgnoreCase("S")){
                            CestaCompraAux.add(new LineaPedido(idT,disponibles));
                        }
                    }  
                }
            }while (!idT.equals("99"));
         
            //IMPRIMO EL PEDIDO Y SOLICITO ACEPTACION DEFINITIVA DEL MISMO 
            for (LineaPedido l:CestaCompraAux){
                System.out.println(articulos.get(l.getIdArticulo()).getDescripcion() + " - ("+ l.getUnidades() + ")");
            }
            
            System.out.println("ESTE ES TU PEDIDO. PROCEDEMOS? (S/N)   ");
            opc=sc.next();
            
            if (opc.equalsIgnoreCase("S")){
            // ESCRIBO EL PEDIDO DEFINITIVAMENTE Y DESCUENTO LAS EXISTENCIAS PEDIDAS DE CADA ARTICULO
                LocalDate hoy=LocalDate.now();
                pedidos.add(new Pedido(generaIdPedido(dniT),clientes.get(dniT),hoy,CestaCompraAux));
                
                for (LineaPedido l:CestaCompraAux){
                    articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias()-l.getUnidades());
                } 
            }
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
    
    public double totalPedido(Pedido p){
        double total = 0;
        for(LineaPedido l:p.getCestaCompra()){
            total+=(articulos.get(l.getIdArticulo()).getPvp()*l.getUnidades());
        }
        return total;
    }
    
    
    public void cargaDatos(){
        
       clientes.put("80580845T",new Cliente("80580845T","ANA ","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","LOLA","649222222","lola@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","JUAN","652333333","juan@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","EDU","634567890","edu@gmail.com"));
              
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",12,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("80580845T-001/2024",clientes.get("80580845T"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("4-22",3)))));                                                                                                                                                               
       pedidos.add(new Pedido("80580845T-002/2024",clientes.get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-11",3),new LineaPedido("4-22",2),new LineaPedido("4-33",4)))));
       pedidos.add(new Pedido("36347775R-001/2024",clientes.get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3)))));
       pedidos.add(new Pedido("36347775R-002/2024",clientes.get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("4-33",3),new LineaPedido("2-11",3)))));
       pedidos.add(new Pedido("63921307Y-001/2024",clientes.get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("2-33",3),new LineaPedido("4-33",2)))));
    } 
}
