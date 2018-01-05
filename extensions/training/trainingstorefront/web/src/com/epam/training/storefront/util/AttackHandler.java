/**
 *
 */
package com.epam.training.storefront.util;


import de.hybris.platform.core.model.user.CustomerModel;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.training.core.dao.CustomerDao;
import com.epam.training.storefront.security.BruteForceAttackCounter;


/**
 * @author Oleksandr_Bohdan
 *
 */

public class AttackHandler implements BruteForceAttackCounter
{

	private final Integer MAX_ATTEMPTS = 3;
	@Autowired
	private CustomerDao customerDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter#registerLoginFailure(java.lang.
	 * String)
	 */
	@Override
	public void registerLoginFailure(final String userUid)
	{
		final CustomerModel customer = customerDao.get(userUid);
		final Integer attemptCount = customer.getAttemptCount() == null ? new Integer(0) : customer.getAttemptCount();
		customer.setAttemptCount(attemptCount + 1);
		customerDao.save(customer);
		if (customer.getAttemptCount() >= MAX_ATTEMPTS)
		{
			customer.setStatus(true);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter#isAttack(java.lang.String)
	 */
	@Override
	public boolean isAttack(final String userUid)
	{
		final CustomerModel customer = customerDao.get(userUid);
		if (customer == null)
		{
			return false;
		}

		if (customer.getAttemptCount() != null)
		{
			if (customer.getAttemptCount() >= MAX_ATTEMPTS)
			{
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter#resetUserCounter(java.lang.String)
	 */
	@Override
	public void resetUserCounter(final String userUid)
	{
		final CustomerModel customer = customerDao.get(userUid);
		customer.setAttemptCount(new Integer(0));
		customerDao.save(customer);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.acceleratorstorefrontcommons.security.BruteForceAttackCounter#getUserFailedLogins(java.lang.
	 * String)
	 */
	@Override
	public int getUserFailedLogins(final String userUid)
	{
		final CustomerModel customer = customerDao.get(userUid);
		return customer.getAttemptCount();
	}

}