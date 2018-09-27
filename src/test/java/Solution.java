import java.util.*;

public class Solution {
    static List<String> paginate(int resultsPerPage, List<String> results) {
        List<String> res = new LinkedList<>();
        if (resultsPerPage < 1 || results.size() == 0) return res;
        boolean[] state = new boolean[results.size()];
        LinkedHashMap<Integer, List<String>> map = new LinkedHashMap<>();
        Iterator<String> iterator = results.listIterator();
        int idx = 0;
        while (iterator.hasNext()) {
            String temp = iterator.next();
            String[] value = temp.split(",");
            int host = Integer.parseInt(value[0]);
            if (map.containsKey(host)) {
                List<String> tlist = map.get(host);
                tlist.add(idx++ + "," + temp);
                map.put(host, tlist);
            } else {
                List<String> tlist = new LinkedList<>();
                tlist.add(idx++ + "," + temp);
                map.put(host, tlist);
            }
        }
        int count = 0;
        while (map.size() >= resultsPerPage) {
            Iterator<Map.Entry<Integer, List<String>>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, List<String>> entry = iter.next();
                List<String> str = entry.getValue();

                String[] tempstr = str.remove(0).split(",");
                int hostTemp = Integer.parseInt(tempstr[0]);
                state[hostTemp] = true;
                res.add(results.get(hostTemp));
                count++;
                if (count >= resultsPerPage) {
                    res.add("");
                    count = 0;
                }
                if (str.size() == 0)
                    iter.remove();
                else
                    map.put(entry.getKey(), str);
            }
        }
        if (map.size() != 0) {
            for (int i = 0; i < state.length; i++) {
                if (!state[i]) {
                    res.add(results.get(i));
                    count++;
                    if (count >= resultsPerPage) {
                        res.add("");
                        count = 0;
                    }
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int resultsPerPage = 5;
        List<String> results = new LinkedList<>();
        String[] str = {"1,28,300.6,San F", "4,5,209.1,San F", "20,7,203.4,San F", "6,8,20" +
                "2.9,San F", "6,10,199.8,San F", "1,16,190.5,San F", "6,29,185.3,San F", "" +
                "7,20,180.0,San F", "6,21,162.2,San F", "2,18,161.7,San F", "2,30,149.8,Sa" +
                "n F", "3,76,146.7,San F", "2,14,141.8,San F" };
        results = Arrays.asList(str);
        System.out.println(paginate(resultsPerPage,results));
    }
}
