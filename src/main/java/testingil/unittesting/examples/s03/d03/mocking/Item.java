package testingil.unittesting.examples.s03.d03.mocking;

public class Item {
	String name;
	int value;
	
	public Item() {}
	public Item (String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

}
