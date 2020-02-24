
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TeacherList implements List<Teacher> {
	private ArrayList<Teacher> teachers;
	
	public TeacherList() {
		teachers = new ArrayList<Teacher>();
	}

	@Override
	public boolean add(Teacher teacher) {
		return teachers.add(teacher);
	}

	@Override
	public void add(int index, Teacher teacher) {
		teachers.add(index, teacher);
	}

	@Override
	public boolean addAll(Collection<? extends Teacher> teachers) {
		return this.teachers.addAll(teachers);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Teacher> teachers) {
		return this.teachers.addAll(index, teachers);
	}

	@Override
	public void clear() {
		teachers.clear();
	}

	@Override
	public boolean contains(Object teacher) {
		return teachers.contains(teacher);
	}

	@Override
	public boolean containsAll(Collection<?> teachers) {
		return this.teachers.containsAll(teachers);
	}

	@Override
	public Teacher get(int index) {
		return this.teachers.get(index);
	}

	@Override
	public int indexOf(Object teacher) {
		return teachers.indexOf(teacher);
	}

	@Override
	public boolean isEmpty() {
		return teachers.isEmpty();
	}

	@Override
	public Iterator<Teacher> iterator() {
		return teachers.iterator();
	}

	@Override
	public int lastIndexOf(Object teacher) {
		return teachers.lastIndexOf(teacher);
	}

	@Override
	public ListIterator<Teacher> listIterator() {
		return teachers.listIterator();
	}

	@Override
	public ListIterator<Teacher> listIterator(int index) {
		return teachers.listIterator(index);
	}

	@Override
	public boolean remove(Object teacher) {
		return teachers.remove(teacher);
	}

	@Override
	public Teacher remove(int index) {
		return teachers.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> teachers) {
		return this.teachers.removeAll(teachers);
	}

	@Override
	public boolean retainAll(Collection<?> teachers) {
		return this.teachers.retainAll(teachers);
	}

	@Override
	public Teacher set(int index, Teacher teacher) {
		return teachers.set(index, teacher);
	}

	@Override
	public int size() {
		return teachers.size();
	}

	@Override
	public List<Teacher> subList(int fromIndex, int toIndex) {
		return teachers.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return teachers.toArray();
	}

	@Override
	public <T> T[] toArray(T[] teachers) {
		return this.teachers.toArray(teachers);
	}
}
