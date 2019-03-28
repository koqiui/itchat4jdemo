package itchat4jtest.demo.linux;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.beans.BaseMsg;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import cn.zhouyafeng.itchat4j.utils.MyHttpClient;

public class LinuxSimpleDemo implements IMsgHandlerFace {

	MyHttpClient myHttpClient = MyHttpClient.getInstance();
	String apiKey = "597b34bea4ec4c85a775c469c84b6817"; // 这里是我申请的图灵机器人API接口，每天只能5000次调用，建议自己去申请一个，免费的:)
	Logger logger = Logger.getLogger("TulingRobot");

	@Override
	public String textMsgHandle(BaseMsg msg) {
		String result = "";
		String text = msg.getText();
		String url = "http://www.tuling123.com/openapi/api";
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("key", apiKey);
		paramMap.put("info", text);
		paramMap.put("userid", "123456");
		String paramStr = JSON.toJSONString(paramMap);
		try {
			HttpEntity entity = myHttpClient.doPost(url, paramStr);
			result = EntityUtils.toString(entity, "UTF-8");
			JSONObject obj = JSON.parseObject(result);
			if (obj.getString("code").equals("100000")) {
				result = obj.getString("text");
			} else {
				result = "处理有误";
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}

	@Override
	public String picMsgHandle(BaseMsg msg) {

		return "收到图片";
	}

	@Override
	public String voiceMsgHandle(BaseMsg msg) {

		return "收到语音";
	}

	@Override
	public String viedoMsgHandle(BaseMsg msg) {

		return "收到视频";
	}

	public static void main(String[] args) {
		IMsgHandlerFace msgHandler = new LinuxSimpleDemo();
		Wechat wechat = new Wechat(msgHandler, "/home/itchat4j/demo/itchat4j/login");
		wechat.start();
	}

	@Override
	public String nameCardMsgHandle(BaseMsg arg0) {
		return "收到名片消息";
	}

	@Override
	public void sysMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public String verifyAddFriendMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mediaMsgHandle(BaseMsg msg) {
		// TODO Auto-generated method stub
		return null;
	}
}
