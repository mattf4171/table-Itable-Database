package heapdb;
public class Application{
	public static void main(String[] args) {

		Schema schema = new Schema(); 		// create tbl


		schema.addKeyIntType("ID"); // ID must be a key
		schema.addVarCharType("name");
		schema.addVarCharType("dept_name");
		schema.addIntType("salary");
//		s.addKeyVarCharType("ID");
		Table table = new Table(schema);
		
		Tuple[] tup = new Tuple[] {
				new Tuple(schema, 22222, "Einstein",    "Physics", 95000),
				new Tuple(schema, 45565, "Katz",        "Comp. Sci.", 75000),
				new Tuple(schema, 98345, "Kim",         "Elec. Eng.", 80000),
				new Tuple(schema, 10101, "Srinivasan" , "Comp. Sci.", 65000),
				new Tuple(schema, 49494, "Alondra" ,      "Physiology", 72000),
				new Tuple(schema, 49494, "Alondra" ,      "Physiology", 72000)
		};
		for(int i = 0; i < tup.length; i++){ // insert 
			table.insert(tup[i]);
		}
		
		System.out.println("\nContents of table:\n"+table);
		
//		System.out.print("delete 22222: ");
		table.delete(22222); // delete success
		System.out.println("\nContents of table:\n"+table);
		
//		System.out.print("")
			
//        System.out.print("lookup 49494: ");	// lookup in table
        table.lookup(49494);

//        System.out.print("lookup 10001: "); // lookup not in tbl
        table.lookup(10001);

//        System.out.println("lookup ID=19803: "); // lookup given column and value
        table.lookup("salary", 72000);
        
//        System.out.println("lookup dept_name=Comp. Sci.: "); // lookup from name
        table.lookup("name", "Alondra");

//        System.out.println("lookup ID=19802: "); // lookup
        table.lookup("ID", 19802);
	}

}
