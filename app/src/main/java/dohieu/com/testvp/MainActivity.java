package dohieu.com.testvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import dohieu.com.testvp.adapter.MediaOfPostAdapter;
import dohieu.com.testvp.model.Imager;

public class MainActivity extends AppCompatActivity {
    private MediaOfPostAdapter adapter;
    private List<Imager> mediaList;
    private CirclePageIndicator indicator;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaList = new ArrayList<>();
        mPager = (ViewPager) findViewById(R.id.pager);
        indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        adapter = new MediaOfPostAdapter(mediaList, this);
        mPager.setAdapter(adapter);
        indicator.setViewPager(mPager);

        getData();

    }

    private void getData() {
        List<Imager> imagers = new ArrayList<>();
        imagers.add(new Imager(R.mipmap.ic_launcher));


        adapter.changeData(imagers);





    }
}
