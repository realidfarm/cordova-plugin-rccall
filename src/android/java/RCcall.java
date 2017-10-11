package com.realidfarm.rccall;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.text.TextUtils;
import android.util.Log;

import com.taofeng.laodao.MainActivity;

import io.rong.imkit.RongIM;
import io.rong.callkit.RongCallKit;
import io.rong.imlib.RongIMClient;

public class RCcall extends CordovaPlugin{

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Activity activity = this.cordova.getActivity();
        if (action.equals("voiceCall")) {
            //RongCallKit.startSingleCall(activity.getApplicationContext(), "2", RongCallKit.CallMediaType.CALL_MEDIA_TYPE_AUDIO);
			      callbackContext.success("语音通话");
            return true;
        }else if (action.equals("connect")) {
          String token = args.getString(0);
          RongIM.connect(token, new RongIMClient.ConnectCallback() {

            /**
             * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
             *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
             */
            @Override
            public void onTokenIncorrect() {

            }

            /**
             * 连接融云成功
             * @param userid 当前 token 对应的用户 id
             */
            @Override
            public void onSuccess(String userid) {
              Log.d("LoginActivity", "--onSuccess" + userid);
              callbackContext.success(userid);
            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             */
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
          });
          return true;
        }
        return false;
    }

}
