package com.example.application.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadImageUtil {
    private Activity context;

    public DownloadImageUtil(Activity context) {
        this.context = context;
    }

    public void downloadImage (final String url, final ImageView imageView) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = getUnsafeOkHttpClient();
                Request request = new Request.Builder().get()
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();

                    }
                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("TAG",response.toString());

                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {

//                                              Log.d("TAG",response.body().string());
                                        Bitmap bitmap = null;
                                        try {
                                            byte[] bytes = response.body().bytes();
                                            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                            final Bitmap finalBitmap = bitmap;
                                            context.runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    imageView.setImageBitmap(finalBitmap);
                                                }
                                            });
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }).start();


                            }
                        });
                    }
                });
            }
        }).start();

    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
