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
 * Diese Klasse bildet das Lagerfett ab.
 * @author Alfred Loran
 * @version 1.00
 */
class Lagerfett extends Zubehoer {
    private double inhalt;
    
    /**
     * Erzeugt ein Lagerfett - Objekt.
     * @param artikelGruppe Die übergebene Artikelgruppe.
     * @param artikelName Der übergebne Artikelname.
     * @param inhalt Der übergebene Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public Lagerfett(Artikelgruppe artikelGruppe, String artikelName, double inhalt) throws UngueltigeEingabeException {
        super(artikelGruppe, artikelName);
        setInhalt(inhalt);
    }
    
    /**
     * Liefert den Inhalt des Lagerfetts.
     * @return den Inhalt des Lagerfetts.
     * @since 1.00
     */
    protected double getInhalt() {
        return inhalt;
    }
    
    /**
     * Setzt den Inhalt des Lagerfetts.
     * @param inhalt Der übergebene Inhalt.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe kleiner oder gleich 0 ist.
     * @since 1.00
     */
    private void setInhalt(double inhalt) throws UngueltigeEingabeException {
        if (inhalt <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.inhalt = inhalt;
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
                "Inhalt: " + getInhalt() + "g" + "\n" +
                "Beschreibung: " + super.getBeschreibung();
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
        } else if (!(object instanceof Lagerfett)) {
            return false;
        } else {
            Lagerfett lagerFett = (Lagerfett)object;
            return lagerFett.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und leifert den hashCode des Objektes
     * @return den hashCode
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.inhalt) ^ (Double.doubleToLongBits(this.inhalt) >>> 32));
        return hash;
    }        
}