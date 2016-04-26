package jiangxiaobai.com.whiteweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import jiangxiaobai.com.whiteweather.service.AutoUpdateService;

/**
 * Created by JYH on 2016/4/26.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, AutoUpdateService.class);
        context.startService(i);
    }
}
