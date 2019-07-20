package com.example.triphelper.adapter;

import android.media.Image;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.triphelper.R;
import com.example.triphelper.struct.ShortDescription;

public class ShortDesctiptionViewHolder extends  RecyclerView.ViewHolder{
    ImageView placeImage;
    TextView name;
    TextView shortDectiprionView;
    ImageView selectedImage;
    public ShortDesctiptionViewHolder(View itemView){
        super(itemView);
        placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
        name = (TextView) itemView.findViewById(R.id.name);
        shortDectiprionView = (TextView) itemView.findViewById(R.id.shortDescription);
        selectedImage = (ImageView) itemView.findViewById(R.id.imageSelected);
    }
    public void bind(ShortDescription shortDescription){
    name.setText(shortDescription.getName());
   shortDectiprionView.setText(shortDescription.getShortDectiprion());
   if(shortDescription.getIsChecked()) selectedImage.setImageResource(android.R.drawable.ic_delete);
   else selectedImage.setImageResource(android.R.drawable.ic_input_add);
   selectedImage.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           if(shortDescription.getIsChecked()) {selectedImage.setImageResource(android.R.drawable.ic_input_add);
           shortDescription.setIsChecked(false);

           }
           else {selectedImage.setImageResource(android.R.drawable.ic_delete);
           shortDescription.setIsChecked(true);
           }
        /*   for(int i = 0; i < ls.size(); i++){
               if(name.equals(ls.get(i).getName())){
                   ls.get(i).setIsChecked(shortDescription.getIsChecked());
                   break;
               }
           }*/
       }
   });
    }

}
