package com.example.inimfonakpabio.mp7p1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQCODE = 1;
    ImageView imgDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDisplay = (ImageView) findViewById(R.id.imgDisplay);
    }

    public void TakePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap img = (Bitmap) data.getExtras().get("data");
        imgDisplay.setImageBitmap(img);
    }
}
