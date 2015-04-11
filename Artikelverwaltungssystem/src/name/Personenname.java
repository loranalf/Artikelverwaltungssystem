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
import java.util.Objects;

/**
 * Diese Klasse bildet den Personennamen ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class Personenname extends Name {
    private static int anzahlPersonenNamen;
    private int personenNameNummer;
    private String vorName;
    private String zweitName;
    private String nachName;
    
    /**
     * Erzeugt ein Personenname - Objekt.
     * @param vorName Der übergebene Vorname.
     * @param zweitName Der übergebene Zweitname.
     * @param nachName Der übergebene Nachname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public Personenname(String vorName, String zweitName, String nachName) throws UngueltigeEingabeException {
        setPersonenNameNummer(++anzahlPersonenNamen);
        setVorName(vorName);
        setZweitName(zweitName);
        setNachName(nachName);
    }

    /**
     * Liefert die Personennamennummer.
     * @return die Personennamennummer
     * @since 1.00
     */
    private int getPersonenNameNummer() {
        return personenNameNummer;
    }
        
    /**
     * Setzt die Personennamennummer.
     * @param nummer Die übergebene Nummer.
     * @since 1.00
     */
    private void setPersonenNameNummer(int nummer) {
        this.personenNameNummer = nummer;
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
     * @param vorName Den übergebnen Vornamen.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers weniger als 2 Zeichen enthält.
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
     * @return den Zweitnamen.
     * @since 1.00
     */
    public String getZweitName() {
        return zweitName;
    }

    /**
     * Setzt den Zweitnamen.
     * @param zweitName Der übergebene Zweitname.
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
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers weniger als 2 Zeichen enthält.
     * @since 1.00
     */
    private void setNachName(String nachName) throws UngueltigeEingabeException {
        if (nachName == null) {
            throw new NullPointerException("Kein Nachname vorhanden!");
        } else if (nachName.length() < 2) {
            throw new UngueltigeEingabeException("Bitte geben Sie einen Nachnamen mit mindestens 2 Zeichen ein!");
        } else {
            this.nachName = nachName;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Namenummer: " + getPersonenNameNummer() + "\n" + 
                "Vorname: " + getVorName() + "\n" + 
                "Zweitname: " + getZweitName() + "\n" + 
                "Nachname: " + getNachName();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object Das zu vergleichende Objekt.
     * @return true, die Objekte sind gleich.
     *         false, die Objektesind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof  Personenname)) {
            return false;
        } else {
            Personenname name = (Personenname)object;
            return name.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und leifert den hashCode des Objektes.
     * @return den hashCode des objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.personenNameNummer;
        hash = 53 * hash + Objects.hashCode(this.vorName);
        hash = 53 * hash + Objects.hashCode(this.zweitName);
        hash = 53 * hash + Objects.hashCode(this.nachName);
        return hash;
    }        
}