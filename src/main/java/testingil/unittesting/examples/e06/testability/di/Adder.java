package testingil.unittesting.examples.e06.testability.di;

public class Adder {
	private int temporaryResult=0;
	private AdderRepository repository = new AdderRepository();
	
	public void add(int a, int b) {
		storeAndAdd(a);
		storeAndAdd(b);
	}
	
	private void storeAndAdd(int a) {
		repository.storeInDB(a);
		temporaryResult +=a;
	}
	
	public int getResult() {
		return temporaryResult;
	}
}
