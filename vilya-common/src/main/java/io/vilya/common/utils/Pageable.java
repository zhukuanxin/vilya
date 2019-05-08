/**
 * 
 */
package io.vilya.common.utils;

/**
 * @author erkea <erkea@vilya.io>
 * @see org.springframework.data.domain.Pageable
 */
public interface Pageable {

	int getPageNumber();

	int getPageSize();

	Pageable next();
	
}
