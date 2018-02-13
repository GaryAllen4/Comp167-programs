/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectitem;

/**
 *
 * @author G-Smoove
 */
public class ObjectItem {

    int x, y;

    public ObjectItem() {
        x = 0;
        y = 0;
    }

    public void set(int a, int b) {
        x = a;
        y = b;
    }

    int add() {
        return (x + y);
    }

    void print() {
        System.out.print(x + " " + y + " ");
    }

    public static void main(String[] arg) {
        ObjectItem[] a = new ObjectItem[5];

        for (int x = 0; x < 5; x++) {

            a[x].set(x, x + 1);

            if (x % 2 == 0) {
                System.out.println(a[x].add());
            }

        }
    }
}
