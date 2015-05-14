package com.schneider.cody.getgood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView gtext;
    private EditText gedit;
    private ListView glist;
    private Button gbutton;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> gadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gbutton = (Button)findViewById(R.id.goal_button);
        gbutton.setOnClickListener(this);
        gedit = (EditText)findViewById(R.id.goal_edit);
        gadapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        glist=(ListView)findViewById(R.id.g_list);
        glist.setAdapter(gadapter);


    }

    public void onClick(View v)
    {
        String input = gedit.getText().toString();
        if(input.length() > 0) {
            // add string to the adapter, not the listview
            gadapter.add(input);
            // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() metho


            glist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                // setting onItemLongClickListener and passing the position to the function

                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                    // method to remove list item

                    AlertDialog.Builder alert = new AlertDialog.Builder(
                            MainActivity.this);

                    alert.setTitle("Complete Goal");
                    alert.setMessage("Are you finished with this goal?");
                    AlertDialog.Builder yes = alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TOD O Auto-generated method stub

                            // main code on after clicking yes

                            list.remove(position);
                            gadapter.notifyDataSetChanged();
                            gadapter.notifyDataSetInvalidated();

                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    alert.show();

    }});
        }}}








