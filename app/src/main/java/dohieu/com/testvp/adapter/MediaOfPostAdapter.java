package dohieu.com.testvp.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;


import java.util.List;

import dohieu.com.testvp.R;
import dohieu.com.testvp.model.Imager;

public class MediaOfPostAdapter extends PagerAdapter {


    private List<Imager> mediaList;
    private LayoutInflater inflater;
    private Context context;

    public MediaOfPostAdapter(List<Imager> mediaList, Context context) {
        this.mediaList = mediaList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mediaList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_media_of_post, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);


        imageView.setImageResource(mediaList.get(position).getImgImgage());

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


    public void changeData(List<Imager> mediaList) {
        this.mediaList = mediaList;
        notifyDataSetChanged();
    }
}
