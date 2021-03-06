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

import android.app.Activity;
import android.view.View;
import com.android.internal.util.Predicate;
import io.selendroid.server.ServerInstrumentation;

public class PredicatesFactory {

  public Predicate<View> createIdPredicate(String using) {
    return new IdPredicate(using);
  }

  public Predicate<View> createContentDescriptionPredicate(String using) {
    return new ContentDescriptionPredicate(using);
  }

  public Predicate<View> createTextPredicate(String using) {
    return new TextPredicate(using);
  }

  public Predicate<View> createPartialTextPredicate(String using) {
    return new PartialTextPredicate(using);
  }

  public Predicate<View> createTagNamePredicate(String using) {
    return new TagNamePredicate(using);
  }

  public Predicate<View> createClassPredicate(String using) {
    return new ClassPredicate(using);
  }

  public Predicate createViewTagPredicate(String using) {
    String[] tagKeyValue = using.split(":");
    if (tagKeyValue.length != 2) {
      throw new IllegalArgumentException("Tag selector must be in the form key:value. Was: " + using);
    }
    String tagKeyName = tagKeyValue[0];
    String tagValue = tagKeyValue[1];

    Activity activity = ServerInstrumentation.getInstance().getCurrentActivity();
    int tagKey = activity.getResources().getIdentifier(tagKeyName, "id", activity.getPackageName());
    if (tagKey == 0) {
      throw new IllegalArgumentException("No resource can be found for: " + tagKeyName);
    }
    return new ViewTagPredicate(tagKey, tagValue);
  }
}
