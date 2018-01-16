/**
 *
 */
package com.epam.training.core.dao;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

import com.epam.training.core.util.PageData;
import com.epam.training.model.OrganizationModel;


/**
 * @author Oleksandr_Bohdan
 *
 */
public interface OrganizationDao
{

	public List<OrganizationModel> getAll();

	public List<CustomerModel> getCustomers(String email);

	public List<OrganizationModel> getAll(PageData pageData);

	public List<CustomerModel> getCustomers(String email, PageData pageData);

}
