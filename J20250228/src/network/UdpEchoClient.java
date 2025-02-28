package network;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;

    private String serverIp = "";

    private int serverPort = 0;

    public UdpEchoClient(String ip, int port) throws SocketException {
        // 创建这个对象的时候,不能手动指定端口
        socket = new DatagramSocket();
        // 由于UDP 自身不会持有对端的信息,就需要在应用程序里,把对端的情况给记录下来
        // 这里咱们主要记录对端的 ip 和 端口 即可
        serverIp = ip;
        serverPort = port;
    }

    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 从控制台读取数据,作为请求
            System.out.println("-> ");
            String request = scanner.next();
            // 2. 把请求内容构造成一个DatagramPacket 对象
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            // 3. 尝试读取服务器返回的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            // 4. 把响应,转换成字符串,并显示出来
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }
    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
