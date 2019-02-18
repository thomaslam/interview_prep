public int totalFruit(int[] tree) {
    Set<Integer> set = new HashSet<>();
    int maxTotal = 0;

    for (int i = 0; i < tree.length; i++) {
        int total = 0;
        for (int j = i; j < tree.length; j++) {
            if (!set.contains(tree[j])) {
                if (set.size() == 2) {
                    break;
                }
                set.add(tree[j]);
            }
            total += 1;
        }

        set.clear();
        if (total > maxTotal) {
            maxTotal = total;
        }
    }

    return maxTotal;
}   