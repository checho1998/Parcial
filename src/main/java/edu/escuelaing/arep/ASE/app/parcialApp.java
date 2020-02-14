package edu.escuelaing.arep.ASE.app;

import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class parcialApp 
{
	public static void main(String[] args) {
		port(getPort());
		get("/inputdata", (req, res) -> inputDataPage(req, res));
		get("/results", (req, res) -> resultsPage(req, res));
	}

	
	private static String inputDataPage(Request req, Response res) {
		String pageContent
				= "<!DOCTYPE html>"
				+ "<html>"
				+ "<body>"
				+ "<h2>Mostrar Media y Desviacion estandar </h2>"
				+ "<form action=\"/results\">"
				+ "  Ingrese los datos de la lista, separados por espacios : <br>"
				+ "  <input type=\"text\" name='lista'>"
				+ "  <br>"
				+ "  <br><br>"
				+ "<input type=\"submit\" value=\"Submit\">"
				+ "</form>"
				+ "</body>"
				+ "</html>";
		return pageContent;
	}

	private static String resultsPage(Request req, Response res) {
		String respuesta = "Sergio";
		String resultado
				= "<!DOCTYPE html>"
				+ "<html>"
				+ "<body>"
				+ "<h2>  Desviacion estandar </h2>"
				+ respuesta
				+ "</form>"
				+ "</body>"
				+ "</html>";
		return resultado;
	}

	
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
	}
	
}
