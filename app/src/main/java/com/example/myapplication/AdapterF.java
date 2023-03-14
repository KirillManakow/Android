package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class AdapterF extends RecyclerView.Adapter<AdapterF.ViewHolder> {

    private List<MaskaFeelings> dataModalArrayList;
    private Context context;

    public AdapterF(List<MaskaFeelings> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterF.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)   {
        return new AdapterF.ViewHolder(LayoutInflater.from(context).inflate(R.layout.maska_nastroenie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterF.ViewHolder holder, int position) {
        final MaskaFeelings modal = dataModalArrayList.get(position);
        holder.title.setText(modal.getTitle());

        if(modal.getImage().equals("null"))
        {
            holder.image.setImageResource(R.drawable.picture);
        }
        else
        {
            new AdapterF.DownloadImageTask((ImageView) holder.image)
                    .execute(modal.getImage());
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Ошибка", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    @Override
    public int getItemCount() {
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.TextNastroenie);
            image = itemView.findViewById(R.id.foto);
        }
    }
}
