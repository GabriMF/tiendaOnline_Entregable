
package com.mendezfrancogabriel.tiendaonline.tiendaonline;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockAgotado;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.Excepciones.StockInsuficiente;
import com.mendezfrancogabriel.tiendaonline.tiendaonline.metodosAux.MetodosAux;

/**
 *
 * @author alu15d
 */

public class TiendaOnline implements Serializable {
    
    Scanner sc = new Scanner(System.in);
    
    private ArrayList <Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;

    public TiendaOnline() {
        this.pedidos = new ArrayList();
        this.articulos = new HashMap();
        this.clientes = new HashMap();
    }
    
    public static void main(String[] args) {
        TiendaOnline tiendaOnline = new TiendaOnline();
        tiendaOnline.cargaDatos();
        tiendaOnline.menuPrincipal(); 
    }
    
    /*
    -------------------------------- Menus --------------------------------
    */

   public void menuPrincipal(){
        Scanner sc=new Scanner (System.in);
        int option;
        do{        
            System.out.println("""
            __________________________________________________________________________________________________________

                                                           Menu Principal
            __________________________________________________________________________________________________________

            Por favor, pulsa alguna de las siguientes opciones:

                    - 1 Para consultas sobre articulos.
                    - 2 Para consultas sobre clientes.
                    - 3 Para consultas sobre pedidos.

                    - 0 Para cerrar la aplicacion.
                                                                                                                        """);
            option=sc.nextInt();
            switch (option){
                case 1:{
                    menuArticulos();
                    break;
                }    
                case 2:{
                    menuClientes();
                    break;
                } 
                case 3:{
                    menuPedidos();
                    break;
                }
                case 0:{
                    System.out.println("\n\n                            Gracias por probar mi aplicacion!                                    \n"
                        + "_________________________________________________________________________________________________\n"
                        + "_________________________________________________________________________________________________\n\n"
                        + "               #   #   #   ##### #####   #       #     #   # #####  ####  ###   #                \n"
                        + "               #   #  # #  #       #    # #      #     #   # #     #     #   #  #                \n"
                        + "               ##### #   # #####   #   #   #     #     #   # ####  #  ## #   #  #                \n"
                        + "               #   # #####     #   #   #####     #     #   # #     #   # #   #                   \n"
                        + "               #   # #   # #####   #   #   #     #####  ###  #####  ###   ###   #                \n"
                        + "_________________________________________________________________________________________________\n"
                        + "_________________________________________________________________________________________________\n\n");
                    break;
                }
                default :{
                    System.out.println("Por favor, introduzca una opcion valida");   
                }
                
            }
        }while (option != 0);
    }

