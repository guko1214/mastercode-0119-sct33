package com.vtxlab.mastercode;

import java.math.BigDecimal;

public class Question1 {

    public double computeTax(int[][] brackets, int income) {
       BigDecimal tax = BigDecimal.valueOf(0.0d);
       //double tax = 0.0d;
        double taxedInc = 0.0d;
        double preTaxIc = 0.0d;
        for (int i = 0; i < brackets.length; i++) {
            if (income < preTaxIc)
                break;
            if (income < brackets[i][0]) {
                taxedInc = income;
            } else {
                taxedInc = brackets[i][0];
            }
            taxedInc = taxedInc - preTaxIc;
            //tax += taxedInc * (brackets[i][1] / 100);
            tax = tax.add(BigDecimal.valueOf(taxedInc).multiply(BigDecimal.valueOf(brackets[i][1])).divide(BigDecimal.valueOf(100.0)));
            preTaxIc = brackets[i][0];
        }
        //return tax;//
        return tax.doubleValue();
    }

}
