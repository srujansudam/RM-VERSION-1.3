package com.cg.ibs.remittancemgmt.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import com.cg.ibs.remittancemgmt.bean.AutoPayment;
import com.cg.ibs.remittancemgmt.bean.ServiceProvider;
import com.cg.ibs.remittancemgmt.exception.RmExceptions;

public interface AutoPaymentDAO {
	public Set<AutoPayment> getDetails(String UCI);

	public void copyDetails(String UCI, AutoPayment autoPayment);

	public boolean deleteDetails(String UCI, BigInteger serviceProviderId) throws RmExceptions;

	public List<ServiceProvider> showServiceProviderList();

	public BigDecimal getCurrentBalance(String UCI);

	public void setCurrentBalance(String UCI, BigDecimal currentBalnce);

}
