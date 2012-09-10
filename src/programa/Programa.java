package programa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import domain.*;

public class Programa {
	private static List<Linea> programa;
	public static void main(String[] args){
		programa = new ArrayList<Linea>();
		File asm = new File("P1ASM.txt");
		FileReader fr;
		BufferedReader br;
		Separador s = new Separador();
		
		try {
			fr = new FileReader(asm);
			br = new BufferedReader(fr);
			
			String linea = br.readLine();
			while(linea != null){
				
				programa.add(s.separa(linea));
				
				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		boolean b = false;

		for(Linea l : programa){
			if(l instanceof Instruccion){
				Instruccion ins = (Instruccion) l;
				System.out.print(ins);
				b = true;
			} else{	
				if(b == true)
					System.out.print("\nCOMENTARIO\n");
				else
					System.out.print("COMENTARIO\n");
				b = false;

			}
		}
		Linea ultima = programa.get(programa.size()- 1);
		
		if(ultima instanceof Instruccion){
			Operador o = ((Instruccion) ultima).getOperador();
			if(o.getContenido().compareToIgnoreCase("END") != 0){
				System.out.println("\nError: No se encontro el END");
			}
		} else {
			System.out.println("\nError: No se encontro el END");
		}
		
		
	}
}
