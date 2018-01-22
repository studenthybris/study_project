/**
 *
 */
package com.epam.training.event;

import de.hybris.platform.servicelayer.event.events.AbstractEvent;

import com.epam.training.model.OrganizationModel;

/**
 * @author Oleksandr_Bohdan
 *
 */
public class CustomersCountEvent extends AbstractEvent
{

	private final OrganizationModel organizationModel;

	/**
	 * @param organizationModel
	 */
	public CustomersCountEvent(final OrganizationModel organizationModel)
	{
		this.organizationModel = organizationModel;
	}

	/**
	 * @return the organizationModel
	 */
	public OrganizationModel getOrganizationModel()
	{
		return organizationModel;
	}

}
