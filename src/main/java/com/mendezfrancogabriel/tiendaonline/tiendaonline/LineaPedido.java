
package com.mendezfrancogabriel.tiendaonline.tiendaonline;

import java.io.Serializable;

/**
 *
 * @author alu15d
 */

public class LineaPedido implements Serializable {
    
    private String idArticulo;
    private int unidades;

    public LineaPedido(String idArticulo, int unidades) {
        this.idArticulo = idArticulo;
        this.unidades = unidades;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public int getUnidades() {
        return unidades;
    }

    
    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
