package com.harshit.goswami.makenote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.harshit.goswami.makenote.modals.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakerActivity extends AppCompatActivity {
    EditText editText_title,editText_notes;
    ImageView img_save;
    Notes notes;
    boolean isoldNote =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        img_save =findViewById(R.id.img_save);
       editText_title =findViewById(R.id.editText_title);
      editText_notes =findViewById(R.id.editText_notes);


      notes =new Notes();

      try {
          notes = (Notes) getIntent().getSerializableExtra("old_note");
          editText_title.setText(notes.getTitle());
          editText_notes.setText(notes.getNotes());
          isoldNote=true;
      }catch (Exception e){
          e.printStackTrace();
      }

        img_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title =editText_title.getText().toString();
                String description = editText_notes.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "Please add some notes!"
                            ,Toast.LENGTH_SHORT).show();
                    return;
                }


                SimpleDateFormat formatter = new SimpleDateFormat("EEE,d MMM yyyy HH:mm a");
                Date date =new Date();

                if(!isoldNote){
                    notes = new Notes();
                }
                notes.setTitle(title);
                notes.setNotes(description);

                notes.setDate(formatter.format(date));

                Intent intent =new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });
    }
}