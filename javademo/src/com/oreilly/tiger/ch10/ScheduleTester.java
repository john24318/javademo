package com.oreilly.tiger.ch10;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class ScheduleTester {

	public static void main(String[] args) {
		// Get the scheduler
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

		// Get a handle, starting now, with a 10 second delay
		final ScheduledFuture<?> timeHandle = scheduler
				.scheduleAtFixedRate(new TimePrinter(System.out), 0, 10, SECONDS);

		// Schedule the event, and run for 1 hour (60 * 60 seconds)
		scheduler.schedule(new Runnable() {
			public void run() {
				timeHandle.cancel(false);
			}
		}, 60 * 60, SECONDS);

		/**
		 * On some platforms, you'll have to setup this infinite loop to see output while (true) { }
		 */
	}
}

class TimePrinter implements Runnable {

	private PrintStream out;

	public TimePrinter(PrintStream out) {
		this.out = out;
	}

	public void run() {
		out.printf("Current time: %tr%n", new Date());
	}
}