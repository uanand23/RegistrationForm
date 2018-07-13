package com.example.udit.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText ed,ed1;
    String sex = "Sex : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=(EditText) findViewById(R.id.name);
        ed1=(EditText) findViewById(R.id.aboutu);
        registerForContextMenu(ed);
        registerForContextMenu(ed1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater min = getMenuInflater();
        min.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                Toast.makeText(this, "Reset is called", Toast.LENGTH_SHORT).show();
                reset();
                break;

            case R.id.log:
                Toast.makeText(this, "Logout is clicked", Toast.LENGTH_SHORT).show();
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater min = getMenuInflater();
        min.inflate(R.menu.menu2, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.reset:
                reset();
                Toast.makeText(this, "Reset is called", Toast.LENGTH_LONG).show();
                break;

            case R.id.copy:
                Toast.makeText(this, "Copy is called", Toast.LENGTH_SHORT).show();
                String name = ((EditText)findViewById(R.id.name)).getText().toString();
                // String aboutu = ((EditText)findViewById(R.id.aboutu)).getText().toString();
                break;

            case R.id.cut:
                Toast.makeText(this, "Cut is called", Toast.LENGTH_SHORT).show();
                ((EditText)findViewById(R.id.name)).setText("");
                //((EditText)findViewById(R.id.aboutu)).setText("");
                break;


        }
        return super.onContextItemSelected(item);
    }

    public void RadioButtonClicked(View v) {


        switch (v.getId()) {
            case R.id.male:
                sex += " Male\n";

                break;
            case R.id.female:
                sex += " Female\n";
                break;
        }
    }


    public void display(View v) {
        String name = "Name : " + ((EditText) findViewById(R.id.name)).getText().toString() + "\n";
        String mobile = "Mobile :" + ((EditText) findViewById(R.id.phone)).getText().toString() + "\n";
        String roll = "Roll :" + ((EditText) findViewById(R.id.roll)).getText().toString() + "\n";
        String email = "Email :" + ((EditText) findViewById(R.id.email)).getText().toString() + "\n";
        CheckBox checkBoxCN = findViewById(R.id.cn);
        CheckBox checkBoxFLA = findViewById(R.id.fla);
        CheckBox checkBoxOS = findViewById(R.id.os);
        CheckBox checkBoxDSA = findViewById(R.id.dsa);
        String subject = "Subject :";

        if (checkBoxCN.isChecked()) {
            subject += " CN,";
        }
        if (checkBoxFLA.isChecked()) {
            subject += " FLA,";
        }
        if (checkBoxDSA.isChecked()) {
            subject += " DSA,";
        }
        if (checkBoxOS.isChecked()) {
            subject += " OS,";
        }
        String aboutu = ((EditText) findViewById(R.id.aboutu)).getText().toString();
        String message = name + mobile + roll + email + sex + subject + "\n" + aboutu;

        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("mess", message);
        startActivity(i);

    }
    private void reset(){
        ((EditText) findViewById(R.id.name)).setText("");
        ((EditText) findViewById(R.id.phone)).setText("");
        ((EditText) findViewById(R.id.email)).setText("");
        ((EditText) findViewById(R.id.roll)).setText("");
        ((EditText) findViewById(R.id.aboutu)).setText("");
        CheckBox checkBoxCN = findViewById(R.id.cn);
        CheckBox checkBoxFLA = findViewById(R.id.fla);
        CheckBox checkBoxOS = findViewById(R.id.os);
        CheckBox checkBoxDSA = findViewById(R.id.dsa);
        if (checkBoxCN.isChecked())
            checkBoxCN.toggle();
        if (checkBoxOS.isChecked())
            checkBoxOS.toggle();
        if (checkBoxFLA.isChecked())
            checkBoxFLA.toggle();
        if (checkBoxDSA.isChecked())
            checkBoxDSA.toggle();
        RadioButton male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);
        if (male.isChecked())
            male.setChecked(false);
        else if(female.isChecked())
            female.setChecked(false);

    }
}
