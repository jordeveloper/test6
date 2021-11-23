package com.example.devscodex.Interfaces;

import com.example.devscodex.Model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RetrofitService
{

    //  https://www.api.themoviedb.org/3/search/movie?api_key="YOUR_API_KEY"&query="MOVIE_NAME"
    //clé api = 2c46288716a18fb7aadcc2a801f3fc6b

   // https://www.api.themoviedb.org/3/search/person?api_key="YOUR_API_KEY"&query="ACTOR_NAME"

    //https://www.api.themoviedb.org/3/

    // create a service to the get result and convert result into model class

    @GET("search/movie")
    Call<MovieResponse> getMoviesByQuery(@Query("api_key") String api_key, @Query("query") String query);

    //now create a service for person response
    // before that ceate a model for person results

}
