package com.harshit.goswami.makenote;

import androidx.cardview.widget.CardView;

import com.harshit.goswami.makenote.modals.Notes;

public interface NotesClickListener {

    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
