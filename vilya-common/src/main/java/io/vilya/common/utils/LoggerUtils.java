/**
 * 
 */
package io.vilya.common.utils;

import java.lang.StackWalker.Option;
import java.lang.StackWalker.StackFrame;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author erkea <erkea@vilya.io>
 *
 */
public class LoggerUtils {

	private static ConcurrentHashMap<Class<?>, Logger> loggerCache = new ConcurrentHashMap<>();

	private LoggerUtils() {
	}

	public static void info(String message) {
		getLogger().info(message);
	}

	private static Logger getLogger() {
		return loggerCache.computeIfAbsent(getCaller(), LoggerFactory::getLogger);
	}

	private static Class<?> getCaller() {
		return StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE)
				.walk(LoggerUtils::selectCaller);
	}

	private static Class<?> selectCaller(Stream<StackFrame> sfs) {
		return sfs.map(StackFrame::getDeclaringClass)
				.dropWhile(clazz -> clazz == LoggerUtils.class)
				.findFirst()
				.orElseThrow();
	}

}
