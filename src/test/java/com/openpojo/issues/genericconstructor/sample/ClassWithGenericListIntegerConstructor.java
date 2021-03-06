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

package com.openpojo.issues.genericconstructor.sample;

import java.util.List;
import java.util.Map;


public class ClassWithGenericListIntegerConstructor {
  private final List<List<Integer>> integers;
  private final Map<String, Integer> mymap;
  private final String string;

  public ClassWithGenericListIntegerConstructor(final List<List<Integer>> integers, final Map<String, Integer> mymap, final
  String string) {
    this.integers = integers;
    this.mymap = mymap;
    this.string = string;
  }

  public List<List<Integer>> getIntegers() {
    return integers;
  }

  public Map<String, Integer> getMymap() {

    return mymap;
  }

  public String getString() {
    return string;
  }
}
