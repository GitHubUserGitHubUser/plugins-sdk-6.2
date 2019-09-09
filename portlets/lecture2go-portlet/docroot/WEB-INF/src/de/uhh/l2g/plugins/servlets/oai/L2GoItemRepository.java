package de.uhh.l2g.plugins.servlets.oai;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dspace.xoai.dataprovider.exceptions.IdDoesNotExistException;
import org.dspace.xoai.dataprovider.exceptions.OAIException;
import org.dspace.xoai.dataprovider.filter.Filter;
import org.dspace.xoai.dataprovider.filter.FilterResolver;
import org.dspace.xoai.dataprovider.filter.Scope;
import org.dspace.xoai.dataprovider.filter.ScopedFilter;
import org.dspace.xoai.dataprovider.handlers.results.ListItemIdentifiersResult;
import org.dspace.xoai.dataprovider.handlers.results.ListItemsResults;
import org.dspace.xoai.dataprovider.model.Item;
import org.dspace.xoai.dataprovider.model.ItemIdentifier;
import org.dspace.xoai.dataprovider.repository.ItemRepository;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.dspace.xoai.dataprovider.model.conditions.Condition;
import com.lyncode.builder.ListBuilder;

import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.impl.OaiRecordImpl;
import de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil;
import de.uhh.l2g.plugins.servlets.oai.filters.DateFromFilter;
import de.uhh.l2g.plugins.servlets.oai.filters.DateUntilFilter;
import de.uhh.l2g.plugins.servlets.oai.filters.L2GoFilter;



public class L2GoItemRepository implements ItemRepository {

