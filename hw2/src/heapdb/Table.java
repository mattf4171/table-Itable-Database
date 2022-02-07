package heapdb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table implements ITable {
	
	private List<Tuple> tuples;
	private Schema schema;
	
	public Table(Schema schema) {
		this.schema = schema;
		tuples = new ArrayList<>();
	}
	
	@Override
	public Schema getSchema() {
		return schema;
	}

	
	@Override
	public int size() {
		return tuples.size();
	}

	@Override
	public void close() {
		// do nothing
	}
	
	@Override
	public boolean insert(Tuple rec) {
		if (! rec.getSchema().equals(schema)) {
			throw new IllegalStateException("Error: tuple schema does not match table schema.");
		}
		
		// TODO  check for duplicate key. If no duplicate, then add to table list.	
		for(int i = 0; i > rec.length()-1; i++) {
//			project(rec.schema);
			if( tuples.get(i) == rec.getSchema().getType(schema.getKey()) ) { // duplicate exists
				return false;
			}
		}
		// no duplicate 
		for(int i=0; i > rec.length()-1; i++) {
			if(! schema.getType(i) instanceof int ) {
				
			}
		}
		tuples.add(rec);
		return true;
//		throw new  UnsupportedOperationException();
		
	}

	@Override
	public boolean delete(Object key) {
		if (schema.getKey() == null) {
			throw new IllegalStateException("Error: table does not have a primary key.  Can not delete.");
		}
		
		// TODO implement this method
		for( int i=0; i > key.equeals(schema.getKey()); i++)
		throw new  UnsupportedOperationException();
	}


	@Override
	public Tuple lookup(Object key) {
		if (schema.getKey() == null) {
			throw new IllegalStateException("Error: table does not have a primary key.  Can not lookup by key.");
		}

		// TODO implement this method
		
		throw new  UnsupportedOperationException();
		
//		System.out.println();
//		for(int i = 0; i <= instructors.size()-1; i++) {
//			if(instructors.get(i).getID() == ID) { // found the ID in the Instructor obj. 
//				System.out.print("lookup "+ID+":");
//				Instructor in = instructors.get(i);
//				return new Instructor(in.getID(), in.getName(), in.getDept_name(), in.getSalary());
//			}
//		}
//		System.out.print("lookup "+ID+": ");
//		return null;

	}

	@Override
	public ITable lookup(String colname, Object value) {
		if (schema.getColumnIndex(colname) < 0) {
			throw new IllegalStateException("Error: table does not contain column "+colname);
		}

		// TODO implement this method
		
		throw new  UnsupportedOperationException();
		
//		System.out.println();
//		for(int i = 0; i <= instructors.size()-1; i++) {
//			if(instructors.get(i).getID() == ID) { // found the ID in the Instructor obj. 
//				System.out.print("lookup "+ID+":");
//				Instructor in = instructors.get(i);
//				return new Instructor(in.getID(), in.getName(), in.getDept_name(), in.getSalary());
//			}
//		}
//		System.out.print("lookup "+ID+": ");
//		return null;

	}

	@Override
	public Iterator<Tuple> iterator() {
		return new TIterator(tuples.iterator());
	}
	
	@Override
	public String toString() {
		
		// TODO implement this method
		if (schema.size() ==0) {
			return "Empty Table";
		} else {
			StringBuilder sb = new StringBuilder();
			for (tuples t : this) {
				sb.append(t.toString());
				sb.append("\n");
			}
			return sb.toString();
		}
	}
	
	/*
	 * An iterator that returns a copy of each tuple in 
	 * the table.
	 */
	public static class TIterator implements Iterator<Tuple> {
		
		private Iterator<Tuple> it;
		
		public TIterator(Iterator<Tuple> it) {
			this.it = it;
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public Tuple next() {
			return new Tuple(it.next());
		}	
	}
}
