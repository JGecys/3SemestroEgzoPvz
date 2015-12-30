import java.util.Comparator;

public class Knyga implements Comparable<Knyga> {

    private String leidykla;
    private String autorius;
    private int puslapiai;
    private float kaina;

    public Knyga(String leidykla, String autorius, int puslapiai, float kaina) {
        this.leidykla = leidykla;
        this.autorius = autorius;
        this.puslapiai = puslapiai;
        this.kaina = kaina;
    }


    @Override
    public int compareTo(Knyga o) {
        if (equals(o)) {
            return 0;
        }
        return kaina < o.kaina ? -1 : 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Knyga) {
            Knyga o = ((Knyga) obj);
            if (!leidykla.equals(o.leidykla)) {
                return false;
            }
            if (!autorius.equals(o.autorius)) {
                return false;
            }
            if (puslapiai != o.puslapiai) {
                return false;
            }
            if (kaina != o.kaina) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final Comparator<Knyga> pagalKaina = Knyga::compareTo;

    public static final Comparator<Knyga> pagalPuslapius = new Comparator<Knyga>() {
        @Override
        public int compare(Knyga o1, Knyga o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            return o1.puslapiai < o2.puslapiai ? -1 : 1;
        }
    };

    public static final Comparator<Knyga> pagalAutoriuIrKaina = new Comparator<Knyga>() {
        @Override
        public int compare(Knyga o1, Knyga o2) {
            int pagalAutoriu = o1.autorius.compareTo(o2.autorius);
            if(pagalAutoriu == 0){
                if(o1.kaina == o2.kaina){
                    return 0;
                }
                return o1.kaina < o2.kaina ? -1 : 1;
            }
            return pagalAutoriu;
        }
    };

    @Override
    public String toString() {
        return leidykla + " " + autorius + " " + String.valueOf(puslapiai) + " " + String.valueOf(kaina);
    }

    public String getLeidykla() {
        return leidykla;
    }

    public void setLeidykla(String leidykla) {
        this.leidykla = leidykla;
    }

    public String getAutorius() {
        return autorius;
    }

    public void setAutorius(String autorius) {
        this.autorius = autorius;
    }

    public int getPuslapiai() {
        return puslapiai;
    }

    public void setPuslapiai(int puslapiai) {
        this.puslapiai = puslapiai;
    }

    public float getKaina() {
        return kaina;
    }

    public void setKaina(float kaina) {
        this.kaina = kaina;
    }

}
