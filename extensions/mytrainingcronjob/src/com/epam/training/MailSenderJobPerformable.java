/**
 *
 */
package com.epam.training;


import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.training.core.service.OrganizationService;











/**
 * @author Oleksandr_Bohdan
 *
 */
public class MailSenderJobPerformable extends AbstractJobPerformable<CronJobModel>
{

	private static final Logger LOG = Logger.getLogger(MailSenderJobPerformable.class.getName());


	@Autowired
	OrganizationService organizationService;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable#perform(de.hybris.platform.cronjob.model.CronJobModel)
	 */
	@Override
	public PerformResult perform(final CronJobModel arg0)
	{

		organizationService.sendMailsToOrganizationManagers();

		LOG.info("**********************************");
		LOG.info("Greeting from MyJobPerformable!!!");
		LOG.info("Cron job is working!!!");
		LOG.info("**********************************");

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}

}
