package com.example.volleyassignment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyassignment.User;
import com.example.volleyassignment.UserAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);

        String url = "https://jsonplaceholder.typicode.com/users";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String username = jsonObject.getString("username");
                            String email = jsonObject.getString("email");
                            String phone = jsonObject.getString("phone");
                            String website = jsonObject.getString("website");

                            // استخراج العنوان
                            JSONObject addressObject = jsonObject.getJSONObject("address");
                            String address = addressObject.getString("street") + ", " +
                                    addressObject.getString("suite") + ", " +
                                    addressObject.getString("city") + ", " +
                                    addressObject.getString("zipcode");

                            // استخراج بيانات الشركة
                            JSONObject companyObject = jsonObject.getJSONObject("company");
                            String companyName = companyObject.getString("name");
                            String catchPhrase = companyObject.getString("catchPhrase");
                            String bs = companyObject.getString("bs");

                            User user = new User(id, name, username, email, address, phone, website, companyName, catchPhrase, bs);
                            userList.add(user);
                        }
                        userAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("VolleyError", "Error: " + error.toString()));

        requestQueue.add(jsonArrayRequest);
    }
}
