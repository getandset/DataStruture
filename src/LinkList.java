import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: lj
 * Date: 13-12-28
 * Time: 下午8:28
 * To change this template use File | Settings | File Templates.
 */
public class LinkList <T> implements Queue<T>{

	Entry<T> head;
	int size;
	public LinkList () {
		head = new Entry<T>(null, null, null);
		head.next = head;
		head.pre = head;
	}

	private class Entry<T> {
		T key;
		Entry<T> pre;
		Entry<T> next;

		public Entry (T key, Entry<T> pre, Entry<T> next) {
			this.key = key;
			this.pre = pre;
			this.next = next;
		}
	}

	public boolean add (T obj) {
		Entry<T> oldLast = head.pre;
		Entry<T> newEntry = new Entry<T>(obj, null, null);
		oldLast.next = newEntry;
		newEntry.pre = oldLast;
		newEntry.next = head;
		head.pre = newEntry;
		size++;
		return true;
	}

	public void add (T obj, int location) throws IndexOutOfBoundsException{
		if (location>=0 && location<=size) {
			Entry<T> insertion = new Entry<T>(obj, null, null);
			Entry<T> entry = head;
			if (location<size/2) {
				for (int i=0; i<=location; i++) {
					entry = entry.next;
				}
			}else {
				for (int i = size; i>=location; i--) {
					entry = entry.pre;
				}
			}
			Entry<T> next = entry.next;
			entry.next = insertion;
			Entry<T> last = entry;
			entry = entry.next;
			entry.pre = last;
			entry.next = next;
			next.pre = entry;
			size++;
		}
	}

	public void addLast (T obj) {
		add(obj);
	}

	public void addFirst (T obj) {
		Entry<T> oldFirst = head.next;
		Entry<T> newFirst = new Entry<T>(obj, null,null);
		head.next = newFirst;
		newFirst.pre = head;
		newFirst.next = oldFirst;
		oldFirst.pre = newFirst;
		size++;
	}


	public void clear () {
		if (size>0) {
			size = 0;
			head.next = head;
			head.pre = head;
		}
	}

	public void remove (int location) {
		Entry<T> entry = head;
		for (int i = 0; i<=location; i++) {
			entry = entry.next;
		}
		Entry<T> pre = entry.pre;
		Entry<T> next = entry.next;
		pre.next = next;
		next.pre = pre;

	}

	public void removeFirst () {
		Entry<T> entry = head.next.next;
		head.next = entry;
		entry.pre = head;
	}

	public void removeLast () {
		Entry<T> last = head.pre.pre;
		last.next = head;
		head.pre = last;

	}

	public T get (int index) {
		if (index>=0 && index<size) {
			Entry<T> entry = head;
			for (int i=0; i<=index; i++) {
				entry = entry.next;
			}
			return entry.key;
		}
		return null;

	}

	public T getFirst () {
		if (size>0) {
			return head.next.key;
		}
		return null;
	}

	public T getLast () {
		return head.pre.key;

	}


	@Override
	public void enqueue(T e) {
		add(e);

	}

	@Override
	public T dequeue() throws Exception {
		if (head.next==head) {
			throw new Exception("queue is null");
		}
		T e = getFirst();
		return e;
	}

	@Override
	public T head() {
		if (head.next==head) {
			return null;
		}
		return getFirst();
	}

	@Override
	public boolean isEmpty() {
		return head.next==head;
	}

}
