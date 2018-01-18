/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jan 17, 2018 12:13:00 PM                    ---
 * ----------------------------------------------------------------
 */
package com.epam.training.jalo;

import com.epam.training.constants.MytrainingConstants;
import com.epam.training.jalo.Organization;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.Utilities;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generated class for type <code>MytrainingManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedMytrainingManager extends Extension
{
	/** Relation ordering override parameter constants for MyCustomerOrganization from ((mytraining))*/
	protected static String MYCUSTOMERORGANIZATION_SRC_ORDERED = "relation.MyCustomerOrganization.source.ordered";
	protected static String MYCUSTOMERORGANIZATION_TGT_ORDERED = "relation.MyCustomerOrganization.target.ordered";
	/** Relation disable markmodifed parameter constants for MyCustomerOrganization from ((mytraining))*/
	protected static String MYCUSTOMERORGANIZATION_MARKMODIFIED = "relation.MyCustomerOrganization.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("status", AttributeMode.INITIAL);
		tmp.put("attemptCount", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute.
	 * @return the attemptCount
	 */
	public Integer getAttemptCount(final SessionContext ctx, final Customer item)
	{
		return (Integer)item.getProperty( ctx, MytrainingConstants.Attributes.Customer.ATTEMPTCOUNT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute.
	 * @return the attemptCount
	 */
	public Integer getAttemptCount(final Customer item)
	{
		return getAttemptCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute. 
	 * @return the attemptCount
	 */
	public int getAttemptCountAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Integer value = getAttemptCount( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.attemptCount</code> attribute. 
	 * @return the attemptCount
	 */
	public int getAttemptCountAsPrimitive(final Customer item)
	{
		return getAttemptCountAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount
	 */
	public void setAttemptCount(final SessionContext ctx, final Customer item, final Integer value)
	{
		item.setProperty(ctx, MytrainingConstants.Attributes.Customer.ATTEMPTCOUNT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount
	 */
	public void setAttemptCount(final Customer item, final Integer value)
	{
		setAttemptCount( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount
	 */
	public void setAttemptCount(final SessionContext ctx, final Customer item, final int value)
	{
		setAttemptCount( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.attemptCount</code> attribute. 
	 * @param value the attemptCount
	 */
	public void setAttemptCount(final Customer item, final int value)
	{
		setAttemptCount( getSession().getSessionContext(), item, value );
	}
	
	public Organization createOrganization(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( MytrainingConstants.TC.ORGANIZATION );
			return (Organization)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Organization : "+e.getMessage(), 0 );
		}
	}
	
	public Organization createOrganization(final Map attributeValues)
	{
		return createOrganization( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return MytrainingConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.Organization</code> attribute.
	 * @return the Organization
	 */
	public Set<Organization> getOrganization(final SessionContext ctx, final Customer item)
	{
		final List<Organization> items = item.getLinkedItems( 
			ctx,
			true,
			MytrainingConstants.Relations.MYCUSTOMERORGANIZATION,
			null,
			false,
			false
		);
		return new LinkedHashSet<Organization>(items);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.Organization</code> attribute.
	 * @return the Organization
	 */
	public Set<Organization> getOrganization(final Customer item)
	{
		return getOrganization( getSession().getSessionContext(), item );
	}
	
	public long getOrganizationCount(final SessionContext ctx, final Customer item)
	{
		return item.getLinkedItemsCount(
			ctx,
			true,
			MytrainingConstants.Relations.MYCUSTOMERORGANIZATION,
			null
		);
	}
	
	public long getOrganizationCount(final Customer item)
	{
		return getOrganizationCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.Organization</code> attribute. 
	 * @param value the Organization
	 */
	public void setOrganization(final SessionContext ctx, final Customer item, final Set<Organization> value)
	{
		item.setLinkedItems( 
			ctx,
			true,
			MytrainingConstants.Relations.MYCUSTOMERORGANIZATION,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(MYCUSTOMERORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.Organization</code> attribute. 
	 * @param value the Organization
	 */
	public void setOrganization(final Customer item, final Set<Organization> value)
	{
		setOrganization( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to Organization. 
	 * @param value the item to add to Organization
	 */
	public void addToOrganization(final SessionContext ctx, final Customer item, final Organization value)
	{
		item.addLinkedItems( 
			ctx,
			true,
			MytrainingConstants.Relations.MYCUSTOMERORGANIZATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MYCUSTOMERORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to Organization. 
	 * @param value the item to add to Organization
	 */
	public void addToOrganization(final Customer item, final Organization value)
	{
		addToOrganization( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from Organization. 
	 * @param value the item to remove from Organization
	 */
	public void removeFromOrganization(final SessionContext ctx, final Customer item, final Organization value)
	{
		item.removeLinkedItems( 
			ctx,
			true,
			MytrainingConstants.Relations.MYCUSTOMERORGANIZATION,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MYCUSTOMERORGANIZATION_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from Organization. 
	 * @param value the item to remove from Organization
	 */
	public void removeFromOrganization(final Customer item, final Organization value)
	{
		removeFromOrganization( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute.
	 * @return the status
	 */
	public Boolean isStatus(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, MytrainingConstants.Attributes.Customer.STATUS);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute.
	 * @return the status
	 */
	public Boolean isStatus(final Customer item)
	{
		return isStatus( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute. 
	 * @return the status
	 */
	public boolean isStatusAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isStatus( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.status</code> attribute. 
	 * @return the status
	 */
	public boolean isStatusAsPrimitive(final Customer item)
	{
		return isStatusAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, MytrainingConstants.Attributes.Customer.STATUS,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final Customer item, final Boolean value)
	{
		setStatus( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final SessionContext ctx, final Customer item, final boolean value)
	{
		setStatus( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.status</code> attribute. 
	 * @param value the status
	 */
	public void setStatus(final Customer item, final boolean value)
	{
		setStatus( getSession().getSessionContext(), item, value );
	}
	
}
