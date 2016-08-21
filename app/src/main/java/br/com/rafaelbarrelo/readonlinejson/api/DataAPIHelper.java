package br.com.rafaelbarrelo.readonlinejson.api;

import android.content.Context;

import br.com.rafaelbarrelo.readonlinejson.R;
import br.com.rafaelbarrelo.readonlinejson.model.DataJsonObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafaelbarrelo on 8/21/16.
 */

public class DataAPIHelper {

    private Retrofit retrofit;
    private Context context;

    public DataAPIHelper(Context context) {
        this.context = context;
    }

    private Retrofit getRetrofitInstance(){
        if (this.retrofit == null) {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(this.context.getString(R.string.data_endpoint))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return this.retrofit;
    }

    public DataAPI getDataApi(){
        return this.getRetrofitInstance().create(DataAPI.class);
    }

    public Call<DataJsonObject> getDataJsonObject(){
        return this.getDataApi().getData();
    }
}
