package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import androidx.fragment.app.Fragment;



import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CinemaFragment extends Fragment {

    String URL_CinemaList = "http://data1.library.sh.cn/shnh/dydata/webapi/architecture/getArchitecture?free%20text=%E4%B8%8A%E6%B5%B7%E5%A4%A7%E6%88%8F%E9%99%A2&key=ac55669606af89333c79296def567d4b48059d4b";
    List<ArrayList<String>> listOfCinema;
    ArrayList<Integer> imgResource = new ArrayList<>();

    //Assign variable
    private TextView cinema_name;
    TextView intro;
    TextView intro_details;
    ImageView cinema_image;
    private int CINEMA_NAME;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            CINEMA_NAME = getArguments().getInt("CINEMA");
        }
        catch (java.lang.NullPointerException e){
            CINEMA_NAME = 0;
        }

        imgResource.add(R.drawable.daxiyuan);
        imgResource.add(R.drawable.yingyueting);
        imgResource.add(R.drawable.renming);
        imgResource.add(R.drawable.lanxin);
        imgResource.add(R.drawable.daguangmin);
        imgResource.add(R.drawable.xinguangyin);
        imgResource.add(R.drawable.meiqi);
        imgResource.add(R.drawable.changjiang);
        imgResource.add(R.drawable.huangpu);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cinema, container, false);
        try {


            //display image and text
            cinema_name = (TextView) rootView.findViewById(R.id.cinema_name);
            intro = (TextView) rootView.findViewById(R.id.intro);
            intro_details = (TextView) rootView.findViewById(R.id.intro_details);
            cinema_image = (ImageView) rootView.findViewById(R.id.cinemaImage);
            intro_details.findViewById(R.id.intro_details).setSelected(true);

            listOfCinema = new ArrayList<ArrayList<String>>();
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    URL_CinemaList,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                JSONArray array = jsonObject.getJSONArray("data");

                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject o = array.getJSONObject(i);
                                    ArrayList<String> cinema_details = new ArrayList<String>();
                                    cinema_details.add(o.getString("nameT")); //0
                                    cinema_details.add(o.getString("nameS")); //1
                                    cinema_details.add(o.getString("nameE")); //2
                                    cinema_details.add(o.getString("orgName")); //3
                                    cinema_details.add(o.getString("des")); //4
                                    cinema_details.add(o.getString("bUri")); //5
                                    cinema_details.add(o.getString("nameOtherUri")); //6
                                    cinema_details.add(o.getString("dramaName")); //7
                                    cinema_details.add(o.getString("nameOther")); //8
                                    cinema_details.add(o.getString("uri")); //9
                                    cinema_details.add(o.getString("movieName")); //10
                                    cinema_details.add(o.getString("personList")); //11
                                    listOfCinema.add(cinema_details);
                                }
                                cinema_name.setText(listOfCinema.get(CINEMA_NAME).get(1));
                                intro.setText("简介");
                                intro_details.setText(listOfCinema.get(CINEMA_NAME).get(4));
                                cinema_image.setImageResource(imgResource.get(CINEMA_NAME));
//                                String url = listOfCinema.get(CINEMA_NAME).get(9);
//                                if (!url.equalsIgnoreCase(""))
//                                    Picasso.get().load(url).into(cinema_image);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(requireActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
            RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());
            requestQueue.add(stringRequest);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rootView;
    }

}