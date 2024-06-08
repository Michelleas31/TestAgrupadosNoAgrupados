/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testagrupadosnoagrupados;

/**
 *
 * @author Michelle
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class ProcesosAgrupadosNoAgrupados {
    // Cálculos para datos no agrupados
    public static double meanUngrouped(double[] data) {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public static double modeUngrouped(double[] data) {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        double mode = data[0];
        int maxCount = 0;
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public static double medianUngrouped(double[] data) {
        Arrays.sort(data);
        int n = data.length;
        if (n % 2 == 0) {
            return (data[n / 2 - 1] + data[n / 2]) / 2.0;
        } else {
            return data[n / 2];
        }
    }

    // Cálculos para datos agrupados
    public static double meanGrouped(double[][] data) {
        double sum = 0;
        double totalFrequency = 0;
        for (double[] row : data) {
            sum += row[0] * row[1];
            totalFrequency += row[1];
        }
        return sum / totalFrequency;
    }

    public static double modeGrouped(double[][] data) {
        double maxFrequency = 0;
        double mode = 0;
        int modeIndex = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i][1] > maxFrequency) {
                maxFrequency = data[i][1];
                modeIndex = i;
            }
        }

        if (modeIndex == 0 || modeIndex == data.length - 1) {
            return data[modeIndex][0]; // Si la clase modal es la primera o última
        }

        double L = data[modeIndex][0] - (data[1][0] - data[0][0]) / 2;
        double f1 = data[modeIndex][1];
        double f0 = data[modeIndex - 1][1];
        double f2 = data[modeIndex + 1][1];
        double h = data[1][0] - data[0][0]; // Asumiendo intervalos iguales

        mode = L + ((f1 - f0) / (2 * f1 - f0 - f2)) * h;
        return mode;
    }

    public static double medianGrouped(double[][] data) {
        double totalFrequency = 0;
        for (double[] row : data) {
            totalFrequency += row[1];
        }
        double medianPos = totalFrequency / 2;
        double cumulativeFrequency = 0;
        double previousCumulativeFrequency = 0;
        double medianClassMidpoint = 0;
        double classWidth = data[1][0] - data[0][0]; // Suponiendo intervalos iguales

        for (double[] row : data) {
            previousCumulativeFrequency = cumulativeFrequency;
            cumulativeFrequency += row[1];
            if (cumulativeFrequency >= medianPos) {
                medianClassMidpoint = row[0];
                break;
            }
        }
        double L = medianClassMidpoint - classWidth / 2;
        double f = cumulativeFrequency - previousCumulativeFrequency;
        double F = previousCumulativeFrequency;

        return L + ((medianPos - F) / f) * classWidth;
    }
}
