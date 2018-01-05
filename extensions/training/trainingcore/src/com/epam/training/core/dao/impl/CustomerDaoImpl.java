/**
 *
 */
package com.epam.training.core.dao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.training.core.dao.CustomerDao;

/**
 * @author Oleksandr_Bohdan
 *
 */
@Transactional
public class CustomerDaoImpl implements CustomerDao
{

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	@Autowired
	private ModelService modelService;

	/* (non-Javadoc)
	 * @see com.epam.training.core.dao.CustomerDao#get(java.lang.String)
	 */
	@Override
	public CustomerModel get(final String uid)
	{

		final String fsq = "select {PK} From {Customer} Where {uid} = ?uid";
		final Map<String, String> params = new HashMap<>();
		params.put("uid", uid);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq, params);
		final SearchResult<CustomerModel> result = flexibleSearchService.search(query);
		final List<CustomerModel> list = result.getResult();
		return list.get(0);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.epam.training.core.dao.CustomerDao#save(de.hybris.platform.core.model.user.CustomerModel)
	 */
	@Override
	public void save(final CustomerModel customer)
	{
		modelService.save(customer);
	}

}
