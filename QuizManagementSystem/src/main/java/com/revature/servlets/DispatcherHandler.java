package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DispatcherHandler implements DispatcherServices {
	
	private final List<DispatcherServices> dispatchers;
	private static final DispatcherHandler instance = new DispatcherHandler();
	
	private DispatcherHandler() {
		this.dispatchers = new ArrayList<>();
		this.dispatchers.add(new AuthDispatcher());
		this.dispatchers.add(new QuizDispatcher());
	}

	@Override
	public boolean supports(HttpServletRequest request) {
		for (DispatcherServices d : dispatchers) {
			if (d.supports(request)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void performService(HttpServletRequest request, HttpServletResponse response) {
		for (DispatcherServices d : dispatchers) {
			if (d.supports(request)) {
				d.performService(request, response);
			}
		}
	}

	public static DispatcherHandler getInstance() {
		return instance;
	}

}
