import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Подключение к серверу установлено.");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Введите ваше имя: ");
            String senderName = userInput.readLine();

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

            String messageToServer;
            while (true) {
                System.out.print("Введите сообщение для отправки: ");
                messageToServer = userInput.readLine();

                // Добавляем имя отправителя к сообщению
                out.println(senderName + ": " + messageToServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
