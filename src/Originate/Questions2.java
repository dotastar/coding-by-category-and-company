package originate;

public class Questions2 {
    public static String removeNonLetter(String src) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char temp = src.charAt(i);
            if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z'))
                output.append(temp);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String test = new String("asdfas7df6sdf*7654322&&^%%$$$");
        System.out.println(Questions2.removeNonLetter(test));
    }
}
