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

import static org.junit.Assert.assertEquals;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Set;

import org.junit.Test;
import org.mockito.Mockito;

import com.epam.training.model.OrganizationModel;


/**
 *
 */
public class TestHandler
{
	private final Integer CUSTOMERS_AMOUNT = new Integer(5);
	private final Handler handler = new Handler();
	private final OrganizationModel model = Mockito.mock(OrganizationModel.class);
	private final Set<CustomerModel> customers = Mockito.mock(Set.class);

	@Test
	public void testGet()
	{
		final Integer expected = CUSTOMERS_AMOUNT;
		Mockito.when(customers.size()).thenReturn(expected);
		Mockito.when(model.getCustomer()).thenReturn(customers);
		final Integer actual = handler.get(model);
		assertEquals(expected, actual);
	}

}
