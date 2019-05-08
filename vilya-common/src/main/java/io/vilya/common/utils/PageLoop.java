package io.vilya.common.utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;

/**
 * @author erkea <erkea@vilya.io>
 *
 */
public class PageLoop<T> implements Iterable<T> {

	private static final int DEFAULT_SIZE = 1000;

	private Iterator<T> cache = Collections.emptyIterator();

	private Pageable pageable;

	private boolean stateful = false;

	private Function<Pageable, Iterable<T>> function;

	public PageLoop(Function<Pageable, Iterable<T>> function) {
		Objects.requireNonNull(function, "function");
		this.function = function;
		this.pageable = PageRequest.of(1, DEFAULT_SIZE);
	}
	
	public void setStateful(boolean stateful) {
		this.stateful = stateful;
	}

	@Override
	public Iterator<T> iterator() {
		return new AbstractIterator<T>() {
			@Override
			protected T computeNext() {
				if (!cache.hasNext()) {
					Iterable<T> list = function.apply(pageable);
					if (list == null || !list.iterator().hasNext()) {
						return endOfData();
					} else {
						cache = list.iterator();
					}

					if (!stateful) {
						pageable = pageable.next();
					}
				}
				return cache.next();
			}
		};
	}
	
	private static class PageRequest implements Pageable {

		private int page;

		private int size;

		public static PageRequest of(int page, int size) {
			Preconditions.checkArgument(page > 0, "page must > 0.");
			Preconditions.checkArgument(size > 0, "size must > 0.");

			PageRequest request = new PageRequest();
			request.page = page;
			request.size = size;
			return request;
		}

		@Override
		public int getPageNumber() {
			return page;
		}

		@Override
		public int getPageSize() {
			return size;
		}

		@Override
		public Pageable next() {
			return PageRequest.of(++page, size);
		}

		@Override
		public String toString() {
			return "PageRequest [page=" + page + ", size=" + size + "]";
		}
	}
}
