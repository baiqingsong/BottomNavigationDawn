# 底部导航栏BottomNavigation的使用


* [引用](#引用)
* [使用](#使用)
* [相关属性](#相关属性)
* [参考地址](#参考地址)

## 引用
```
dependencies {
    compile 'com.aurelhubert:ahbottomnavigation:2.1.0'
}
```

## 使用
xml中调用
```
<com.aurelhubert.ahbottomnavigation.AHBottomNavigation
    android:id="@+id/bottom_navigation"
    android:layout_alignParentBottom="true"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```
activity中调用
```
// Create items
AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.home, R.drawable.home, R.color.colorPrimary);
AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.notification, R.drawable.remind, R.color.gray);
AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.personal, R.drawable.account, R.color.gray);
// Add items
bottomNavigation.addItem(item1);
bottomNavigation.addItem(item2);
bottomNavigation.addItem(item3);        
// Set listeners
bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Do something cool here...
        return true;
    }
});        
```

## 相关属性
设置默认背景颜色
```
// Set background color
bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
```
是否按照item的背景颜色，如果设置此属性，则设置背景颜色不起作用
```
bottomNavigation.setColored(true);
```
设置选中的颜色和未选中的颜色
```
bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));//设置选中颜色
bottomNavigation.setInactiveColor(Color.parseColor("#747474"));//设置未选中的颜色
```
设置字体是否隐藏属性
```
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
```
设置当前选中的id
```
bottomNavigation.setCurrentItem(1);
```
设置提示的背景颜色
```
bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));//设置提示数量的背景颜色
```
设置提示数字的id和字符串
```
bottomNavigation.setNotification("1", 0);//设置提示的数量和对应的id
```
设置当前的选项不能点击
```
bottomNavigation.disableItemAtPosition(2);//设置第id个不能点击
```
点击事件
```
bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        // Do something cool here...
        return true;
    }
});
```
其中取中后取消提示可以在点击事件中
```
bottomNavigation.setNotification("", 0);
```
选中后不可以再次点击可以在点击事件中
```
if(wasSelected)
    return;
```

## 参考地址

[https://github.com/aurelhubert/ahbottomnavigation](https://github.com/aurelhubert/ahbottomnavigation)


