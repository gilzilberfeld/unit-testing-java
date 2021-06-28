package testingil.unittesting.examples.s01.e01.coverage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreditCard {

	private Date expirationDate;
	public CreditCard(Date expirationDate){
		this.expirationDate = expirationDate;
	}
	
	public boolean isExpired() {
		LocalDate localExpDate = LocalDate.ofInstant(
			      expirationDate.toInstant(), ZoneId.systemDefault());
		LocalDate today = LocalDate.now();
		if (today.compareTo(localExpDate) < 0 )
			return true;
		else
			return false;
	}
}
