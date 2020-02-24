
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AbsenceList implements List<Absence> {
	private ArrayList<Absence> absences;
	
	public AbsenceList() {
		absences = new ArrayList<Absence>();
	}

	@Override
	public boolean add(Absence absence) {
		return absences.add(absence);
	}

	@Override
	public void add(int index, Absence absence) {
		absences.add(index, absence);
	}

	@Override
	public boolean addAll(Collection<? extends Absence> absences) {
		return this.absences.addAll(absences);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Absence> absences) {
		return this.absences.addAll(index, absences);
	}

	@Override
	public void clear() {
		absences.clear();
	}

	@Override
	public boolean contains(Object absence) {
		return absences.contains(absence);
	}

	@Override
	public boolean containsAll(Collection<?> absences) {
		return this.absences.containsAll(absences);
	}

	@Override
	public Absence get(int index) {
		return this.absences.get(index);
	}

	@Override
	public int indexOf(Object absence) {
		return absences.indexOf(absence);
	}

	@Override
	public boolean isEmpty() {
		return absences.isEmpty();
	}

	@Override
	public Iterator<Absence> iterator() {
		return absences.iterator();
	}

	@Override
	public int lastIndexOf(Object absence) {
		return absences.lastIndexOf(absence);
	}

	@Override
	public ListIterator<Absence> listIterator() {
		return absences.listIterator();
	}

	@Override
	public ListIterator<Absence> listIterator(int index) {
		return absences.listIterator(index);
	}

	@Override
	public boolean remove(Object absence) {
		return absences.remove(absence);
	}

	@Override
	public Absence remove(int index) {
		return absences.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> absences) {
		return this.absences.removeAll(absences);
	}

	@Override
	public boolean retainAll(Collection<?> absences) {
		return this.absences.retainAll(absences);
	}

	@Override
	public Absence set(int index, Absence absence) {
		return absences.set(index, absence);
	}

	@Override
	public int size() {
		return absences.size();
	}

	@Override
	public List<Absence> subList(int fromIndex, int toIndex) {
		return absences.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return absences.toArray();
	}

	@Override
	public <T> T[] toArray(T[] absences) {
		return this.absences.toArray(absences);
	}
}
