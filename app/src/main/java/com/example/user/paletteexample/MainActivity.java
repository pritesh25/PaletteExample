package com.example.user.paletteexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.nature);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {


                Palette.Swatch vibrantSwatch        = p.getVibrantSwatch();

                if(vibrantSwatch != null)
                {
                    int BodyTextColor   = vibrantSwatch.getBodyTextColor();
                    int TitleTextColor  = vibrantSwatch.getTitleTextColor();
                    int Population      = vibrantSwatch.getPopulation();
                    int Rgb             = vibrantSwatch.getRgb();
                    float Hsl[]         = vibrantSwatch.getHsl();

                    TextView tv_BodyTextColor = findViewById(R.id.tv_BodyTextColor);
                    tv_BodyTextColor.setTextColor(BodyTextColor);

                    TextView tv_TitleTextColor = findViewById(R.id.tv_TitleTextColor);
                    tv_TitleTextColor.setTextColor(TitleTextColor);

                    TextView tv_Population = findViewById(R.id.tv_Population);
                    tv_Population.setTextColor(Population);

                    LinearLayout background = findViewById(R.id.background);
                    background.setBackgroundColor(Rgb);

                }
                else
                {

                }

                Palette.Swatch DarkVibrantSwatch    = p.getDarkVibrantSwatch();
                Palette.Swatch LightVibrantSwatch   = p.getLightVibrantSwatch();



                Palette.Swatch DominantSwatch   = p.getDominantSwatch();

                Palette.Swatch MutedSwatch      = p.getMutedSwatch();
                Palette.Swatch DarkMutedSwatch  = p.getDarkMutedSwatch();
                Palette.Swatch LightMutedSwatch = p.getLightMutedSwatch();



            }
        });

    }
}
