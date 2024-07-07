import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {

        InetAddress currentIP = null;
        InetAddress githubIP = null;
        try {
            currentIP  =  InetAddress.getLocalHost();

            System.out.println("IP -> " + currentIP.getHostAddress());

            githubIP  =  InetAddress.getByName("www.github.com");
            System.out.println("Github -> " + githubIP.getHostAddress());

        }  catch (UnknownHostException e) {
            System.err.println("адрес недоступен " + e);
        }

        URL github = null;
        String urlName = "https://www.github.com";
        try {
            github  =  new URL(urlName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (github == null) {
            throw new RuntimeException();
        }
        try(BufferedReader d = new BufferedReader(new InputStreamReader(github.openStream()))){
            String content = "";
            while((content = d.readLine())!=null){
                System.out.println(content);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}