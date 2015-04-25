/*
 * Copyright (C) 2015 AlfredLoran
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
 *
 * @author AlfredLoran
 */
public class test {

    public static void main(String[] args) {
        try {
            MaschinenVerwaltung v = new MaschinenVerwaltung();
            v.fuegeMaschineHinzu("Test", 2, 9, "3 AC Servo Motoren", 82, 2000000, "0,1 - 12,7", 1200, 3, 8, 1, "225");
            System.out.println(v.toString());

            v.entferneMaschine("Bla");
            System.out.println(v.toString());
            v.entferneMaschine("Test");
            System.out.println(v.toString());
            v.entferneMaschine("Test");
            System.out.println(v.toString());
        } catch (UngueltigeEingabeException fehler) {
            System.err.println(fehler.getMessage());
        }
    }
}
