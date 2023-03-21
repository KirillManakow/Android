package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class photo extends AppCompatActivity  {
    ImageView imageView;
    RelativeLayout layout;
    private boolean isImageScaled;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        layout = findViewById(R.id.relativeLayout);
        imageView = findViewById(R.id.photo);



        layout.setOnTouchListener(new OnSwipeTouchListener(photo.this) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                try
                {
                    Profile.maskProfileImage.imageProfile.delete();
                }
                catch(Exception exception)
                {
                    Toast.makeText(photo.this, "При удаление картинки возникла ошибка!", Toast.LENGTH_LONG).show();
                }
                startActivity(new Intent(photo.this, Profile.class));
            }
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                startActivity(new Intent(photo.this, Profile.class));
               }
            @Override
            public void onDoubleClick() {
                super.onDoubleClick();

                if (!isImageScaled) imageView.animate().scaleX(1.6f).scaleY(1.6f).setDuration(500);
                if (isImageScaled) imageView.animate().scaleX(1f).scaleY(1f).setDuration(500);
                isImageScaled = !isImageScaled;

            }
        });

        if(Profile.maskProfileImage.getImageProfile().exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(Profile.maskProfileImage.getImageProfile().getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }

    }



    public void Close(View view)
    {
        startActivity(new Intent(this, Profile.class));
    }
    public void Delete(View view)
    {
        try
        {
            Profile.maskProfileImage.imageProfile.delete();
        }
        catch(Exception exception)
        {
            Toast.makeText(this, "При удаление картинки возникла ошибка!", Toast.LENGTH_LONG).show();
        }
        startActivity(new Intent(this, Profile.class));
    }
}