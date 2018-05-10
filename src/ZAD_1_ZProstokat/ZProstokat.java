package ZAD_1_ZProstokat;

public class ZProstokat {

    private int w, h, nr;
    private char in, out;
    private static int p=1, k=1;

    ZProstokat(int w, char in, char out){
        this(w,w,in,out);
    }

    ZProstokat(int w, int h, char in, char out){
        this.w=w;
        this.h=h;
        this.in=in;
        this.out=out;

        if(w!=h) {
            nr = p;
            p++;
        }
        else {
            nr=k;
            k++;
        }
    }

    public void rysuj() throws ZProstokatException{
        if((w<1||h<1)||(w==1||h==1)&&(in!=out)) {
            throw new ZProstokatException();
        }
        else {
            int wew =(h-2)*(w-2), brzeg=(w*h)-wew;

            if (w == h) System.out.print("Kwadrat");
            else System.out.print("Prostokat");

            if(w==1||h==1)
                System.out.println(" ("+nr+") "+"rozmiaru "+h+" x "+w+", "+out+"="+brzeg);
            else
                System.out.println(" ("+nr+") "+"rozmiaru "+h+" x "+w+", "+in+"="+wew+", "+out+"="+brzeg);

            for (int i=0; i<h; i++){
                for(int j=0; j<w; j++){

                    if(i==0||j==0||i==h-1||j==w-1) {
                        System.out.print(out);
                    }
                    else {
                        System.out.print(in);
                    }
                }
                System.out.println();
            }


        }
    }


}
