package com.example.devscodex;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private NiceSpinner sourceSpinner;

    private AppCompatEditText queryEditText;

    private AppCompatButton querySearchButton;

    private RecyclerView resultRecyclerView;

    private  String movie = "By movie title";
    private  String person = "By person title";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //disable the keyword on start

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        sourceSpinner = findViewById(R.id.source_spinner);
        queryEditText = findViewById(R.id.query_edit_text);
        querySearchButton = findViewById(R.id.query_search_button);

        resultRecyclerView = findViewById(R.id.results_recycler_view);
        resultRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        final ArrayList<String> category = new ArrayList<>();

        // set list for sourceSpinner
        category.add(movie);
        category.add(person);

        int position = sourceSpinner.getSelectedIndex();

        if (position == 0)
            {
             queryEditText.setText("Enter any movie title");
            }
        else
            {
              queryEditText.setText("Enter Actor's name");
            }

        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
               // when sourceSpinner in clicked change the text of the edit text

                if (position == 0)
                {
                    queryEditText.setText("Enter any movie title");
                }
                else
                {
                    queryEditText.setText("Enter Actor's name");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // get the query from user
        querySearchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (queryEditText.getText() != null)
                {
                    String query = queryEditText.getText().toString();

                    if (query.equals("") || query.equals(" "))
                    {
                        Toast.makeText(MainActivity.this, "please enter any text", Toast.LENGTH_SHORT);
                    }
                    else
                    {
                        queryEditText.setText("");

                        //get the category to search th query. movie or actor

                        String finalQuery = query.replaceAll(" ", "+");

                        if (category.size() >0 )
                        {
                            String categoryName = category.get(sourceSpinner.getSelectedIndex());

                            if (categoryName.equals(movie))
                            {

                            }
                            else
                            {

                            }
                        }

                    }


                }


            }
        });
    }
}