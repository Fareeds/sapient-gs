import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducersConsumers {

	public static void main(String[] args) 
	{
		BlockingQueue<Object > queue = new LinkedBlockingQueue<>();
		for(int i = 0; i < 10; i++)
		{
			new Thread(new Producer(queue, "abc"+i)).start();
			new Thread(new Consumer(queue)).start();
		}	
	}

}

class Producer implements Runnable
{
	BlockingQueue<Object> q;
	Object o;
	public Producer(BlockingQueue<Object> p_q, Object p_o) {
		q = p_q;
		o = p_o;
	}
	
	@Override
	public void run() {		
		try {
			System.out.println("Produced : " +o);
			q.put(o);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}	
}

class Consumer implements Runnable
{
	BlockingQueue<Object> q;
	public Consumer(BlockingQueue<Object> p_q) {
		q = p_q;
	}
	
	@Override
	public void run() {		
		Object o;
		try {
			o = q.take();
			System.out.println("Consumed : "+o);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}	
}