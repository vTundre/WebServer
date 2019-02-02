import org.junit.Test;
import server.Server;

import java.io.IOException;

public class testServer {

    @Test
    public void testRun() throws IOException {
        Server server = new Server();
        server.setPort(3000);
        server.setWebAppPath("C:/Users/J/IdeaProjects/WebServer/resources/webapp");
        server.start();
    }

}
