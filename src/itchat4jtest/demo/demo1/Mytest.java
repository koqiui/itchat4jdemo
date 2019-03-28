package itchat4jtest.demo.demo1;

import cn.open.itchat4j.Wechat;
import cn.open.itchat4j.face.IMsgHandlerFace;
import cn.open.itchat4j.utils.SysUtils;

/**
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月28日 上午12:44:10
 * @version 1.0
 *
 */
public class Mytest {
	public static void main(String[] args) {
		String qrPath = SysUtils.selectByOs("E:/MiscData/swb/itchat/login", "/swb-base/data/itchat/login"); // 保存登陆二维码图片的路径
		IMsgHandlerFace msgHandler = new SimpleDemo(); // 实现IMsgHandlerFace接口的类
		Wechat wechat = new Wechat(msgHandler, qrPath); // 【注入】
		wechat.start(); // 启动服务，会在qrPath下生成一张二维码图片，扫描即可登陆，注意，二维码图片如果超过一定时间未扫描会过期，过期时会自动更新，所以你可能需要重新打开图片
	}

}
