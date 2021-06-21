package ar.com.springboot.ms.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTransacurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PreTiempoTransacurridoFilter.class);
	
	//Metodo que indica se se ejecuta el Filtro
	//Se puede implementar una logica para hacerlo
	@Override
	public boolean shouldFilter() {
		return true; //En cada request se va a ejecutar el filtro
	}

	//Metodo que ejecuta el filtro
	@Override
	public Object run() throws ZuulException {
		
		//Obtenemos el contexto
		RequestContext ctx = RequestContext.getCurrentContext();
		//Obtenemos los datos del Request HTTP
		HttpServletRequest request = ctx.getRequest();
		
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long timeStart = System.currentTimeMillis();
		request.setAttribute("timeStart", timeStart);
		
		
		return true; 
	}

	//Tipo de Filtro (Pre, Post, Route)
	@Override
	public String filterType() {
		return "pre";
	}

	//Orden del Filtro
	@Override
	public int filterOrder() {
		return 1;
	}

}
