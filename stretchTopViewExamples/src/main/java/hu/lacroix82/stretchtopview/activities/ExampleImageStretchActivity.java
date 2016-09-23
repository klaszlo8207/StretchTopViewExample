package hu.lacroix82.stretchtopview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import hu.lacroix82.stretchscrollbarexample.R;
import hu.lacroix82.stretchtopview.Globals;
import hu.lacroix82.stretchtopviewlibrary.StretchTopScrollView;

public class ExampleImageStretchActivity extends AppCompatActivity {

    @Bind(R.id.stretchTopView) StretchTopScrollView stretchTopView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch_img);

        ButterKnife.bind(this);

        init();
    }

    private void init() {

        final View bottomView = stretchTopView.getBottomView();

        final TextView descriptionTextView = (TextView) bottomView.findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(Html.fromHtml(Globals.DESC));

        stretchTopView.setFactor(1.7f);

        stretchTopView.setChangeListener(new StretchTopScrollView.onOverScrollChanged() {
            @Override
            public void onChanged(float factor) {
                descriptionTextView.setAlpha(factor);
            }
        });

    }

    public static void open(MainActivity act) {
        act.startActivity(new Intent(act, ExampleImageStretchActivity.class));
    }
}
