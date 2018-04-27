package net.churchofgod.cogmedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.churchofgod.cogmedia.R;
import net.churchofgod.cogmedia.model.liveModel;

import java.util.ArrayList;

public class liveAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<liveModel> imageObjects;

    private LayoutInflater mLayoutInflate;


    public liveAdapter(Context context, ArrayList<liveModel> imageObjects){
        this.context = context;
        this.imageObjects = imageObjects;

        this.mLayoutInflate = LayoutInflater.from(context);
    }

    public int getCount() {
        if(imageObjects != null) return  imageObjects.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(imageObjects != null && imageObjects.size() > position) return  imageObjects.get(position);

        return null;
    }

    @Override
    public long getItemId(int position) {
        if(imageObjects != null && imageObjects.size() > position) return  imageObjects.get(position).getId();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {

            viewHolder = new ViewHolder();

            convertView = mLayoutInflate.inflate(R.layout.gridview, parent,
                    false);
            viewHolder.imageView = convertView.findViewById(R.id.artwork);
            viewHolder.textView = convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        liveModel imageObject = (liveModel) getItem(position);
        if(imageObject != null) {
            Glide
                    .with(context)
                    .load(imageObject.getImageUrl())
                    .centerCrop()
                    .crossFade()
                    .into(viewHolder.imageView);

            viewHolder.textView.setText(imageObject.getTitle());
        }

        return convertView;
    }

    private class ViewHolder {
        private ImageView imageView;
        private TextView textView;
    }
}
