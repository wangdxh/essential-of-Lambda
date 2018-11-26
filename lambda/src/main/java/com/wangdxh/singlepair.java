package com.wangdxh;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class singlepair
{
    public static String convertString(String input)
    {
        List<Integer> leftlist = new ArrayList<>();
        List<Pair<Integer, Integer>> pairlist = new ArrayList<>();

        for(int i = 0; i < input.length(); i++)
        {
            char item = input.charAt(i);
            if (item == '('){
                leftlist.add(i);
            }
            else if (item == ')'){
                pairlist.add(new Pair<>(leftlist.get(leftlist.size()-1), i));
                leftlist.remove(leftlist.size()-1);
            }
        }


        pairlist.sort((Pair<Integer, Integer>p1, Pair<Integer, Integer> p2)-> p1.getKey().compareTo(p2.getKey()));

/*                new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer>p1, Pair<Integer, Integer> p2){
                if (p1.getKey() > p2.getKey())
                {
                    return 1;
                }
                if (p1.getKey() == p2.getKey())
                {
                    return 0;
                }
                return -1;
            }
        });*/

        List<Integer> omitindexlist = new ArrayList<>();

        for (Pair<Integer, Integer> item : pairlist){
            Integer left = item.getKey();
            Integer right = item.getValue();
            for (Pair<Integer, Integer> iteminner : pairlist){
                    Integer leftloop = iteminner.getKey();
                    Integer rightloop = iteminner.getValue();
                    if ((leftloop > left) && (Math.abs(left - leftloop) == 1) && (Math.abs(right - rightloop) == 1)){
                        omitindexlist.add(left);
                        omitindexlist.add(right);
                    }
                }
            // x(z)y delete to  xzy  () delete
            if ((right - left) == 2 || (right - left) == 1){
                omitindexlist.add(left);
                omitindexlist.add(right);
            }
        }

        StringBuilder strret = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if (omitindexlist.contains(i) == false){
                strret.append(input.charAt(i));
            }
        }
        return strret.toString();
    }
}
