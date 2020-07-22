package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewFlipper v_flipper;
    GridView gridView;
    BottomNavigationView bottomNav ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // images slide display
        int flipImages [] = {R.drawable.s1,R.drawable.s2,R.drawable.s3};
        v_flipper = findViewById(R.id.v_fliper);
        gridView = findViewById(R.id.gridView);
        for (int image:flipImages){
            flipImages(image);
        }

        // images grid
        String [] gridNames = {"testing1","testing2","testing3","testing4","testing5","testing6","testing7","testing8"};
        int [] gridimages = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8};
        CustomAdapter customAdapter = new CustomAdapter(gridNames,gridimages,this);
        gridView.setAdapter(customAdapter);

        //bottom navigation
        bottomNav = findViewById(R.id.bottom_navigation_main);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        break;
                    case R.id.nav_cinema:
                        Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_actor:
                        Intent intent2 = new Intent(MainActivity.this,Actor.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }

    public void flipImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public class CustomAdapter extends BaseAdapter{
        private String [] tvNames;
        private int [] tvPhotos;
        private Context context;
        private LayoutInflater layoutInflater;
        public CustomAdapter(String [] tvNames,int [] tvPhotos,Context context){
            this.tvNames = tvNames;
            this.tvPhotos = tvPhotos;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return tvPhotos.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = layoutInflater.inflate(R.layout.grid_row_items,viewGroup,false);
            }

            TextView tvName = view.findViewById(R.id.imageName);
            ImageView tvPhoto = view.findViewById(R.id.imageView);

            tvName.setText(tvNames[i]);
            tvPhoto.setImageResource(tvPhotos[i]);

            return view;
        }
    }
}