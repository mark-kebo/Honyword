package com.example.mark.honyword;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView.*;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mark.honyword.adapters.WordAdapter;
import com.example.mark.honyword.util.DictionaryModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TranslateActivity extends AppCompatActivity {

    public static final String FILE_DICTIONARY = "dict.txt";
    private List<DictionaryModel> data;
    private RecyclerView rvWord;
    private WordAdapter mWordAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        mToolbar = findViewById(R.id.toolbar_new);
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        rvWord = findViewById(R.id.rvWord);
        rvWord.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        data = new ArrayList<>();
        readFromAsset(getApplicationContext(), FILE_DICTIONARY);
        mWordAdapter = new WordAdapter(true);
        mWordAdapter.setDictionaryModels(data);
        rvWord.setAdapter(mWordAdapter);

        final SearchView searchView = findViewById(R.id.searchView);
        TextView searchText = searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/normal.otf");
        searchText.setTypeface(myCustomFont);
        searchText.setTextColor(getResources().getColor(R.color.colorPrimary));
        searchText.setHintTextColor(getResources().getColor(R.color.colorAccent));
        LinearLayout linearLayout1 = (LinearLayout) searchView.getChildAt(0);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);
        LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(1);
        AutoCompleteTextView autoComplete = (AutoCompleteTextView) linearLayout3.getChildAt(0);
        autoComplete.setTextSize(20);
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchWord(s);
                return true;
            }
        });
    }

    private void searchWord(String newText) {
        data.clear();
        readFromAsset(getApplicationContext(), FILE_DICTIONARY);
        List<DictionaryModel> temp = new ArrayList<>();

        for (DictionaryModel d : data) {
            if (d.getWord().contains(newText)) {
                temp.add(d);
            }
        }
        data = temp;
        mWordAdapter.setDictionaryModels(data);
    }

    private void readFromAsset(Context context, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)));
            String mline;
            int i = 0;

            while ((mline = reader.readLine()) != null) {
                String[] lineData = mline.split("-");
                data.add(new DictionaryModel("" + i, lineData[0], lineData[1]));
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
