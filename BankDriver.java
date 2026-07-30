package banking;

public class BankDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bank bk=new Bank();
		//bk.createConnection();
		//bk.viewDetails();
		//System.out.println("inserted");
	//	bk.insertDetails();
		//System.out.println("updation");
	//	bk.updateDetails();
		//	CRUDPrograms cp=new CRUDPrograms();
		//	cp.createConnection();
		//cp.getAllDetails();
		//cp.insertDetails(777,"ram","ongole",9000);
		//System.out.println("inserted");
		//cp.updateDetails(1201,"guntur");
	//	System.out.println("Updated");
	//	cp.deleteDetails(154);
	//	System.out.println("Deleted");
	//	StoredProcedure sp=new StoredProcedure();
	//	sp.createConnection();
		//sp.CreateCallableProcedure(1201);
	//	sp.createCallableFunction(1202);
		BatchUpdates bu=new BatchUpdates();
		bu.createConnection();
		bu.batchInsert();
		bu.updateDetails();
		bu.viewDetails();
		
	}

}
