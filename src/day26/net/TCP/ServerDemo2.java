package day26.net.TCP;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 程序功能：网络编程---TCP---服务端
 * 程序员：魏国平
 * 编写时间：3月16日
 */

public class ServerDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//创建服务端Socket服务，通过ServerSocket
		ServerSocket ss = new ServerSocket(10009);
		
		//服务端必须提供一个对外窗口否则客户端无法连接s
		Socket s = ss.accept();
		
		//获取连接过来的客户端对象
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		String text = new String(buf, 0, len);
		System.out.println(text);
		
		//使用客户端socket对象的输出流给客户端返回数据
		OutputStream out = s.getOutputStream();
		
		out.write("收到".getBytes());
		
		ss.close();
		s.close();
		
	}

}
