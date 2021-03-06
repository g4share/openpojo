/*
 * Copyright (c) 2010-2015 Osman Shoukry
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License or any
 *    later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.openpojo.validation.rule.impl;

import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.sampleclasses.NoNestedClassDoesClass;
import com.openpojo.validation.rule.impl.sampleclasses.NoNestedClassDoesntClass;
import org.junit.Test;


/**
 * @author oshoukry
 */
public class NoNestedClassRuleTest {
  Class<?>[] failClasses = new Class<?>[] { NoNestedClassDoesntClass.NestedClass.class };
  Class<?>[] passClasses = new Class<?>[] { NoNestedClassDoesClass.class };
  Rule rule = new NoNestedClassRule();

  @Test
  public void testEvaluate() {
    CommonCode.shouldPassRuleValidation(rule, passClasses);
    CommonCode.shouldFailRuleValidation(rule, failClasses);
  }
}
