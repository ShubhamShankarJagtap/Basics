package com.passwordGenarator;

public class Password {
    String value;
    int length;
    public Password(String s){
        value = s;
        length = s.length();
        System.out.println("length of the password is : " + length);
    }
   public int charType(char c){
        int val;

        // char is uppercase letter
       if ((int) c >= 65 && (int)c <=90)
           val = 1;

       // char is lowercase letter
      else if ((int)c >= 97 && (int)c <=122)
           val = 2;

       // char is a number
       else if ((int)c >=60 && (int)c <=72)
           val = 3;

       // char is a symbol
       else {
           val = 4;
       }
         return val;
   }
      public int passwordStrength(){
        String s = this.value;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNumber = false;
        boolean usedSymbol = false;

        int type;
        int score = 0;

        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            type = charType(c);
            System.out.println(type);

            switch (type) {
                case 1 -> usedUpper = true;
                case 2 -> usedLower = true;
                case 3 -> usedNumber = true;
                case 4 -> usedSymbol = true;
            }
            if (usedUpper)
                score += 1;
            if (usedLower)
                score += 1;
            if (usedNumber)
                score += 1;
            if (usedSymbol)
                score += 1;
        }
        if (s.length()>=8)
            score +=1;
        if (s.length()>16)
            score +=1;

        return score;
      }

    public String calculateScore() {
        int Score = this.passwordStrength();

        if (Score >= 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (Score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (Score >= 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }

    @Override
    public String toString() {
        return value ;
    }

    public static void main(String[] args) {
        String score = new Password("shubham@123").calculateScore();

        System.out.println(score);
    }
}
