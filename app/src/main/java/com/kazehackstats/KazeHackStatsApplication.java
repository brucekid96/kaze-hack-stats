package com.kazehackstats;

import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;

import com.amplifyframework.core.AmplifyConfiguration;
import com.amplifyframework.datastore.AWSDataStorePlugin;

import com.jakewharton.threetenabp.AndroidThreeTen;

public class KazeHackStatsApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    AndroidThreeTen.init(this);
    super.onCreate();

    try {
      Amplify.addPlugin(new AWSApiPlugin());
      Amplify.configure(
          AmplifyConfiguration.builder(this, R.raw.amplifyconfiguration)
              .devMenuEnabled(false)
              .build(),
          this);
      Log.i("KazeHackStats", "Initialized Amplify");
    } catch (AmplifyException error) {
      Log.e("KazeHackStats", "Could not initialize Amplify", error);
    }

  }
}
