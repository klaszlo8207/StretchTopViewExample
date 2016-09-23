package hu.lacroix82.stretchtopview.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;

import hu.lacroix82.stretchscrollbarexample.R;


public class ImageViewAdapter extends PagerAdapter {

	private Context mContext;
	private ArrayList<Integer> mDrawableResources;
	private LayoutInflater mInflater;

	public ImageViewAdapter(Context c, ArrayList<Integer> drawableResources) {
		mContext 				= c;
		mDrawableResources 		= drawableResources;
		mInflater 				= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() { 
		return mDrawableResources.size();
	}

	@Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
	
	@Override
    public Object instantiateItem(ViewGroup container, final int position) {
 
        View viewLayout = mInflater.inflate(R.layout.adapter_images, container, false);

		ImageView imageViewPicture = (ImageView) viewLayout.findViewById(R.id.imageViewPicture);
		imageViewPicture.setImageDrawable(mContext.getResources().getDrawable(mDrawableResources.get(position)));

		container.addView(viewLayout);

        return viewLayout;
	}
	
	@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
 
    }

}
