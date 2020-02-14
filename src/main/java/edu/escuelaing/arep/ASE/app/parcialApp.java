package edu.escuelaing.arep.ASE.app;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class parcialApp {
    
	public static void main(String[] args) {
		port(getPort());
		get("/inputdata", (req, res) -> inputDataPage(req, res));
		get("/results", (req, res) ->{res.type("application/json");return resultsPage(req, res);});}

	
	private static String inputDataPage(Request req, Response res) {
		String pageContent
				= "<!DOCTYPE html>"
				+ "<html>"
				+ "<body>"
				+ "<h2>Parcial</h2>"
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
            
            String lista = req.queryParams("lista");
            String[] lista2 = lista.split(" ");
            calculos cal = new calculos(lista2);
            int[] ent= new int[lista2.length];
            for (int i= 0;i<lista2.length;i++){
                ent[i]  = Integer.parseInt(lista2[i]);
            }
            cal.mergeSort(ent, ent.length);
            for (int i= 0;i<lista2.length;i++){
                lista2[i] = String.valueOf(ent[i]);
            }
            calculos list = new calculos(lista2);
            Gson gson= new Gson();
            String JSON = gson.toJson(list);
            return JSON;
	}
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
	}
        
}
