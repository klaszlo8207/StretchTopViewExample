package hu.lacroix82.stretchtopview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.lacroix82.stretchtopview.Globals;
import hu.lacroix82.stretchtopview.adapters.ImageViewAdapter;
import stretchtopview.lacroix82.hu.stretchscrollbarexample.R;
import stretchtopview.lacroix82.hu.stretchtopviewlibrary.stretch.StretchTopScrollView;

public class ExampleViewpagerStretchActivity extends AppCompatActivity {

    @Bind(R.id.stretchTopView)
    StretchTopScrollView stretchTopView;
    private ArrayList<Integer> drawables = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch_vp);

        ButterKnife.bind(this);

        init();
    }

    private void init() {

        final FrameLayout topView = (FrameLayout)stretchTopView.getTopView();
        final LinearLayout bottomView = (LinearLayout)stretchTopView.getBottomView();

        final CirclePageIndicator indicator = (CirclePageIndicator) topView.getChildAt(1);

        TextView descriptionTextView = (TextView) bottomView.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(Html.fromHtml(Globals.DESC));

        stretchTopView.setFactor(1.5f);

        stretchTopView.setChangeListener(new StretchTopScrollView.onOverScrollChanged() {
            @Override
            public void onChanged(float factor) {
                indicator.setAlpha(factor);
            }
        });

        addDatasToViewPager((ViewPager) topView.getChildAt(0), indicator);
    }

    private void addDatasToViewPager(ViewPager vp, CirclePageIndicator indicator) {
        for (int i = 0; i < 3; i++) {
            int res = getResources().getIdentifier("img" + (i + 1), "drawable", this.getPackageName());
            drawables.add(res);
        }

        ImageViewAdapter adapter = new ImageViewAdapter(this, drawables);
        vp.setAdapter(adapter);
        indicator.setViewPager(vp);
    }

    public static void open(MainActivity act) {
        act.startActivity(new Intent(act, ExampleViewpagerStretchActivity.class));
    }

}
