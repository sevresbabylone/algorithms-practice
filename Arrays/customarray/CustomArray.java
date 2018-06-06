package com.example.customarray;

public class CustomArray {
    public static void main(String[] args) {
        long[] arr; // reference to array
        arr = new long[100];
        int nElems = 0; // number of items
        int j = 0; // counter for loop
        long searchKey;

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10; // insert 10 items

        for(j=0; j<nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println("");

        searchKey = 66;
        for(j=0; j< nElems; j++)
            if(arr[j] == searchKey)
                break;
            if(j==nElems)
                System.out.println( searchKey + " was not found");
            else
                System.out.println( searchKey + " found at " + Integer.toString(j));

        searchKey = 55;
        for(j=0; j< nElems; j++)
            if(arr[j] == searchKey)
                break;
        for(int k = j; k < nElems - 1; k++)
            arr[k] = arr[k + 1];
        nElems--;

        for(j=0; j<nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println("");
    }
}