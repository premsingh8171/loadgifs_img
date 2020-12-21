package com.premsinghdaksha.trainmaingif.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
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
import com.premsinghdaksha.utils.APIClient;
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
    private EditText search_giphy;
    private SwipeRefreshLayout refrece;
    private LocalPreference localPreference;
    private List<DataDTO> dataList = new ArrayList<>();
    private List<DataDTO> filters_dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localPreference = new LocalPreference(MainActivity.this);
        search_giphy = findViewById(R.id.search_giphy);
        rv_gif = findViewById(R.id.rv_gif);
        refrece = findViewById(R.id.refrece);
        apiInterface = APIClient.getClient().create(ApiInterface.class);
        dataList.clear();
        dataList = localPreference.getData("offline");

        if (dataList.size() == 0) {
            if (isConnectingToInternet()) {
                ApiResponce();
                //apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
            }
            {
                Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
            }
        } else {
            dataList = localPreference.getData("offline");
            Log.d("dataList_sizeoff", String.valueOf(dataList.size()));

            rvSetData(dataList);
        }

        refrece.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isConnectingToInternet()) {
                    localPreference.clear();
                    dataList.clear();
                    refrece.setRefreshing(true);
                    ApiResponce();

                    // apiCall("https://api.giphy.com/v1/gifs/trending?api_key=eLPy7CXqimAo9wqht5EKRcAujKGpzDsV&limit=25");
                } else {
                    Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();
                    refrece.setRefreshing(false);

                }
            }
        });

        search_giphy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (dataList.isEmpty()) {
                    return;
                }
                filters_dataList = filter(dataList, s.toString());
                dataAdapter.setFilter(filters_dataList);
                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    //using retrofit
    private void ApiResponce() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        Call<ResponseDTO> call = apiInterface.getdata("eLPy7CXqimAo9wqht5EKRcAujKGpzDsV", "25");
        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                Log.d("Response___", response.body().toString());
                refrece.setRefreshing(false);

                progressDialog.dismiss();
                dataList = response.body().getData();
                localPreference.StoreData(dataList, "offline");
                rvSetData(dataList);


            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                refrece.setRefreshing(false);
                progressDialog.dismiss();
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
                localPreference.StoreData(dataList, "offline");
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
                AppUtils.startActivityRightToLeft(MainActivity.this, intent);
            }
        });
        rv_gif.setAdapter(dataAdapter);
    }

    //search List logic
    private List<DataDTO> filter(List<DataDTO> models, String query) {
        query = query.toLowerCase();

        final List<DataDTO> filteredModelList = new ArrayList<>();
        for (DataDTO model : models) {
            final String text = model.getTitle().toLowerCase();
            //  final String text1 = model.getCategories_name().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);

            }
        }
        return filteredModelList;

    }
}