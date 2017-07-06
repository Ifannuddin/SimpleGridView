package com.ok.ifan.simplegridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "https://intermilanfansworldwide.files.wordpress.com/2012/05/ronaldo.jpg",
            "https://static01.nyt.com/images/2010/05/23/sports/YSOCCER/YSOCCER-popup.jpg",
            "http://i.dailymail.co.uk/i/pix/2017/05/28/20/40E4DD1400000578-4550134-image-a-50_1495999296106.jpg",
            "http://images.solopos.com/2012/05/alessandro-nesta-gfdb.com_.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Gianluigi_Buffon_%2831784615942%29.jpg/1200px-Gianluigi_Buffon_%2831784615942%29.jpg",
            "http://i.dailymail.co.uk/i/pix/2014/09/02/1409646459001_wps_5_BATISTUTA_AS_Roma_s_Gabri.jpg",
            "http://mesingol.com/wp-content/uploads/2013/07/Javier-Zanetti-Tak-Tertarik-Jadi-Pelatih.jpg",
            "https://www.thesun.co.uk/wp-content/uploads/2016/06/nintchdbpict000003490322.jpg",
            "http://a.espncdn.com/combiner/i/?img=/soccernet/design05/images/2012/0309/diegomaradonarun1988_205x285.jpg",
            "http://s.weltsport.net/bilder/spieler/gross/1355.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        getSupportActionBar().setTitle("Star Wars");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context) {
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
