package ar.com.springboot.ms.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTransacurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PostTiempoTransacurridoFilter.class);
	
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
		
		log.info("Entrando a post filter");
		
		Long timeStart = (Long) request.getAttribute("timeStart");
		Long timeEnd = System.currentTimeMillis();
		Long timeElapsed = timeEnd - timeStart;
		
		log.info(String.format("Tiempo transcurrido en segundos: %s seg.", timeElapsed.doubleValue() / 1000.00));
		log.info(String.format("Tiempo transcurrido en miliseg: %s ms.", timeElapsed));
		
		
		return true; 
	}

	//Tipo de Filtro (pre, post, route, error)
	@Override
	public String filterType() {
		return "post";
	}

	//Orden del Filtro
	@Override
	public int filterOrder() {
		return 1;
	}

}
