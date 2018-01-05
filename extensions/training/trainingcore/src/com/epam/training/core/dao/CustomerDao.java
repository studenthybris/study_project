/**
 *
 */
package com.epam.training.core.dao;

import de.hybris.platform.core.model.user.CustomerModel;

/**
 * @author Oleksandr_Bohdan
 *
 */
public interface CustomerDao
{

	public CustomerModel get(String uid);

	public void save(CustomerModel customer);

}
