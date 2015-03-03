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

import android.view.View;
import com.android.internal.util.Predicate;
import io.selendroid.server.util.Preconditions;

/**
 * Finds views with a given tag.
 * See <a href="http://developer.android.com/reference/android/view/View.html#getTag(int)">View.getTag(key)</a>.
 */
public class ViewTagPredicate implements Predicate<View> {

  private final int key;
  private final String value;

  public ViewTagPredicate(int key, String value) {
    this.key = key;
    this.value = Preconditions.checkNotNull(value, "Tag value cannot be null.");
  }

  @Override
  public boolean apply(View view) {
    return this.value.equals(view.getTag(this.key));
  }
}
