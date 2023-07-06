package com.kazehackstats.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.io.File;


@Database(entities = {Match.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {

  private static final String TAG = MainDatabase.class.getSimpleName();
  private static final String DATABASE_NAME = "kazehackstats.db";




  private static volatile MainDatabase INSTANCE;

  public static MainDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (MainDatabase.class) {
        if (INSTANCE == null) {
          // Create database here
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              MainDatabase.class, MainDatabase.DATABASE_NAME)

              .build();
        }
      }
    }



    return INSTANCE;

  }

  public abstract MatchDao matchDao();
  public abstract TeamDao teamDao();
}

