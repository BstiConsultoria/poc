package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by Luis.SILVA.ext on 21/09/2016.
 */

public class SplashScreen extends Activity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro);

        final ImageView animationImageView = (ImageView) findViewById(R.id.AnimationImageView);
        animationImageView.setBackgroundResource(R.drawable.android);

        final AnimationDrawable frameAnimation = (AnimationDrawable) animationImageView.getBackground();
        animationImageView.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        Handler h = new Handler();
        h.postDelayed(this, 2000);
    }

    public void run() {
        startActivity(new Intent(this, BoaViagemActivity.class));
        finish();
    }
}
