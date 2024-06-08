/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testagrupadosnoagrupados;

/**
 *
 * @author Michelle
 */
public class TestProbabilidadMarginalConjuntaCondicional {
    public static void main(String[] args) {
        double A1general = A1valorTotal();
        double A2general = A2valorTotal();
        double B1general = B1valorTotal();
        double B2general = B2valorTotal();
        double ABgeneral = ABvalorTotal();

        ProbabilidadMarginal();
        ValorA1ABgeneral(A1general, ABgeneral);
        ValorB1ABgeneral(B1general, ABgeneral);
        ValorA2ABgeneral(A2general, ABgeneral);
        ValorB2ABgeneral(B2general, ABgeneral);
        ProbabilidadConjunta();
        Valor1ABconjunta(ABgeneral);
        Valor2ABconjunta(ABgeneral);
        ProbabilidadCondicional();
        Valor1ABcondicional(A1general);
        Valor2ABcondicional(B1general);
        Valor3ABcondicional(A1general);
        Valor4ABcondicional(B1general);
        Valor5ABcondicional(A2general);
        Valor6ABcondicional(B2general);
    }

    public static void ProbabilidadMarginal (){
        System.out.println("============================== PROBABILIDAD MARGINAL ==============================");
    }

    public static double ABvalorTotal(){
        double ABgeneral = DataSet.abData[0][0] + DataSet.abData[0][1] + DataSet.abData[1][0] + DataSet.abData[1][1];
        return ABgeneral;
    }

    public static double A1valorTotal(){
        double A1general = DataSet.abData[0][0] + DataSet.abData[1][0];
        return A1general;
    }

    public static double A2valorTotal(){
        double A2general = DataSet.abData[0][0] + DataSet.abData[0][1];
        return A2general;
    }

    public static double B1valorTotal(){
        double B1general = DataSet.abData[0][1] + DataSet.abData[1][1];
        return B1general;
    }

    public static double B2valorTotal(){
        double B2general = DataSet.abData[1][0] + DataSet.abData[1][1];
        return B2general;
    }

    public static double ValorA1ABgeneral(double A1general, double ABgeneral){
        double A1ABgeneral = (A1general / ABgeneral) * 100;
        System.out.println("La probabilidad de que esté nublado es " + A1general + "/" + ABgeneral + "\n **En porcentaje sería el " + A1ABgeneral + "%\n");
        return A1ABgeneral;
    }

    public static double ValorA2ABgeneral(double A2general, double ABgeneral){
        double A2ABgeneral = (A2general / ABgeneral) * 100;
        System.out.println("La probabilidad de que llueva es " + A2general + "/" + ABgeneral + "\n **En porcentaje sería el " + A2ABgeneral + "%\n");
        return A2ABgeneral;
    }

    public static double ValorB1ABgeneral(double B1general, double ABgeneral){
        double B1ABgeneral = (B1general / ABgeneral) * 100;
        System.out.println("La probabilidad de que no esté nublado es " + B1general + "/" + ABgeneral + "\n **En porcentaje sería el " + B1ABgeneral + "%\n");
        return B1ABgeneral;
    }

    public static double ValorB2ABgeneral(double B2general, double ABgeneral){
        double B2ABgeneral = (B2general / ABgeneral) * 100;
        System.out.println("La probabilidad de que no llueva es " + B2general + "/" + ABgeneral + "\n **En porcentaje sería el " + B2ABgeneral + "%\n");
        return B2ABgeneral;
    }

    public static void ProbabilidadConjunta (){
        System.out.println("============================== PROBABILIDAD CONJUNTA ==============================");
    }

    public static double Valor1ABconjunta(double ABgeneral){
        double ABconjunta = (DataSet.abData[0][0] / ABgeneral)*100;
        System.out.println("La probabilidad de que este nublado y llueva " + DataSet.abData[0][0] + "/" + ABgeneral + "\n **En porcentaje sería el " + ABconjunta + "%\n");
        return ABconjunta;
    }

    public static double Valor2ABconjunta(double ABgeneral){
        double AB2conjunta = (DataSet.abData[1][1] / ABgeneral)*100;
        System.out.println("La probabilidad de que no este nublado y no llueva " + DataSet.abData[1][1] + "/" + ABgeneral + "\n **En porcentaje sería el " + AB2conjunta + "%\n");
        return AB2conjunta;
    }

    public static void ProbabilidadCondicional (){
        System.out.println("============================== PROBABILIDAD CONDICIONAL ==============================");
    }

    public static double Valor1ABcondicional(double A1general){
        double AB1condicional = (DataSet.abData[0][0] / A1general)*100;
        System.out.println("La probabilidad de que llueva dado que este nublado " + DataSet.abData[0][0] + "/" + A1general + "\n **En porcentaje sería el " + AB1condicional + "%\n");
        return AB1condicional;
    }

    public static double Valor2ABcondicional(double B1general){
        double AB1condicional = (DataSet.abData[0][1] / B1general)*100;
        System.out.println("La probabilidad de que llueva dado que no este nublado " + DataSet.abData[0][1] + "/" + B1general + "\n **En porcentaje sería el " + AB1condicional + "%\n");
        return AB1condicional;
    }

    public static double Valor3ABcondicional(double A1general){
        double AB1condicional = (DataSet.abData[1][0] / A1general)*100;
        System.out.println("La probabilidad de que no llueva dado que este nublado " + DataSet.abData[1][0] + "/" + A1general + "\n **En porcentaje sería el " + AB1condicional + "%\n");
        return AB1condicional;
    }

    public static double Valor4ABcondicional(double B1general){
        double AB1condicional = (DataSet.abData[1][1] / B1general)*100;
        System.out.println("La probabilidad de que no llueva dado que no este nublado " + DataSet.abData[1][1] + "/" + B1general + "\n **En porcentaje sería el " + AB1condicional + "%\n");
        return AB1condicional;
    }

    public static double Valor5ABcondicional(double A2general){
        double AB2condicional = (DataSet.abData[0][0] / A2general)*100;
        System.out.println("La probabilidad de que este nublado dado que llueva " + DataSet.abData[0][0] + "/" + A2general + "\n **En porcentaje sería el " + AB2condicional + "%\n");
        return AB2condicional;
    }

    public static double Valor6ABcondicional(double B2general){
        double AB1condicional = (DataSet.abData[1][0] / B2general)*100;
        System.out.println("La probabilidad de que este nublado dado que no llueva " + DataSet.abData[1][0] + "/" + B2general + "\n **En porcentaje sería el " + AB1condicional + "%\n");
        return AB1condicional;
    }
}
