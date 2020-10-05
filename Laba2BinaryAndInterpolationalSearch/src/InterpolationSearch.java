import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {
    public static void interpolationSearch(int[] array,int first,int last,int item) {

        int position;
        int comparisonCount = 0;    // для подсчета количества сравнений

        double w0=first;
        double w1=(last-first);
        double w2=((array[last]-array[first]));
        double w3=(item - array[first]);

        // для начала найдем индекс среднего элемента массива
        position = (int)(w0 + ((w1)/(w2)*(w3)));


        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число больше заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            w0=first;
            w1=(last-first);
            w2=((array[last]-array[first]));
            w3=(item - array[first]);
            position = (int)(w0 + ((w1)/(w2)*(w3)));



        }
        if (first <= last) {
            System.out.println(item + " является " + ++position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
    public static void main(String...args){
        int[]array= InitOfRandomArray.InitOfRandomArray(1000000,100000);
        int num, item, first, last;
        num=array.length;
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));


        // вводим элемент для бинарного поиска
        System.out.println("Введите элемент для бинарного поиска: ");
        Scanner input = new Scanner(System.in);
        item = input.nextInt();

        // определяем последний и начальный индекс
        first = 0;
        last = num - 1;

        // метод принимает начальный и последний индекс, а также число для поиска
        interpolationSearch(array, first, last, item);
    }
}