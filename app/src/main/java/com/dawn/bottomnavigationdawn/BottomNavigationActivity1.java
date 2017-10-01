package com.dawn.bottomnavigationdawn;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

/**
 * Created by 90449 on 2017/10/1.
 */

public class BottomNavigationActivity1 extends AppCompatActivity {
    private AHBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation1);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        setBottomNavigation();

    }
    private void setBottomNavigation(){
        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.home, R.drawable.home, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.notification, R.drawable.remind, R.color.gray);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.personal, R.drawable.account, R.color.gray);
        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        // Disable the translation inside the CoordinatorLayout
//        bottomNavigation.setBehaviorTranslationEnabled(false);
        // Enable the translation of the FloatingActionButton
//        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);
        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));//设置选中颜色
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));//设置未选中的颜色
        // Force to tint the drawable (useful for font with icon for example)
//        bottomNavigation.setForceTint(true);
        // Display color under navigation bar (API 21+)
        // Don't forget these lines in your style-v21
        // <item name="android:windowTranslucentNavigation">true</item>
        // <item name="android:fitsSystemWindows">true</item>
//        bottomNavigation.setTranslucentNavigationEnabled(true);
        // Manage titles // 字体是否隐藏
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        // Use colored navigation with circle reveal effect
//        bottomNavigation.setColored(true);//item设置的背景颜色是否起作用，如果true则background设置不起作用

        // Set current item programmatically
        bottomNavigation.setCurrentItem(1);

        // Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));//设置提示数量的背景颜色

        // Add or remove notification for each item
        bottomNavigation.setNotification("1", 0);//设置提示的数量和对应的id
        // OR
//        AHNotification notification = new AHNotification.Builder()
//                .setText("1")
//                .setBackgroundColor(ContextCompat.getColor(BottomNavigationActivity1.this, R.color.color_notification_back))
//                .setTextColor(ContextCompat.getColor(BottomNavigationActivity1.this, R.color.color_notification_text))
//                .build();
//        bottomNavigation.setNotification(notification, 1);

        // Enable / disable item & set disable color
//        bottomNavigation.enableItemAtPosition(2);
        bottomNavigation.disableItemAtPosition(2);//设置第id个不能点击
//        bottomNavigation.setItemDisableColor(Color.parseColor("#3A000000"));//设置不能点击的颜色

        // Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                if(!wasSelected)
                    Toast.makeText(BottomNavigationActivity1.this, "position " + position, Toast.LENGTH_SHORT).show();
                if(position == 0){
                    bottomNavigation.setNotification("", 0);
                }

                return true;
            }
        });
//        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
//            @Override public void onPositionChange(int y) {
//                // Manage the new y position
//            }
//        });
    }
}
