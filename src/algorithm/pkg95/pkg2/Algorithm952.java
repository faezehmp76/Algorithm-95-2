// added this comment just for test

//New comment
//Newer comment as guest
//Next comment
//added this comment for another test!

//my new comment with MyNewBranch

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.pkg95.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 */
public class Algorithm952 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // **********************************
        System.out.println("************      Menu      ************** \n Plz Enter One of the Menu Numbers");
        System.out.println("1. Exit \n2. Generate File\n3. Merge Sort \n4. Triple Merge Sort \n5. Simple Sort\n6. etc");
        while(true)
        {
            int n = input.nextInt();
            switch (n)
            {
                case 1:
                    Exit(); // don't forget to use comment in your code.
                    break;
                case 2:
                    System.out.println("Generating random integers and writing to File.txt ...");
                    generateFile();
                    break;
                case 3:
                    System.out.println("Using Merge Sort Method For Sorting.");
                    //voroodi mikhad!! az generateFile bayad estefade konam??
                    //mergeSort();
                    break;
                case 4:
                    System.out.println("Using TripleMergeSort for sorting.");
                    int[] array = getArray();
                    TripleMergeSort(array);
                    arrayToFile(array);
                    System.out.println("Sorting done and the sorted file is \"TripleMergeSort.txt\" in the project directory!");
                    break;
                case 5:
                    System.out.println("Using Simple Sort Method For Sorting");
                    SimpleSort("File.txt");
                    break;
            }
        }

    }

    public static int[] getArray()
    {
        // Ali Salehi - 9250025
        // it returns an array read from a file
        int []array;
        try
        {
            InputStream fis = new FileInputStream("File.txt");
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            List<Integer> arr = new ArrayList<Integer>();
            String line;
            // read from file and split by ',' then store the integer in an array List
            while(( line = br.readLine()) != null)
            {
                String []ss = line.split(",");
                for(int i=0;i<ss.length;i++)
                {
                    arr.add(Integer.parseInt(ss[i]));
                }
            }
            // call the Convert Integer method. it converts a list to an array
            array  = convertIntegers(arr);
            //System.out.println("array.length >    " + array.length);
            return array;
        }
        catch(Exception ex)
        {
            System.out.println("Exception :   " +ex);
        }
        array = new int[0];
        return array;
    }
    public static int[] convertIntegers(List<Integer> integer)
    {
        // this Method Convert an Integer ArrayList to integer array :)
        int []result = new int[integer.size()];
        for(int i=0;i< result.length;i++)
            result[i] = integer.get(i).intValue();
        return result;
    }
    public static void Exit()
    {
        /*  Ali Salehi - 9250025
            Run time for this function >> very low
            <the student must write the exact time for their functions>
            <if your fuction takes more than 30 min to compelete, stop the program and write more than 30 min>
        */
        System.out.println("Exit called");
        System.exit(0);

        /*
            at this place other student check the function and write down their result. for example:
            Ali Salehi - 9250025{
                run time >> 0.1 sec (or very low)
                how did I optimal the code?
                    >> first
                    >>second
                    >>etc
            }
        */
    }


    public static void generateFile()
    {
        /*  Mohammad Amin Meshk - 9450025
            Mansour Ahmadzadeh - 9450001
            Run time for this function: < 1 second
        */
        try
        {
            long FirstTime = System.currentTimeMillis();
            Random rand = new Random();
            File file = new File("File.txt");
            FileWriter wr = new FileWriter(file);
            wr.append(1 + ",");
            int count = 6580000;
            for (int i = 0; i < count; i++)
            {
                wr.append(rand.nextInt(998) + 1 + ",");
            }
            wr.append(999 + "");
            wr.flush();
            wr.close();
            long FinalTime = System.currentTimeMillis();
            System.out.println("The File.txt has been successfully generated with the size of " + file.length() / 1000 +
                    " KB and " + count + " integer numbers and took " + (FinalTime - FirstTime) + " miliseconds.");

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static int[] mergeSort(int a[])
    {
        /*  Iman Shirali - 9450016
            Mohammad Hassan Helali Jula-
            Amirhossein Salahmanesh- 9450035
            Run time for this function:-------
        */
	if(a.length<=1){
            return a;
	}

	int b[];
	int c[];
	int x=a.length;

	if(x%2==0){
            b=new int[(a.length/2)];
            c=new int[(a.length/2)];

	}
        else{
            b=new int[(a.length/2)];
            c=new int[(a.length/2)+1];
	}

	for(int i=0 ;i<b.length ;i++){
            b[i]=a[i];
	}

	for(int i=b.length;i<a.length ;i++){
            c[i-b.length]=a[i];
	}

	b=mergeSort(b);
	c=mergeSort(c);
	return merge(b,c);

    }

    public static int[] merge(int b[],int c[])
    {
	/*  Iman Shirali - 9450016
            Mohammad Hassan Helali-
            Amirhossein Salahmanesh- 9450035
        */
	int res[]=new int[b.length+c.length];
	int i=0,j=0,k=0;
	while(i<b.length && j<c.length){
            if(b[i]>c[j]){
		res[k]=c[j];
		j++;
            }
            else{
		res[k]=b[i];
		i++;
            }
            k++;
            }
            if(i==b.length){
		while(j<c.length){
		res[k]=c[j];
		j++;
		k++;
                }
            }
            else if(j==c.length){
                while(i<b.length){
                    res[k]=b[i];
                    i++;
                    k++;
		}
            }
	return res;
    }

    public static void TripleMergeSort(int[] array){
        /*
            AmirMohammad Karamzadeh - 9450021
            Dariush Makvandi - 9450028
            Running time : 4 seconds
        */
        int temp;

        if(array.length>=3){
            int fmid =(int) ((array.length)/3);
            int smid = (int) (2*(array.length))/3;
            int high = array.length;

            //divide
            int[] first = Arrays.copyOfRange(array, 0, fmid);
            int[] second = Arrays.copyOfRange(array, fmid, smid);
            int[] third = Arrays.copyOfRange(array, smid, high);
            TripleMergeSort(first);
            TripleMergeSort(second);
            TripleMergeSort(third);

            //conquer
            TripleMerge(first,second,third,array);
        }
        else {
            int[] first = Arrays.copyOfRange(array, 0, 0);
            int[] second = Arrays.copyOfRange(array, 0, 1);
            int[] third = Arrays.copyOfRange(array, 1, array.length);
            TripleMerge(first, second, third, array);
        }


    }

    public static void TripleMerge(int[] first,int[] second, int[] third, int[] array){
        /*
            AmirMohammad Karamzadeh - 9450021
            Dariush Makvandi - 9450028
            Running time : 4 seconds
        */
        int i=0,j=0,k=0;

        while(i+j+k < array.length){

            //two arrays have been used and one of them is not
            if((k==third.length&&j == second.length && i<first.length))// ||(i<first.length && first[i]<second[j] && first[i]<third[k]))
                array[i+j+k] = first[i++];
            else if((k==third.length && i==first.length && j<second.length))// ||(j<second.length && second[j]<first[i] && second[j] < third[k]))
                array[i+j+k] = second[j++];
            else if((i==first.length && j==second.length && k<third.length))// ||(j<second.length && third[k]<first[i] && third[k] < second[j]))
                array[i+j+k] = third[k++];

            //one of arrays is used and two others are not
            //first is used :
            else if(i==first.length && (j<second.length && k<third.length)){
                if(second[j] < third[k])
                    array[i+j+k] = second[j++];
                else
                    array[i+j+k] = third[k++] ;
            }

            //second is used :
            else if(j==second.length && (i<first.length && k<third.length)){
                if(first[i] < third[k])
                    array[i+j+k] = first[i++];
                else
                    array[i+j+k] = third[k++];
            }

            //third is used:
            else if(k==third.length && (i<first.length && j<second.length)){
                if(first[i] < second[j])
                    array[i+j+k] = first[i++];
                else
                    array[i+j+k] = second[j++];
            }

            //all arrays have not completly used
            else{
                if(first[i]<=second[j] && first[i]<=third[k])
                    array[i+j+k] = first[i++];
                else if(second[j]<=first[i] && second[j]<=third[k])
                    array[i+j+k] = second[j++];
                else
                    array[i+j+k] = third[k++];
            }
        }
    }
    
    public static void SimpleSort(String file){
        /*
            Ghazal Arefzadeh : 9450018
            Nikoo Moradi : 9450024
            Maryam Mousawi : 9450029
            Running time : Over 24 hours !
        */
        
        int[] array = getArray();
        
        // نگهداری زمان شروع مرتب سازی
        long t1 = System.currentTimeMillis();
        
       // شروع مرتب سازی 
     	 int temp = 0;
            for(int i=0 ; i<array.length ; i++)
            {
                for(int j=i ; j<array.length ; j++)
                {
                    if(array[i] >array[j])
                    {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
	// زمان پایان مرتب سازی
        long t2 = System.currentTimeMillis();
   	// محاسبه اختلاف زمان شروع و پایان برای به دست آورد مدت زمانی که مرتب سازی به طول می انجامد
        System.out.println("Time in milliseconds: " + (t2 - t1));
  
}

    public static void arrayToFile(int[] array){
        /*
            Amirmohammad Karamzadeh - 9450021
            Dariush Makvandi - 9450028
        */
        try
        {
            java.io.File file = new java.io.File("TripleMegeSort.txt");
            file.createNewFile();
            java.io.FileWriter wr = new java.io.FileWriter(file);
            for (int a : array)
            {
                wr.append(a + ",");
            }
            wr.flush();
            wr.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
