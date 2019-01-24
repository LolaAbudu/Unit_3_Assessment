package org.pursuit.unit_03_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetSingleton {
    private static Retrofit singleInstance;

    private PlanetSingleton() { }

    public static Retrofit getSingleInstance(){
        if (singleInstance != null) {
            return singleInstance;
        }
        singleInstance = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return singleInstance;
    }
}
