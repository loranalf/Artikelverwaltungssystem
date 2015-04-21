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
import java.util.Objects;

/**
 * Diese Klasse enthält die Daten der Maschine.
 * @author Alfred Loran
 * @version 1.00
 */
class Daten {
    private float gewicht;
    private int speicher;
    private String stichlaenge;
    private int drehzahl;
    private int anzahlUSBStecker;
    private String monitorgroese;
    
    /**
     * Erzuegt ein Daten - Objekt.
     * @param gewicht Das übergebene Gewicht.
     * @param speicher Die übergebene Speichergröße.
     * @param stichLaenge Die übergebene Stichlänge.
     * @param drehzahl Die übergebene Drehzahl.
     * @param anzahlUSBStecker Die Anzahl der USB Stecker.
     * @param monitorgroesse Die übergebene Monitorgröße.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingaben des Benutzers ungültig ist.
     * @since 1.00
     */
    protected Daten(float gewicht, int speicher, String stichLaenge, int drehzahl, int anzahlUSBStecker, String monitorgroesse) throws UngueltigeEingabeException {
        setGewicht(gewicht);       
        setSpeicher(speicher);
        setStichlaenge(stichLaenge);
        setDrehzahl(drehzahl);
        setAnzahlUSBStecker(anzahlUSBStecker);
        setMonitorgroese(monitorgroesse);
    }

    /**
     * Liefert das Gewicht.
     * @return das Gewicht.
     * @since 1.00
     */
    protected float getGewicht() {
        return gewicht;
    }

    /**
     * Setzt das Gewicht.
     * @param gewicht Das übergebene Gewicht.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe kleiner oder gleich 0 ist.
     * @since 1.00
     */
    private void setGewicht(float gewicht) throws UngueltigeEingabeException {
        if (gewicht <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.gewicht = gewicht;
        }
    }

    /**
     * Liefert die Groesse des Speichers.
     * @return die Groesse des Speichers
     * @since 1.00
     */
    protected int getSpeicher() {
        return speicher;
    }

    /**
     * Setzt den Speicher.
     * @param speicher Der übergebene Speicher
     * @since 1.00
     */
    private void setSpeicher(int speicher) throws UngueltigeEingabeException {
        if (speicher <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine zahl größer 0 ein!");
        } else {
            this.speicher = speicher;
        }
    }

    /**
     * Liefert die Stichlaenge.
     * @return die Stichlaenge
     * @since 1.00
     */
    protected String getStichlaenge() {
        return stichlaenge;
    }

    /**
     * Setzt die Stichlaenge.
     * @param stichlaenge Die Stichlaenge.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe kleiner oder groesser 0 ist.
     * @since 1.00
     */
    private void setStichlaenge(String stichlaenge) throws UngueltigeEingabeException {
        if (stichlaenge == null) {
            throw new NullPointerException("Keine Stichlänge vorhanden!");
        } else if (stichlaenge.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else {
            this.stichlaenge = stichlaenge;
        }
    }

    /**
     * Liefert die Drehzahl.
     * @return die Drehzahl
     * @since 1.00
     */
    protected int getDrehzahl() {
        return drehzahl;
    }

    /**
     * Setzt die Drehzahl.
     * @param drehzahl Dieübergebene Drehzahl.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe kleiner oder gleich 0 ist.
     * @since 1.00
     */
    private void setDrehzahl(int drehzahl) throws UngueltigeEingabeException {
        if (drehzahl <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine zahl größer 0 ein!");
        } else {
            this.drehzahl = drehzahl;
        }
    }

    /**
     * Liefert die Anzahl der USB Sticks.
     * @return die Anzahl der USB Sticks
     * @since 1.00
     */
    protected int getAnzahlUSBStecker() {
        return anzahlUSBStecker;
    }

    /**
     * Gibt die Anzahl der USB Stecker ein.
     * @param anzahlUSBStecker 
     */
    private void setAnzahlUSBStecker(int anzahlUSBStecker) throws UngueltigeEingabeException {
        if (anzahlUSBStecker <= 0) {
            throw new UngueltigeEingabeException("Bitte geben Sie eine Zahl größer 0 ein!");
        } else{
            this.anzahlUSBStecker = anzahlUSBStecker;
        }
    }

    /**
     * Liefert die Monitorgroesse.
     * @return die Monitorgroesse.
     * @since 1.00
     */
    protected String getMonitorgroese() {
        return monitorgroese;
    }

    /**
     * Setzt die Monitorgroesse.
     * @param monitorgroese Die Monitorgroesse.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingabe weniger als 4 Zeichen enthält.
     * @since 1.00
     */
    private void setMonitorgroese(String monitorgroese) throws UngueltigeEingabeException {
        if (monitorgroese == null) {
            throw new NullPointerException("Keine Monitorgröße vorhanden!");
        } else if (monitorgroese.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen ein!");
        } else {
            this.monitorgroese = monitorgroese;
        }
    }
    
    
    @Override
    public String toString() {
        return  "Gewicht: " + getGewicht() + "kg\n" + 
                "Speicher: " + getSpeicher() + " Stiche\n" +
                "Stichlänge: " + getStichlaenge() + "mm\n" + 
                "Drehzahl: " + getDrehzahl() + "Stiche/min\n" + 
                "Anzahl USB Ports: " + getAnzahlUSBStecker();
                
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
            throw new NullPointerException("Kein Objekt zum vergleichen vorhanden!");
        } else if (!(object instanceof Daten)) {
            return false;
        } else {
            Daten daten = (Daten)object;
            return daten.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und liefert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Float.floatToIntBits(this.gewicht);
        hash = 59 * hash + this.speicher;
        hash = 59 * hash + Objects.hashCode(this.stichlaenge);
        hash = 59 * hash + this.drehzahl;
        hash = 59 * hash + this.anzahlUSBStecker;
        hash = 59 * hash + Objects.hashCode(this.monitorgroese);
        return hash;
    }
}