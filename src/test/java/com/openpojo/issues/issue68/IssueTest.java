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

package com.openpojo.issues.issue68;

import com.openpojo.issues.issue68.sample.TestClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

/**
 * This issue only fails on JDK 1.5 & 1.6.
 *
 * @author oshoukry
 */
public class IssueTest {
  @Test
  public void issueTest() {

    Validator validator = ValidatorBuilder.create()
        .with(new SetterTester())
        .with(new GetterTester())
        .build();

    validator.validate(PojoClassFactory.getPojoClass(TestClass.class));
  }

}
