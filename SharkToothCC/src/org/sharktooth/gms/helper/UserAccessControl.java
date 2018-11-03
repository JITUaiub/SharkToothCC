package org.sharktooth.gms.helper;

import javax.servlet.http.HttpServletRequest;

import org.sharktooth.gms.model.User;

public class UserAccessControl {
	public static void setSessionAttribute(HttpServletRequest request, String sessionName, User sessionValue) {
		request.getSession().setAttribute(sessionName, sessionValue);
	}

	public static void removeSessionAttribute(HttpServletRequest request, String sessionName) {
		request.getSession().removeAttribute(sessionName);
	}

	public static boolean checkSessionStatus(HttpServletRequest request, String sessionName) {
		if (request.getSession().getAttribute(sessionName) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String viewSelectorSession(HttpServletRequest request, String viewName) {
		if (checkSessionStatus(request, "loggedUser") == false) {
			return "redirect:/account/login";
		}
		return viewName;
	}
}
