package testingil.unittesting.examples.e06.testability.modularity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	int currentResult = 0;
	
	@Autowired
	private AdderLogic adderLogic;

	@Autowired
	private PowerInfo powerInfo;

	@Autowired
	private PowerLogic powerLogic;

	public void add(int data) {
		adderLogic.add(data);
		currentResult = adderLogic.result;
	}

	public int getResult() {
		return currentResult;
	}
	
	public void raisePower() {
		powerLogic.toThePower(currentResult, powerInfo.getPower());
		currentResult = powerLogic.result;
	}

}
