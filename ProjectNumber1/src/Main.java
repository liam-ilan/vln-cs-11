public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            // get letter
            String letter = s.substring(i, i+1);
            // compare to vowels
            if (
                    letter.equals("a") ||
                    letter.equals("e") ||
                    letter.equals("i") ||
                    letter.equals("o") ||
                    letter.equals("u")
            ) {
                // add to answer
                answer++;
            }
        }

        return answer;
    }

    //Code you problem number two here
    static int problemTwo(String s){
        int answer = 0;
        // not looping over last two chars so that bob does not overflow
        for (int i = 0; i < s.length() - 2; i++) {

            // get string that needs to be equal to bob
            String bob = s.substring(i, i+3);

            if (bob.equals("bob")) {
                answer++;
            }
        }

        return answer;
    }

    //Code your solution to problem number 3 here
    static String problemThree(String s){

        // init (first letter)
        String currentGroup = s.substring(0, 1);
        String res = currentGroup;

        // from the 2nd letter
        for (int i = 1; i < s.length(); i++) {
            char letter = s.charAt(i);

            // last letter in currentGroup
            char last = currentGroup.charAt(currentGroup.length() - 1);

            // is in sequence
            if (((int) letter) >= ((int) last)) {
                currentGroup += letter;
            } else {
                // reset current group
                currentGroup = "";
                currentGroup  += letter;
            }

            // update res
            if (currentGroup.length() > res.length()) {
                res = currentGroup;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s;
    }
}
