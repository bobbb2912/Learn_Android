package bobbb2912.com.gamevongxoay_apdunganimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DeviceAdminService;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    ImageView imgHinh;
    TextView txtKQ;
    int phanThuong[] = {300, 700, 1, 900, 100, 200, 2, 1000, 600, 300, 3, 400, 700, 1000, 4, 300, 800, 400, 5, 900, 200, 500, 6, 2000};
    int viTri[] = {8, 16, 31, 46, 61, 76, 91, 106, 121, 136, 151, 166, 181, 196, 211, 226, 241, 256, 271, 286, 301, 316, 331, 346};
    int vong[] = {360, 720, 1080, 1440};
    int from=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        btnPlay=findViewById(R.id.btnPlay);
        imgHinh=findViewById(R.id.imgHinh);
        txtKQ=findViewById(R.id.txtKQ);
        
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLy();
            }
        });

    }

    private void XuLy() {
        final int position = getRandom(viTri.length);
        final int positionVong = getRandom(vong.length);

        int to=viTri[position] +vong[positionVong];


        RotateAnimation anim = new RotateAnimation(from, to, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        anim.setDuration(5000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (phanThuong[position]) {
                    case 1:
                        txtKQ.setText("double");
                        break;
                    case 2:
                        txtKQ.setText("lucky letter");
                        break;
                    case 3:
                        txtKQ.setText("free play");
                        break;
                    case 4:
                        txtKQ.setText("half");
                        break;
                    case 5:
                        txtKQ.setText("bankrupt");
                        break;
                    case 6:
                        txtKQ.setText("lost a turn");
                        break;
                    default:
                        txtKQ.setText(String.valueOf(phanThuong[position]));

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imgHinh.startAnimation(anim);
        from=viTri[position];

    }
    public int getRandom(int max){
        return (int) (Math.random()*max);
    }
}