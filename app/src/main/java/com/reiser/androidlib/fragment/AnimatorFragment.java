package com.reiser.androidlib.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reiser.androidlib.R;

/**
 * Created by sunsharp on 16/9/14.
 */
public class AnimatorFragment extends Fragment {
    private  final static String TAG="AnimatorFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animation, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        startValueAnimator();
        startObjectAnimator();
    }


    private void startValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d(TAG,"value is "+(Integer)animation.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }

    private void startObjectAnimator() {

    }
}