    private void menuArticulos() {
        
        Scanner sc=new Scanner (System.in);
        int option;
        
        do{
            System.out.println("""
            __________________________________________________________________________________________________________

                                                           Menu Articulos
            __________________________________________________________________________________________________________

            Por favor, pulsa alguna de las siguientes opciones:

                    - 1 Para agregar un articulo.
                    - 2 Para eliminar un articulo.
                    - 3 Para modificar un cliente.
                    - 4 Para consultar el listado de articulos.

                    - 0 Para volver al menu principal.
                                                                                                                        """);
            option=sc.nextInt();
            switch (option){
                case 1:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                }
                case 2:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                }
                case 3:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                }
                case 4:{
                    listaArticulos();
                }
            }
        }while (option != 0);
    }  
  
    private void menuClientes() {
        
        Scanner sc=new Scanner (System.in);
        int option;
        
        do{
            System.out.println("""
            __________________________________________________________________________________________________________

                                                           Menu Clientes
            __________________________________________________________________________________________________________

            Por favor, pulsa alguna de las siguientes opciones:

                    - 1 Para agregar un nuevo cliente.
                    - 2 Para eliminar un cliente.
                    - 3 Para modificar un cliente.
                    - 4 Para consultar el listado de clientes.

                    - 0 Para volver al menu principal.
                                                                                                                        """);
            option=sc.nextInt();
            switch (option){
                case 1:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                }    
                case 2:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                } 
                case 3:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                } 
                case 4:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                } 
            }
        }while (option != 0);
    }
    
    private void menuPedidos() {
        
        Scanner sc=new Scanner (System.in);
        int option;
        
        do{
            System.out.println("""
            __________________________________________________________________________________________________________

                                                           Menu Pedidos
            __________________________________________________________________________________________________________

            Por favor, pulsa alguna de las siguientes opciones:

                    - 1 Para agregar un pedido.
                    - 2 Para eliminar un pedido.
                    - 3 Para modificar un pedido.
                    - 4 Para consultar el listado de pedidos.
                    - 5 Para consultar el listado de pedidos en
                        base a su cantidad.

                    - 0 Para volver al menu principal.
                                                                                                                        """);
            option=sc.nextInt();
            switch (option){
                case 1:{
                    nuevoPedido();
                    break;
                }    
                case 2:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                } 
                case 3:{
                    System.out.println("\n...Coming soon!\n");
                    break;
                } 
                case 4:{
                    listaPedidos();
                    break;
                }
                case 5:{
                    listarPedidosPorTotal();
                    break;
                }
            }
        }while (option != 0);
    }
    
    /*
    -----------------------------------------------------------------------
    */
   
    public void stock (int unidadesPed, String id) throws StockAgotado, StockInsuficiente{
        
        int n = articulos.get(id).getExistencias();
        
        if (n==0){
            throw new StockAgotado("Stock agotado para el articulo "+ articulos.get(id).getDescripcion());
            
        }else if(n < unidadesPed){
            throw new StockInsuficiente("No hay stock suficiente para el pedido. Solicita "
                    + unidadesPed + " unidades de "+articulos.get(id).getDescripcion() 
                    + " y solo se dispone de "+n+".");
        }
    }
   
    public void nuevoPedido() {
        //ARRAYLIST AUXILIAR PARA CREAR EL PEDIDO
        ArrayList<LineaPedido> CestaCompraAux = new ArrayList();
        String dniT, idT, opc, pedidasS;
        int pedidas=0;
       
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
                        + "                 Bienvenido a la compra de un nuevo pedido\n"
                        + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
        System.out.println("Pulse enter para continuar...\n");
        sc.nextLine();
       
        do{
            System.out.println("Introduzca su DNI, por favor:");
            dniT=sc.nextLine().toUpperCase();
            
            if (dniT.isBlank()){
                System.out.println("DNI en blanco. Saliendo del pedido...");
                break;
            }
            if (!MetodosAux.validarDni(dniT)|| !clientes.containsKey(dniT)){
                System.out.println("El DNI no es un DNI válido. Intentelo de nuevo, por favor.");
            }
        }while (!clientes.containsKey(dniT));
        
        if (!dniT.isBlank()){
          
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
                        + "                    Bienvenido/a, "+ clientes.get(dniT).getNombre() + "\n"
                        + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
            
            do{
                System.out.println("\nPor favor, introduzca el identificador del articulo deseado:\n"
                        + "(Introduzca '00' para terminar) ");
                idT=sc.next();
                
                if (!idT.equals("00") && articulos.containsKey(idT)){
                    System.out.print("(" + articulos.get(idT).getDescripcion()+ ") - Cuantas unidades desea? ");
                    
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
                        
                        System.out.print("Desea las " + disponibles + " unidades disponibles? (S/N) ");
                        opc=sc.next();
                        
                        if (opc.equalsIgnoreCase("S")){
                            CestaCompraAux.add(new LineaPedido(idT,disponibles));
                        }
                    }  
                }
            }while (!idT.equals("00"));
         
            //IMPRIMO EL PEDIDO Y SOLICITO ACEPTACION DEFINITIVA DEL MISMO 
            System.out.println("El pedido seleccionado es el siguiente.");
            System.out.println("____________________________________________________________________________\n");
            for (LineaPedido l:CestaCompraAux){
                System.out.println(articulos.get(l.getIdArticulo()).getDescripcion() + " - ("+ l.getUnidades() + ")");
            }
            System.out.println("____________________________________________________________________________\n");

            
            System.out.println("Desea confirmar el pedido? (S/N)");
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
    
    public void listarPedidosPorTotal() {
         
        pedidos.stream().sorted(Comparator.comparing(p -> totalPedido((Pedido)p)).reversed()).forEach(p -> System.out.println(p + "\t - IMPORTE TOTAL:" + totalPedido(p)));  
        
        //Si fuese un HasMap, se haría así:
        //pedidos.values().stream().sorted([...]
        
        //A completar con codigo teams 
        //pedidos.stream().filter(p-> p.getClientePedido().getNombre().equals("ANA"))
    }
    
    public void listaArticulos(){
        ArrayList <Articulo> articulosAux = new ArrayList(articulos.values());
        Collections.sort(articulosAux);
        
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }
        System.out.println("\nDel reves:");
        Collections.reverse(articulosAux);
        for (Articulo a : articulosAux) {
            System.out.println(a);
        }
    }
   
    
    public void listaPedidos(){
        Collections.sort(pedidos);
        
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
        
        Collections.reverse(pedidos);
        
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
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
