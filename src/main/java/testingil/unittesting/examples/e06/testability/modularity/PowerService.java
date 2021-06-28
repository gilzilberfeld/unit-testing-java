package testingil.unittesting.examples.e06.testability.modularity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerService {

	int currentResult = 0;

	@Autowired
	private PowerLogic powerLogic;

	@Autowired
	private PowerInfo powerInfo;
	
	public void raisePower() {
		powerLogic.toThePower(currentResult, powerInfo.getPower());
		currentResult = powerLogic.result;
	}

	public int getResult() {
		return currentResult;
	}
	

}
