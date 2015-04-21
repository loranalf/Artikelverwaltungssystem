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
 * Diese Klassebildet eine Einkopfmaschine ab.
 * @author Alfred Loran
 * @version 1.00
 */
class EinKopf {
    private static int anzahlEinkofMaschine;
    private int einkopfMaschinenNummer;
    private String maschinenNummer;
    private String maschinenName;
    private Kopf kopf;
    private Motor motor;
    private Daten daten;
    private Stickfeldgroesse stickFeldGoesse;
    private String elektro;
    
    /**
     * Erzeugt ein EinKopf - Objekt.
     * @param maschinenName Der übergebene Maschinenname.
     * @param kopf Das übergebene Kopf - Objekt.
     * @param motor Das übergebene Motor - Objekt.
     * @param daten Das übergebene Daten - Objekt.
     * @param stickFeldgroesse Die übergebene Stickfeldgroesse.
     * @param elektro Die übergebene Bezeichnung des Elektromotors.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Eingaben des Benutzr ungültig sind.
     * @since 1.00
     */
    protected EinKopf(String maschinenName, Kopf kopf, Motor motor, Daten daten, Stickfeldgroesse stickFeldgroesse, String elektro) throws UngueltigeEingabeException {
        setEinkopfMaschinenNummer(++anzahlEinkofMaschine);
        setMaschinenName(maschinenName);
        setKopf(kopf);
        setMotor(motor);
        setDaten(daten);
        setStickFeldGoesse(stickFeldgroesse);
        setElektro(elektro);
        setMaschinenNummer();
    }

    /**
     * Liefert die Maschinennummer.
     * @return die Maschinennummer
     * @since 1.00
     */
    protected int getEinkopfMaschinenNummer() {
        return einkopfMaschinenNummer;
    }

    /**
     * Setzt die Maschinennummer.
     * @param einkopfMaschinenNummer Die übergebene Maschinennummer.
     * @since 1.00
     */
    private void setEinkopfMaschinenNummer(int einkopfMaschinenNummer) {
        this.einkopfMaschinenNummer = einkopfMaschinenNummer;
    }

    /**
     * Liefert den Maschinennamen.
     * @return den Maschinennamen
     * @since 1.00
     */
    protected String getMaschinenName() {
        return maschinenName;
    }

