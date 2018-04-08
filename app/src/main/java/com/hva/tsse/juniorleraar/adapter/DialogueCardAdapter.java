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
    private Context context;
    private List<DialogueCard> mDialogueCards;

    public DialogueCardAdapter() {
        super();
    }

    public DialogueCardAdapter(Context context, List<DialogueCard> mDialogueCards) {
        this.context = context;
        this.mDialogueCards = mDialogueCards;
    }

    /**
     * @return The amount of cards in the list
     */
    @Override
    public int getCount() {
        return mDialogueCards.size();
    }

    /**
     * @param position The position of the card in the list
     * @return The card at the position
     */
    @Override
    public DialogueCard getItem(int position) {
        return mDialogueCards.get(position);
    }

    /**
     * @param position The position of the card in the list
     * @return Id of the card is the position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * This method will devide the headers and listitems in the list. If header the item must look differently
     * When item
     *
     * @param position The position of the card
     * @param view view
     * @param viewGroup viewgroup
     * @return
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



        // The item in the list is an header when
        // matches a digit and a point and after a space or a 1.
        // the card must be the same as the card after otherwise it isn't a header
        // for that there must be a check that the card is not the last one
        if (mDialogueCards.get(position).getTitle().matches("\\d\\.(\\s|1).*") &&
                        position + 1 < mDialogueCards.size() &&
                        mDialogueCards.get(position).getTitle() == mDialogueCards.get(position + 1).getTitle()) {
            // if section header
            view = inflater.inflate(R.layout.list_section_item, viewGroup, false);
            TextView item_section_title = (TextView) view.findViewById(R.id.list_item_section_title);
            item_section_title.setText((mDialogueCards.get(position)).getCompetence());
            view.setOnClickListener(null);
            setBackgroundColor(item_section_title, true, mDialogueCards.get(position).getTheme());
        }
        else
        {
            // if item
            view = inflater.inflate(R.layout.list_item, viewGroup, false);
            TextView item_title = (TextView) view.findViewById(R.id.list_item_title);
            item_title.setText((mDialogueCards.get(position)).getTitle());
            setBackgroundColor(item_title, false, mDialogueCards.get(position).getTheme());
        }
        return view;
    }

    private void setBackgroundColor(TextView text, boolean title, String theme){
        if (title) {
            switch (theme){
                case "Didactisch Bekwaam":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorDidAccent));
                    break;
                case "Collegiale Samenwerking":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorCollAccent));
                    break;
                case "Pedagogisch Bekwaam":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorPedAccent));
                    break;
            }
        } else {
            switch (theme){
                case "Didactisch Bekwaam":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorDid60));
                    break;
                case "Collegiale Samenwerking":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorColl60));
                    break;
                case "Pedagogisch Bekwaam":
                    text.setBackgroundColor(context.getResources().getColor(R.color.colorPed60));
                    break;
            }
        }

//        switch (theme){
//            case "Didactisch Bekwaam":
//                context.setTheme(context.getResources(R.style.Dida));
//                break;
//            case "Collegiale Samenwerking":
//                context.setTheme(context.getResources(R.style.Coll));
//                break;
//            case "Pedagogisch Bekwaam":
//                context.setTheme(context.getResources(R.style.Peda));
//                break;
//        }
    }
}
