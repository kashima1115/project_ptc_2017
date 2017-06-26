package sockettestU;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientU {

	public static void main(String[] args) {
		try {
            System.out.println("conf run");
			InetAddress addr = InetAddress.getByName(args[0]);//サーバーのあるIPアドレス
            int port = Integer.parseInt(args[1]); //サーバ側の待受ポート番号

            // 送信するパケットを生成(一定数ループさせる）
            for(int i =0;i<=2000000;i++){
            	byte buffer[] = (i+args[2]).getBytes();//送信するメッセージとか番号とか
            	DatagramPacket dp = new DatagramPacket(buffer, buffer.length, addr, port);

            	// ソケットを生成してパケットを送信
            	DatagramSocket ds = new DatagramSocket();

            	ds.send(dp);

            	ds.close();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

	}

}
