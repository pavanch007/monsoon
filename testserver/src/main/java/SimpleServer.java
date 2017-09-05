import com.twitter.finagle.stats.InMemoryStatsReceiver;
import com.twitter.finagle.stats.StatsReceiver;
import com.twitter.server.AbstractTwitterServer;

public class SimpleServer extends AbstractTwitterServer {

  public static class Main {

    public static void main(String[] args) throws InterruptedException {
      Thread waiterThread = new Thread(new Waiter());
      waiterThread.start();
      StatsReceiver isr = new InMemoryStatsReceiver();
      SimpleServer ss = new SimpleServer();
      ss.main(args);
      waiterThread.join();
    }
  }

  static class Waiter implements Runnable {

    public void run() {
      try {
        Thread.sleep(100000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
