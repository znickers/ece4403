
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SubList implements List<Sub> {
	private ArrayList<Sub> subs;
	
	public SubList() {
		subs = new ArrayList<Sub>();
	}

	@Override
	public boolean add(Sub sub) {
		return subs.add(sub);
	}

	@Override
	public void add(int index, Sub sub) {
		subs.add(index, sub);
	}

	@Override
	public boolean addAll(Collection<? extends Sub> subs) {
		return this.subs.addAll(subs);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Sub> subs) {
		return this.subs.addAll(index, subs);
	}

	@Override
	public void clear() {
		subs.clear();
	}

	@Override
	public boolean contains(Object sub) {
		return subs.contains(sub);
	}

	@Override
	public boolean containsAll(Collection<?> subs) {
		return this.subs.containsAll(subs);
	}

	@Override
	public Sub get(int index) {
		return this.subs.get(index);
	}

	@Override
	public int indexOf(Object sub) {
		return subs.indexOf(sub);
	}

	@Override
	public boolean isEmpty() {
		return subs.isEmpty();
	}

	@Override
	public Iterator<Sub> iterator() {
		return subs.iterator();
	}

	@Override
	public int lastIndexOf(Object sub) {
		return subs.lastIndexOf(sub);
	}

	@Override
	public ListIterator<Sub> listIterator() {
		return subs.listIterator();
	}

	@Override
	public ListIterator<Sub> listIterator(int index) {
		return subs.listIterator(index);
	}

	@Override
	public boolean remove(Object sub) {
		return subs.remove(sub);
	}

	@Override
	public Sub remove(int index) {
		return subs.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> subs) {
		return this.subs.removeAll(subs);
	}

	@Override
	public boolean retainAll(Collection<?> subs) {
		return this.subs.retainAll(subs);
	}

	@Override
	public Sub set(int index, Sub sub) {
		return subs.set(index, sub);
	}

	@Override
	public int size() {
		return subs.size();
	}

	@Override
	public List<Sub> subList(int fromIndex, int toIndex) {
		return subs.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return subs.toArray();
	}

	@Override
	public <T> T[] toArray(T[] subs) {
		return this.subs.toArray(subs);
	}
	
	public String toString()
	{
		return subs.toString();
	}
}
