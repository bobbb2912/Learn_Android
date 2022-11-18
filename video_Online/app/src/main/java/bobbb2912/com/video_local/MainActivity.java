package bobbb2912.com.video_local;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        video = findViewById(R.id.video);

        video.setMediaController(new MediaController(MainActivity.this));
//        video.setVideoURI(Uri.parse(
//                "https://rr3---sn-42u-i5olz.googlevideo.com/videoplayback?expire=1651358751&ei=vmdtYqaVL86tvcAP7byjyAU&ip=118.71.165.8&id=o-AKCKwasnPpiGkiMypO6SfbHEtP5el0uLl8REzqctXtMQ&itag=399&aitags=133%2C134%2C135%2C136%2C160%2C242%2C243%2C244%2C247%2C278%2C298%2C299%2C302%2C303%2C394%2C395%2C396%2C397%2C398%2C399&source=youtube&requiressl=yes&mh=Dl&mm=31%2C26&mn=sn-42u-i5olz%2Csn-oguelner&ms=au%2Conr&mv=m&mvi=3&pcm2cms=yes&pl=24&ctier=L&initcwndbps=1648750&spc=4ocVC2fd0IfX5MBgKk_M0vEeAR85pPPTiHRmBfhmTw&vprv=1&mime=video%2Fmp4&ns=b_vtFlsAVje5d2PzbGz2AJUG&gir=yes&clen=12431232&dur=59.999&lmt=1629108474645070&mt=1651336861&fvip=4&keepalive=yes&fexp=24001373%2C24007246&c=WEB&txp=5531432&n=ksbt3PsGAuwiYA&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cctier%2Cspc%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAP-5vxH-ECZuYbGQx15oLH8r-IBe_U8K_q0jJE_zREwGAiEA_iK-cBdxdQZp8j3Ck3MwwszY76Du_MwT-0PXXmC9lnc%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgOimdryz1W_33CeExbcOzZyvfuBK7btxtVPfUg_PDmggCIG3EgyeYLpJQanYIymBIERjz3dlQqV7lijDfkGjtJ8JM&alr=yes&cpn=J8I-mMUgeGMwx6Ih&cver=2.20220429.00.00&rn=10&pot=GpIBCmWVjHbCKZEt_TxH9dKDjlmITmxH-vkd1sc5-1XqJyL4gY8LkQM6kYYFtAuvTuyvTqsBj_NtBSZ72pdeRdX_koHtSF5TL8aVEhCXthPalGhkaBsH3uSksoKVlyKdERXkIQzLa1jnghIpATwYQQ6xVzkM_JhMI-B2_n2VOk0iR-vsihOlx6TsbQyk_o9OOwpmC1c="
//        ));
//        video.setVideoPath("https://rr3---sn-42u-i5ols.googlevideo.com/videoplayback?expire=1651359129&ei=OWltYtbvKI7s2roP_9O-uAM&ip=118.71.165.8&id=o-ALS5VcqADG4IfTA8sJhvBtanXKDrxGY62zHrajT0HOwV&itag=399&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278%2C394%2C395%2C396%2C397%2C398%2C399&source=youtube&requiressl=yes&mh=fz&mm=31%2C26&mn=sn-42u-i5ols%2Csn-ogul7nel&ms=au%2Conr&mv=m&mvi=3&pl=24&ctier=L&initcwndbps=1631250&spc=4ocVCzA70wb5646mSuKoGgejbO9p3OHuCARy1LbfRQ&vprv=1&mime=video%2Fmp4&ns=gmPFj8sEB3C7wZgoabjxcM0G&gir=yes&clen=3627667&dur=15.040&lmt=1647128077167777&mt=1651337099&fvip=3&keepalive=yes&fexp=24001373%2C24007246&c=WEB&txp=5532434&n=Kgo4tR0FP9LuGQ&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cctier%2Cspc%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAO0zeozdQ_HuVFMwPpIXGE2a8AJyLWpsswRBRsr2EwyxAiBpjfqYQeJ9VnqanaPFq2SODRfUIoFgEqalmHS_O0CDiw%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAL79nYkvqh7AIEgJfDtqaJ25GeHPNArhJMZ3y9zFmxN-AiAHswSdCZpwJosnaBJiAKvRuZjvzrsifwtz13eiUTA-SA%3D%3D&alr=yes&cpn=lHZQBqn4w3dJZIyW&cver=2.20220429.00.00&rn=12&pot=GpIBCmUnJBg-E77kmOE5De7a_kAAPsYWTqzsunUlEj6ztCAhJXsV1I8SZIcu477RBlcGTQ64N2GM3RwGLA0saP2ZtekiXqpM44uodTjbKfeboUcl8ANapaU4iFic2Alxcunx9-zirFlsFxIpATwYQQ6q8EB8h45VJlS_m0B-VL00WfZd-QuSoIcwdOrUkhZkAvD7eVY="
//        );
        video.setVideoURI(Uri.parse("https://rr4---sn-42u-i5ol6.googlevideo.com/videoplayback?expire=1651360065&ei=4GxtYqePOrqyvcAPvZyb0A8&ip=118.71.165.8&id=o-ABjvsbjLCmH4OkbXurbxqasQeyT5v-zjjEdCG5UhMuo1&itag=248&aitags=133%2C134%2C135%2C136%2C137%2C160%2C242%2C243%2C244%2C247%2C248%2C278&source=youtube&requiressl=yes&mh=SO&mm=31%2C26&mn=sn-42u-i5ol6%2Csn-oguesn6s&ms=au%2Conr&mv=m&mvi=4&pcm2cms=yes&pl=24&initcwndbps=1473750&spc=4ocVC4cfQ-EKcRLluu3InCtKSxoPM0EiSIXM2xtRpw&vprv=1&mime=video%2Fwebm&ns=OUcZnpB_wwWMvSMMWMac0_gG&gir=yes&clen=59957128&dur=302.958&lmt=1650732088570773&mt=1651338060&fvip=5&keepalive=yes&fexp=24001373%2C24007246&c=WEB&txp=5437434&n=dDaynt3XwXqDAg&sparams=expire%2Cei%2Cip%2Cid%2Caitags%2Csource%2Crequiressl%2Cspc%2Cvprv%2Cmime%2Cns%2Cgir%2Cclen%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAOR3RMwq594Wqa81BXu36925Of85D3DjdiNgaHsEISsJAiB6Jto8_6iunQFtr_HDSpPxnvCx-P4yvhhWNFCm3cilQA%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAKsoZleALqFWFTW812YVitSQHue9u0HcI2P1_hJcifgyAiBanj6nW4GolwWKYHexpc1b6kdPmwC5SaK0DjlljnKbzQ%3D%3D&alr=yes&cpn=sEoWwSsJhPQUV7Et&cver=2.20220429.00.00&rn=1="
        ));
        video.start();
    }
}