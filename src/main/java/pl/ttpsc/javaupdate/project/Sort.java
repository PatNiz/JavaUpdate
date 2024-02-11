package pl.ttpsc.javaupdate.project;

import java.util.Arrays;
import java.util.LinkedList;

public class Sort {
    //QuickSort: Jest to jedna z najbardziej efektywnych metod sortowania o złożoności czasowej O(n log n) w przypadku średnim. Jednakże, warto zauważyć, że w najgorszym przypadku może osiągnąć złożoność czasową O(n^2), co można unikać przez odpowiednie wybieranie pivota.
    //
    //MergeSort: Inny algorytm o złożoności czasowej O(n log n) we wszystkich przypadkach. Jednakże, w porównaniu do QuickSort, MergeSort działa stabilnie i ma zawsze gorszą złożoność pamięciową, co może być istotne dla bardzo dużych zbiorów danych.
    //
    //Timsort: Jest to hybrydowy algorytm sortowania, który łączy elementy MergeSort i InsertionSort. Timsort jest używany jako domyślny algorytm sortowania w niektórych implementacjach Javy (np. w Pythonie), i jest znany ze swojej dobrej wydajności.
    //
    //Arrays.parallelSort: Jeśli pracujesz z dużymi tablicami w języku Java, metoda Arrays.parallelSort może być dobrym wyborem, ponieważ używa sortowania QuickSort w połączeniu z MergeSort, a także potrafi wykorzystać wielowątkowość dla zwiększenia wydajności.

    //czasy
    //QuickSort: O(n log n) czasowo w przeciętnym przypadku, ale może degradować do O(n^2) w najgorszym przypadku. Sortuje w miejscu.
    //MergeSort: O(n log n) czasowo w każdym przypadku. Nie sortuje w miejscu.
    //HeapSort: O(n log n) czasowo w każdym przypadku. Sortuje w miejscu.
    //InsertionSort: O(n^2) czasowo w najgorszym przypadku. Skuteczny dla małych zbiorów danych. Sortuje w miejscu.
    public static void main(String[] args) {
        int[] table = {6,5,4,3,4,2,1};
        for (int i : table) {
            System.out.print(i);
        }
        System.out.println("");
        sortTable(table);
        for (int i : table) {
            System.out.print(i);
        }
    }
    //bubble sort który przechodzi przez wszystkie nawet jesli nie trzeba
    //Złożoność czasowa i pamięciowa:
    //Złożoność czasowa: O(n^2) - ze względu na zagnieżdżone pętle.
    //Złożoność pamięciowa: O(1) - algorytm sortuje dane "w miejscu", bez dodatkowej alokacji pamięci w stosunku do ilości elementów w tabeli.
    public static void sortTable(int [] table){
        int min;
        for(int i = 0; i<table.length;i++){
            min= table[i];
            for(int j=i+1; j< table.length; j++){
                if(table[j] <min){
                    min = table [j];
                    table[j] = table[i];
                    table[i]= min;
                }
            }
        }

    }
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int min = array[i];
        array[i] = array[j];
        array[j] = min;
    }

    private static void parallelSort(int[] array){
        Arrays.parallelSort(array);
    }
}
