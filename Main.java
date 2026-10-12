/**
 * ES234317 - Algorithms and Data Structures
 * Coursework   : 04
 * Student ID   : 5026251019
 * Full Name    : Alberto Marcelo Payong Dahe Belolu
 * Class        : C
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Problem Test Case 1:");
        Integer [] a = {1, 3, 1, 4, 3, 7, -2, 0, 7, -2, -2, 1};
        ArrayList<Integer> v = new ArrayList<Integer> (Arrays.asList(a));
        System.out.println(twice(v));
        
        System.out.println("Problem Test Case 2:");
        String [] fNames ={"Marty", "Stuart", "Jessica", "Amanda", "Meghan", "Hal"};
        String [] lNames ={"Stepp", "Reges", "Miller", "Camp", "Miller", "Perkins"};
        String [] lNamesX ={"Stepp", "Reges", "Muller", "Camp", "Miller", "Perkins"};
        
        TreeMap<String, String> m1 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m1.put(fNames[i],lNames[i]);
        }
        
        TreeMap<String, String> m2 = new TreeMap<String, String>();
        for(int i=0;i<fNames.length;i++){
            m2.put(fNames[i],lNamesX[i]);
        }
        
        System.out.println(hasDuplicateValue(m1));
        System.out.println(hasDuplicateValue(m2));
        
        System.out.println("Problem Test Case 3:");
        Integer d1 [] = {3, 8, 17, 9, 17, 8, 3};
        Integer d2 [] = {3, 8, 17, 9, 4, 17, 8, 3};
        
        Queue<Integer> q1 = new LinkedList<Integer> (Arrays.asList(d1));
        Queue<Integer> q2 = new LinkedList<Integer> (Arrays.asList(d2));
        
        System.out.println(isPalindrome(q1));
        System.out.println(isPalindrome(q2));
    }
    
    public static Set<Integer> twice(List<Integer> l){
        Set<Integer> s = new TreeSet<Integer>();
        //gunakan set tambahan untuk melacak angka yang sudah dilihat sekali dan yang sudah lebih dari dua kali
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> moreThanTwice = new HashSet<Integer>();
        
        //telusuri setiap angka dalam list
        for (Integer n : l) {
            if (moreThanTwice.contains(n)) {
                //jika sudah muncul lebih dari dua kali, abaikan
            } else if (s.contains(n)) {
                //jika sudah ada di s (berarti kemunculan kedua), pindahkan ke moreThanTwice dan hapus dari s
                s.remove(n);
                moreThanTwice.add(n);
            } else if (visited.contains(n)) {
                //jika baru dilihat sekali sebelumnya, masukkan ke s (menjadi tepat dua kali)
                s.add(n);
            } else {
                //tandai pertama kali dilihat
                visited.add(n);
            }
        }
        return s;
    }
    
    public static boolean hasDuplicateValue(Map<String,String> m){
        boolean s=false;
        //kembalikan false jika map kosong atau hanya punya satu elemen
        if (m == null || m.size() <= 1) {
            return s;
        }
        
        Set<String> uniqueValues = new HashSet<String>();
        //periksa setiap nilai (value) di dalam map
        for (String value : m.values()) {
            //jika nilai gagal ditambahkan ke set, berarti ada nilai duplikat
            if (!uniqueValues.add(value)) {
                s = true;
                break;
            }
        }
        
        return s;
    }
    
    public static boolean isPalindrome(Queue<Integer> q){
        boolean s=false;
        //antrian kosong atau satu elemen selalu dianggap palindrome
        if (q == null || q.size() <= 1) {
            return true;
        }
        
        int size = q.size();
        Stack<Integer> stack = new Stack<Integer>();
        
        //tahap 1: masukkan elemen ke stack sekaligus kembalikan antrian ke posisi semula
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            stack.push(n);
            q.add(n);
        }
        
        //tahap 2: bandingkan elemen antrian dengan isi stack (urutan terbalik)
        boolean isPal = true;
        for (int i = 0; i < size; i++) {
            int n = q.remove();
            int fromStack = stack.pop();
            if (n != fromStack) {
                isPal = false;
            }
            q.add(n);
        }
        
        s = isPal;
        return s;
    }
}