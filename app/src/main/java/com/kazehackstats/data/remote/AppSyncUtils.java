package com.kazehackstats.data.remote;

import com.apollographql.apollo.api.Response;

public class AppSyncUtils {
  public static String stringifyResponse(Response<?> response) {
    return "response = {\n" +
        "data = " + (response.data() == null ? "null" : response.data().toString()) + ", " +
        "errors = " + response.errors().toString() +
        "\n}";
  }
}
