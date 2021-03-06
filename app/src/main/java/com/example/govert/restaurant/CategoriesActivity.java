package com.example.govert.restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity implements CategoriesRequest.Callback {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        // get ListView
        lv = (ListView) findViewById(R.id.categories);

        // request categories
        CategoriesRequest x = new CategoriesRequest(this);
        x.getCategories(this);

        // set listener
        lv.setOnItemClickListener(new ListItemClickListener());
    }

    @Override
    public void gotCategories(ArrayList<String> categories) {
        // make adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, categories);

        //set adapter
        lv.setAdapter(adapter);
    }

    @Override
    public void gotCategoriesError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // get category
            String category = (String) parent.getItemAtPosition(position).toString();

            // make intent
            Intent intent = new Intent(CategoriesActivity.this, MenuActivity.class);
            intent.putExtra("selected_category", category);

            // start MenuActivity with intent
            startActivity(intent);
        }
    }
}
