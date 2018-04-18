package com.lcsystem.ordering;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class LCOrder {	
	private static final String NEW_LINE = "\n";
		
	public static void ordenar(final String _destino, byte[] contenido) {			
		List<String> registros = new ArrayList<String>();
		
		String destino = _destino.replace(".txt", "").concat("_ordenado.txt");
		
		String cabecera = "";
		try(InputStream inputStream = new ByteArrayInputStream(contenido);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); 
				Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destino), "utf-8"))){
			String linea;
			
			while ((linea = br.readLine()) != null) {
				if(linea.startsWith("Matriz")) {
					cabecera = linea;
				}
				
				if(linea.matches("^(\\d){8}.*")){
					registros.add(linea);					
				}
			}

			registros = LCOrdering.ordenar(registros);

			writer.write(cabecera);
			for(String registro : registros) {				
				writer.write(NEW_LINE);
				writer.write(registro);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
