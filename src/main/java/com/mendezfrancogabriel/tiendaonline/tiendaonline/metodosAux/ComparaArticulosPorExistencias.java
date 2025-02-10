
package com.mendezfrancogabriel.tiendaonline.tiendaonline.metodosAux;

import com.mendezfrancogabriel.tiendaonline.tiendaonline.Articulo;
import java.util.Comparator;

/**
 *
 * @author gabri
 */

public class ComparaArticulosPorExistencias implements Comparator <Articulo> {

    @Override
    public int compare(Articulo a1, Articulo a2) {
        return Integer.compare(a1.getExistencias(),a2.getExistencias());
    }
}
