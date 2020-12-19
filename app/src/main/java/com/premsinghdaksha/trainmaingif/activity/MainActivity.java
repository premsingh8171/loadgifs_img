package com.premsinghdaksha.trainmaingif.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.premsinghdaksha.startactivityanimationlibrary.AppUtils;
import com.premsinghdaksha.trainmaingif.R;
import com.premsinghdaksha.trainmaingif.adapter.DataAdapter;
import com.premsinghdaksha.trainmaingif.interfaces.ApiInterface;
import com.premsinghdaksha.trainmaingif.model.DataDTO;
import com.premsinghdaksha.trainmaingif.model.ResponseDTO;
import com.premsinghdaksha.utils.BaseActivity;
import com.premsinghdaksha.utils.LocalPreference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity {
    private ApiInterface apiInterface;
    private DataAdapter dataAdapter;
    private RecyclerView rv_gif;
    private SwipeRefreshLayout refrece;
    private LocalPreference localPreference;
    private List<DataDTO> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localPreference = new LocalPreference(MainActivity.this);
        dataList.clear();
        rv_gif = findViewById(R.id.rv_gif);
        refrece = findViewById(R.id.refrece);
        // apiInterface = APIClient.getClient().create(ApiInterface.class);
        //ApiResponce();

        if (dataList.size() == 0) {
            if (isConnectingToInternet()) {
                apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
            }
            {
                Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        } else {
            dataList = localPreference.getData("offile");
            rvSetData(dataList);
        }

        refrece.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                localPreference.clear();
                if (isConnectingToInternet()) {
                    refrece.setRefreshing(true);
                    apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
                } else {
                    Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    //using retrofit
    private void ApiResponce() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Call<List<DataDTO>> call = apiInterface.getdata("eLPy7CXqimAo9wqht5EKRcAujKGpzDsV", "25");
        call.enqueue(new Callback<List<DataDTO>>() {
            @Override
            public void onResponse(Call<List<DataDTO>> call, Response<List<DataDTO>> response) {
                progressDialog.dismiss();
                if (!response.isSuccessful()) {
                    Log.d("response__", String.valueOf(response));
                    return;
                }
                List<DataDTO> data_ = response.body();
                for (DataDTO data : data_) {
                    String data1 = "";
                    data1 += "ID: " + data.getId() + "\n";
                }
            }

            @Override
            public void onFailure(Call<List<DataDTO>> call, Throwable t) {
                // progressDialog.dismiss();
            }


        });
    }

    //using volley
    private void apiCall(String urls) {
        refrece.setRefreshing(false);
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.GET, urls, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response);
                refrece.setRefreshing(false);
                dataList.clear();
                progressDialog.dismiss();
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);
                dataList = responseDTO.getData();
                localPreference.StoreData(dataList, "offile");
                rvSetData(responseDTO.getData());
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }

    private void rvSetData(List<DataDTO> dataDTO) {
        dataAdapter = new DataAdapter(dataDTO, MainActivity.this, new DataAdapter.OnClickGif() {
            @Override
            public void onClik(DataDTO dataDTO) {
                String gif = "https://media1.giphy.com/media/" + dataDTO.getId() + "/giphy.gif";
                Log.d("gif", gif);
                Intent intent = new Intent(MainActivity.this, GifFullScreen.class);
                intent.putExtra("url", gif);
                AppUtils.startActivityRightToLeft(MainActivity.this,intent);
            }
        });
        rv_gif.setAdapter(dataAdapter);
    }
}