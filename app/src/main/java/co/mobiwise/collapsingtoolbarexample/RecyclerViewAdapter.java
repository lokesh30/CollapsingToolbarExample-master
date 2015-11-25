package co.mobiwise.collapsingtoolbarexample;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RadioViewHolder> {

    private boolean isLongPressed = false;

    private Context context;

    private List<Radio> radioList;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        radioList = new ArrayList<>();
    }

    public void setRadioList(List<Radio> radioList){
        this.radioList = radioList;
        notifyDataSetChanged();
    }

    @Override
    public RadioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card, parent, false);
        RadioViewHolder viewHolder = new RadioViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RadioViewHolder holder, final int position) {

        Radio radio = radioList.get(position);
        holder.textViewRadioName.setText(radio.getRadioName());

        //Button Animation according to operation
        holder.button.setBackgroundResource(R.drawable.off);
        holder.button.setOnClickListener(new View.OnClickListener() {


            boolean isOddClicked = true;

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!isLongPressed) {
                    if (isOddClicked) {
                        holder.button.setBackgroundResource(R.drawable.on);
                        isOddClicked = false;

                    } else


                    {
                        holder.button.setBackgroundResource(R.drawable.off);
                        isOddClicked = true;


                    }
                } else {
                }
            }
        });
        holder.button.setOnLongClickListener(new View.OnLongClickListener() {
            boolean isLongPressed = true;
            @Override
            public boolean onLongClick(View v) {
                if (isLongPressed) {
                    holder.button.setBackgroundResource(R.drawable.power);
                    isLongPressed = false;

                } else {

                    isLongPressed = true;
                }
                return true;
                }

        });
    }


        /*holder.textViewRadioDial.setText("(" + radio.getRadioDial() + ")");*/
       /* Picasso.with(context).load(radio.getRadioArt()).into(holder.imageViewRadioLogo);*/
      /*  holder.textViewRadioTags.setText("#rock #pop #news");*/


    @Override
    public int getItemCount() {
        return radioList.size();
    }

    public class RadioViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.textview_radio_name)
        TextView textViewRadioName;

        @Bind(R.id.main_button)
        Button button;

       /* @Bind(R.id.textview_radio_dial)
        TextView textViewRadioDial;

        @Bind(R.id.textview_tags)
        TextView textViewRadioTags;*/

       // @Bind(R.id.intensity)
        //SeekBar seekBar;
/*
        @Bind(R.id.imageview_radio_logo)
        ImageView imageViewRadioLogo;*/



        public RadioViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

}
