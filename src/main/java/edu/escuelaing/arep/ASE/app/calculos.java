/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.ASE.app;

import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author sergio.nunez
 */
public final class calculos {
    private String[] lista;
    private int[] enteros ;
    
    public calculos(String[] lista) {
        this.lista = lista;
        //mergeSort(aInteros(),aInteros().length);
        //System.out.println(enteros.toString());
        
    }
    
    public String[] aString(){
        for(int i=0; i<lista.length;i++){
            lista[i] = String.valueOf(lista[i]);
        }
        return lista;
    }
    
    public int[] aInteros(){
        for(int i=0; i<lista.length;i++){
            enteros[i] = Integer.parseInt(lista[i]);
        }
        return enteros;
    }
    
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
            int i = 0, j = 0, k = 0;
            while (i < left && j < right) {
                if (l[i] <= r[j]) {
                    a[k++] = l[i++];
                }
                else {
                    a[k++] = r[j++];
                }
            }
            while (i < left) {
                a[k++] = l[i++];
            }
            while (j < right) {
                a[k++] = r[j++];
            }
    }

    public int[] getEnteros() {
        return enteros;
    }

    public String[] getLista() {
        return lista;
    }
    
}
