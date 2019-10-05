package com.cg.ibs.remittancemgmt.dao;

import java.math.BigInteger;
import java.util.Set;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public interface CreditCardDAO {
	public Set<CreditCard> getDetails(String UCI);

	public void copyDetails(String UCI, CreditCard card) throws RmExceptions;

	public boolean deleteDetails(String UCI, BigInteger cardNumber) throws RmExceptions;
}
