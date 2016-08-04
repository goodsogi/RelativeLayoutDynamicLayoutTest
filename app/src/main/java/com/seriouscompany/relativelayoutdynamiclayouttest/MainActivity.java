package com.seriouscompany.relativelayoutdynamiclayouttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
       addButtonListener();
    }

    private void addButtonListener() {
        Button addView = (Button) findViewById(R.id.addView);
        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView(v);
            }
        });
           }

    private void addView(final View v) {


                RelativeLayout viewContainer = (RelativeLayout) findViewById(R.id.viewContainer);
                ImageView blueImage = new ImageView(MainActivity.this);
        int blueImageId = ViewIdGenerator.run();
        blueImage.setId(blueImageId);
                blueImage.setBackgroundColor(Color.BLUE);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
               //layoutParams.addRule(RelativeLayout.BELOW, v.getId());
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                //blueImage.setLayoutParams(layoutParams);



                viewContainer.addView(blueImage, layoutParams);

        RelativeLayout.LayoutParams buttonLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        buttonLayoutParams.addRule(RelativeLayout.ABOVE,blueImageId);
        v.setLayoutParams(buttonLayoutParams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
