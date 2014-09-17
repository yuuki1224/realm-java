/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.tests.api;

import android.test.AndroidTestCase;

import java.io.IOException;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.internal.SharedGroup;
import io.realm.internal.Table;
import io.realm.tests.api.entities.AllColumns;
import io.realm.tests.api.entities.AllColumnsRealmProxy;
import io.realm.tests.api.entities.Dog;
import io.realm.tests.api.entities.NoAnnotationObject;


public class RealmClearTest extends RealmSetupTests {

    //void clear(Class<?> classSpec)
    public void testClassClear()
    {
        Realm realm = getTestRealm();
        buildAllColumnsTestData(realm);

        realm.beginWrite();
        realm.clear(AllColumns.class);
        realm.commit();

        Boolean objectIsStillThere = realm.contains(AllColumns.class);
        assertFalse("Realm.clear does not remove table", objectIsStillThere);
    }

}