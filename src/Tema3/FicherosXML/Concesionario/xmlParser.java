package Tema3.FicherosXML.Concesionario;

import java.util.List;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class xmlParser{
	//Aqu� van los objetos principales
	
	/* Almacena el archivo que contiene los datos*/
	private File archivo;
	
	/* Almacena el documento XML*/
	private Document documento;
	
	/*Almacena el nodo principal del documento*/
	private Element nodoRaiz;
	
	public xmlParser() {
		//Aqu� se desarrolla el programa
		/* Creamos una instancia del archivo data.xml */
		archivo = new File("C:\\Users\\analo\\Desktop\\Benigaslo\\ADD\\aplicaciones.xml");
		
		/*Creamos un objeto SAXBuilder que nos construir� nuestro fichero XML*/
	
		/*Creamos el documento xml a partir del archivo File*/
		SAXBuilder constructorSAX = new SAXBuilder();
		
		try {
			documento = constructorSAX.build(archivo);
		}
		catch(JDOMException e){
			System.out.println("Fichero XML no valido");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Fichero no valido");
			e.printStackTrace();
		}
		
		/* Obtenemos el nodo raiz o principal*/
		nodoRaiz = documento.getRootElement();
		
		/* Obtenemos la lista de los nodos con la etiqueta 
		 * "aplicacion" que se encuentran en el nodo raiz*/
		List listaAplicaciones = nodoRaiz.getChildren("aplicacion");
		
		/* Recorremos esta lista imprimiendo los elementos
		 * dentro de cada aplicacion y su categoria*/
		for (int i=0; i<listaAplicaciones.size(); i++) {
			
			/* Obtenemoms el elemento de la lista*/
			Element nodo = (Element)listaAplicaciones.get(i);
			
			/* Obtenemos el atributo "categoria" del nodo*/
			String categoria = nodo.getAttribute("categoria").getValue();
			
			/* Obtenemos los datos almacenados en los subnodos
			 * "nombre" y "categoria" de cada nodo "aplicacion"*/
			String nombreAplicacion = nodo.getChild("nombre").getValue();
			String companiaAplicacion = nodo.getChild("compania").getValue();
			
			/* Imprimimos los datos recolectados */
			System.out.println("En categoria: " +categoria);
			System.out.println("Nombre de la aplicacion: "+nombreAplicacion);
			System.out.println("Compania desarrolladora: "+companiaAplicacion);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new xmlParser();
	}

}
