/*
 * Copyright (c) 2010-2015 Osman Shoukry
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.openpojo.reflection.java.bytecode;

import java.lang.reflect.Modifier;

import com.openpojo.log.Logger;
import com.openpojo.log.LoggerFactory;
import com.openpojo.reflection.java.bytecode.asm.ASMDetector;
import com.openpojo.reflection.java.bytecode.asm.ASMNotLoadedException;
import com.openpojo.reflection.java.bytecode.asm.ASMService;

/**
 * This factory is to be used to generate a subclass for a given PojoClass.
 *
 * @author oshoukry
 */
public class ByteCodeFactory {
  private static final Logger LOGGER = LoggerFactory.getLogger(ByteCodeFactory.class);
  private static boolean asm_enabled = ASMDetector.getInstance().isASMLoaded();
  private static ASMService asmService = ASMService.getInstance();

  private ByteCodeFactory() {
    throw new IllegalStateException(ByteCodeFactory.class.getName() + " should not be constructed!");
  }

  public static <T> Class<? extends T> getSubClass(Class<T> clazz) {
    if (isNull(clazz) || isAnInterface(clazz) || isAnEnum(clazz) || isPrimitive(clazz) || isAnArray(clazz) || isFinal(clazz)) {
      LOGGER.error("Invalid request to generate a subclass for [{0}], argument must be [not null, not an interface, not an" +
          " enum, not primitive, not an array or a final class", clazz);
      return null;
    }

    if (!asm_enabled)
      throw ASMNotLoadedException.getInstance();

    LOGGER.info("Generating subclass for class [{0}]", clazz);
    return asmService.createSubclassFor(clazz);
  }

  private static <T> boolean isNull(Class<T> clazz) {
    return clazz == null;
  }

  private static <T> boolean isAnInterface(Class<T> clazz) {
    return Modifier.isInterface(clazz.getModifiers());
  }

  private static <T> boolean isAnEnum(Class<T> clazz) {
    return clazz.isEnum();
  }

  private static <T> boolean isPrimitive(Class<T> clazz) {
    return clazz.isPrimitive();
  }

  private static <T> boolean isAnArray(Class<T> clazz) {
    return clazz.isArray();
  }

  private static <T> boolean isFinal(Class<T> clazz) {
    return Modifier.isFinal(clazz.getModifiers());
  }
}
