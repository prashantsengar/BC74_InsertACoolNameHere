package com.sih2020.sih_2020_policeapp.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("crime")
    Call<Crime> pushcrime(

            @Query("lat") String lat,
            @Query("long") String longg,
            @Query("crime") String crime

    );
}
