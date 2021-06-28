package testingil.unittesting.examples.e06.testability.modularity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdderService {

	int currentResult = 0;
	
	@Autowired
	private AdderLogic adderLogic;
	
	public void add(int data) {
		adderLogic.add(data);
		currentResult = adderLogic.result;
	}

	public int getResult() {
		return currentResult;
	}

}
