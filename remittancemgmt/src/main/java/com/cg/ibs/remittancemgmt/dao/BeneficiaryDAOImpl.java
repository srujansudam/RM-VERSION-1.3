package com.cg.ibs.remittancemgmt.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cg.ibs.remittancemgmt.bean.Beneficiary;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.bean.FinalCustomer;
import com.cg.ibs.remittancemgmt.bean.TemporaryCustomer;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public class BeneficiaryDAOImpl implements BeneficiaryDAO {
	private static FinalCustomer customer = new FinalCustomer();
	private static Map<String, TemporaryCustomer> tempMap = new HashMap<>();
	private static Map<String, FinalCustomer> finalMap = new HashMap<>();
	private static ArrayList<Beneficiary> savedBeneficiaries = new ArrayList<>();
	private static ArrayList<Beneficiary> unapprovedBeneficiaries = new ArrayList<>();
	private static TemporaryCustomer tempCustomer = new TemporaryCustomer();
	Iterator<Beneficiary> it;

	@Override
	public ArrayList<Beneficiary> getDetails(String UCI) {
		return finalMap.get(UCI).getSavedBeneficiaries();
	}

	@Override
	public void copyDetails(String UCI, Beneficiary beneficiary) throws RmExceptions {
		if (finalMap.get(UCI).getSavedBeneficiaries().contains(beneficiary)) {
			throw new RmExceptions("Beneficiary already added");
		} else {
			unapprovedBeneficiaries.add(beneficiary);
			tempCustomer.setUnapprovedBeneficiaries(unapprovedBeneficiaries);
			tempMap.put(UCI, tempCustomer);
		}

	}

	@Override
	public boolean updateDetails(String UCI, Beneficiary beneficiary1) throws RmExceptions {

		boolean result = false;

		if (!(finalMap.get(UCI).getSavedBeneficiaries().contains(beneficiary1))) {
			throw new RmExceptions("Beneficiary doesn't exist");

		}
		it = finalMap.get(UCI).getSavedBeneficiaries().iterator();
		while (it.hasNext()) {
			Beneficiary beneficiary = (Beneficiary) it.next();
			if (beneficiary.getAccountNumber().equals(beneficiary1.getAccountNumber())) {
				savedBeneficiaries.remove(beneficiary);
				result = true;
			}
		}
		unapprovedBeneficiaries.add(beneficiary1);
		tempCustomer.setUnapprovedBeneficiaries(unapprovedBeneficiaries);
		tempMap.put(UCI, tempCustomer);

		return result;

	}

	@Override
	public boolean deleteDetails(String UCI, BigInteger accountNumber) throws RmExceptions {
		// TODO Auto-generated method stub
		boolean result = false;
		for (Beneficiary beneficiary : finalMap.get(UCI).getSavedBeneficiaries()) {
			if (beneficiary.getAccountNumber().equals(accountNumber))  {

				throw new RmExceptions("Beneficiary doesn't exist");
			}
		}
		it = finalMap.get(UCI).getSavedBeneficiaries().iterator();
		while (it.hasNext()) {
			Beneficiary beneficiary = (Beneficiary) it.next();
			if (beneficiary.getAccountNumber().equals(accountNumber)) {
				savedBeneficiaries.remove(beneficiary);
				result = true;
			}
		}
		return result;
	}

}
