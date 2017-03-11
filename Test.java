import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        testChaining();
        testLinearProbing();
        testDoubleHashing();
    }

    public static void testChaining() {
        Function h = new Function1();
        HTChaining hashTable = new HTChaining(h, 11);
        hashTable.insert(22,22);
        hashTable.insert(1,1);
        hashTable.insert(13,13);
        hashTable.insert(11,11);
        hashTable.insert(24,24);
        hashTable.insert(33,33);
        hashTable.insert(18,18);
        hashTable.insert(42,42);
        hashTable.insert(31,31);
        Object[] result = hashTable.getHashTable();
        List tempList;
        boolean flag = true;
        tempList = (List) result[0];
        if (!(((Integer)((HashObject)tempList.get(0)).getData() == 33) &&
                ((Integer)((HashObject)tempList.get(1)).getData() == 11) &&
                ((Integer)((HashObject)tempList.get(2)).getData() == 22) &&
                tempList.size() == 3))
            flag = false;
        tempList = (List) result[1];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 1) &&
                        tempList.size() == 1))
            flag = false;
        tempList = (List) result[2];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 24) &&
                        ((Integer)((HashObject)tempList.get(1)).getData() == 13) &&
                        tempList.size() == 2))
            flag = false;
        for (int i = 3; i <= 6 && flag; i++) {
            tempList = (List) result[i];
            if (flag &&
                    !(tempList.size() == 0))
                flag = false;
        }
        tempList = (List) result[7];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 18) &&
                        tempList.size() == 1))
            flag = false;
        tempList = (List) result[8];
        if (flag &&
                !(tempList.size() == 0))
            flag = false;
        tempList = (List) result[9];
        if (flag &&
                !(((Integer)((HashObject)tempList.get(0)).getData() == 31) &&
                        ((Integer)((HashObject)tempList.get(1)).getData() == 42) &&
                        tempList.size() == 2))
            flag = false;
        tempList = (List) result[10];
        if (flag &&
                !(tempList.size() == 0))
            flag = false;
        if (flag)
            System.out.println("Chaining test 1.1 was passed");
        else {
            System.out.println("Chaining test 1.1 was FAILED");
            System.out.println("Expected table: {[33, 11, 22],[1],[24, 13],[],[],[],[],[18],[],[31, 42],[]}");
            System.out.println("Your table: " + Arrays.toString(result));
        }

        Object existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33))
            System.out.println("Chaining find test 1.2 was passed");
        else {
            System.out.println("Chaining find test 1.2 was FAILED");
            System.out.println("Expected data: find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(33) = " + existingData);
            else
                System.out.println("Your data: find(33) = " + existingData.toString());
        }

        hashTable.delete(11);
        Object deletedData = hashTable.find(11);
        existingData = hashTable.find(33);
        if (existingData != null && existingData.equals(33) && deletedData==null)
            System.out.println("Chaining delete test 1.3 was passed");
        else {
            System.out.println("Chaining delete test 1.3 was FAILED");
            System.out.println("Expected data: find(11) = null ; find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData);
            else
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData.toString());
        }
        Function h2 = new Function3();
        HTChaining hashTable2 = new HTChaining(h2,11);
        Student beyonce = new Student(3542486,"beyonce","computer science");
        Student elvis = new Student(987654,"elvis presley","computer science");
        hashTable2.insert(beyonce.getId(), beyonce);
        hashTable2.insert(elvis.getId(), elvis);
        hashTable2.delete(elvis.getId());
        Student existingData2 = (Student)hashTable2.find(beyonce.getId());
        if (existingData2 != null && existingData2.getName().equals(beyonce.getName()))
            System.out.println("Chaining find test 1.4 was passed");
        else {
            System.out.println("Chaining find test 1.4 was FAILED");
            System.out.println("Expected data: find(" + beyonce.getId() + ").getName() = " + beyonce.getName());
            if (existingData2==null)
                System.out.println("Your data: find(" + beyonce.getId() + ") = " + existingData2);
            else
                System.out.println("Your data: find(" + beyonce.getId() + ").getName() = " + existingData2.getName());
        }
        Student existingData3 = (Student)hashTable2.find(elvis.getId());
        if (existingData3 == null)
            System.out.println("Chaining find test 1.5 was passed");
        else {
            System.out.println("Chaining find test 1.5 was FAILED");
            System.out.println("Expected data: find(" + elvis.getId() + ") = null");
            System.out.println("Your data: find(" + beyonce.getId() + ").toString() = \"" + existingData2.toString() + "\"");
        }
    }
    public static void testLinearProbing() {
        Function h = new Function1();
        HTLinearProbing hashTable = new HTLinearProbing(h,11);
        hashTable.insert(22,22);
        hashTable.insert(1,1);
        hashTable.insert(13,13);
        hashTable.insert(11,11);
        hashTable.insert(24,24);
        hashTable.insert(33,33);
        hashTable.insert(18,18);
        hashTable.insert(42,42);
        hashTable.insert(31,31);
        Object[] result = hashTable.getHashTable();
        Integer[] rightAnswer = {22,1,13,11,24,33,null,18,null,42,31};

        boolean flag = true;
        for (int i = 0; i < 11 && flag; i++) {
            if((result[i]!=null && rightAnswer[i]==null) || (result[i]==null && rightAnswer[i]!=null)
                    || !(((result[i]==null && rightAnswer[i]==null) ||
                    (result[i].equals(rightAnswer[i])))))
                flag = false;
        }
        if (flag)
            System.out.println("LinearProbing test 2.1 was passed");
        else {
            System.out.println("LinearProbing test 2.1 was FAILED");
            System.out.println("Expected table: " + Arrays.toString(rightAnswer));
            System.out.println("Your table: " + Arrays.toString(result));
        }
        Object existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33))
            System.out.println("LinearProbing find test 2.2 was passed");
        else {
            System.out.println("LinearProbing find test 2.2 was FAILED");
            System.out.println("Expected data: find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(33) = " + existingData);
            else
                System.out.println("Your data: find(33) = " + existingData.toString());
        }

        hashTable.delete(11);
        Object deletedData = (Object)hashTable.find(11);
        existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33) && deletedData==null)
            System.out.println("LinearProbing delete test 2.3 was passed");
        else {
            System.out.println("LinearProbing delete test 2.3 was FAILED");
            System.out.println("Expected data: find(11) = null ; find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData);
            else
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData.toString());
        }
        Function h2 = new Function3();
        HTLinearProbing hashTable2 = new HTLinearProbing(h2,11);
        Student beyonce = new Student(3542486,"beyonce","computer science");
        Student elvis = new Student(987654,"elvis presley","computer science");
        hashTable2.insert(beyonce.getId(), beyonce);
        hashTable2.insert(elvis.getId(), elvis);
        hashTable2.delete(elvis.getId());
        Student existingData2 = (Student)hashTable2.find(beyonce.getId());
        if (existingData2 != null && existingData2.getName().equals(beyonce.getName()))
            System.out.println("LinearProbing find test 2.4 was passed");
        else {
            System.out.println("LinearProbing find test 2.4 was FAILED");
            System.out.println("Expected data: find(" + beyonce.getId() + ").getName() = " + beyonce.getName());
            if (existingData2==null)
                System.out.println("Your data: find(" + beyonce.getId() + ") = " + existingData2);
            else
                System.out.println("Your data: find(" + beyonce.getId() + ").getName() = " + existingData2.getName());
        }
        Student existingData3 = (Student)hashTable2.find(elvis.getId());
        if (existingData3 == null)
            System.out.println("LinearProbing find test 2.5 was passed");
        else {
            System.out.println("LinearProbing find test 2.5 was FAILED");
            System.out.println("Expected data: find(" + elvis.getId() + ") = null");
            System.out.println("Your data: find(" + beyonce.getId() + ").toString() = \"" + existingData2.toString() + "\"");
        }
    }
    public static void testDoubleHashing() {
        Function h = new Function1();
        Function stepFunction = new Function2();
        HTDoubleHashing hashTable = new HTDoubleHashing(h,stepFunction,11);
        hashTable.insert(22,22);
        hashTable.insert(1,1);
        hashTable.insert(13,13);
        hashTable.insert(11,11);
        hashTable.insert(24,24);
        hashTable.insert(33,33);
        hashTable.insert(18,18);
        hashTable.insert(42,42);
        hashTable.insert(31,31);
        Object[] result = hashTable.getHashTable();
        Integer[] rightAnswer = {22,1,13,null,11,18,31,24,33,42,null};

        boolean flag = true;
        for (int i = 0; i < 11 && flag; i++) {
            if((result[i]!=null && rightAnswer[i]==null) || (result[i]==null && rightAnswer[i]!=null)
                    || !(((result[i]==null && rightAnswer[i]==null) ||
                    (result[i].equals(rightAnswer[i])))))
                flag = false;
        }
        if (flag)
            System.out.println("DoubleHashing insert test 3.1 was passed");
        else {
            System.out.println("DoubleHashing insert test 3.1 was FAILED");
            System.out.println("Expected table: " + Arrays.toString(rightAnswer));
            System.out.println("Your table: " + Arrays.toString(result));
        }
        Object existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33))
            System.out.println("DoubleHashing find test 3.2 was passed");
        else {
            System.out.println("DoubleHashing find test 3.2 was FAILED");
            System.out.println("Expected data: find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(33) = " + existingData);
            else
                System.out.println("Your data: find(33) = " + existingData.toString());
        }

        hashTable.delete(11);
        Object deletedData = (Object)hashTable.find(11);
        existingData = (Object)hashTable.find(33);
        if (existingData != null && existingData.equals(33) && deletedData==null)
            System.out.println("DoubleHashing delete test 3.3 was passed");
        else {
            System.out.println("DoubleHashing delete test 3.3 was FAILED");
            System.out.println("Expected data: find(11) = null ; find(33) = 33");
            if (existingData==null)
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData);
            else
                System.out.println("Your data: find(11) = " + deletedData + " ; find(33) = " + existingData.toString());
        }
        Function h2 = new Function3();
        Function h3 = new Function4();
        HTDoubleHashing hashTable2 = new HTDoubleHashing(h2,h3,11);
        Student beyonce = new Student(3542486,"beyonce","computer science");
        Student elvis = new Student(987654,"elvis presley","computer science");
        hashTable2.insert(beyonce.getId(), beyonce);
        hashTable2.insert(elvis.getId(), elvis);
        hashTable2.delete(elvis.getId());
        Student existingData2 = (Student)hashTable2.find(beyonce.getId());
        if (existingData2 != null && existingData2.getName().equals(beyonce.getName()))
            System.out.println("DoubleHashing find test 3.4 was passed");
        else {
            System.out.println("DoubleHashing find test 3.4 was FAILED");
            System.out.println("Expected data: find(" + beyonce.getId() + ").getName() = " + beyonce.getName());
            if (existingData2==null)
                System.out.println("Your data: find(" + beyonce.getId() + ") = " + existingData2);
            else
                System.out.println("Your data: find(" + beyonce.getId() + ").getName() = " + existingData2.getName());
        }
        Student existingData3 = (Student)hashTable2.find(elvis.getId());
        if (existingData3 == null)
            System.out.println("DoubleHashing find test 3.5 was passed");
        else {
            System.out.println("DoubleHashing find test 3.5 was FAILED");
            System.out.println("Expected data: find(" + elvis.getId() + ") = null");
            System.out.println("Your data: find(" + beyonce.getId() + ").toString() = \"" + existingData2.toString() + "\"");
        }
    }
}
