package com.cg.ibs.remittancemgmt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cg.ibs.remittancemgmt.bean.Beneficiary;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.bean.FinalCustomer;

public class BankRepresentativeDAOImpl implements BankRepresentativeDAO {
	private static Map<String, FinalCustomer> finalMap = new HashMap<>();
	private static Map<String, FinalCustomer> tempMap = new HashMap<>();
	private static FinalCustomer finalCustomer = new FinalCustomer();
	private static Set<CreditCard> approvedCreditCards = new HashSet<>();
	private static ArrayList<Beneficiary> approvedBeneficiaries = new ArrayList<>();

	@Override
	public Map<String, FinalCustomer> getDetails() {
		return tempMap;
	}

	@Override
	public void copyCreditCardDetails(String UCI, CreditCard card) {
		approvedCreditCards.add(card);
		finalCustomer.setSavedCreditCards(approvedCreditCards);
		finalMap.put(UCI, finalCustomer);

	}

	@Override
	public void copyBeneficiaryDetails(String UCI, Beneficiary beneficiary) {
		approvedBeneficiaries.add(beneficiary);
		finalCustomer.setSavedBeneficiaries(approvedBeneficiaries);
		finalMap.put(UCI, finalCustomer);
	}

}
