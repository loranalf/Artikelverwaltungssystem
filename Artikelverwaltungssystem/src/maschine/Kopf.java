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
package maschine;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet einen Kopf ab.
 * @author Alfred Loran
 * @since 1.00
 */
class Kopf {
    private int anzahlKoepfe;
    private int anzahlNadeln;
    private int anzahlFarben;
    
    protected Kopf(int anzahlKoepfe, NadelAnzahlEnum anzahlNadeln) throws UngueltigeEingabeException {
        setAnzahlKoepfe(anzahlKoepfe);
        setAnzahlNadelnUndFarben(anzahlNadeln);
    }

    /**
     * Liefert die Anzahl der Koepfe.
     * @return die Anzahl der Koepfe
     * @since 1.00
     */
    protected int getAnzahlKoepfe() {
        return anzahlKoepfe;
    }

    /**
     * Setzt die Anzahl der Koepfe.
     * @param anzahlKoepfe Die übergebene Anzahl der Koepfe
     * @since 1.00
     */
    private void setAnzahlKoepfe(int anzahlKoepfe) throws UngueltigeEingabeException {
        if (anzahlKoepfe <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.anzahlKoepfe = anzahlKoepfe;
        }
    }

    /**
     * Liefert die Anzahl der Nadeln.
     * @return die Anzahl der Nadeln
     * @since 1.00
     */
    public int getAnzahlNadeln() {
        return anzahlNadeln;
    }

    /**
     * Setzt die Anzhal der Nadeln.
     * Zusätzlich wird auch die Anzahl der möglich verwendbaren Farben gesetzt.
     * @param anzahlNadeln Die übergebene Anzahl der Nadeln.                       
     * @since 1.00
     */
    private void setAnzahlNadelnUndFarben(NadelAnzahlEnum anzahlNadeln) {
        if (anzahlNadeln == null) {
            throw new NullPointerException("Keine Anzahl der Nadeln vorhanden!");
        } else {
            if (anzahlNadeln.equals(NadelAnzahlEnum.EINS)) {
                this.anzahlNadeln = 1;
                this.anzahlFarben = 1;
            } else if (anzahlNadeln.equals(NadelAnzahlEnum.NEUN)) {
                this.anzahlNadeln = 9;
                this.anzahlFarben = 9;
            } else if (anzahlNadeln.equals(NadelAnzahlEnum.ZWOELF)) {
                this.anzahlNadeln = 12;
                this.anzahlFarben = 12;
            } else if (anzahlNadeln.equals(NadelAnzahlEnum.FUENFZEHN)) {
                this.anzahlNadeln = 15;
                this.anzahlFarben = 15;
            }
        }
    }

    /**
     * Liefert die Anzahl der Farben.
     * @return die Anzahl der Farben
     * @since 1.00
     */
    protected int getAnzahlFarben() {
        return anzahlFarben;
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Anzahl der Köpfe: " + getAnzahlKoepfe() + "\n" +
                "Anzahl der Nadeln: " + getAnzahlNadeln() + "\n" +
                "Anzhal der Farben: " + getAnzahlFarben();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Kopf)) {
            return false;
        } else {
            Kopf kopf = (Kopf)object;
            return kopf.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.anzahlKoepfe;
        hash = 53 * hash + this.anzahlNadeln;
        hash = 53 * hash + this.anzahlFarben;
        return hash;
    }
    
    
}