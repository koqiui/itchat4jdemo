package itchat4jtest.demo.demo1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.open.itchat4j.beans.BaseMsg;
import cn.open.itchat4j.core.MsgHandler;
import cn.open.itchat4j.enums.MsgTypeCodeEnum;
import cn.open.itchat4j.tools.DownloadTools;

/**
 * 简单示例程序，收到文本信息自动回复原信息，收到图片、语音、小视频后根据路径自动保存
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月28日 下午10:50:36
 * @version 1.0
 *
 */
public class DemoMsgHandler implements MsgHandler {

	@Override
	public String textMsgHandle(BaseMsg msg) {
		String text = msg.getText();
		return text;
	}

	@Override
	public String picMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".jpg"; // 这里使用收到图片的时间作为文件名
		String picPath = "D://itchat4j/pic" + File.separator + fileName; // 保存图片的路径
		DownloadTools.getDownloadFile(msg, MsgTypeCodeEnum.PIC.getCode(), picPath); // 调用此方法来保存图片
		return "图片保存成功";
	}

	@Override
	public String voiceMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp3"; // 这里使用收到语音的时间作为文件名
		String voicePath = "D://itchat4j/voice" + File.separator + fileName; // 保存语音的路径
		DownloadTools.getDownloadFile(msg, MsgTypeCodeEnum.VOICE.getCode(), voicePath); // 调用此方法来保存语音
		return "声音保存成功";
	}

	@Override
	public String viedoMsgHandle(BaseMsg msg) {
		String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".mp4"; // 这里使用收到小视频的时间作为文件名
		String viedoPath = "D://itchat4j/viedo" + File.separator + fileName;// 保存小视频的路径
		DownloadTools.getDownloadFile(msg, MsgTypeCodeEnum.VIEDO.getCode(), viedoPath);// 调用此方法来保存小视频
		return "视频保存成功";
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
