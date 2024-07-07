import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<PrintWriter> clients = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Сервер запущен. Ожидание подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключение принято. IP адрес клиента: " + clientSocket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;

        public ClientHandler(Socket clientSocket) {

                this.clientSocket = clientSocket;

        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                synchronized (clients) {
                    clients.add(out);
                }

                String messageFromClient;
                while ((messageFromClient = in.readLine()) != null) {
                    System.out.println("Сообщение от клиента: " + messageFromClient);

                    synchronized (clients) {
                        for (PrintWriter client : clients) {
                            if (client != out) {
                                client.println(messageFromClient);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                synchronized (clients) {
                    clients.remove(out);
                }
            }
        }
    }
}
