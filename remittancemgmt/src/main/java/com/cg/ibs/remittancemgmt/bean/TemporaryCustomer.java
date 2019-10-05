package com.cg.ibs.remittancemgmt.bean;

import java.util.ArrayList;
import java.util.Set;

public class TemporaryCustomer {
	private String UCI;
	private Set<CreditCard> unapprovedCreditCards;
	private ArrayList<Beneficiary> unapprovedBeneficiaries;

	public TemporaryCustomer() {
		super();
	}

	public TemporaryCustomer(String uCI, Set<CreditCard> unapprovedCreditCards,
			ArrayList<Beneficiary> unapprovedBeneficiaries) {
		super();
		UCI = uCI;
		this.unapprovedCreditCards = unapprovedCreditCards;
		this.unapprovedBeneficiaries = unapprovedBeneficiaries;
	}

	@Override
	public String toString() {
		return "TemporaryCustomer [UCI=" + UCI + ", unapprovedCreditCards=" + unapprovedCreditCards
				+ ", unapprovedBeneficiaries=" + unapprovedBeneficiaries + "]";
	}

	public String getUCI() {
		return UCI;
	}

	public void setUCI(String uCI) {
		UCI = uCI;
	}

	public Set<CreditCard> getUnapprovedCreditCards() {
		return unapprovedCreditCards;
	}

	public void setUnapprovedCreditCards(Set<CreditCard> unapprovedCreditCards) {
		this.unapprovedCreditCards = unapprovedCreditCards;
	}

	public ArrayList<Beneficiary> getUnapprovedBeneficiaries() {
		return unapprovedBeneficiaries;
	}

	public void setUnapprovedBeneficiaries(ArrayList<Beneficiary> unapprovedBeneficiaries) {
		this.unapprovedBeneficiaries = unapprovedBeneficiaries;
	}

}
