package misc;

public class LocalClassExample {

    interface HelloThere {//NOTE
        public void greet();
    }

    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {//NOTE

        final int numberLength = 10;

        // int numberLength = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null; //NOTE

            public static final String farewell = "Bye bye";//NOTE

            PhoneNumber(String phoneNumber) {
                // numberLength = 7;NOTE
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength)//NOTE
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            //            public void printOriginalNumbers() {//NOTE
            //                System.out.println("Original numbers are " + phoneNumber1 + " and " + phoneNumber2);
            //            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);//NOTE
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in Java SE 8 and later:

        //        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("603-555-0123", "555-0123");
    }
}