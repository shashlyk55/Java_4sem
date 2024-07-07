import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        final int serverPort = 3000;

        try (DatagramSocket serverSocket = new DatagramSocket(serverPort)) {
            byte[] receiveData = new byte[1024];

            System.out.println("UDP Server запущен на порту " + serverPort);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Получено от клиента: " + message);

                // Отправляем ответ клиенту
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String replyMessage = "Вы подключились к серверу!";
                byte[] sendData = replyMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
