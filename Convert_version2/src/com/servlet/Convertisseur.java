package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Temperature;

@WebServlet("/Convertisseur")
public class Convertisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Convertisseur() {
        super();
          }

	// fait uniquement appel à la vue
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// appel de la vue pour le formulaire 
		request.getRequestDispatcher("vue/Demande.jsp").forward(request, response); 
	}

	// traite le choix de l'utilisateur
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupération du paramètre 
		String valCelsius = request.getParameter("celsius");
		// variable pour la conversion
		double celsius=0;
		Temperature t;
		// zone de texte pour paramétrer le message à transmettre à la jsp
		String message=null;
		if (valCelsius.isEmpty()) {
		          message="vous n'avez rien saisi, on vous donne par défaut la conversion pour 20 degrés";
		                  // Pas de valeur: il faudrait afficher un message, etc.
		                  valCelsius = "20";
		          }
		          try
		          {
		        	  celsius=Double.valueOf(valCelsius);
		        	  t= new Temperature(Double.valueOf(valCelsius));
		        	  // on transmet l'objet t en paramètre à la jsp
			          request.setAttribute("t", t);
		          }
		          catch (NumberFormatException e)
		          {
		    	   message="la valeur saisie doit être  numérique";
		          }
		          // on transmet l'objet message  en paramètre à la jsp
		          request.setAttribute("message", message);
		          // appel de la vue
		          request.getRequestDispatcher("vue/Resultat.jsp").forward(request, response); 
	}

}
