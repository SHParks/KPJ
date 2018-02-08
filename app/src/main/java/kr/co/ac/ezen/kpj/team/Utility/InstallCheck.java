package kr.co.ac.ezen.kpj.team.Utility;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

/**
 * Created by sh_pa on 2018-02-09.
 */

public class InstallCheck {

    public static boolean searchAppPackage(Context context, String packageName){
        boolean bExist = false;

        PackageManager pkgMgr = context.getPackageManager();
        List<ResolveInfo> mAppList;
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mAppList = pkgMgr.queryIntentActivities(mainIntent, 0);

        try{
            for(int i=0;i<mAppList.size();i++){
                if(mAppList.get(i).activityInfo.packageName.startsWith(packageName)){
                    bExist = true;
                    break;
                }
            }
        }catch(Exception e){
            bExist = false;
        }
        return bExist;
    }

    public static void executeLocalAppPackage(Context context, String packageName){
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void executeStoreAppPackage(Context context, String packageName){
        String url = "market://details?id=" + packageName;
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(i);
    }
}
