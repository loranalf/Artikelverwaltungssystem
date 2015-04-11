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
package exceptions;

/**
 * Diese Klasse dient als Exception für ungültige Eingaben, die der Benutzer tätigt.
 * @author Alfred Loran
 * @version 1.00
 */
public class UngueltigeEingabeException extends Exception {
    private static final long serialVersionUID = 6675145070741261894L;
    
    /**
     * Erzeugt ein UngueltigesEingabeException - Objekt.
     * @since 1.00
     */
    public UngueltigeEingabeException(){}
    
    /**
     * Erzeugt ein UngültigesEingabeException - Objekt mit dem übergebenem Parameter.
     * @param nachricht Die übergebene Nachricht.
     * @since 1.00
     */
    public UngueltigeEingabeException(String nachricht) {
        super(nachricht);
    }        
}