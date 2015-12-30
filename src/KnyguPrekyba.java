import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class KnyguPrekyba {

    private LinkedList<Knyga> sarasas = new LinkedList<>();

    public static void main(String[] args) {
        new KnyguPrekyba().testavimas();
    }

    public void pridetiKnyga(Knyga k){
        sarasas.add(k);
    }

    public LinkedList<Knyga> rastiPlonasKnygas(int riba){
        LinkedList<Knyga> naujas = new LinkedList<>();
        for(Knyga k : sarasas){
            if(k.getPuslapiai() < riba){
                naujas.add(k);
            }
        }
        return naujas;
    }

    public void rikiuotiIrSpausdinti(){
        sarasas.sort(Knyga.pagalAutoriuIrKaina);
        for (Knyga knyga : sarasas) {
            System.out.println(knyga);
        }
    }

    public void rikiuotiPagalKaina(){
        sarasas.sort(Knyga.pagalKaina);
        for (Knyga knyga : sarasas) {
            System.out.println(knyga);
        }
    }

    public int porosMazesnesUz(float kaina){
        int pora = 0;
        for(int i = 0; i < sarasas.size() - 1; i++){
            for(int j = i + 1; j < sarasas.size(); j++){
                if(sarasas.get(i).getKaina() + sarasas.get(j).getKaina() < kaina){
                    pora++;
                }
            }
        }
        return pora;
    }

    public void skirtingiAutoriai(){
        TreeMap<String, Integer> map = new TreeMap<>();
        for (Knyga k : sarasas) {
            String autorius = k.getAutorius();
            if(map.containsKey(autorius)){
                map.put(autorius, map.get(autorius) + 1);
            }else{
                map.put(autorius, 1);
            }
        }
        System.out.println(map);
    }

    public void skirtingosLeidyklos(){
        HashMap<String, Integer> map = new HashMap<>();
        for (Knyga k : sarasas) {
            String leidy = k.getLeidykla();
            if(map.containsKey(leidy)){
                map.put(leidy, map.get(leidy) + 1);
            }else{
                map.put(leidy, 1);
            }
        }
        System.out.println(map);
    }

    public void testavimas(){
        pridetiKnyga(new Knyga("Vaga", "Vaižgantas", 49, 19.55f));
        pridetiKnyga(new Knyga("Vaga", "Remarkas", 86, 27.55f));
        pridetiKnyga(new Knyga("AlmaLitera", "Avyžius", 207, 23.55f));
        pridetiKnyga(new Knyga("Vaga", "Avyžius", 127, 9.55f));
        pridetiKnyga(new Knyga("Vaga", "Baltušis", 99, 19.55f));
        pridetiKnyga(new Knyga("Mintis", "Remarkas", 123, 7.55f));
        pridetiKnyga(new Knyga("Mintis", "Remarkas", 207, 19.55f));
        pridetiKnyga(new Knyga("Mintis", "Avyžius", 127, 8.55f));
        pridetiKnyga(new Knyga("Mintis", "Avyžius", 384, 19.55f));

        System.out.println("Plonesnes knygos uz 50 pls");
        System.out.println(rastiPlonasKnygas(50));
        System.out.println();

        System.out.println("Surykiuota pagal autorius ir kaina");
        rikiuotiIrSpausdinti();
        System.out.println();

        System.out.println("Surykiuota pagal kaina");
        rikiuotiPagalKaina();
        System.out.println();

        System.out.println("Poros mazesnes uz 30.0");
        System.out.println(porosMazesnesUz(30f));
        System.out.println();

        System.out.println("Skirtingi autoriai");
        skirtingiAutoriai();
        System.out.println();

        System.out.println("Skirtingos leidyklos");
        skirtingosLeidyklos();
        System.out.println();

    }


}
