package cn.shineiot.buglytinker;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerPatchReporter;
import com.tencent.bugly.crashreport.CrashReport;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        MultiDex.install(base);
        Beta.installTinker();

    }

    @Override
    public void onCreate() {
        super.onCreate();

        //crash  调试=true
        CrashReport.initCrashReport(getApplicationContext(),"650763bceb",true);
        //CrashReport.testJavaCrash();测试异常统计

        //tinker   调试=true
        Bugly.init(getApplicationContext(),"650763bceb",true);

        //Beta.checkUpgrade();//主动检查更新
        Beta.enableHotfix = true;// 设置是否开启热更新能力，默认为true
        Beta.canAutoDownloadPatch = true;//是否自动下载补丁
        Beta.canNotifyUserRestart = true;//是否通知用户重启
        Beta.canAutoPatch = true;//是否自动合成补丁

        /**
         * 补丁回调接口
         */
        Beta.betaPatchListener = new BetaPatchListener() {
            @Override
            public void onPatchReceived(String s) {
                Log.e("onPatchReceived",s);
            }

            @Override
            public void onDownloadReceived(long l, long l1) {
                Log.e("onDownloadReceived",l+"------------------"+l1);
            }

            @Override
            public void onDownloadSuccess(String s) {
                Log.e("onDownloadSuccess",s);
            }

            @Override
            public void onDownloadFailure(String s) {
                Log.e("onDownloadFailure",s);
            }

            @Override
            public void onApplySuccess(String s) {
                Log.e("onApplySuccess",s);
            }

            @Override
            public void onApplyFailure(String s) {
                Log.e("onApplyFailure",s);
            }

            @Override
            public void onPatchRollback() {
                Log.e("onPatchRollback","");
            }
        };
    }

}
