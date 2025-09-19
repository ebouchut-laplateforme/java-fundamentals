package com.ericbouchut.oop.inheritance;

import java.util.Map;

/**
 * This class implements several interfaces.
 */
class MyApplicationMultipleInterfaces implements Monitorable, Configurable, Runnable {
    private boolean isRunning;

    public static void main(String[] args) {
        MyApplicationMultipleInterfaces app = new MyApplicationMultipleInterfaces();

        System.out.println("isRuning(): " + app.isRunning());
        app.run();
        app.stop();
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public Map<String, Object> getMetrics() {
        return Map.of(
                "error", 42,
                "success", 567
        );
    }

    @Override
    public void loadConfig() {
        System.out.println("Loading configuration.");
    }

    @Override
    public void saveConfig() {
        System.out.println("Saving configuration.");
    }

    @Override
    public void run() {
        System.out.println("Running...");
        try {
            start();
            monitor();
        } catch (Exception ex) {
            // Handle exception
        } finally {
            stop();
        }
    }

    protected void monitor() {
        System.out.println("Monitoring...");
        System.out.println("App isRunning?: " + isRunning());

        System.out.println("App Metrics:" );
        for (Map.Entry<String, ?> metricEntry: getMetrics().entrySet()) {
            System.out.print("\t- ");
            System.out.println(metricEntry);
        }
    }

    protected void start() {
        System.out.println("Starting the App...");

        if (!isRunning()) {
            loadConfig();
            isRunning = true;
        }
    }

    protected void stop() {
        System.out.println("Stopping the App...");

        if (isRunning()) {
            saveConfig();
            isRunning = false;
        }
    }
}