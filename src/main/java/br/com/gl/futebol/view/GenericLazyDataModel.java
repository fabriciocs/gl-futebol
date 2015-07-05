package br.com.gl.futebol.view;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.NumberUtils;

import br.com.gl.futebol.entity.HasID;
import br.com.gl.futebol.service.GenericService;

public class GenericLazyDataModel<T extends HasID<?>> extends LazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericService<T> service;
	private Page<T> page;

	public GenericLazyDataModel(GenericService<T> service) {
		this.service = service;
	}

	@Override
	public List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		Object search = filters.get("search");
		if (search == null) {
			search = "";
		}
		Direction direction = (SortOrder.ASCENDING == sortOrder) ? Direction.ASC
				: Direction.DESC;
		Pageable pageable = new PageRequest((first / pageSize), pageSize,
				direction, sortField);

		page = service.buscar(Optional.of(search.toString()), pageable);
		setRowCount(new Long(page.getTotalElements()).intValue());
		return page.getContent();
	}

	public T getRowData(String rowKey) {
		return service.get(NumberUtils.parseNumber(rowKey, Integer.class));
	}

	public Object getRowKey(T object) {
		return object.getId();
	}
}
