package com.ok.ifan.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.etsy.android.grid.StaggeredGridView;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/inter_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/boca_juniors_badge.jpg?itok=xJrhX0jF",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/roma_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/liverpool_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/cluj_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/ajax_badge.jpg?itok=P2h_rP3Y",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/cska_moscow_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/birmingham_badge.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/guangzhou.jpg",
            "https://images.cdn.fourfourtwo.com/sites/fourfourtwo.com/files/styles/inline-image/public/basel_badge.jpg"
    };
    private GridView gvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Logo Klub Dunia");
        gvItem = (GridView)findViewById(R.id.gv_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gvItem.setAdapter(itemGridAdapter);
        gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this,

                        images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_staggered) {
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
