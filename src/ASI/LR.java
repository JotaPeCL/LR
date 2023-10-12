/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASI;

import java.io.File;

/**
 *
 * @author juanp
 */
public class LR {
    public static void main(String[] args) {
        String ruta="C:/Users/juanp/OneDrive/Documentos/Workspace/LR/src/ASI/Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo=new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
