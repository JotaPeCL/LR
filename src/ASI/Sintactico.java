/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASI;

/**
 *
 * @author juanp
 */
import java.util.Stack;

public class Sintactico {

    private int is;

    private String resultado="";
    public String error, ante;
    private final String simbolos[] = {"ID", "Numero", "ent", "flot", "car", ",", ";", "+", "-", "*", "/", "(", ")", "=", "$", "P", "Tipo", "V", "A", "S", "E", "T", "F"};
    private final String estados[] = {"I0", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19", "I20", "I21", "I22", "I23", "I24", "I25", "I26", "I27", "I28", "I29", "I30", "I31", "I32", "I33", "I34", "I35", "I36", "I37"};

    private final String tabla[][] = {{"I7", "error", "I4", "I5", "I6", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I1", "I2", "error", "I3", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P0", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"I8", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P2,P-1", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"P3,Tipo-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"P4,Tipo-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"P5,Tipo-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I9", "error", "error", "error", "error", "error", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "I11", "I12", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I10", "error", "error", "error", "error", "error"},
    {"I20", "I21", "error", "error", "error", "error", "error", "I14", "I15", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "I13", "I16", "I17", "I18"},
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P1,P-3", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"I22", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},
    {"I7", "error", "I4", "I5", "I6", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I23", "I2", "error", "I3", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "error", "I24", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "I25", "I17", "I18"},
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "I26", "I17", "I18"},
    {"error", "error", "error", "error", "error", "error", "P11,S-1", "I27", "I28", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P14,E-1", "P14,E-1", "P14,E-1", "I29", "I30", "error", "P14,E-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P17,T-1", "P17,T-1", "P17,T-1", "P17,T-1", "P17,T-1", "error", "P17,T-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "I31", "I17", "I18"},
    {"error", "error", "error", "error", "error", "error", "P19,F-1", "P19,F-1", "P19,F-1", "P19,F-1", "P19,F-1", "error", "P19,F-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P20,F-1", "P20,F-1", "P20,F-1", "P20,F-1", "P20,F-1", "error", "P20,F-1", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "I11", "I12", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I32", "error", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P7,V-2", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P8,A-4", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P9,S-2", "I27", "I28", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P10,S-2", "I27", "I28", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I33", "I18"},
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I34", "I18"},
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I35"},
    {"I20", "I21", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I19", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "I36"},
    {"error", "error", "error", "error", "error", "error", "error", "I27", "I28", "error", "error", "error", "I37", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},
    {"error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error", "P6,V-3", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P12,E-3", "P12,E-3", "P12,E-3", "I29", "I30", "error", "P12,E-3", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P13,E-3", "P13,E-3", "P13,E-3", "I29", "I30", "error", "P13,E-3", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P15,T-3", "P15,T-3", "P15,T-3", "P15,T-3", "P15,T-3", "error", "P15,T-3", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P16,T-3", "P16,T-3", "P16,T-3", "P16,T-3", "P16,T-3", "error", "P16,T-3", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},//
    {"error", "error", "error", "error", "error", "error", "P18,F-3", "P18,F-3", "P18,F-3", "P18,F-3", "P18,F-3", "error", "P18,F-3", "error", "error", "error", "error", "error", "error", "error", "error", "error", "error"},};//
    private Stack<String> pila;

    public Sintactico() {
        pila = new Stack();
        pila.push("$");
        pila.push("I0");
        // resultado = "$IO\n";
        error = "";
    }

    public void Analisis(String token, int linea) {
        for (is = 0; is < simbolos.length; is++) {
            if (simbolos[is].equals(token)) {
                this.Accion(token, linea);
            }
        }
    }

    private void Accion(String token, int linea) {
        String arriba, entrada, entabla = "", termi;
        int accion, x, y;
        boolean ban = true;
        // arriba = pila.peek();
        entrada = token;

        while (ban) {
            arriba = pila.peek();
            out:

            for (int i = 0; i < estados.length; i++) {
                if (estados[i].equals(arriba)) {
                    for (int j = 0; j < simbolos.length; j++) {
                        if (simbolos[j].equals(entrada)) {
                            entabla = tabla[i][j];
                            break out;
                        }
                    }
                }
            }
            if (entabla.startsWith("P")) {
                if (entabla.equals("P0") && entrada.endsWith("$")) {
                    resultado += "Se acepta la cadena";
                    return;
                } else {
                    accion = Integer.parseInt(entabla.substring(entabla.indexOf("-") + 1, entabla.length())) * 2;
                    termi = entabla.substring(entabla.indexOf(",") + 1, entabla.indexOf("-"));
                    for (int z = 0; z < accion; z++) {
                        pila.pop();
                    }
                    arriba = pila.peek();
                    pila.push(termi);
                    out:
                    for (x = 0; x < estados.length; x++) {
                        if (estados[x].equals(arriba)) {
                            for (y = 0; y < simbolos.length; y++) {
                                if (simbolos[y].equals(termi)) {
                                    entabla = tabla[x][y];
                                    pila.push(entabla);
                                    ante = entrada;
                                    break out;
                                }
                            }

                        }
                    }
                }
            } else if (entabla.startsWith("I")) {
                pila.push(entrada);
                pila.push(entabla);
                ante = entrada;
                return;
            } else {
                switch (ante) {
                    case "ID" -> {
                        resultado = "Error sintactico en " + linea + " se esperaba , o ;";
                        return;
                    }
                    case "ent", "flot", "car" -> {
                        resultado = "Error sintactico en " + linea + " se esperaba un ID";
                        return;
                    }
                    case "Numero" -> {
                        resultado = "Error sintactico en " + linea + " se esperaba un operador";
                        return;
                    }
                    case ",", ";" -> {
                        resultado = "Error sintactico en " + linea + " se esperaba un Tipo o ID";
                        return;
                    }
                    case "+", "-", "*", "/", "=" -> {
                        resultado = "Error sintactico en " + linea + " se esperaba un numero o ID";
                        return;
                    }
                    default -> {
                        resultado = "Error sintactico en " + linea + " se esperaba ";
                        return;

                    }
                }
                            }

        }
    }

    public String Resultado() {
        return resultado;
    }

}
