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
 * Diese Klasse bildet das Vlies ab.
 * Ein Vlies besitzt eine Grammangabe und eine Beschreibung.
 * @author Alfred Loran
 * @version 1.00
 */
class Vlies extends Zubehoer {
    private double gramm;
    
    /**
     * Erzeugt ein Vlies - Objekt mit den übergebenen Parametern.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebene Artikelname.
     * @param gramm Die übergebene Grammmenge.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers fehlerhaft ist.
     * @since 1.00
     */
    protected Vlies(Artikelgruppe artikelGruppe, String artikelName, double gramm) throws UngueltigeEingabeException {
        super(artikelGruppe, artikelName);
        setGramm(gramm);
    }
        
    /**
     * Liefert die Grammanzahl.
     * @return die Grammanzahl
     * @since 1.00
     */
    protected double getGramm() {
        return gramm;
    }
    
    /**
     * Setzt die Grammanzahl.
     * @param gramm Die übergebenen Gramm.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benuters kleiner oder gleich 0 ist.
     * @since 1.00
     */
    private void setGramm(double gramm) throws UngueltigeEingabeException {
        if (gramm <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.gramm = gramm;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  super.toString() + "\n" +
                "Gramm: " + getGramm() + "\n" +
                "Beschreibung: " + super.getBeschreibung();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das übergebene Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object)  {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Vlies)) {
            return false;
        } else {
            Vlies vlies = (Vlies)object;
            return vlies.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gramm) ^ (Double.doubleToLongBits(this.gramm) >>> 32));
        return hash;
    }        
}