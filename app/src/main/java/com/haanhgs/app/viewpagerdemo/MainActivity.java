package com.haanhgs.app.viewpagerdemo;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vpMain)
    ViewPager vpMain;

    private int[] imageList;

    private void initImageList(){
        TypedArray imgStrings = getResources().obtainTypedArray(R.array.imgList);
        imageList = new int[imgStrings.length()];
        for (int i = 0; i < imgStrings.length(); i++){
            imageList[i] = imgStrings.getResourceId(i, 0);
        }
        imgStrings.recycle();
    }

    private void initViewPager(){
        Adapter adapter = new Adapter(imageList);
        vpMain.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initImageList();
        initViewPager();
    }
}
