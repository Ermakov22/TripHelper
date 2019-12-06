package com.example.triphelper.adapter;

import android.media.Image;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.triphelper.R;
import com.example.triphelper.activity.MainActivity;
import com.example.triphelper.fragment.MainFragments.LongDescriptionFragment;
import com.example.triphelper.handler.FragmentController;
import com.example.triphelper.mvp.core.FragmentByName;
import com.example.triphelper.placesAPI.DownloadImageTask;
import com.example.triphelper.struct.ShortDescription;

import static com.example.triphelper.activity.MainActivity.HEIGHT;
import static com.example.triphelper.activity.MainActivity.WIDTH;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.currIndexInListOfPlaces;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.currNameInListOfPlaces;
import static com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment.listOfPlaces;

public class ShortDesctiptionViewHolder extends  RecyclerView.ViewHolder  {
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
        int width = WIDTH;
        int height = HEIGHT / 10 * 3;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,height);
        placeImage.setLayoutParams(params);
        //placeImage.setImageResource(shortDescription.getImageId());
        //new DownloadImageTask(placeImage)
          //      .execute("https://www.dlit.dp.ua/wp-content/uploads/2019/09/%D0%92%D0%B8%D1%82%D1%8F-%D1%81-%D0%BE%D1%80%D0%BB%D0%BE%D0%BC-3-1024x768.jpg");
        new DownloadImageTask(placeImage)
                .execute(shortDescription.getImageId());
        System.out.println(shortDescription.getImageId() + " ATTENTION !!!!!!!!");
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
                for(int i = 0; i < listOfPlaces.get(currIndexInListOfPlaces).size(); i++)
                    if(listOfPlaces.get(currIndexInListOfPlaces).get(i).getName().equals(shortDescription.getName())){
                        listOfPlaces.get(currIndexInListOfPlaces).get(i).setIsChecked(shortDescription.getIsChecked());
                    }
            }
        });
        placeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currNameInListOfPlaces = shortDescription.getName();
                FragmentController.changeNextFragment(new LongDescriptionFragment(), FragmentByName.LONG_DESCRIPTION_FRAGMENT);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currNameInListOfPlaces = shortDescription.getName();
                FragmentController.changeNextFragment(new LongDescriptionFragment(), FragmentByName.LONG_DESCRIPTION_FRAGMENT);
            }
        });
        shortDectiprionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currNameInListOfPlaces = shortDescription.getName();
                FragmentController.changeNextFragment(new LongDescriptionFragment(), FragmentByName.LONG_DESCRIPTION_FRAGMENT);
            }
        });

    }
}
