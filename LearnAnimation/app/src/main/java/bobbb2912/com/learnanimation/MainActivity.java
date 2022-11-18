package bobbb2912.com.learnanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnZoom, btnClockwise, btnFade, btnBlink, btnMove, btnSlide;
    ImageView imgHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        imgHinh=findViewById(R.id.imgHinh);
        btnZoom=findViewById(R.id.btnZoom);
        btnClockwise=findViewById(R.id.btnClockwise);
        btnFade=findViewById(R.id.btnFade);
        btnBlink=findViewById(R.id.btnBlink);
        btnMove=findViewById(R.id.btnMove);
        btnSlide=findViewById(R.id.btnSlide);
        imgHinh.setImageResource(R.drawable.h1);

        btnZoom.setOnClickListener(this);
        btnClockwise.setOnClickListener(this);
        btnFade.setOnClickListener(this);
        btnBlink.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        btnSlide.setOnClickListener(this);


    }
//https://www.tutorialspoint.com/android/android_animations.htm
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnZoom:
                Animation zoom = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom);
                imgHinh.startAnimation(zoom);
                break;
            case R.id.btnClockwise:
                Animation clockwise = AnimationUtils.loadAnimation(MainActivity.this, R.anim.clockwise);
                imgHinh.startAnimation(clockwise);
                break;
            case R.id.btnFade:
                Animation fade = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade);
                imgHinh.startAnimation(fade);
                break;
            case R.id.btnBlink:
                Animation blink = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
                imgHinh.startAnimation(blink);
                break;
            case R.id.btnMove:
                Animation move = AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
                imgHinh.startAnimation(move);
                break;
            case R.id.btnSlide:
                Animation slide = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide);
                imgHinh.startAnimation(slide);
                break;
        }
    }
}