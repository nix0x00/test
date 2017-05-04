package org.nix_dev.meta.transitionanimation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

public class InstructiveMotion extends AppCompatActivity {

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructive_motion);

        scrollView = (ScrollView) findViewById(R.id.scroll);
    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        final int startScrollPos = getResources().getDimensionPixelSize(R.dimen.scroll_size);

        Animator animator = ObjectAnimator.ofInt(
                scrollView,
                "scrollY",
                startScrollPos).setDuration(300);
        animator.start();
    }

}
