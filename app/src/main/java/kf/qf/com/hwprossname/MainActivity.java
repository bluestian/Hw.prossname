package kf.qf.com.hwprossname;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import kf.qf.com.hwprossname.models.AndroidAppProcess;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 应用程序管理器
        ActivityManager am = (ActivityManager) this
                .getSystemService(this.ACTIVITY_SERVICE);

        // 应用程序包管理器
        PackageManager pm = this.getPackageManager();
        List processInfos = ProcessManager.getRunningAppProcesses();
        /*for (AndroidAppProcess processInfo : processInfos) {

        }*/

    }
    public  void  btnClick(View view){
                getRunningAppProcess();
    }
    public  List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessInfo(){
        if (Build.VERSION.SDK_INT >= 21) {
            List<AndroidAppProcess> runningAppProcesses = ProcessManager.getRunningAppProcesses();
            List<ActivityManager.RunningAppProcessInfo> appProcessInfos = new ArrayList<>();
            for (AndroidAppProcess process : runningAppProcesses) {
                ActivityManager.RunningAppProcessInfo info = new ActivityManager.RunningAppProcessInfo(
                        process.name, process.pid, null
                );

                info.uid = process.uid;
                // TODO: Get more information about the process. pkgList, importance, lru, etc.
                appProcessInfos.add(info);
            }
            Log.d("AndroidAppProcess","process"+appProcessInfos+"  ");
            return appProcessInfos;
        }
        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        return am.getRunningAppProcesses();
    }
    public  List<ActivityManager.RunningAppProcessInfo> getRunningAppProcess(){
        if (Build.VERSION.SDK_INT >= 21) {
            List<AndroidAppProcess> runningAppProcesses = ProcessManager.getRunningAppProcesses();

            for (AndroidAppProcess process : runningAppProcesses) {
                        if ("com.biyao.fu".equals(process.name)){
                            Log.d("AndroidAppProcess","process"+process.name+"  "+process.uid);

                        }



            }


        }
        ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        return am.getRunningAppProcesses();
    }

}
