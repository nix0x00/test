package org.nix_dev.meta.transitionanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        textview = (TextView) findViewById(R.id.textView);
    }

    public void click(View view) {
        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.TOP);

        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        TransitionManager.beginDelayedTransition(root, slide);
        imageView.setVisibility(View.INVISIBLE);

        startActivity(new Intent(this, InstructiveMotion.class));
    }

    public void demoInterpolator(View v) {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        textview.setTranslationY(metrics.heightPixels);

        AccelerateInterpolator interpolator = new AccelerateInterpolator();
        textview.animate().setInterpolator(interpolator)
                .setDuration(350)
                .setStartDelay(600)
                .translationYBy(-metrics.heightPixels)
                .start();
            }
}
