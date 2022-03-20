package com.example.hosp.analysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.hosp.CreateCall;
import com.example.hosp.R;
import com.example.hosp.Select_Doctor;

public class AddRecord extends AppCompatActivity {
    int SELECT_PICTURE = 200;
    ImageView imagebackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
    }
    public void uploadimagefromgallery(View view) {
        imageChooser();
    }

    public void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    imagebackground.setImageURI(selectedImageUri);
                }
            }
        }
    }

    public void onCreateRecord(View view) {
        Intent intent=new Intent(AddRecord.this, RequestsDetails.class);
        startActivity(intent);
    }
}