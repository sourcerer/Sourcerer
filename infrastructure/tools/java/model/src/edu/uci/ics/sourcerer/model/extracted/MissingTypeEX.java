/* 
 * Sourcerer: an infrastructure for large-scale source code analysis.
 * Copyright (C) by contributors. See CONTRIBUTORS.txt for full list.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.uci.ics.sourcerer.model.extracted;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public class MissingTypeEX implements ModelEX {
  private String fqn;
  
  private MissingTypeEX(String fqn) {
    this.fqn = fqn;
  }
  
  public String getFqn() {
    return fqn;
  }
  
  // ---- PARSER ----
  private static ModelExParser<MissingTypeEX> parser = new ModelExParser<MissingTypeEX>() {
    @Override
    public MissingTypeEX parseLine(String line) {
      return new MissingTypeEX(line);
    }
  };
  
  public static ModelExParser<MissingTypeEX> getParser() {
    return parser;
  }
  
  public static String getLine(String fqn) {
    return fqn;
  }
}