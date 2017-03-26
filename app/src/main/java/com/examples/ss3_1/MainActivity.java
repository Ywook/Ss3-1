package com.examples.ss3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int rotation = 0;

    TextView textView;

    ImageView imageView;

    RelativeLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요.");

        textView = (TextView) findViewById(R.id.textView1);

        imageView = (ImageView) findViewById(R.id.image1);

        layout1 = (RelativeLayout) findViewById(R.id.relativeLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuRed:
                layout1.setBackgroundColor(Color.rgb(255,0,0));
                break;

            case R.id.mnuBlue:
                layout1.setBackgroundColor(Color.rgb(0,0,255));
                break;

            case R.id.mnuYellow:
                layout1.setBackgroundColor(Color.rgb(255,255,0));
                break;

            case R.id.item_rotation:
                rotation+=30;
                if(rotation >=360) {
                    rotation-=360;
                }
                imageView.setRotation(rotation);
                break;

            case R.id.item_title:
                if(item.isChecked()){
                    item.setChecked(false);
                    textView.setVisibility(View.GONE);
                }else{
                    item.setChecked(true);
                    textView.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.item_expansion:
                if(item.isChecked()){
                    item.setChecked(false);
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }else{
                    item.setChecked(true);
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }
                break;

            case R.id.chicken:
                item.setChecked(true);
                textView.setText("겁나 맛있는 치킨");
                imageView.setImageResource(R.drawable.chicken);
                break;

            case R.id.spaghetti:
                item.setChecked(true);
                textView.setText("새콤한 스파게티");
                imageView.setImageResource(R.drawable.spaghetti);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
