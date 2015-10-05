package com.example.dai.contextmenuapp;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.view.View.*;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private static final int MENU_EDIT = Menu.FIRST;
    private static final int MENU_SHARE = Menu.FIRST + 1;
    private static final int MENU_DEL = Menu.FIRST + 2;
    private static final int MENU_FB = Menu.FIRST + 3;
    private static final int MENU_LI = Menu.FIRST + 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tv = (TextView) findViewById(R.id.textView);
        registerForContextMenu(tv);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        int groupId = 0;
        menu.add(groupId, MENU_EDIT, Menu.NONE, R.string.menu_edit);
        menu.add(groupId, MENU_DEL, Menu.NONE, R.string.menu_del);

        SubMenu subMenu = menu.addSubMenu(groupId, MENU_SHARE, Menu.NONE, R.string.menu_share);

        subMenu.add(1, MENU_FB, Menu.NONE, R.string.menu_fb);
        subMenu.add(1, MENU_LI, Menu.NONE, R.string.menu_li);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);



    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_DEL:
                Toast.makeText(getApplicationContext(), "Delete OK", Toast.LENGTH_SHORT).show();
                return true;
            case MENU_EDIT:
                Toast.makeText(getApplicationContext(), "Edit OK", Toast.LENGTH_SHORT).show();
                return true;
            case MENU_FB:
                Toast.makeText(getApplicationContext(), "Sharing via facebook", Toast.LENGTH_SHORT).show();
                return true;
            case MENU_LI:
                Toast.makeText(getApplicationContext(), "Sharing via LinkedIn", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.sub_del) {
            Toast.makeText(getApplicationContext(), "Delete OK", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.sub_edit) {
            Toast.makeText(getApplicationContext(), "Edit OK", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
