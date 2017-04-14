package com.example.zhu.resumetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zhu.resumetest.R;


public abstract class EditBaseActivity<T> extends AppCompatActivity {
    private T data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = initializeData();
        if(data != null) {
            setupUIForEdit(data);
        }else {
            setupUIForCreate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.home) {
            finish();
            return true;
        }else if(item.getItemId() == R.id.ic_save){
            saveAndEdit(data);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract int getLayoutId();

    protected abstract void setupUIForCreate();

    protected abstract void setupUIForEdit(@Nullable T data);

    protected abstract void saveAndEdit(@Nullable T data);

    protected abstract T initializeData();
}
