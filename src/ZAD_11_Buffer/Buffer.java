package ZAD_11_Buffer;

public class Buffer {

    int tab[];
    static int next;
    int lenght;
    static boolean free;
    static int begin;

    Buffer(){
        tab = new int[10];
        lenght = tab.length;
        next=0;
        free=true;
        begin=0;
    }

    int get(){
//        int liczba;
//        liczba = tab[begin];
////        tab[begin]=-1;
        begin++;
        return tab[--begin];
    }

    void put(int i){
        if(next<lenght)
        tab[this.next]=i;
        next++;
    }
}
