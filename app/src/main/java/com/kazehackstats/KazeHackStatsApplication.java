package com.kazehackstats;

import android.util.Log;

import androidx.multidex.MultiDexApplication;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;

public class KazeHackStatsApplication extends MultiDexApplication {

  @Override
  public void onCreate() {
    super.onCreate();

    try {
      Amplify.configure(getApplicationContext());
      Log.i("KazeHackStats", "Initialized Amplify");
    } catch (AmplifyException error) {
      Log.e("KazeHackStats", "Could not initialize Amplify", error);
    }
  }
}
