package com.lcsystem.ordering;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LCOrdering {
	private static final String SEPARADOR = "===========================================================================================================";
	private static final String DOS_CEROS = "00";
	private static final String TRES_CEROS = "000";
	private static final String CUATRO_CEROS = "0000";
	private static final String SEIS_CEROS = "000000";
	private static final String OCHO_CEROS = "00000000";
	private static final String FORMATO_TRES_CEROS = "%03d";
	private static final String FORMATO_CUATRO_CEROS = "%04d";
	private static final String FORMATO_OCHO_CEROS = "%08d";
	
	public static List<String> ordenar(List<String> entrada) {
		Map<BigInteger, String> registrosOrdenados = new TreeMap<>();
		
		for(String _registro : entrada) {
			String [] registros = _registro.split("\t");
			String adquisicion = registros[1];
			adquisicion = adquisicion.trim();
			String registro = registros[2];			
			
			StringBuilder clase = new StringBuilder(2);
			
			StringBuilder subClase1 = new StringBuilder(2);
			StringBuilder subClase2 = new StringBuilder(2);
			
			StringBuilder seccion = new StringBuilder(8);
			StringBuilder subSeccion = new StringBuilder(4);
			
			StringBuilder cutter1Parte1 = new StringBuilder(2);
			StringBuilder cutter1Parte2 = new StringBuilder(4);
			
			StringBuilder cutter2Parte1 = new StringBuilder(2);
			StringBuilder cutter2Parte2 = new StringBuilder(4);
			
			StringBuilder edicionParte1 = new StringBuilder(2);
			StringBuilder edicionParte2 = new StringBuilder(2);

			StringBuilder anioParte1 = new StringBuilder(4);
			StringBuilder anioParte2 = new StringBuilder(3);
						
			StringBuilder representacion = new StringBuilder(64);
						
			char [] caracteres = registro.toCharArray();
			
			int etapa = 1;
			int actual = 0;
						
			for(char caracter : caracteres) {
				if(etapa == 1) {
					if(caracter >= 'A' && caracter <= 'Z') {
						actual = caracter;
						clase.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 2) {
					if(caracter >= 'A' && caracter <= 'Z') {
						actual = caracter;
						subClase1.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 3) {
					actual = caracter;
					if(caracter >= 'A' && caracter <= 'Z') {
						subClase2.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 4) {
					if(caracter >= '0' && caracter <= '9') {						
						seccion.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 5) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					if(caracter >= '0' && caracter <= '9') {						
						subSeccion.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 6) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					actual = caracter;
					if(caracter >= 'A' && caracter <= 'Z') {
						cutter1Parte1.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 7) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					if(caracter >= '0' && caracter <= '9') {						
						cutter1Parte2.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 8) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					actual = caracter;
					if(caracter >= 'A' && caracter <= 'Z') {
						cutter2Parte1.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 9) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					if(caracter >= '0' && caracter <= '9') {						
						cutter2Parte2.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 10) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					actual = caracter;
					if(caracter >= 'A' && caracter <= 'Z') {
						edicionParte1.append(actual);
					}else {
						etapa++;
					}
				}
				
				if(etapa == 11) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					if(caracter >= '0' && caracter <= '9') {						
						edicionParte2.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 12) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					if(caracter >= '0' && caracter <= '9') {						
						anioParte1.append(caracter);
						continue;
					}else {
						etapa++;
					}
				}
				
				if(etapa == 13) {
					if(caracter == '.' || caracter == ' ') {
						continue;
					}
					
					actual = caracter;
					if(caracter >= 'a' && caracter <= 'z') {
						anioParte2.append(actual);
					}else {
						etapa++;
					}
				}
				
				etapa ++;
			}
			
			if(cutter1Parte2.length() > 4) {
				anioParte1 = new StringBuilder(revisarAnio(cutter1Parte2.substring(cutter1Parte2.length() - 4)));
				if(anioParte1.toString().equals(CUATRO_CEROS) == false) {
					cutter1Parte2 = new StringBuilder(cutter1Parte2.substring(0, cutter1Parte2.length() - 4));
				}
			}
			
			if(cutter2Parte2.length() > 4) {
				anioParte1 = new StringBuilder(revisarAnio(cutter2Parte2.substring(cutter2Parte2.length() - 4)));
				if(anioParte1.toString().equals(CUATRO_CEROS) == false) {
					cutter2Parte2 = new StringBuilder(cutter2Parte2.substring(0, cutter2Parte2.length() - 4));
				}
			}
			
			if(edicionParte2.length() > 4) {				
				anioParte1 = new StringBuilder(revisarAnio(edicionParte2.substring(edicionParte2.length() - 4)));
				if(anioParte1.toString().equals(CUATRO_CEROS) == false) {
					edicionParte2 = new StringBuilder(edicionParte2.substring(0, edicionParte2.length() - 4));
				}
			}
			
			if(vacio(subClase1)) {
				subClase1.append(DOS_CEROS);
			}
			
			if(vacio(subClase2)) {
				subClase2.append(DOS_CEROS);
			}
			
			if(vacio(seccion)) {
				seccion.append(OCHO_CEROS);
			}else {
				int _seccion = Integer.parseInt(seccion.toString());
				seccion = new StringBuilder(String.format(FORMATO_OCHO_CEROS, _seccion));
			}
			
			if(vacio(subSeccion)) {
				subSeccion.append(SEIS_CEROS);
			}else {
				subSeccion = tratamientoDecimal(subSeccion);
			}
			
			if(vacio(cutter1Parte1)) {
				cutter1Parte1.append(DOS_CEROS);
			}
			
			if(vacio(cutter1Parte2)) {
				cutter1Parte2.append(SEIS_CEROS);
			}else {
				cutter1Parte2 = tratamientoDecimal(cutter1Parte2);
			}
			
			if(vacio(cutter2Parte1)) {
				cutter2Parte1.append(DOS_CEROS);
			}
			
			if(vacio(cutter2Parte2)) {
				cutter2Parte2.append(SEIS_CEROS);
			}else {
				cutter2Parte2 = tratamientoDecimal(cutter2Parte2);
			}
			
			if(vacio(edicionParte1)) {
				edicionParte1.append(DOS_CEROS);
			}
			
			if(vacio(edicionParte2)) {
				edicionParte2.append(CUATRO_CEROS);
			}else {
				int _edicionParte2 = Integer.parseInt(edicionParte2.toString());
				edicionParte2 = new StringBuilder(String.format(FORMATO_CUATRO_CEROS, _edicionParte2));
			}
			
			if(vacio(anioParte1)) {
				anioParte1.append(CUATRO_CEROS);
			}
			
			if(vacio(anioParte2)) {
				anioParte2.append(TRES_CEROS);
			}else {
				int _anioParte2 = Integer.parseInt(anioParte2.toString());
				anioParte2 = new StringBuilder(String.format(FORMATO_TRES_CEROS, _anioParte2));
			}
			
			representacion.append(clase)
			.append(subClase1)
			.append(subClase2)
			.append(seccion)
			.append(subSeccion)
			.append(cutter1Parte1)
			.append(cutter1Parte2)
			.append(cutter2Parte1)
			.append(cutter2Parte2)
			.append(edicionParte1)
			.append(edicionParte2)
			.append(anioParte1)
			.append(anioParte2)
			.append(adquisicion);						
			
//			System.out.println(registro);
//			System.out.println(representacion);
//			System.out.println(clase
//					+ " " + subClase1
//					+ " " + subClase2
//					+ " " + seccion
//					+ " " + subSeccion
//					+ " " + cutter1Parte1
//					+ " " + cutter1Parte2
//					+ " " + cutter2Parte1
//					+ " " + cutter2Parte2
//					+ " " + edicionParte1
//					+ " " + edicionParte2
//					+ " " + anioParte1
//					+ " " + anioParte2
//					+ "\n");

			BigInteger n = new BigInteger(representacion.toString());
			registrosOrdenados.put(n, _registro);
		}
		
		System.out.println(SEPARADOR);
		System.out.println("REGISTROS ORDENADOS");
		System.out.println(SEPARADOR);
		
		return new ArrayList<String>(registrosOrdenados.values());
	}
	
	private static String revisarAnio(final String _anio) {
		StringBuilder anio = new StringBuilder(4);
		
		try {
			int anioN = Integer.parseInt(_anio);
			
			if(anioN >= 1 && anioN < 2100) {
				anio.append(_anio);
			}else {
				anio.append(CUATRO_CEROS);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return anio.toString();
	}
	
	private static StringBuilder tratamientoDecimal(final StringBuilder _parteDecimal) {		
		float parteDecimal = 0f;
		
		try {
			parteDecimal = Float.parseFloat("0." + _parteDecimal.toString());
		}catch(Exception e) {
			System.out.println(e);
		}
		
		String parteDecimalS = String.format("%.6f", parteDecimal);
		parteDecimalS = parteDecimalS.substring(2, parteDecimalS.length());
		StringBuilder resultado = new StringBuilder(parteDecimalS);
		
		return resultado;
	}
	
	private static boolean vacio(final StringBuilder valor) {
		boolean resultado = false;
		
		if(valor.length() == 0) {
			resultado = true;
		}
		
		return resultado;
	}
}
