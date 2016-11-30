package com.luigh.raveen.luigh;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MobitelScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobitel_screen);
    }

    public void toReloadAction(View view){
        Intent intent = new Intent(MobitelScreen.this, CameraActions.class);
        startActivity(intent);
    }
}
