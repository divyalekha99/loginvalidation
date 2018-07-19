package com.divyalekha.login;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);


    EditText pwdid, user;
 //   TextView ptext;
    Button button, button2;

    public void logging(View v) {

        String pass = user.getText().toString();
        String password = helper.searchpwd(pass);

        if (password.equals(pwdid.getText().toString()))
          Toast.makeText(MainActivity.this, "WELCOMEEEE!!", Toast.LENGTH_LONG).show();

        else
           Toast.makeText(MainActivity.this, "incorrect password", Toast.LENGTH_LONG).show();


        //  ptext.setVisibility(View.INVISIBLE);
        //  valid();

    }

    public void signup(View v) {

        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pwdid = (EditText) findViewById(R.id.pwdid);
        user = (EditText) findViewById(R.id.user);
        //ptext =(TextView) findViewById(R.id.ptext);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

    }



}



       // if(v.getId()== R.id.)




/*        if(ptext.equals(pwd))
            Toast.makeText(MainActivity.this,"WELCOMEEEE!!",Toast.LENGTH_LONG).show();

        else
            Toast.makeText(MainActivity.this,"incorrect password",Toast.LENGTH_LONG).show();
*/
        // Intent intent = new Intent(MainActivity.this,signup.class);
        // startActivity(intent);



    /*public void valid()

        int c = pwd.getText().toString().trim().length();
        String pstr[] = pwd.getText().toString();
        if(user.getText().toString().length()<=0)
        Toast.makeText(MainActivity.this,"Enter the username!",Toast.LENGTH_LONG).show();
        if(c < 6 || c > 6)
         ptext.setAlpha(1);
    */






