package com.hva.tsse.juniorleraar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hva.tsse.juniorleraar.R;
import com.hva.tsse.juniorleraar.model.DialogueCard;

import java.util.List;

/**
 * Created by Melanie on 21-2-2018.
 */

public class DialogueCardAdapter extends BaseAdapter
{
    private final String TAG = "DIALOGUECARDADAPTER";

    private Context context;
    private List<DialogueCard> mDialogueCards;

    public DialogueCardAdapter() {
        super();
    }

    public DialogueCardAdapter(Context context, List<DialogueCard> mDialogueCards) {
        this.context = context;
        this.mDialogueCards = mDialogueCards;
    }

    @Override
    public int getCount() {
        return mDialogueCards.size();
    }

    @Override
    public DialogueCard getItem(int position) {
        return mDialogueCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (mDialogueCards.get(position).getTitle().matches("\\d\\.(\\s|1).*") &&
                        position + 1 < mDialogueCards.size() &&
                        mDialogueCards.get(position).getTitle() == mDialogueCards.get(position + 1).getTitle()) {
            // if section header
            view = inflater.inflate(R.layout.list_section_item, viewGroup, false);
            TextView item_section_title = (TextView) view.findViewById(R.id.list_item_section_title);
            item_section_title.setText((mDialogueCards.get(position)).getCompetence());
            view.setOnClickListener(null);
        }
        else
        {
            // if item
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
            TextView item_title = (TextView) view.findViewById(R.id.list_item_title);
            item_title.setText((mDialogueCards.get(position)).getTitle());
        }
        return view;
    }
}
