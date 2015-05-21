package com.schneider.cody.getgood;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


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


        glist=(ListView)findViewById(R.id.g_list);
        glist.setAdapter(gadapter);


    }

    public void onClick(View v)
    {
        String input = gedit.getText().toString();
        if(input.length() > 0) {
            // add string to the adapter, not the listview
            gadapter.add(input);



        glist.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {


                    // method to remove list item

            AlertDialog.Builder alert = new AlertDialog.Builder(
                            MainActivity.this);

            alert.setTitle("Complete Goal");
            alert.setMessage("Are you finished with this goal?");
            AlertDialog.Builder yes = alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            // main code on after clicking yes

                            list.remove(position);
                            gadapter.notifyDataSetChanged();
                            gadapter.notifyDataSetInvalidated();
                            Context context = getApplicationContext();
                            CharSequence text = "Congratulations!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();

                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            CharSequence text = "Keep Trying";
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                            dialog.dismiss();
                        }
                    });

                    alert.show(); }})
            ;}}}







