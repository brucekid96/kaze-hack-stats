package com.kazehackstats.utils;


import android.content.Context;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {
  public static String getDateString(String timestamp){
    LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.parse(timestamp), ZoneId.systemDefault());
    String dateStr = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dateTime);
    return dateStr;
  }

  public static LocalDate epochMillisToLocalDate(long epochMillis) {
    Instant instant = Instant.ofEpochMilli(epochMillis);
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    return localDateTime.toLocalDate();
  }

  public static String getShortLocalizedDateString(
      Context context, long epochMillis, boolean includeYear) {
    final String ENGLISH_DATE_PATTERN_WITHOUT_YEAR = "MMM d";
    final String ENGLISH_DATE_PATTERN_WITH_YEAR = "MMM d, yyyy";
    final String FRENCH_DATE_PATTERN_WITHOUT_YEAR = "d MMM";
    final String FRENCH_DATE_PATTERN_WITH_YEAR = "d MMM yyyy";
    final String FALLBACK_DATE_PATTERN_WITHOUT_YEAR = "dd / MM";
    final String FALLBACK_DATE_PATTERN_WITH_YEAR = "dd / MM / yyyy";

    SimpleDateFormat dateFormat = new SimpleDateFormat();
    Date date = new Date(epochMillis);

    Locale currentLocale = LocaleUtils.getCurrentLocale(context);
    if (currentLocale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
      dateFormat.applyPattern(
          includeYear ? ENGLISH_DATE_PATTERN_WITH_YEAR : ENGLISH_DATE_PATTERN_WITHOUT_YEAR);
    } else if (currentLocale.getLanguage().equals(Locale.FRENCH.getLanguage())) {
      dateFormat.applyPattern(
          includeYear ? FRENCH_DATE_PATTERN_WITH_YEAR : FRENCH_DATE_PATTERN_WITHOUT_YEAR);
    } else {
      dateFormat.applyPattern(
          includeYear ? FALLBACK_DATE_PATTERN_WITH_YEAR : FALLBACK_DATE_PATTERN_WITHOUT_YEAR);
    }

    return dateFormat.format(date);
  }

}
