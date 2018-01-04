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
package de.hybris.platform.mytraining.hmc;

import de.hybris.platform.hmc.AbstractEditorMenuChip;
import de.hybris.platform.hmc.AbstractExplorerMenuTreeNodeChip;
import de.hybris.platform.hmc.EditorTabChip;
import de.hybris.platform.hmc.extension.HMCExtension;
import de.hybris.platform.hmc.extension.MenuEntrySlotEntry;
import de.hybris.platform.hmc.generic.ClipChip;
import de.hybris.platform.hmc.generic.ToolbarActionChip;
import de.hybris.platform.hmc.webchips.Chip;
import de.hybris.platform.hmc.webchips.DisplayState;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 */
public class MyTrainingHMCExtension extends HMCExtension
{

	public final static String RESOURCE_PATH = "de.hybris.platform.mytraining.hmc.locales";

	@Override
	public List<EditorTabChip> getEditorTabChips(final DisplayState arg0, final AbstractEditorMenuChip arg1)
	{
		return Collections.EMPTY_LIST;
	}

	@Override
	public ResourceBundle getLocalizeResourceBundle(final Locale arg0) throws MissingResourceException
	{
		return null;
	}

	@Override
	public List<MenuEntrySlotEntry> getMenuEntrySlotEntries(final DisplayState arg0, final Chip arg1)
	{
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getResourcePath()
	{
		return RESOURCE_PATH;
	}

	@Override
	public List<ClipChip> getSectionChips(final DisplayState arg0, final ClipChip arg1)
	{
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<ToolbarActionChip> getToolbarActionChips(final DisplayState arg0, final Chip arg1)
	{
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<AbstractExplorerMenuTreeNodeChip> getTreeNodeChips(final DisplayState arg0, final Chip arg1)
	{
		return Collections.EMPTY_LIST;
	}

}
