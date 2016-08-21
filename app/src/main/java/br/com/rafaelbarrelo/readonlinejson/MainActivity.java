package br.com.rafaelbarrelo.readonlinejson;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import br.com.rafaelbarrelo.readonlinejson.api.DataAPIHelper;
import br.com.rafaelbarrelo.readonlinejson.model.DataJsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "RBARRELO_MAIN";

    private UsuarioAdapter adapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inicializaRecycler();
        this.carregaDados();
    }


    private void inicializaRecycler() {
        this.recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.adapter = new UsuarioAdapter();
        this.recyclerView.setAdapter(this.adapter);

        this.swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        this.swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary),
                                                getResources().getColor(R.color.colorAccent),
                                                getResources().getColor(R.color.colorPrimaryDark));

        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carregaDados();
            }
        });
    }

    private void carregaDados() {
        DataAPIHelper helper = new DataAPIHelper(this);
        helper.getDataJsonObject().enqueue(new Callback<DataJsonObject>() {
            @Override
            public void onResponse(Call<DataJsonObject> call, Response<DataJsonObject> response) {
                Log.d(TAG, response.body().getData().toString());
                adapter.setUsuarios(response.body().getData());
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<DataJsonObject> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                Snackbar.make(recyclerView, getString(R.string.erro_carregar), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
