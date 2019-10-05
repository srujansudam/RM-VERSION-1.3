package com.cg.ibs.remittancemgmt.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.bean.FinalCustomer;
import com.cg.ibs.remittancemgmt.bean.TemporaryCustomer;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public class CreditCardDAOImpl implements CreditCardDAO {
	private static FinalCustomer customer = new FinalCustomer();
	private static Map<String, TemporaryCustomer> tempMap = new HashMap<>();
	private static Set<CreditCard> savedCreditCards = new HashSet<>();
	private static Map<String, FinalCustomer> finalMap = new HashMap<>();
	private static Set<CreditCard> unapprovedCreditCards = new HashSet<>();
	private static TemporaryCustomer tempCustomer = new TemporaryCustomer();
	CreditCard creditCard = new CreditCard();
	Iterator<CreditCard> it;

	@Override
	public Set<CreditCard> getDetails(String UCI) {
		return finalMap.get(UCI).getSavedCreditCards();
	}

	@Override
	public void copyDetails(String UCI, CreditCard card) throws RmExceptions {
		if (finalMap.get(UCI).getSavedCreditCards().contains(card)) {
			throw new RmExceptions("Credit card already added");
		} else {
			unapprovedCreditCards.add(card);
			customer.setSavedCreditCards(unapprovedCreditCards);
			tempMap.put(UCI, tempCustomer);
		}
	}

	@Override
	public boolean deleteDetails(String UCI, BigInteger cardNumber) throws RmExceptions {
		boolean result = false;

		if (null == finalMap.get(UCI).getSavedCreditCards()) {
			throw new RmExceptions("Credit Card doesn't exist");

		} else {

			it = finalMap.get(UCI).getSavedCreditCards().iterator();
			while (it.hasNext()) {
				CreditCard creditCard = (CreditCard) it.next();
				if (creditCard.getcreditCardNumber().equals(cardNumber)) {
					savedCreditCards.remove(creditCard);
					result = true;
				}
			}
			return result;
		}
	}

}
