
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UnavailabilityList implements List<Unavailability> {
	private ArrayList<Unavailability> unavailabilities;
	
	public UnavailabilityList() {
		unavailabilities = new ArrayList<Unavailability>();
	}

	@Override
	public boolean add(Unavailability unavailability) {
		return unavailabilities.add(unavailability);
	}

	@Override
	public void add(int index, Unavailability unavailability) {
		unavailabilities.add(index, unavailability);
	}

	@Override
	public boolean addAll(Collection<? extends Unavailability> unavailabilities) {
		return this.unavailabilities.addAll(unavailabilities);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Unavailability> unavailabilities) {
		return this.unavailabilities.addAll(index, unavailabilities);
	}

	@Override
	public void clear() {
		unavailabilities.clear();
	}

	@Override
	public boolean contains(Object unavailability) {
		return unavailabilities.contains(unavailability);
	}

	@Override
	public boolean containsAll(Collection<?> unavailabilities) {
		return this.unavailabilities.containsAll(unavailabilities);
	}

	@Override
	public Unavailability get(int index) {
		return this.unavailabilities.get(index);
	}

	@Override
	public int indexOf(Object unavailability) {
		return unavailabilities.indexOf(unavailability);
	}

	@Override
	public boolean isEmpty() {
		return unavailabilities.isEmpty();
	}

	@Override
	public Iterator<Unavailability> iterator() {
		return unavailabilities.iterator();
	}

	@Override
	public int lastIndexOf(Object unavailability) {
		return unavailabilities.lastIndexOf(unavailability);
	}

	@Override
	public ListIterator<Unavailability> listIterator() {
		return unavailabilities.listIterator();
	}

	@Override
	public ListIterator<Unavailability> listIterator(int index) {
		return unavailabilities.listIterator(index);
	}

	@Override
	public boolean remove(Object unavailability) {
		return unavailabilities.remove(unavailability);
	}

	@Override
	public Unavailability remove(int index) {
		return unavailabilities.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> unavailabilities) {
		return this.unavailabilities.removeAll(unavailabilities);
	}

	@Override
	public boolean retainAll(Collection<?> unavailabilities) {
		return this.unavailabilities.retainAll(unavailabilities);
	}

	@Override
	public Unavailability set(int index, Unavailability unavailability) {
		return unavailabilities.set(index, unavailability);
	}

	@Override
	public int size() {
		return unavailabilities.size();
	}

	@Override
	public List<Unavailability> subList(int fromIndex, int toIndex) {
		return unavailabilities.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return unavailabilities.toArray();
	}

	@Override
	public <T> T[] toArray(T[] unavailabilities) {
		return this.unavailabilities.toArray(unavailabilities);
	}
}
