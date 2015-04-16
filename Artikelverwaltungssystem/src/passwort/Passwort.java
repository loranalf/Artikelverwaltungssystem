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
package passwort;

import datenbankverbindung.DatenbankVerbindung;
import exceptions.UngueltigeEingabeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Diese Klasse bildet das Passwort ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class Passwort {
    private static int anzahlPasswörter;
    private DatenbankVerbindung dbv;
    private int passwortNummer;
    private String passwort;
    
    /**
     * Erzeugt ein Passwort - Objekt mit dem übergebenen Parameter.
     * @param passwort Das übergebene Passwort
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public Passwort(String passwort) throws UngueltigeEingabeException {
        verbindungErstellen();
        setPasswortNummer(++anzahlPasswörter);
        setPasswort(passwort);
        eintragenInDatenBank(passwort);
    }
    
    /**
     * Liefert das Passwort.
     * @return das passwort
     * @since 1.00
     */
    public int getPasswortNummer() {
        return passwortNummer;
    }
    
    /**
     * Setzt die Passwortnummer.
     * @param nummer Die übergebene Passwortnummer.
     * @since 1.00
     */
    private void setPasswortNummer(int nummer) {
        this.passwortNummer = nummer;
    }
    
    /**
     * Liefert das Passwort.
     * @return das übergebene Passwort.
     * @since 1.00
     */
    public String getPasswort() {
        return passwort;
    }
    
    /**
     * Setzt das Passwort.
     * @param passwort Das übergebene Passwort.
     * @throws UngueltigeEingabeException 
     * @since 1.00
     */
    private void setPasswort(String passwort) throws UngueltigeEingabeException {
        if (passwort == null) {
            throw new NullPointerException("Kein Passwort vorhanden!");
        } else if (passwort.length() < 6) {
            throw new UngueltigeEingabeException("Bitte geben Sie ein Passwort mit mindestens 6 Zeichen ein!");
        } else {
            this.passwort = passwort;
        }
    }
    
    /**
     * Erstellt die Verbindung zur Datenbank.
     * @since 1.00
     */
    private void verbindungErstellen() {
        dbv = new DatenbankVerbindung();
    }
    
    /**
     * Trägt das Passwort in die Datenbank ein.
     * @param passwort Das übergebene Passwort. 
     * @since 1.00
     */
    private void eintragenInDatenBank(String passwort) {
        try {
            Connection conn = dbv.verbindungAufbauen();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into passwort(idpasswort,pwd) values(" + getPasswortNummer() + ",\"" + passwort + "\");");
            dbv.verbindungTrennen();
        } catch(SQLException fehler) {
            System.err.println(fehler.getMessage());
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Passwort: " + getPasswort();
    }
    
    /**
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object){
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Passwort)) {
            return false;
        } else {
            Passwort pwd = (Passwort)object;
            return pwd.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.passwortNummer;
        hash = 73 * hash + Objects.hashCode(this.passwort);
        return hash;
    }        
}