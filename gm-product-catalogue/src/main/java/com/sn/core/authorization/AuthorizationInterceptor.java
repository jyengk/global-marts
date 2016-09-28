package com.sn.core.authorization;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sn.core.exception.UnauthorizedException;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor{
	
	Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);
	
	//TODO - Better to have a service since this will be a shared resource between various services
	@Autowired
	SecurityDao dao;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, 
								HttpServletResponse arg1, 
								Object arg2, 
								Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler) throws UnauthorizedException {
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Authorize authorizationAnnotation = handlerMethod.getMethodAnnotation(Authorize.class);
		RolesAllowed rolesAllowed = handlerMethod.getMethodAnnotation(RolesAllowed.class);
		if(authorizationAnnotation != null){
			log.info(">>> Before executing preHandle");
			String basicAuth = request.getHeader("Authorization");
			log.debug("Basic authentication details :"+ basicAuth);
			if(basicAuth == null){
				throw new UnauthorizedException("Unauthorized to access the resource.");
			}
			String raw = new String(Base64.decodeBase64(basicAuth.replaceFirst("Basic ", "").getBytes()));
			log.info("usernameAndPassword : "+raw);
			if(!(StringUtils.isEmpty(raw))){
				String[] auths = raw.split(":");
				if(auths.length == 0){
					throw new UnauthorizedException("User name and password not provided to access resource.");
				}
				String username = auths[0];
				String password = auths[1];
				log.debug("username|"+username+"|password|"+password+"|");
				if(rolesAllowed != null){
					String[] roles = rolesAllowed.value();
					for(String role : roles){
						if(role.equals("ALL")){
							if(dao.findByUsernameAndPassword(username, password) != null){
								log.debug(">>>>> User name, password authenticated");
								return true;
							}
						}
						else{
							if(dao.findByUsernameAndPasswordAndRole(username, password, role) != null){
								log.debug(">>>>> User name, password and role authorized");
								return true;
							}
						}
					}
				}
				else{
					if(dao.findByUsernameAndPassword(username, password) != null){
						log.debug(">>>>> User name, password authenticated");
						return true;
					}
				}
				throw new UnauthorizedException("Unauthorized to access the resource.");
			}
		}
		
		log.debug(">>>>>dao returned is null");
		return true;
	}

}
