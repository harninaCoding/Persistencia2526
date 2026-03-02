package com.adorno.configuration.security.jwt.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adorno.configuration.security.jwt.JWTUtils;
import com.adorno.model.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//vamos a utilizar una autentication con username y password
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final JWTUtils jwtUtils;

	public JwtAuthenticationFilter(JWTUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}

	// con el loigin creamos el token

	// Si la autenticacion es correcta el retorno de este metodo sirve como entrada
	// del siguiente metodo
	// successfulAuthentication
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		UserEntity userEntity;
		String username;
		String password;
		try {
			// En el request viene el objeto en el bodyu que se puede mapear a user
			userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
			username = userEntity.getUsername();
			password = userEntity.getPassword();
			// aqui consigo el token que envio al user para autenticacion
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
					password);
			// aqui retorno la autenticacion
			Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);
			System.out.println("JwtAuthenticationFilter:terminado intento authenticate");
			return authenticate;
//		} catch (StreamReadException e) {
//			throw new RuntimeException(e);
//		} catch (DatabindException e) {
//			throw new RuntimeException(e);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		super.unsuccessfulAuthentication(request, response, failed);
		System.out.println("JwtAuthenticationFilter:fallo autenticado");

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// esta clase user se importa de otro sitio?
		// hemos de pillar el objeto autenticado
		User user = (User) authResult.getPrincipal();
		// hacemos un token de acceso con el username
		String accessToken = jwtUtils.generateAccessToken(user.getUsername());
		// escribimos el token en la cabecera
		response.addHeader("Authorization", accessToken);
		// token de refresco
		String refreshToken = jwtUtils.generateRefreshToken(user);

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("token", accessToken);
		hashMap.put("refreshtoken", refreshToken);
		hashMap.put("Message", "autenticacion correcta");
		hashMap.put("usario", user.getUsername());

		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		// para escribir en la respuesta
		/*
		 * En el contexto de Servlets de Java y el framework de Java EE, el objeto
		 * HttpServletResponse proporciona métodos para configurar la respuesta HTTP que
		 * será enviada al cliente. Sin embargo, no proporciona un método para
		 * establecer directamente el contenido del cuerpo de la respuesta como lo
		 * harías con un atributo. La razón principal es que la respuesta HTTP se envía
		 * de manera incremental mientras se procesa. Cuando llamas a
		 * response.getWriter().write(...), estás escribiendo directamente en el flujo
		 * de salida HTTP que se envía al cliente. Esto permite que la respuesta se
		 * genere y envíe al cliente en tiempo real, lo que puede ser útil para enviar
		 * grandes cantidades de datos o para transmitir datos de manera eficiente. En
		 * contraste, si se permitiera establecer el contenido de la respuesta en un
		 * atributo y luego enviarla al cliente, tendrías que construir toda la
		 * respuesta en memoria antes de enviarla, lo que podría ser ineficiente y
		 * consumir más recursos, especialmente para respuestas grandes. Además, HTTP es
		 * un protocolo basado en texto que se envía en forma de flujo de datos. No es
		 * una estructura de datos como un objeto. Por lo tanto, escribir directamente
		 * en el flujo de salida HTTP es la forma natural de enviar la respuesta al
		 * cliente. En resumen, en Servlets de Java y el framework de Java EE, es más
		 * común y eficiente escribir directamente en el flujo de salida HTTP utilizando
		 * métodos como response.getWriter().write(...), en lugar de establecer el
		 * contenido de la respuesta en un atributo y luego enviarla al cliente.
		 */
		/*
		 * O sea, escribir en un flujo puede hcaerse mientras se envia el objeto al
		 * cliente
		 */
		response.getWriter().write(new ObjectMapper().writeValueAsString(hashMap));
		response.getWriter().flush();

		super.successfulAuthentication(request, response, chain, authResult);
		System.out.println("JwtAuthenticationFilter:usuario autenticado");
	}

}
