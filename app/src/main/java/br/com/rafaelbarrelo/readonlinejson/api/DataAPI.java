package br.com.rafaelbarrelo.readonlinejson.api;

import br.com.rafaelbarrelo.readonlinejson.model.DataJsonObject;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rafaelbarrelo on 8/21/16.
 */

public interface DataAPI {

    @GET("data.json")
    Call<DataJsonObject> getData();
}
