/*
 * Copyright 2012-2014 eBay Software Foundation and selendroid committers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.selendroid.server.model;

public class Factories {

  private static AndroidNativeElementFactory androidNativeElementFactory = null;
  private static PredicatesFactory predicatesFactory = null;

  public static AndroidNativeElementFactory getAndroidNativeElementFactory() {
    if (androidNativeElementFactory == null) {
      androidNativeElementFactory = new DefaultAndroidNativeElementFactory();
    }
    return androidNativeElementFactory;
  }

  public static PredicatesFactory getPredicatesFactory() {
    if (predicatesFactory == null) {
      predicatesFactory = new PredicatesFactory();
    }
    return predicatesFactory;
  }
}
