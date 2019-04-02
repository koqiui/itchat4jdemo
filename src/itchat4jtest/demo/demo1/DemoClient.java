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

		// 如果指定图片保存目录则从本地打开（仅用于测试，web应用下不要设置，从getQrImageUrl(false)即可获取 二维码图片url ）
		String qrImageFileDir = SysUtils.selectByOs("E:/MiscData/swb/itchat", "/swb-base/data/itchat");

		// 登陆用户相关数据存储文件（如果不提供则使用内存模型，不包括消息，但很容易支持）
		String dataStoreFilePath = SysUtils.selectByOs("E:/MiscData/swb/itchat/data.json", "/swb-base/data/itchat/data.json");

		// 缓存用户头像的目录
		String headImgCacheDir = SysUtils.selectByOs("E:/MiscData/swb/itchat/head", "/swb-base/data/itchat/head");
		// 无头像的默认替代头像文件名（绝对路径 或 相对于头像缓存目录，用于 离线获取不到头像 或 未设头像或的场景）
		String headImgFaultFileName = "default-head-img.jpg";

		wechat.start(qrImageFileDir, dataStoreFilePath, headImgCacheDir, headImgFaultFileName);
	}

}
