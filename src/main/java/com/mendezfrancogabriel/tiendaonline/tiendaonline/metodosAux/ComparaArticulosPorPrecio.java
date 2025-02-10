
package com.mendezfrancogabriel.tiendaonline.tiendaonline.metodosAux;

import com.mendezfrancogabriel.tiendaonline.tiendaonline.Articulo;
import java.util.Comparator;

/**
 *
 * @author gabri
 */


public class ComparaArticulosPorPrecio implements Comparator <Articulo> {

    @Override
    public int compare(Articulo a1, Articulo a2) {
        return Double.compare(a1.getPvp(),a2.getPvp());
    }
}
