package com.kazehackstats.utils;

import android.net.Uri;

import androidx.room.TypeConverter;

import java.util.Date;
import java.util.UUID;

public class Converters {

  @TypeConverter
  public static Date toDate(Long timestamp) {
    return timestamp == null ? null : new Date(timestamp);

  }

  @TypeConverter
  public static Long fromDate(Date date) {
    return date == null ? null : date.getTime();
  }

  @TypeConverter
  public static String stringFromURI(Uri uri) {
    return uri == null ? null : uri.toString();
  }

  @TypeConverter
  public static Uri UriToString(String s) {
    return s == null ? null : Uri.parse(s);

  }

  @TypeConverter
  public static String uuidFromString(UUID mId) {
    return mId == null ? null: mId.toString();
  }
  @TypeConverter
  public static UUID uuidToString (String s) {
    return s == null ? null : UUID.fromString(s);
  }

}
