import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Подключение к серверу установлено.");

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Поток для приема сообщений от сервера
            new Thread(() -> {
                try {
                    String messageFromServer;
                    while ((messageFromServer = serverInput.readLine()) != null) {
                        System.out.println(messageFromServer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
