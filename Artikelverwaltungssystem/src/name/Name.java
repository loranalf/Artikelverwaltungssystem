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
package name;

import exceptions.UngueltigeEingabeException;

/**
 * Diese Klasse bildet den Namen ab. Hierbei handelt es sich um eine abstrakte Basisklasse.
 * @author Alfred Loran
 * @version 1.00
 */
public class Name {
    private static int anzahlNamen;
    private int nameNummer;
    private String vorName;
    private String zweitName;
    private String nachName;
    private String firmenName;
    
    /**
     * Erzeugt ein Name - Objekt.
     * @param vorName Der übergebene Vorname.
     * @param zweitName Der übergebene Zweitname.
     * @param nachName Der übergebene Nachname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzersungültig ist.
     * @since 1.00
     */
    public Name(String vorName, String zweitName ,String nachName) throws UngueltigeEingabeException {
        setNummer(++anzahlNamen);
        setVorName(vorName);
        setZweitName(zweitName);
        setNachName(nachName);
    }
    
    /**
     * Erzeugt ein Name - Objekt mit dem übergebenen Parameter.
     * @param firmenName Der übergebene Firmenname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benuters ungültig ist.
     * @since 1.00
     */
    public Name (String firmenName) throws UngueltigeEingabeException {
        setNummer(++anzahlNamen);
        setFirmenName(firmenName);
    }
    
    /**
     * Liefert die Nummer.
     * @return die Nummer
     * @since 1.00
     */
    public int getNummer() {
        return nameNummer;
    }
    
    /**
     * Setzt die Nummer.
     * @param nummer Die übergebene Nummer.
     * @since 1.00
     */
    private void setNummer(int nummer) {
        this.nameNummer = nummer;
    }
            
    /**
     * Liefert den Vornamen.
     * @return den Vornamen
     * @since 1.00
     */
    public String getVorName() {
        return vorName;
    }
    
    /**
     * Setzt den Vornamen.
     * @param vorName Den Vornamen.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers nicht aus mindestens 2 Zeichen besteht.
     * @since 1.00
     */
    private void setVorName(String vorName) throws UngueltigeEingabeException {
        if (vorName == null) {
            throw new NullPointerException("Kein Vorname vorhanden!");
        } else if (vorName.length() < 2) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 2 Zeichen als Vornamen ein!");
        } else {
            this.vorName = vorName;
        }
    }
    
    /**
     * Liefert den Zweitnamen.
     * @return den ZweitNamen
     * @since 1.00
     */
    public String getZweitName() {
        return zweitName;
    }
    
    /**
     * Setzt den Zweitnamen.
     * @param zweitName Den übergebenen Zweitnamen.
     * @since 1.00
     */
    private void setZweitName(String zweitName) {
        this.zweitName = zweitName;
    }
    
    /**
     * Liefert den Nachnamen.
     * @return den Nachnamen
     * @since 1.00
     */
    public String getNachName() {
        return nachName;
    }
    
    /**
     * Setzt den Nachnamen.
     * @param nachName Der übergebene Nachname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers nicht mindestens 2 Zeichen enthält.
     * @since 1.00
     */
    private void setNachName(String nachName) throws UngueltigeEingabeException {
        if (nachName == null) {
            throw new NullPointerException("Kein Nachname vorhanden!");
        } else if (nachName.length() < 2) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 2 Zeichen als Nachnamen ein!");
        } else {
            this.nachName = nachName;
        }
    }
    
    /**
     * Liefert den Firmennamen.
     * @return den Firmennamen
     * @since 1.00
     */
    public String getFirmenName() {
        return firmenName;
    }
    
    /**
     * Setzt den Firmennamen.
     * @param firmenName Der übergebene Firmenname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des benutzers nicht mindestnes 2 Zeichen enthält.
     * @since 1.00
     */
    private void setFirmenName(String firmenName) throws UngueltigeEingabeException {
        if (firmenName == null) {
            throw new NullPointerException("Kein Firmenname vorhanden!");
        } else if (firmenName.length() < 2) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 2 Zeichen als Firmenname ein!");
        } else {
            this.firmenName = firmenName;
        }
    }
    
    private void eingabeInDatenbankPersonenName(String vorname, String zweitName, String nachName) {
        
    }
    
    
    private void eingabeInDatenbankFirmenName(String firmenName) {
        
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Namenummer: " + getNummer();
    }
    
    /**
     * Vergleicht zwei Objekte
     * @param object Das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Name)) {
            return false;
        } else {
            Name name = (Name)object;
            return name.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes.
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.nameNummer;
        return hash;
    }        
}