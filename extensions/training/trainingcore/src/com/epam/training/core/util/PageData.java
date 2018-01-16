/**
 *
 */
package com.epam.training.core.util;

/**
 * @author Oleksandr_Bohdan
 *
 */
public class PageData
{

	final int pageNumber;
	final int pageSize;
	final int count;

	/**
	 * @param pageNumber
	 * @param pageSize
	 * @param count
	 */
	public PageData(final int pageNumber, final int pageSize, final int count)
	{
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.count = count;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber()
	{
		return pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/**
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}

}
