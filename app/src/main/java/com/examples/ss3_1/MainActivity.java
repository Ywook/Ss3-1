package com.examples.ss3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int rotation = 0;

    TextView textView;

    ImageView imageView;

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요.");

        textView = (TextView) findViewById(R.id.textView1);

        imageView = (ImageView) findViewById(R.id.image1);

        layout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuRed:
                layout.setBackgroundColor(Color.RED);
                break;

            case R.id.mnuBlue:
                layout.setBackgroundColor(Color.BLUE);
                break;

            case R.id.mnuYellow:
                layout.setBackgroundColor(Color.YELLOW);
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
                imageView.setImageResource(R.drawable.chicken);
                break;

            case R.id.spaghetti:
                item.setChecked(true);
                imageView.setImageResource(R.drawable.spaghetti);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
