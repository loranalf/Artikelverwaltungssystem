/*
 * Copyright (C) 2015 Alfred Loran
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zubehör;

import exceptions.UngueltigeEingabeException;
import zubehör.artikelgruppe.Artikelgruppe;

/**
 * Diese Klasse bildet die Nadeln ab.
 * @author Alfred Loran
 * @version 1.00
 */
class Nadeln extends Zubehoer {
   
    /**
     * Erzeugt ein Nadel - Objekt.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebene Artikelname
     * @param beschreibung Die übergebene Beschreibung
     * @throws UngueltigeEingabeException Wird geworfen, wenn die die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    protected Nadeln(Artikelgruppe artikelGruppe, String artikelName, String beschreibung) throws UngueltigeEingabeException {
        super(artikelGruppe, artikelName, beschreibung);
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return super.toString();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Nadeln)) {
            return false;
        } else {
            Nadeln n = (Nadeln)object;
            return n.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes.
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash;
    }        
}