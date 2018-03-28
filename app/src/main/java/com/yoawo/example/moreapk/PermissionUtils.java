package com.yoawo.example.moreapk;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13145 on 2017/12/20.
 */

public class PermissionUtils {


    private static final int CODE_PERMISSION = 4;
    private static List<String> list;
    //获取权限
    public static boolean obtainPermission(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            list = new ArrayList<>();
            if (context.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.CAMERA);
            }
            if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if (context.checkSelfPermission(Manifest.permission.INSTALL_SHORTCUT) != PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.INSTALL_SHORTCUT);
            }
            if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                list.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if (list.size() != 0)
                context.requestPermissions(list.toArray(new String[list.size()]), CODE_PERMISSION);
            return true;
        } else
           return false;

    }
}
