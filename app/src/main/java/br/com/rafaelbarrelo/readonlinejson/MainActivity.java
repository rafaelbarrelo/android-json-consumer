package br.com.rafaelbarrelo.readonlinejson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.rafaelbarrelo.readonlinejson.api.DataAPIHelper;
import br.com.rafaelbarrelo.readonlinejson.model.DataJsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataAPIHelper helper = new DataAPIHelper(this);
        helper.getDataJsonObject().enqueue(new Callback<DataJsonObject>() {
            @Override
            public void onResponse(Call<DataJsonObject> call, Response<DataJsonObject> response) {
                Log.d("TAG", response.body().getData().toString());
            }

            @Override
            public void onFailure(Call<DataJsonObject> call, Throwable t) {

            }
        });


    }
}
