package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
            if(balance < 5000)
            {
                throw new Exception("Insufficient Balance");
            }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        HashMap<Character,Integer> hm =new HashMap<>();
        int maxCount = 0;
        boolean flag = false;
        for(int i = 0 ;i<tradeLicenseId.length();i++)
        {
            if(i != 0)
            {
                if(tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i-1))
                {
                    flag=true;
                }
            }
            hm.put(tradeLicenseId.charAt(i),hm.getOrDefault(tradeLicenseId.charAt(i),0)+1);
            maxCount=Math.max(maxCount,hm.get(tradeLicenseId.charAt(i)));
        }
        if(tradeLicenseId.length() % 2 == 0)
        {
            if(maxCount > ((tradeLicenseId.length() + 1)/2)+1)
            {
                throw new Exception("Valid License can not be generated");
            }
            else
            {
                if(flag==true)
                {
                    int size=tradeLicenseId.length();
                    char arr[] = new char[size];
                    int index = 0; //array 0,2,4,6,8,10,12,14 16
                    int index2 = 1;
                    for(var entry:hm.entrySet()) {
                        int freq = entry.getValue();
                        int i=0;
                        for(;i<freq && index<size;i++) {
                            arr[index] = entry.getKey();
                            index+=2;
                        }
                        //d - 4
                        if(index >= size)
                        {
                            for(;i<freq && index2<size;i++) {
                                arr[index2] = entry.getKey();
                                index2+=2;
                            }
                        }
                    }
                    String updatedId = "";
                    for(int i =0;i<size;i++)
                    {
                        updatedId+=arr[i];
                    }
                    this.tradeLicenseId = updatedId;
                }
            }
        }
        else
        {
            if(maxCount > (tradeLicenseId.length()/2)+2)
            {
                throw new Exception("Valid License can not be generated");
            }
            else
            {
                if(flag==true)
                {
                    int size=tradeLicenseId.length();
                    char arr[] = new char[size];
                    int index = 0; //array 0,2,4,6,8,10,12,14 16
                    int index2 = 1;
                    for(var entry:hm.entrySet()) {
                        int freq = entry.getValue();
                        int i=0;
                        for(;i<freq && index<size;i++) {
                            arr[index] = entry.getKey();
                            index+=2;
                        }
                        //d - 4
                        if(index >= size)
                        {
                            for(;i<freq && index2<size;i++) {
                                arr[index2] = entry.getKey();
                                index2+=2;
                            }
                        }
                    }
                    String updatedId = "";
                    for(int i =0;i<size;i++)
                    {
                        updatedId+=arr[i];
                    }
                    this.tradeLicenseId = updatedId;
                }
            }
        }
    }
}
