package com.kazehackstats.data.remote;

import android.content.Context;
import android.os.Build;

import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;



public class AppSyncProvider {
  private static AWSAppSyncClient sAppSyncClient;
  private static final Object LOCK = new Object();

  // FIXME AppSync client initialization fails on API 19 because the default OKHttp library version
  // only supports API 21 and higher
  public static AWSAppSyncClient getAppSyncClient(Context context) {
    if (sAppSyncClient == null) {
      synchronized (LOCK) {
        AWSConfiguration awsConfig = new AWSConfiguration(context.getApplicationContext());

        AWSAppSyncClient.Builder appSyncClientBuilder = AWSAppSyncClient.builder()
            .context(context.getApplicationContext())
            .awsConfiguration(awsConfig)
            .defaultResponseFetcher(AppSyncResponseFetchers.NETWORK_ONLY);
        sAppSyncClient = appSyncClientBuilder.build();
      }
    }

    return sAppSyncClient;
  }
}
