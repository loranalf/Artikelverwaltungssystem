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

import datenbankverbindung.DatenbankVerbindung;
import exceptions.UngueltigeEingabeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import mitarbeiter.Mitarbeiter;


/**
 * Diese Klasse bildet den Firmennamen ab.
 * @author Alfred Loran
 * @version 1.00
 */
public class Firmenname {
    private static int anzahlFirmenNamen;
    private DatenbankVerbindung dbv;
    private int firmenNameNummer;
    private String firmenName;    
    private ArrayList<Mitarbeiter>listeMitarbeiter;
    
    /**
     * Erzeugt ein FirmenName - Objekt mit den übergebenen Parametern.
     * @param firmenName Der übergebene Firmenname.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Objektes fehlerhaft ist.
     * @since 1.00
     */
    public Firmenname(String firmenName) throws UngueltigeEingabeException {
        setDatenbankVerbindung();
        setFirmenNameNummer(++anzahlFirmenNamen);
        setFirmenName(firmenName);
        eintragInDieDatenbank(firmenName);
    }
    
    /**
     * Stellt die Datenbankverbindung her.
     * @since 1.00
     */
    private void setDatenbankVerbindung() {
        this.dbv = new DatenbankVerbindung();        
    }
    
    /**
     * Liefert die Firmennummer.
     * @return die Firmennummer
     * @since 1.00
     */
    public int getFirmenNameNummer() {
        return firmenNameNummer;
    }
    
    /**
     * Setzt die Firmennummer.
     * @param nummer Die Firmennummer.
     * @since 1.00
     */
    private void setFirmenNameNummer(int nummer) {
        this.firmenNameNummer = nummer;
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
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe des Benutzers nicht mindestens 4 Zeichen enthält.
     * @since 1.00
     */
    private void setFirmenName(String firmenName) throws UngueltigeEingabeException {
        if (firmenName == null) {
            throw new NullPointerException("Kein Firmenname vorhanden!");
        } else if (firmenName.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen als Firmennamen ein!");
        } else {
            this.firmenName = firmenName;
        }
    }            
    
    /**
     * Diese Methode dient dazu, den eintrag in die Datenbank zu tätigen.
     * @param firmenName Der übergebene Firmenname.
     * @since 1.00
     */
    private void eintragInDieDatenbank(String firmenName) {
        try {
            Connection conn = dbv.verbindungAufbauen();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into firmenname(idfirmenname,firmenname) values (" + getFirmenNameNummer() + "\"" + firmenName + "\"");
            dbv.verbindungTrennen();
        } catch(SQLException fehler) {
            System.err.println(fehler.getMessage());
        }
    }
    
    /**
     * Setzt die Mitarbeiterliste.
     * @since 1.00
     */
    private void setMitarbeiterListe() {
        listeMitarbeiter = new ArrayList<Mitarbeiter>();
    }
    
    /**
     * Liefert die Mitarbeiterliste.
     * @return die Mitarbeiterliste
     * @since 1.00
     */
    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return listeMitarbeiter;
    }
    
    /**
     * Fügt einen Mitarbeiter der Liste hinzu.
     * @param mitarbeiter Der übergebene Mitarbeiter.
     * @since 1.00
     */
    public void fuegeMitarbeiterHinzu(Mitarbeiter mitarbeiter) {
        if (listeMitarbeiter == null) {
            setMitarbeiterListe();
        } else if (mitarbeiter == null) {
            throw new NullPointerException("Kein Mitarbeiter vorhanden!");
        } else {
            listeMitarbeiter.add(mitarbeiter);
        }
    }
    
    /**
     * Diese Methode entfernt den Mitarbeiter aus der Liste.
     * @param mitarbeiterNummer Die Mitarbeiternummer.
     * @throws UngueltigeEingabeException Wird geworfen wenn die Eingabe des Benutzers ungültig ist.
     * @since 1.00
     */
    public void entferneMitarbeiter(int mitarbeiterNummer) throws UngueltigeEingabeException {
        if (mitarbeiterNummer <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine positive Zahl ein!");
        } else if (listeMitarbeiter.isEmpty()) {
            throw new UngueltigeEingabeException("Die Liste enthält keine Mitarbeiter!");
        } else {
            int anzahlMitarbeiter = 0;
            for (Mitarbeiter m: listeMitarbeiter) {
                ++anzahlMitarbeiter;
                if (m.getMitarbeiterNummer() == mitarbeiterNummer) {
                    listeMitarbeiter.remove(m);
                }
            }
            
            if (anzahlMitarbeiter == listeMitarbeiter.size()) {
                throw new UngueltigeEingabeException("Diese Mitarbeiternummer existiert nicht!");
            }
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "Firmennamenummer: " + getFirmenNameNummer() + "\n" + 
                "Firmenname: " + getFirmenName();
    }
    
    /**
     * Vergleicht zwei Objekte.
     * @param object das zu vergleichende Objekt.
     * @return true, Objekte sind gleich.
     *         false, Objekte sind ungleich.
     * @since 1.00
     */
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            throw new NullPointerException("Kein Objekt zum Vergleichen vorhanden!");
        } else if (!(object instanceof Firmenname)) {
            return false;
        } else {
            Firmenname firmenN =(Firmenname)object;
            return firmenN.hashCode() == this.hashCode();
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
        hash = 59 * hash + this.firmenNameNummer;
        hash = 59 * hash + Objects.hashCode(this.firmenName);
        return hash;
    }        
}