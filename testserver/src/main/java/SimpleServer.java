import com.twitter.server.AbstractTwitterServer;
import com.twitter.util.Await;
import com.twitter.util.TimeoutException;

public class SimpleServer extends AbstractTwitterServer {

  @Override
  public void main() {
    try {
      Await.ready(this.adminHttpServer());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (TimeoutException e) {
      e.printStackTrace();
    }
  }

  public static class Main {

    public static void main(String[] args) throws InterruptedException {

      //StatsReceiver isr = new InMemoryStatsReceiver();
      new SimpleServer().main(args);
    }
  }

  @Override
  public void onInit() {
    log().info("Java Server initialization...");
  }

}
