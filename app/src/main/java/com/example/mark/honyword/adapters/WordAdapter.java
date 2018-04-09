package com.example.mark.honyword.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mark.honyword.R;
import com.example.mark.honyword.util.DictionaryModel;

import java.util.List;

//public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
//
//    private List<DictionaryModel> dictionaryModels;
//    private boolean tables;
//
//    public WordAdapter(boolean tables) {
//        this.tables = tables;
//    }
//
//    public void setDictionaryModels(List<DictionaryModel> dictionaryModels) {
//        this.dictionaryModels = dictionaryModels;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View worldView;
//        if (tables)
//            worldView = inflater.inflate(R.layout.word_item, parent, false);
//        else worldView = inflater.inflate(R.layout.word_history_item, parent, false);
//        return new ViewHolder(worldView, context);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        DictionaryModel dictionaryModel = dictionaryModels.get(position);
//        holder.wordText.setText(dictionaryModel.getWord());
//        holder.wordTextDe.setText(dictionaryModel.getDefinition());
//    }
//
//    @Override
//    public int getItemCount() {
//        return dictionaryModels.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        Context context;
//        TextView wordText, wordTextDe;
//
//        ViewHolder(View itemView, Context context) {
//            super(itemView);
//            this.context = context;
//            if (tables) {
//                wordText = itemView.findViewById(R.id.wordText);
//                wordTextDe = itemView.findViewById(R.id.wordTextDef);
//            } else {
//                wordText = itemView.findViewById(R.id.wordTextHistory);
//                wordTextDe = itemView.findViewById(R.id.wordTextDefHistory);
//            }
//        }
//    }
//}