    /**
     * Setzt den Maschinennamen.
     * @param maschinenName Der übergebene Maschinenname.
     * @throws UngueltigeEingabeException Wird gewoefen, wenn die Eingabe weniger als 4 Zeichen enthält.
     * @since 1.00
     */
    private void setMaschinenName(String maschinenName) throws UngueltigeEingabeException {
        if (maschinenName == null) {
            throw new NullPointerException("Kein Maschinenname vorhanden!");
        } else if (maschinenName.length() < 4) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 4 Zeichen als Maschinenname ein!");
        } else {
            this.maschinenName = maschinenName;
        }
    }

    /**
     * Liefert das Kopf - Objekt.
     * @return das Kopf - Objekt.
     * @since 1.00s
     */
    protected Kopf getKopf() {
        return kopf;
    }

    /**
     * Setzt das Kopf - Objekt.
     * @param kopf Das übergebene Kopf - Objekt.
     * @since 1.00
     */
    private void setKopf(Kopf kopf) {
        if (kopf == null) {
            throw new NullPointerException("Kein Kopf vorhanden!");
        } else {
            this.kopf = kopf;
        }
    }

    /**
     * Liefert das Motor - Objekt.
     * @return das Motor - Objekt
     * @since 1.00
     */
    protected Motor getMotor() {
        return motor;
    }

    /**
     * Setzt den Motor.
     * @param motor Der übergebene Motor
     * @since 1.00
     */
    private void setMotor(Motor motor) {
        if (motor == null) {
            throw new NullPointerException("Kein Motorr vorhanden!");
        } else {
            this.motor = motor;
        }
    }

    /**
     * Liefert das Daten - Objekt.
     * @return das Daten - Objekt.
     * @since 1.00
     */
    protected Daten getDaten() {
        return daten;
    }

    /**
     * Setzt die Daten.
     * @param daten Die überegeben Daten.
     * @since 1.00
     */
    private void setDaten(Daten daten) {
        if (daten == null) {
            throw new NullPointerException("Keine Daten vorhanden!");
        } else {
            this.daten = daten;
        }
    }

    /**
     * Liefert das Stickfeldgroesse - Objekt.
     * @return das Stickfeldgroesse - Objekt
     * @since 1.00
     */
    protected Stickfeldgroesse getStickFeldGoesse() {
        return stickFeldGoesse;
    }

    /**
     * Setzt die Stickfeldgroesse.
     * @param stickFeldGoesse Die übergebene Stickfeldgroesse.
     * @since 1.00
     */
    private void setStickFeldGoesse(Stickfeldgroesse stickFeldGoesse) {
        if (stickFeldGoesse == null) {
            throw new NullPointerException("Keine STickfeldgröße vorhanden!");
        } else {
            this.stickFeldGoesse = stickFeldGoesse;
        }
    }
    
    /**
     * Liefert die Maschinennummer. Äquivalent zur Maschinennummer.
     * @return die Maschinennummer
     * @since 1.00
     */
    protected String getMaschineneNummer() {
        return maschinenNummer;
    }
    
    /**
     * Generiert die Maschinenummer.
     * @since 1.00
     */
    private void setMaschinenNummer() {
        this.maschinenNummer = getMaschinenName() + "-" + getEinkopfMaschinenNummer() + "-" + getKopf().getAnzahlNadeln() + "-" + getElektro();
    }
    
    /**
     * Liefert die Bezeichnung des Elektromotors zurück.
     * @return die Bezeichnung des Elektromotors
     * @since 1.00s
     */
    protected String getElektro() {
        return elektro;
    }
    
    /**
     * Setzt die Bezeichnung des Elektroautos.
     * @param bezeichnung Die übergebene Bezeichnung.
     * @throws UngueltigeEingabeException Wird geworfen, wenn die Bezeichnung weniger als 4 Zeichen enthält.
     * @since 1.00
     */
    private void setElektro(String bezeichnung) throws UngueltigeEingabeException {
        if (bezeichnung == null) {
            throw new NullPointerException("Keine Bezeichnung vorhanden!");
        } else if (bezeichnung.length() < 2) {
            throw new UngueltigeEingabeException("Bitte geben Sie mindestens 2 Zeichen als Bezeichnung ein!");
        } else {
            this.elektro = bezeichnung;
        }
    }
    
    /**
     * Liefert die Daten des Objektes.
     * @return die Daten des Objektes
     * @since 1.00
     */
    @Override
    public String toString() {
        return  "**********************************************\nMaschinennummer: " + getMaschineneNummer() + "\n" + 
                "Maschinenname: " + getMaschinenName() + "\n" + 
                getKopf().toString() + "\n" +
                getMotor().toString() + "\n" +
                getDaten().toString() + "\n" + 
                getStickFeldGoesse().toString() + "\n" + 
                "Elektro: " + getElektro() + " Watt\n**********************************************\n";
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
        } else if (!(object instanceof EinKopf)) {
            return false;
        } else {
            EinKopf einKopf = (EinKopf)object;
            return einKopf.hashCode() == this.hashCode();
        }
    }

    /**
     * Generiert und leifert den hashCode des Objektes.
     * @return den hashCode des Objektes
     * @since 1.00
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.einkopfMaschinenNummer;
        hash = 43 * hash + Objects.hashCode(this.maschinenNummer);
        hash = 43 * hash + Objects.hashCode(this.maschinenName);
        hash = 43 * hash + Objects.hashCode(this.kopf);
        hash = 43 * hash + Objects.hashCode(this.motor);
        hash = 43 * hash + Objects.hashCode(this.daten);
        hash = 43 * hash + Objects.hashCode(this.stickFeldGoesse);
        hash = 43 * hash + Objects.hashCode(this.elektro);
        return hash;
    }            
}