package ru.antipn.merge.sorting.app;

import org.springframework.stereotype.Service;
@Service
public class Sorting {
    public static void mergeSortInteger(int[] a, int n, String order) {
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
        mergeSortInteger(l, mid, order);
        mergeSortInteger(r, n - mid, order);

        merge(a, l, r, mid, n - mid, order);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right, String order) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (order.equals("-a")) //сортировка по умолчанию
            {
                if (l[i] <= r[j]) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            } else if (order.equals("-d")) { //сортировка в обратном порядке
                if (l[i] >= r[j]) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergeSortString(String[] a, int n, String order) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        String[] l = new String[mid];
        String[] r = new String[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSortString(l, mid, order);
        mergeSortString(r, n - mid, order);
        mergeString(a, l, r, mid, n - mid, order);
    }

    public static void mergeString(
            String[] a, String[] l, String[] r, int left, int right, String order) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (order.equals("-a")) //сортировка по умолчанию
            {
                if ((l[i].charAt(0)) <= r[j].charAt(0)) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            } else if (order.equals("-d")) { //сортировка в обратном порядке
                if (l[i].charAt(0) >= r[j].charAt(0)) {
                    a[k++] = l[i++];
                } else {
                    a[k++] = r[j++];
                }
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
