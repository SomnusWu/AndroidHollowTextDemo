package com.somnus.androidhollowtextdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.somnus.androidhollowtextdemo.view.HollowTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    HollowTextView mHollowTextView;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
                mHollowTextView.setText(((Button) v).getText().toString());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHollowTextView = (HollowTextView) findViewById(R.id.hollow_text);

        ((ImageView) findViewById(R.id.image)).setImageBitmap(createBitmap("我是镂空文字图片", 40));

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    public Bitmap createBitmap(String text, int fontSize) {
        int paddingRight = 10;
        int paddingLeft = 5;

        // Paint config
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        paint.setAntiAlias(true);
        paint.setFakeBoldText(true);

        Bitmap bitmap = Bitmap.createBitmap((int) paint.measureText(text) + paddingRight,
                fontSize + paddingRight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);

        canvas.drawText(text, paddingLeft, fontSize, paint);

        return bitmap;
    }
}
