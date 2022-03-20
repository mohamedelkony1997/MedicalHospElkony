package com.example.hosp.manger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hosp.R;
import com.example.hosp.doctor.BottomSheetDoctor;
import com.example.hosp.doctor.MedicalRecord;

public class AddTaskManger extends AppCompatActivity {
    int SELECT_PICTURE = 200;
    ImageView imagebackground;
    TextView addtodo,gettodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_manger);
        addtodo=findViewById(R.id.addtodo);
        gettodo=findViewById(R.id.todo);
        Intent intent=getIntent();

        addtodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetManger bottomSheetManger=new BottomSheetManger();
                bottomSheetManger.show(getSupportFragmentManager(),"TAG");
            }
        });
    }

    public void onsendtask(View view) {
        Intent intent=new Intent(AddTaskManger.this, MainTasks.class);
        startActivity(intent);
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
}