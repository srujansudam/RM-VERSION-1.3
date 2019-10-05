package com.cg.ibs.remittancemgmt.dao;

import java.util.Map;

import com.cg.ibs.remittancemgmt.bean.Beneficiary;
import com.cg.ibs.remittancemgmt.bean.CreditCard;
import com.cg.ibs.remittancemgmt.bean.FinalCustomer;

public interface BankRepresentativeDAO {
	public Map<String, FinalCustomer> getDetails(); // Object Array
	public void copyCreditCardDetails(String UCI, CreditCard card);
	public void copyBeneficiaryDetails(String UCI, Beneficiary beneficiary);
}
