package com.divyalekha.login;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);
    EditText name ,pwd1 , pwd2 , e_id ;

    //  EditText ph_id = (EditText) findViewById(R.id.ph_id);


    public void signupclick(View v) {

        //  String ph_str = ph_id.getText().toString();
        String namestr = name.getText().toString();
        String pwd1str = pwd1.getText().toString();
        String pwd2str = pwd2.getText().toString();
        String e_str = e_id.getText().toString();


        if (!pwd1str.equals(pwd2str)) {
            Toast.makeText(signup.this, "PASSwORDS DON'T MATCH", Toast.LENGTH_LONG).show();

        }

        else {
            // insert into db
            detail d = new detail();
            d.setName(namestr);
            d.setPwd(pwd1str);
            d.setEmail(e_str);

            helper.insertDetail(d);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText name = (EditText) findViewById(R.id.name);
        EditText pwd1 = (EditText) findViewById(R.id.pwd1);
        EditText pwd2 = (EditText) findViewById(R.id.pwd2);
        EditText e_id = (EditText) findViewById(R.id.e_id);


    }


}