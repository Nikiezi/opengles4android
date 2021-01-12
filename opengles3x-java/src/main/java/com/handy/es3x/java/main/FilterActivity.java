package com.handy.es3x.java.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.handy.es3x.java.R;
import com.handy.es3x.java.filter.GrayFilter;
import com.handy.es3x.java.filter.OriginFilter;
import com.handy.es3x.java.filter.QuarterMirrorFilter;
import com.handy.es3x.java.view.OpenGLView;
import com.onzhou.opengles.base.AbsBaseActivity;

/**
 * @anchor: andy
 * @date: 2019-03-15
 * @description:
 */
public class FilterActivity extends AbsBaseActivity {

    private ViewGroup mRootLayer;

    private OpenGLView mGlView;

    public static void intentStart(Context context) {
        Intent intent = new Intent(context, FilterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setupViews();
    }

    private void setupViews() {
        mRootLayer = (ViewGroup) findViewById(R.id.linear_root_layer);

        mGlView = new OpenGLView(this);
        mRootLayer.addView(mGlView, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.filter_default) {
            mGlView.setFilter(new OriginFilter());
        } else if (itemId == R.id.filter_gray) {
            mGlView.setFilter(new GrayFilter());
        } else if (itemId == R.id.filter_quarter_mirror) {
            mGlView.setFilter(new QuarterMirrorFilter());
        }
        return super.onOptionsItemSelected(item);
    }
}