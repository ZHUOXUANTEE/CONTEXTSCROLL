package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView article,heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        article = findViewById(R.id.article);
        heading = findViewById(R.id.article_heading);
        registerForContextMenu(article);
        registerForContextMenu(heading);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        if(v.getId() == R.id.article)
            getMenuInflater().inflate(R.menu.example_menu,menu);
        else if(v.getId() == R.id.article_heading)
            getMenuInflater().inflate(R.menu.example_menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_edit:
                displayToast(getString(R.string.edit_message));
                return  true;
            case R.id.action_share:
                displayToast(getString(R.string.share_message));
            case R.id.action_delete:
                displayToast(getString(R.string.delete_message));
            return  true;

        }

        return super.onContextItemSelected(item);
    }

    public void displayToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
