package Main;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class setAddresses {

	public static String getIP() {
		String IP;
		InetAddress ip = IPConf();
		IP = ip.getHostAddress();
		return IP;
	}

	public static InetAddress IPConf() {
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}

	public static String getMac() throws SocketException {
		String Mac;
		InetAddress ip = IPConf();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();
		StringBuilder macBuilder = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			macBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		Mac = macBuilder.toString();
		return Mac;
	}

}
