/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author carlo
 */
public class AnalizadorLexico {
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/AnalizadorSintactico.cup"};
        generarLexer(ruta1, ruta2, rutaS);
    }
    public static void generarLexer(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/sym.java"),
                Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/sym.java")
        );
        
        Path rutaSin = Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/Sintax.java"),
                Paths.get("C:/Users/carlo/OneDrive/Documents/NetBeansProjects/TraductorMLP/src/codigo/Sintax.java")
        );
    }
}
