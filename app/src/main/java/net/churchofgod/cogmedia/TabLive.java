package net.churchofgod.cogmedia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import net.churchofgod.cogmedia.adapter.liveAdapter;
import net.churchofgod.cogmedia.model.liveModel;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class TabLive extends Fragment {
    private static final String TAG = "TabLive";

    GridView gridView;
    liveAdapter myGridAdapter;
    private static String DATA_URL = "http://app.trumpetradio.com/musicApp/backend/web/index.php/api/book_by_category_title?categoryId=48&platform=1&page=*";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_radio,container,false);

        gridView = view.findViewById(R.id.gridView);
        getData();

        return view;
    }

    private void getData(){

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray allImageArray = jsonObject.optJSONArray("data");
                    if(allImageArray != null && allImageArray.length() > 0){

                        ArrayList<liveModel> imageObjects = new ArrayList<>();
                        for(int i = 0; i < allImageArray.length();i++){
                            JSONObject jsonItem = allImageArray.optJSONObject(i);

                            imageObjects.add(new liveModel(jsonItem));
                        }

                        myGridAdapter = new liveAdapter(getActivity().getApplicationContext(), imageObjects);

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gridView.setAdapter(myGridAdapter);
                            }
                        });
                    }
                } catch (Exception e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(6000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }
}