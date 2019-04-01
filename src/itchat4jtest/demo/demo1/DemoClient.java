package itchat4jtest.demo.demo1;

import cn.open.itchat4j.Wechat;
import cn.open.itchat4j.core.MsgHandler;
import cn.open.itchat4j.utils.SysUtils;

/**
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月28日 上午12:44:10
 * @version 1.0
 *
 */
public class DemoClient {
	public static void main(String[] args) {
		MsgHandler msgHandler = new DemoMsgHandler();

		Wechat wechat = new Wechat(msgHandler);

		// 登陆用户相关数据存储文件（如果不提供则使用内存模型，不包括消息，但很容易支持）
		String dataStoreFilePath = SysUtils.selectByOs("E:/MiscData/swb/itchat/data.json", "/swb-base/data/itchat/data.json");
		// 保存登陆二维码图片的目录（如果不提供则可以在浏览器中打开对应的二维码扫描）
		String qrImageFileDir = SysUtils.selectByOs("E:/MiscData/swb/itchat", "/swb-base/data/itchat");

		wechat.start(dataStoreFilePath, qrImageFileDir);
	}

}
