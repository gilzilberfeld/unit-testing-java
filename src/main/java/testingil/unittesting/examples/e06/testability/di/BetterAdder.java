package testingil.unittesting.examples.e06.testability.di;

public class BetterAdder {
	private int temporaryResult=0;
	private AdderRepository repository;
	
	public BetterAdder(AdderRepository rep) {
		this.repository= rep;
	}
	
	public void store(int a) {
		repository.storeInDB(a);
	}

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
