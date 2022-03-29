package com.techstart.softwrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Softwrap {

    public static void main(String[] args) {
        System.out.println("Softwrap");

        List<String> line1 = Arrays.asList("This"," ","is"," ","new"," ","line.","This"," ","is"," ","new"," ");
        List<String> line2 = Arrays.asList("line.","This"," ","is"," ");
        List<String> line3 = Arrays.asList("new"," ","line.","This"," ","is"," ","new"," ");

        List<List<String>> input = new ArrayList<>();
        input.add(line1);
        input.add(line2);
        input.add(line3);
        List<List<String>> output = softWrap(input,10);
        for(List<String> line : output){
            System.out.println(line.toString());
        }
    }

    class Response{
        List<String> words;
        boolean isSoftwrap;
        int softWrapIndex;
    }

    public static List<List<String>>  softWrap(List<List<String>> words, int maxChar){

        List<List<String>> outputList = new ArrayList<>();
//        List<Response> outputList = new ArrayList<>();


        for(List<String> eachLine : words){
            int lineCharCount = 0;
            List<String> outputLine = new ArrayList<>();
            for(String word : eachLine){
                // Count char of each word and check whether reached maxchar
                lineCharCount+=word.length();
                if(lineCharCount>maxChar){
                    outputList.add(outputLine);
                    outputLine = new ArrayList<>();
                    lineCharCount =0;
                    outputLine.add(word);
                }
                outputLine.add(word);
            }
            outputList.add(outputLine);
        }

        return  outputList;

    }
}
