import org.example.IntegerListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IntegerListImplTest {
    IntegerListImpl IntegerList;
    Integer[] array;
    int size;

    @BeforeEach
    public void setUp() {
        IntegerList = new IntegerListImpl(10);
        array = new Integer[]{10, 20, 30, 40, 50, 60, 70, 80};
    IntegerList.setArray(array);
        IntegerList.setSize(7);
    }

    @Test
    public void getSize() {
        size=7;
        int sizeExpected = IntegerList.size();
        Assertions.assertEquals(size, sizeExpected);
    }

    @Test
    public void set() {
        IntegerList.set(1, 40);
        Integer[] expected = {10, 40, 30, 40, 50, 60, 70, 80};
        assertThat(IntegerList.getArray()).isEqualTo(expected);
    }

    @Test
    public void addNotIndex() {
        IntegerList.add(10);
        Integer[] expected = {10, 20, 30, 40, 50, 60, 70, 10};
        assertThat(IntegerList.getArray()).isEqualTo(expected);
    }

    @Test
    public void addWithIndex() {
        IntegerList.add(1, 10);
        Integer[] expected = {10, 10, 20, 30, 40, 50, 60, 70};
        assertThat(IntegerList.getArray()).isEqualTo(expected);
    }
    @Test
    public void removeNotIndex(){
        IntegerList.remove(20);
        Integer[] expected = {10, 30, 40, 50, 60, 70, 80, 80};
        assertThat(IntegerList.getArray()).isEqualTo(expected);
    }
    @Test
    public void removeWithIndex(){
        IntegerList.remove(1);
        Integer[] expected = {10, 30, 40, 50, 60, 70, 80, 80};
        assertThat(IntegerList.getArray()).isEqualTo(expected);
    }
    @Test
    public void containsElement(){
        boolean a =  IntegerList.contains(80);
        Assertions.assertTrue(a);
    }
    @Test
    public void indexOf(){
       int index= IntegerList.indexOf(10);
        assertThat(index).isEqualTo(0);
    }
    @Test
    public void lastIndexOf(){
        int index= IntegerList.indexOf(30);
        assertThat(index).isEqualTo(2);
    }
    @Test
    public void isEmpty(){
        boolean b= IntegerList.isEmpty();
        Assertions.assertFalse(b);
    }

}
