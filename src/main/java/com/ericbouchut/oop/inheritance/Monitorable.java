package com.ericbouchut.oop.inheritance;

import java.util.Map;

/**
*  A Class implementing this interface can be monitored,
 * which means we can now if it is running and get metrics.
 */
public interface Monitorable {
    boolean isRunning();
    Map<String, Object> getMetrics();
}
