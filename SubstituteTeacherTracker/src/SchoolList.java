
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SchoolList implements List<School> {
	private ArrayList<School> schools;
	
	public SchoolList() {
		schools = new ArrayList<School>();
	}

	@Override
	public boolean add(School school) {
		return schools.add(school);
	}

	@Override
	public void add(int index, School school) {
		schools.add(index, school);
	}

	@Override
	public boolean addAll(Collection<? extends School> schools) {
		return this.schools.addAll(schools);
	}

	@Override
	public boolean addAll(int index, Collection<? extends School> schools) {
		return this.schools.addAll(index, schools);
	}

	@Override
	public void clear() {
		schools.clear();
	}

	@Override
	public boolean contains(Object school) {
		return schools.contains(school);
	}

	@Override
	public boolean containsAll(Collection<?> schools) {
		return this.schools.containsAll(schools);
	}

	@Override
	public School get(int index) {
		return this.schools.get(index);
	}

	@Override
	public int indexOf(Object school) {
		return schools.indexOf(school);
	}

	@Override
	public boolean isEmpty() {
		return schools.isEmpty();
	}

	@Override
	public Iterator<School> iterator() {
		return schools.iterator();
	}

	@Override
	public int lastIndexOf(Object school) {
		return schools.lastIndexOf(school);
	}

	@Override
	public ListIterator<School> listIterator() {
		return schools.listIterator();
	}

	@Override
	public ListIterator<School> listIterator(int index) {
		return schools.listIterator(index);
	}

	@Override
	public boolean remove(Object school) {
		return schools.remove(school);
	}

	@Override
	public School remove(int index) {
		return schools.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> schools) {
		return this.schools.removeAll(schools);
	}

	@Override
	public boolean retainAll(Collection<?> schools) {
		return this.schools.retainAll(schools);
	}

	@Override
	public School set(int index, School school) {
		return schools.set(index, school);
	}

	@Override
	public int size() {
		return schools.size();
	}

	@Override
	public List<School> subList(int fromIndex, int toIndex) {
		return schools.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return schools.toArray();
	}

	@Override
	public <T> T[] toArray(T[] schools) {
		return this.schools.toArray(schools);
	}
	
	public String toString()
	{
		return schools.toString();
	}
}
