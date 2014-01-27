import java.util.ArrayDeque;

/**
 * Created with IntelliJ IDEA.
 * User: lj
 * Date: 13-12-28
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class ArrayListQueue<T> implements Queue<T> {
	private static final int MIN_SIZE = 8;
	private int head, tail;
	private Object[] array;
	private int length;

	public ArrayListQueue () {
		array = new Object[MIN_SIZE];
		length = MIN_SIZE;
	}

	public ArrayListQueue (int size) {
		array = new Object[size];
		length = size;
	}

	@Override
	public void enqueue(T e) {
		if (isFull()) {
			int size = length;
			int p = head;
			int n = length-head-1;
			int r = tail;
			Object[] newArray = new Object[length<<1];
			System.arraycopy(array,p,newArray,0,n);
			System.arraycopy(array,0,newArray,n+1,r);
			head = 0;
			tail = size;
			array = newArray;
		}
		array[tail++] = e;
	}

	private boolean isFull () {
		return head==(tail+1)%length;
	}


	@Override
	public T dequeue() throws Exception{
		if (isEmpty())
			throw new Exception("queue is empty");
		return (T)array[head++];
	}

	@Override
	public T head() {
		if (isEmpty())
			return null;
		return (T)array[head];
	}

	@Override
	public boolean isEmpty() {
		return head==tail;
	}
}
