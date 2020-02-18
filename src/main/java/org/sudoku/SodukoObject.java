package org.sudoku;

import org.arrays.ArrayExtension;
import org.exceptions.OutOfRangeException;

import java.util.Arrays;
//class exArrayOutOfRange extends Exception{};

public class SodukoObject {
    private int[] Values = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    //CONSTRUCTORS:
    public SodukoObject(int[] arr) {
        try {
            this.AddToObject(arr);
        } catch (OutOfRangeException e) {
        }

    }

    public SodukoObject(int[][] arr) {
        try {
            this.AddToObject(arr);
        } catch (OutOfRangeException e) {
        }

    }

    public SodukoObject(int num) {
        try {
            this.AddToObject(num);
        } catch (OutOfRangeException e) {
        }

    }

    void AddToObject(int num) throws OutOfRangeException {
        int index = this.FindFirstZero();
        if (!(index == 0)) {
            Values[index] = num;
        } else {
            throw new OutOfRangeException();
        }

    }

    void AddToObject(int[] arr) throws OutOfRangeException {
        if (arr.length != this.Values.length) {
            throw new OutOfRangeException();
        } else {
            this.Values = arr;
        }
    }

    void AddToObject(int[][] arr) throws OutOfRangeException {
        int vertSize = arr.length, horzSize = arr[0].length;

        if ((vertSize * horzSize) != this.Values.length) {
            throw new OutOfRangeException();
        } else {
            int i, j, counter = 0;
            for (i = 0; i < vertSize; i++) {
                for (j = 0; j < horzSize; j++) {
                    this.Values[counter++] = arr[i][j];

                }
            }
        }
    }

    boolean CheckSodukoObject() {
        int[] tempArr = Values;
        tempArr = SortSodukoObject(ArrayExtension.Clone(tempArr));
        int i = 0;
        boolean result = true;
        while (result && i < tempArr.length) {
            if (tempArr[i] != (i + 1)) {
                result = false;
            } else {
                i++;
            }
        }
        return result;
    }

    //METHODS:
    //return the first available place in the arr
    private int FindFirstZero() {
        int i = 0;
        while (i < this.Values.length && this.Values[i] == 0) {
            i++;
        }
        if (this.Values[i] == 0) {
            return i;
        } else {
            return 0;
        }
    }

    private int[] SortSodukoObject(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

}

