/**
 *
 */
package com.epam.training.interceptor;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.event.CustomersCountEvent;
import com.epam.training.model.OrganizationModel;

/**
 * @author Oleksandr_Bohdan
 *
 */
public class CustomerCountInterceptor implements ValidateInterceptor<CustomerModel>
{

	@Autowired
	private EventService eventService;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.servicelayer.interceptor.ValidateInterceptor#onValidate(java.lang.Object,
	 * de.hybris.platform.servicelayer.interceptor.InterceptorContext)
	 */
	@Override
	public void onValidate(final CustomerModel arg0, final InterceptorContext arg1) throws InterceptorException
	{
		for(final OrganizationModel organization : arg0.getOrganization()) {
			if (organization.getCustomersNumber().intValue() == 4)
			{
				final CustomersCountEvent event = new CustomersCountEvent(organization);
				eventService.publishEvent(event);
			}
		}
	}


}
