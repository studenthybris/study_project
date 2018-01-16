/**
 *
 */
package com.epam.training.core.service.impl;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.email.EmailAddressModel;
import de.hybris.platform.acceleratorservices.model.email.EmailMessageModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.core.dao.OrganizationDao;
import com.epam.training.core.service.OrganizationService;
import com.epam.training.core.util.PageData;
import com.epam.training.model.OrganizationModel;


/**
 * @author Oleksandr_Bohdan
 *
 */
public class OrganizationServiceImpl implements OrganizationService
{

	@Autowired
	private EmailService emailService;

	@Autowired
	private OrganizationDao organizationDao;

	@Autowired
	private ModelService modelService;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.epam.training.core.service.OrganizationService#sentMailsToOrganizationManagers()
	 */
	@Override
	public void sendMailsToOrganizationManagers()
	{
		int page = 1;
		final int size = 2;
		final int count = 2;
		PageData pd = new PageData(page, size, count);
		List<OrganizationModel> organizations = organizationDao.getAll(pd);
		do
		{
			for (int i = 0; i < organizations.size(); i++)
			{
				final String email = organizations.get(i).getEmail();
				final List<CustomerModel> customers = organizationDao.getCustomers(email);
				sendMail(email, customers);
			}
			pd = new PageData(++page, size, count);
			organizations = organizationDao.getAll(pd);
		}
		while (organizations.size() > 0);
	}

	private void sendMail(final String email, final List<CustomerModel> customers)
	{
		final EmailMessageModel message = prepareMessage(email, customers);
		emailService.send(message);
	}

	private String prepareBody(final List<CustomerModel> customers)
	{
		final List<String> c = new ArrayList<>();
		for (final CustomerModel customer : customers)
		{
			c.add(customer.getDisplayName());
		}
		return c.toString();
	}


	private EmailMessageModel prepareMessage(final String email, final List<CustomerModel> customers)
	{
		final List<EmailAddressModel> addresses = new ArrayList<>();
		final EmailAddressModel address = prepareAddress(email);
		addresses.add(address);
		final String body = prepareBody(customers);
		final EmailMessageModel message = new EmailMessageModel();
		message.setBody(body);
		message.setSubject("customers of our organization");
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
