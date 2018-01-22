/**
 *
 */
package com.epam.training.event;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.model.OrganizationModel;

/**
 * @author Oleksandr_Bohdan
 *
 */
public class CustomersCountEventListener extends AbstractEventListener<CustomersCountEvent>
{

	private static String MESSAGE = "There are 5 customers in your organization";

	@Autowired
	private EmailService emailService;


	/* (non-Javadoc)
	 * @see de.hybris.platform.servicelayer.event.impl.AbstractEventListener#onEvent(de.hybris.platform.servicelayer.event.events.AbstractEvent)
	 */
	@Override
	protected void onEvent(final CustomersCountEvent arg0)
	{
		final OrganizationModel organization = arg0.getOrganizationModel();
		final EmailMessageModel message = prepareEmailMessage(organization.getEmail());
		emailService.send(message);
	}

	private EmailMessageModel prepareEmailMessage(final String email)
	{
		final List<EmailAddressModel> addresses = new ArrayList<>();
		final EmailAddressModel address = prepareAddress(email);
		addresses.add(address);
		final String body = MESSAGE;
		final EmailMessageModel message = new EmailMessageModel();
		message.setBody(body);
		message.setSubject(MESSAGE);
		message.setToAddresses(addresses);
		message.setBccAddresses(addresses);
		message.setCcAddresses(addresses);
		message.setFromAddress(address);
		message.setReplyToAddress(email);
		return message;
	}

	private EmailAddressModel prepareAddress(final String email)
	{
		final EmailAddressModel address = new EmailAddressModel();
		address.setEmailAddress(email);
		final Random random = new Random();
		address.setDisplayName(email + random.nextLong());
		return address;
	}


}
