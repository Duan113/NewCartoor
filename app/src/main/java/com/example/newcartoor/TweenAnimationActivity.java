package com.example.newcartoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class TweenAnimationActivity extends AppCompatActivity {

    private ImageView ivInside;
    private ImageView ivOuter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        textView=findViewById(R.id.tv_view);
        ivInside=findViewById(R.id.iv_inside_circle);
        ivOuter=findViewById(R.id.iv_outer_circle);

        Animation insideCircle=AnimationUtils.loadAnimation(this,R.anim.inside_rotate);
        insideCircle.setInterpolator(new LinearInterpolator());

        Animation outerCircle=AnimationUtils.loadAnimation(this,R.anim.out_rotate);
        insideCircle.setInterpolator(new LinearInterpolator());

        ivInside.startAnimation(insideCircle);
        ivOuter.startAnimation(outerCircle);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_translation:
                //根据anim/xml创建
//                Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_translate);
//                textView.startAnimation(animation);

                Animation animation=new TranslateAnimation(0,100,0,300);
                animation.setDuration(2000);
                textView.startAnimation(animation);
                break;

            case R.id.btn_scale:
//                根据anim/xml创建
                animation= AnimationUtils.loadAnimation(this,R.anim.anim_scale);
                textView.startAnimation(animation);

//                animation=new TranslateAnimation(0,100,0,300);
//                animation.setDuration(2000);
//                textView.startAnimation(animation);
                break;
            case R.id.btn_set:
                animation=AnimationUtils.loadAnimation(this,R.anim.anim_set);
                textView.startAnimation(animation);
                break;
            case R.id.btn_alpha:
//                animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
//                tvView.startAnimation(animation);

                //                动态创建
                animation = new AlphaAnimation(1,0);
                animation.setDuration(3000);
                textView.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.out_rotate);
                textView.startAnimation(animation1);

                //                动态创建
//                animation = new RotateAnimation(0,-360,0,0);
//                animation.setDuration(3000);
                ivInside.startAnimation(animation1);
                ivOuter.startAnimation(animation1);
                textView.startAnimation(animation1);
                break;
            case R.id.btn_flash:
                AlphaAnimation alpha = new AlphaAnimation(0.1f,1.0f);
                alpha.setDuration(3000);
                alpha.setRepeatCount(10);
                alpha.setRepeatMode(Animation.REVERSE);
                textView.startAnimation(alpha);
                break;
            case R.id.btn_change:
                Intent intent = new Intent(TweenAnimationActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
            case R.id.btn_compose:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                textView.startAnimation(animation);

                final Animation second = AnimationUtils.loadAnimation(this, R.anim.out_rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.startAnimation(second);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;


        }
    }
}
