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

package com.openpojo.validation.test.impl;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.ValidationHelper;

/**
 * This Rule ensures that all Fields are initialized to null.<br>
 * This rule ignores fields that are marked as final or primitive types since neither can be initialized to null.<br>
 *
 * @author oshoukry
 */
public class DefaultValuesNullTester implements Tester {

  public void run(final PojoClass pojoClass) {
    final Object classInstance = ValidationHelper.getBasicInstance(pojoClass);

    for (final PojoField fieldEntry : pojoClass.getPojoFields()) {
      if (!fieldEntry.isPrimitive() && !fieldEntry.isFinal()) {
        Affirm.affirmNull(String.format("Expected null value for for field=[%s]", fieldEntry), fieldEntry.get(classInstance));
      }
    }
  }

}
