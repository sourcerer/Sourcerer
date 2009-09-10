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
package edu.uci.ics.sourcerer.extractor.io.file;

import edu.uci.ics.sourcerer.extractor.io.IEntityWriter;
import edu.uci.ics.sourcerer.extractor.io.Location;
import edu.uci.ics.sourcerer.model.Entity;
import edu.uci.ics.sourcerer.model.extracted.EntityExParser;
import edu.uci.ics.sourcerer.repo.base.Repository;
import edu.uci.ics.sourcerer.util.io.Property;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public final class EntityWriter extends ExtractorWriter implements IEntityWriter {
  public EntityWriter(Repository input) {
    super(input, Property.ENTITY_FILE);
  }

  private void writeEntity(Entity type, String fqn, int modifiers, Location location) {
    write(EntityExParser.getLine(type, fqn, modifiers, convertToRelativePath(location.getCompilationUnitPath()), location.getStartPosition(), location.getLength()));
  }
  
  @Override
  public void writeClass(String fqn, int modifiers, Location location) {
    writeEntity(Entity.CLASS, fqn, modifiers, location);
  }

  @Override
  public void writeInterface(String fqn, int modifiers, Location location) {
    writeEntity(Entity.INTERFACE, fqn, modifiers, location);
  }
  
  @Override
  public void writeInitializer(String fqn, int modifiers, Location location) {
    writeEntity(Entity.INITIALIZER, fqn, modifiers, location);
  }
  
  @Override
  public void writeConstructor(String fqn, int modifiers, Location location) {
    writeEntity(Entity.CONSTRUCTOR, fqn, modifiers, location);
  }
  
  @Override
  public void writeEnum(String fqn, int modifiers, Location location) {
    writeEntity(Entity.ENUM, fqn, modifiers, location);
  }
  
  @Override
  public void writeMethod(String fqn, int modifiers, Location location) {
    writeEntity(Entity.METHOD, fqn, modifiers, location);
  }
  
  @Override
  public void writeField(String fqn, int modifiers, Location location) {
    writeEntity(Entity.FIELD, fqn, modifiers, location);
  }
  
  @Override
  public void writeEnumConstant(String fqn, int modifiers, Location location) {
    writeEntity(Entity.ENUM_CONSTANT, fqn, modifiers, location);    
  }
  
  @Override
  public void writeAnnotation(String fqn, int modifiers, Location location) {
    writeEntity(Entity.ANNOTATION, fqn, modifiers, location);
  }
  
  @Override
  public void writeAnnotationElement(String fqn, int modifiers, Location location) {
    writeEntity(Entity.ANNOTATION_ELEMENT, fqn, modifiers, location);
  }
}