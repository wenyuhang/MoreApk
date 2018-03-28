package com.yoawo.example.moreapk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionUtils.obtainPermission(this);
    }

    public void but(View view){
//        // 创建添加快捷方式的Intent
//        Intent addShortCut = new Intent(
//        "com.android.launcher.action.INSTALL_SHORTCUT");
//        // 加载app名
//        String title = getResources().getString(R.string.app_name2);
//        // 加载app的logo
//        Parcelable icon = Intent.ShortcutIconResource.fromContext(
//         MainActivity.this, R.mipmap.ic_launcher);
//        //点击快捷方式后操作Intent,快捷方式建立后，再次启动该程序
//        Intent intent = new Intent(MainActivity.this, MainActivity.class);
//        //设置快捷方式的标题
//        addShortCut.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
//        //设置快捷方式的图标
//        addShortCut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
//        //设置快捷方式对应的Intent
//        addShortCut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
//        //发送广播添加快捷方式
//          sendBroadcast(addShortCut);
        createShortCut();
        Log.e("TAG","发送广播添加快捷方式");
        Toast.makeText(this,"发送广播添加快捷方式",Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }


    private void createShortCut(){
        Intent shortcutIntent = new Intent();
        //设置点击快捷方式时启动的Activity,因为是从Lanucher中启动，所以包名类名要写全。
        shortcutIntent.setComponent(new ComponentName("com.yoawo.example.moreapk", "com.yoawo.example.moreapk.Main2Activity"));
        shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS|Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent resultIntent = new Intent();
        //设置快捷方式图标
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                Intent.ShortcutIconResource.fromContext(this,
                        R.mipmap.icon));
        //启动的Intent
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        //设置快捷方式的名称
        resultIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                getString(R.string.app_name2));
        resultIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        sendBroadcast(resultIntent);
    }
}
