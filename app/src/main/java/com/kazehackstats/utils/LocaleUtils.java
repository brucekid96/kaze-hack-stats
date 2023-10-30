package com.kazehackstats.utils;

import android.content.Context;

import androidx.core.os.ConfigurationCompat;

import java.util.Locale;

public class LocaleUtils {


  public static Locale getCurrentLocale(Context context) {
    return ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
  }

}
