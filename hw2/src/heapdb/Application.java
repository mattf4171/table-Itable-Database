package heapdb;
public class Application{
	public static void main(String[] args) {

		Schema schema = new Schema(); // create schema


		schema.addKeyIntType("ID"); // ID must be a key
		schema.addVarCharType("name");
		schema.addVarCharType("dept_name");
		schema.addIntType("salary");
		
		Table table = new Table(schema);
		
		Tuple[] tup = new Tuple[] {
				new Tuple(schema, 22222, "Einstein",    "Physics",    95000), // insert Success
				new Tuple(schema, 45565, "Katz",        "Comp. Sci.", 75000),
				new Tuple(schema, 98345, "Kim",         "Elec. Eng.", 80000),
				new Tuple(schema, 10101, "Srinivasan" , "Comp. Sci.", 65000),
				new Tuple(schema, 49494, "Alondra" ,    "Physiology", 72000),
				new Tuple(schema, 49494, "Alondra" ,    "Physiology", 72000) // insert Fail
		};
		for(int i = 0; i < tup.length; i++){ // insert 
			table.insert(tup[i]);
		}
		
		System.out.println("\nContents of table:\n"+table);
		
		table.delete(22222); // delete Success
		System.out.println("\nContents of table:\n"+table);
		
		table.delete(10001); // delete Failed
		
        table.lookup(49494); // delete Success
		System.out.println("\nContents of table:\n"+table);


        table.lookup("salary", 72000);
        
        table.lookup("name", "Alondra");

        table.lookup("ID", 10000);
	}

}
