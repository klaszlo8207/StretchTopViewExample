package hu.lacroix82.stretchtopview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hu.lacroix82.stretchscrollbarexample.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void imageStretchOpen(View view) {
        ExampleImageStretchActivity.open(this);
    }

    public void viewpagerStretchOpen(View view) {
        ExampleViewpagerStretchActivity.open(this);
    }

}
