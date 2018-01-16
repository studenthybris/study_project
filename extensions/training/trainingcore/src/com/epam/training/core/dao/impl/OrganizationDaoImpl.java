/**
 *
 */
package com.epam.training.core.dao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.core.dao.OrganizationDao;
import com.epam.training.core.util.PageData;
import com.epam.training.model.OrganizationModel;


/**
 * @author Oleksandr_Bohdan
 *
 */
public class OrganizationDaoImpl implements OrganizationDao
{

	private final String SELECT_ALL_CUSTOMERS_BY_ORGANIZATION_EMAIL = "select {c.PK} From {Customer as c JOIN MyCustomerOrganization as mco ON {c.PK} = {mco.source} JOIN Organization as o ON{mco.target} = {o.PK} and {o.email} = ?email }";

	@Autowired
	private FlexibleSearchService flexibleSearchService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.epam.training.core.dao.OrganizationDao#getCustomers()
	 */

	@Override
	public List<OrganizationModel> getAll()
	{
		final String fsq = "select {PK} From {Organization}";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq);
		final SearchResult<OrganizationModel> result = flexibleSearchService.search(query);
		return result.getResult();
	}

	@Override
	public List<CustomerModel> getCustomers(final String email)
	{
		final String fsq = SELECT_ALL_CUSTOMERS_BY_ORGANIZATION_EMAIL;
		final Map<String, String> params = new HashMap<>();
		params.put("email", email);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq, params);
		final SearchResult<CustomerModel> result = flexibleSearchService.search(query);
		final List<CustomerModel> list = result.getResult();
		return list;
	}

	@Override
	public List<OrganizationModel> getAll(final PageData pageData)
	{
		final int start = pageData.getPageNumber() == 1 ? 0 : (pageData.getPageNumber() - 1) * pageData.getPageSize();
		final int count = pageData.getCount();
		final String fsq = "select {PK} From {Organization}";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq);
		query.setStart(start);
		query.setCount(count);
		final SearchResult<OrganizationModel> result = flexibleSearchService.search(query);
		return result.getResult();
	}

	@Override
	public List<CustomerModel> getCustomers(final String email, final PageData pageData)
	{
		final int start = pageData.getPageNumber() == 1 ? 0 : (pageData.getPageNumber() - 1) * pageData.getPageSize();
		final int count = pageData.getCount();
		final String fsq = SELECT_ALL_CUSTOMERS_BY_ORGANIZATION_EMAIL;
		final Map<String, String> params = new HashMap<>();
		params.put("email", email);
		final FlexibleSearchQuery query = new FlexibleSearchQuery(fsq, params);
		query.setStart(start);
		query.setCount(count);
		final SearchResult<CustomerModel> result = flexibleSearchService.search(query);
		final List<CustomerModel> list = result.getResult();
		return list;
	}

}



