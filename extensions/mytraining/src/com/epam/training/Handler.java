/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2017 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.epam.training;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import com.epam.training.model.OrganizationModel;


/**
 *
 */
public class Handler implements DynamicAttributeHandler<Integer, OrganizationModel>
{

	@Override
	public Integer get(final OrganizationModel arg0)
	{
		if (arg0.getCustomer() != null)
		{
			return new Integer(arg0.getCustomer().size());
		}
		return new Integer(0);
	}

	@Override
	public void set(final OrganizationModel arg0, final Integer arg1)
	{
		throw new UnsupportedOperationException();
	}

}
