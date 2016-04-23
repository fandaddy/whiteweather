package jiangxiaobai.com.whiteweather.util;

/**
 * Created by JYH on 2016/4/23.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