	public L2GoItemRepository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getItem(String identifier) throws IdDoesNotExistException, OAIException {
		// build the lightweight item for the identifier without the metadata		
		L2GoItem item = new L2GoItem(); 
		
		OaiRecord oaiRecord = new OaiRecordImpl();
		
		try {
			oaiRecord = OaiRecordLocalServiceUtil.getByIdentifier(identifier);
		} catch (Exception e) {
			// identifier does not exist
			throw new IdDoesNotExistException();
		}
		
		item
			.with("identifier", oaiRecord.getIdentifier())
			.with("deleted", false)
			.with("sets", new ListBuilder<String>().add(randomAlphabetic(3)).build())
			.with("datestamp", oaiRecord.getDatestamp());
		
		//L2GoItem item = fillItem(identifier);
		return item;
	}
	
	
	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length)
			throws OAIException {
		
		QueryResult queryResult;
		try {
			queryResult = retrieveItems(filters, offset, length);
		} catch (IdDoesNotExistException e) {
			throw new OAIException();
		}
        return new ListItemIdentifiersResult(queryResult.hasMore(), queryResult.getResults());
	}
	

	/**
	 * This translates the scoped filters to a dynamic query
	 * @param filters the scopedFilters which are used for restricting the query to the database
	 * @return the dynamic query which can be further processed
	 */
	private DynamicQuery getDynamicQueryFromFilters(List<ScopedFilter> filters) {
		DynamicQuery dynamicQuery = OaiRecordLocalServiceUtil.dynamicQuery();
		
		for (ScopedFilter scopedFilter: filters) {
			// if filter is a L2GoFilter and has the Query scope add the criterion to the query
			Filter filter = scopedFilter.getCondition().getFilter(null);
			if (filter instanceof L2GoFilter && scopedFilter.getScope() == Scope.Query) {
				Criterion criterion = ((L2GoFilter) filter).getCriterion();
				dynamicQuery.add(criterion);
			}
		}			
		
		return dynamicQuery;
	}
	
	
	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from)
			throws OAIException {
		
        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}
	


	@Override
	public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length,
			Date until) throws OAIException {
		
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length, Date from,
			Date until) throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItemIdentifiers(filters, offset, length);
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date from) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiersUntil(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemIdentifiersResult getItemIdentifiers(List<ScopedFilter> filters, int offset, int length,
			String setSpec, Date from, Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length) throws OAIException {
		
		QueryResult queryResult;
		try {
			queryResult = retrieveItems(filters, offset, length);
		} catch (IdDoesNotExistException e) {
			throw new OAIException();
		}
		
		List<? extends ItemIdentifier> result = queryResult.getResults();
		
        return new ListItemsResults(queryResult.hasMore(), (List<Item>) result);
	}
	

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from)
			throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, Date until)
			throws OAIException {
		
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, Date from, Date until)
			throws OAIException {

        filters.add(new ScopedFilter(getDateFromFilter(from), Scope.Query));
        filters.add(new ScopedFilter(getDateUntilFilter(until), Scope.Query));
        return this.getItems(filters, offset, length);
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec)
			throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from)
			throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItemsUntil(List<ScopedFilter> filters, int offset, int length, String setSpec,
			Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListItemsResults getItems(List<ScopedFilter> filters, int offset, int length, String setSpec, Date from,
			Date until) throws OAIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	// metadata for item has been moved to L2GoItem
	/*
	private L2GoItem fillItem(String identifier) throws IdDoesNotExistException {
		// get the id of the video from the identifier, which is the url is this case
		//String videoIdString = StringUtil.extractLast(identifier, "/");
		Long videoId = Long.parseLong(identifier);
		
		L2GoItem l2GoItem = new L2GoItem(); 
		
		Video v = new VideoImpl();
		try {
			v = VideoLocalServiceUtil.getVideo(videoId);
		} catch (Exception e) {
			throw new IdDoesNotExistException();
		}

		try {
			
			// Identifier
			l2GoItem.with("identifier", identifier);
			
			// Title
			String title = v.getTitle();
			l2GoItem.with("title", title);


			// Creators
			List<Creator> creators = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
			for (Creator c: creators) {
				c.getFullName();
			}
			
			// PublicationYear
			// todo - transform to year
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
			Date generationDate = format.parse(v.getGenerationDate());
			l2GoItem.with("datestamp", generationDate);
		
			// ResourceType
			String containerFormat = v.getContainerFormat();
			l2GoItem.with("containerFormat", containerFormat);
			
			
			// Contributor 
			// todo
			
			// Language
			Metadata metadata = MetadataLocalServiceUtil.getMetadata(v.getMetadataId());
			String language = metadata.getLanguage();
			l2GoItem.with("language", language);

			
			// Size
			// todo - transform
			String duration = v.getDuration();
			l2GoItem.with("duration", duration);
			
			// Rights
			License license = LicenseLocalServiceUtil.getLicense(v.getLicenseId());
			String rights = license.getFullName();
			l2GoItem.with("rights", rights);

			
		} catch (Exception e) {
			// TODO: exception handling -> no video with id
		}
	
		l2GoItem.with("deleted", false).with("sets", new ListBuilder<String>().add(randomAlphabetic(3)).build());
		
		return l2GoItem;
	}
	*/
	
	/**
	 * Uses the Liferay DynamicQuery to fetch the corresponding data and add them to 
	 * @param filters
	 * @param offset
	 * @param length
	 * @return
	 * @throws OAIException 
	 * @throws IdDoesNotExistException 
	 */
	private QueryResult retrieveItems(List<ScopedFilter> filters, int offset, int length) throws IdDoesNotExistException, OAIException {		
		List<ItemIdentifier> l2GoItems =  new ArrayList<ItemIdentifier>();
		
		long count = 0;

		// get the dynamic query according to the filters
		DynamicQuery dynamicQuery = getDynamicQueryFromFilters(filters);
		
		// TODO: this must be set to the new data type, when implemented
		List<OaiRecord> oaiRecords;
		
		try {
			oaiRecords = OaiRecordLocalServiceUtil.dynamicQuery(dynamicQuery,offset, offset + length);
			// get the count of all OaiRecords
			count = OaiRecordLocalServiceUtil.dynamicQueryCount(dynamicQuery);
			
			for (OaiRecord oaiRecord: oaiRecords) {
				l2GoItems.add(getItem(oaiRecord.getIdentifier()));
			}
		}
		catch (SystemException e) {
			throw new OAIException();
		}

		return new QueryResult(l2GoItems, offset + length < count, count);
	}
	
	private Condition getDateFromFilter(final Date from) {
		return new Condition() {
			@Override
			public Filter getFilter(FilterResolver filterResolver) {
                return new DateFromFilter(from);
			}
        };
	}
	
	private Condition getDateUntilFilter(final Date unti) {
		return new Condition() {
			@Override
			public Filter getFilter(FilterResolver filterResolver) {
                return new DateUntilFilter(unti);
			}
        };
	}
	
	private class QueryResult {
        private List<ItemIdentifier> results;
        private boolean hasMore;
        private long total;

        private QueryResult(List<ItemIdentifier> results, boolean hasMore, long count) {
            this.results = results;
            this.hasMore = hasMore;
            this.total = count;
        }

        private List<ItemIdentifier> getResults() {
            return results;
        }

        private boolean hasMore() {
            return hasMore;
        }

        private long getTotal() {
            return total;
        }
    }
}
