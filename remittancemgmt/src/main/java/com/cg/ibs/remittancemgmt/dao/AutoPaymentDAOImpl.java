package com.cg.ibs.remittancemgmt.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.ibs.remittancemgmt.bean.AutoPayment;
import com.cg.ibs.remittancemgmt.bean.FinalCustomer;
import com.cg.ibs.remittancemgmt.bean.ServiceProvider;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public class AutoPaymentDAOImpl implements AutoPaymentDAO {
	private static FinalCustomer finalCustomer = new FinalCustomer();
	private static Map<String, FinalCustomer> finalMap = new HashMap<>();
	private static Set<AutoPayment> savedAutoPaymentServices = new HashSet<>();
	AutoPayment autoPayment = new AutoPayment();

	@Override
	public void copyDetails(String UCI, AutoPayment autoPayment) {
		// TODO Auto-generated method stub
		savedAutoPaymentServices.add(autoPayment);
		finalCustomer.setSavedAutoPaymentServices(savedAutoPaymentServices);
		finalMap.put(UCI, finalCustomer);
	}

	@Override
	public Set<AutoPayment> getDetails(String UCI) {
		// TODO Auto-generated method stub

		return  finalMap.get(UCI).getSavedAutoPaymentServices();
	}

	@Override
	public boolean deleteDetails(String UCI, BigInteger serviceProviderId) throws RmExceptions {
		// TODO Auto-generated method stub
		boolean result = false;

		if (null == finalMap.get(UCI).getSavedAutoPaymentServices()) {
			throw new RmExceptions("Auto payment service doesn't exist");

		} else {

			for (AutoPayment autoPayment : finalMap.get(UCI).getSavedAutoPaymentServices()) {

				if (autoPayment.getServiceProviderId().equals(serviceProviderId)) {
					savedAutoPaymentServices.remove(autoPayment);
					result = true;
				} // iterator check
			}
			return result;

		}

	}

	@Override
	public BigDecimal getCurrentBalance(String UCI) {
		return finalMap.get(UCI).getCurrentBalance();
	}

	@Override
	public void setCurrentBalance(String UCI, BigDecimal currentBalnce) {
		finalCustomer.setCurrentBalance(currentBalnce);
		finalMap.put(UCI, finalCustomer);
	}

	@Override
	public List<ServiceProvider> showServiceProviderList() {
		// TODO Auto-generated method stub
		return null;
	}
}
